package org.openfact.pe.managers;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.core.models.*;
import org.openfact.core.models.files.FileException;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.OrganizacionInformacionAdicionalModel;
import org.openfact.pe.models.utils.JaxbUtils;
import org.openfact.pe.models.utils.ModelToType;
import org.w3c.dom.Document;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class TypeManager {

    private static final Logger logger = Logger.getLogger(TypeManager.class);

    @Inject
    private KeyManager keystore;

    @Inject
    private SUNATManager sunatManager;

    @Inject
    private FileProvider fileProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildBoleta(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, BoletaModel boleta) {
        Document firmaDigital;
        try {
            firmaDigital = getFirmaDigital(organization, additionalInfo);
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            logger.error(e);
            return;
        }

        InvoiceType invoiceType = ModelToType.toInvoiceType(organization, additionalInfo, boleta, firmaDigital);

        try {
            byte[] bytes = toBytes(invoiceType);

            String fileName = "Invoice_Boleta_" + ModelUtils.generateId() + ".xml";
            FileModel file = fileProvider.addFile(fileName, bytes);

            boleta.setFileId(file.getFileName());
        } catch (JAXBException | FileException e) {
            logger.error(e);
            return;
        }

        if (boleta.getEnviarSUNAT()) {
//            sunatManager.enviarBoleta(boleta, file);
        }
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildFactura(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, FacturaModel factura) {
        Document firmaDigital;
        try {
            firmaDigital = getFirmaDigital(organization, additionalInfo);
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            logger.error(e);
            return;
        }

        InvoiceType invoiceType = ModelToType.toInvoiceType(organization, additionalInfo, factura, firmaDigital);

        try {
            byte[] bytes = toBytes(invoiceType);

            String fileName = "Invoice_Factura" + ModelUtils.generateId() + ".xml";
            FileModel file = fileProvider.addFile(fileName, bytes);

            factura.setFileId(file.getFileName());
        } catch (JAXBException | FileException e) {
            logger.error(e);
            return;
        }

        if (factura.getEnviarSUNAT()) {
//            sunatManager.enviarBoleta(boleta, file);
        }
    }


    private byte[] toBytes(InvoiceType invoiceType) throws JAXBException {
        oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
        JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);
        return JaxbUtils.marshalToBytes(InvoiceType.class, jaxbElement);
    }

    private KeyManager.ActiveRsaKey getActiveRsaKey(OrganizationModel organization) {
        if (organization.getUseCustomCertificates()) {
            return keystore.getActiveRsaKey(organization);
        } else {
            OrganizationModel masterOrganization = organizationProvider.getOrganization(OrganizationModel.MASTER_ID).orElseThrow(() -> new ModelRuntimeException("No se encontró la organización master"));
            return keystore.getActiveRsaKey(masterOrganization);
        }
    }

    private Document getFirmaDigital(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo) throws ParserConfigurationException, NoSuchAlgorithmException, XMLSignatureException, InvalidAlgorithmParameterException, MarshalException {
        KeyManager.ActiveRsaKey activeRsaKey = getActiveRsaKey(organization);
        return firmar(activeRsaKey, newEmptyDocument());
    }

    private static Document newEmptyDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    private Document firmar(KeyManager.ActiveRsaKey rsaKey, Document node) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, MarshalException, XMLSignatureException {
        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance();
        Reference reference = signatureFactory.newReference("", signatureFactory.newDigestMethod(DigestMethod.SHA1, null), Collections.singletonList(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null, null);
        SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));

        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<X509Certificate> x509Content = new ArrayList<>();

        // Certificate
        x509Content.add(rsaKey.getCertificate());
        X509Data xData = keyInfoFactory.newX509Data(x509Content);
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(xData));

        DOMSignContext signContext = new DOMSignContext(rsaKey.getPrivateKey(), node);
        XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);

        signContext.setDefaultNamespacePrefix("ds");
        signature.sign(signContext);

        return node;
    }


}
