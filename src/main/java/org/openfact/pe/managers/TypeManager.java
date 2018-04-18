package org.openfact.pe.managers;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ResponseType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.core.models.*;
import org.openfact.core.models.files.FileException;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.utils.JaxbUtils;
import org.openfact.pe.models.utils.ModelToType;
import org.openfact.pe.models.utils.SunatUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
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
    private SunatManager sunatManager;

    @Inject
    private FileProvider fileProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private OrganizationInformacionAdicionalProvider additionalInfoProvider;

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/jms/topic/my-topic")
    private Topic topic;

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildBoleta(OrganizationModel organization, BoletaModel boleta) {
        if (boleta.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            throw new ModelReadOnlyException("Documento es de solo lectura");
        }

        OrganizacionInformacionAdicionalModel additionalInfo = additionalInfoProvider.getOrganizacionInformacionAdicional(organization)
                .orElseThrow(() -> new ModelRuntimeException("No se encontró información adicional de la organización:" + organization.getId()));

        Document firmaDigital;
        try {
            firmaDigital = getFirmaDigital(organization, additionalInfo);
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            throw new ModelRuntimeException("No se pudo general una firma digital valida para la organización:" + organization.getId());
        }

        byte[] bytes;
        try {
            InvoiceType invoiceType = ModelToType.toBoleta(organization, additionalInfo, boleta, firmaDigital);
            bytes = toBytes(invoiceType);
        } catch (JAXBException e) {
            throw new ModelRuntimeException("No se pudo transformar Type a bytes");
        }

        FileModel file = guardarInvoiceFile(boleta, bytes);

        if (boleta.getEnviarSUNAT()) {
            ResponseType responseType = sunatManager.enviarBoleta(organization, additionalInfo, boleta, file);
            if (responseType.getResponseCode().getValue().equals("0")) {

            }
        }
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void buildFactura(OrganizationModel organization, FacturaModel factura) {
        if (factura.getEstado().equals(EstadoComprobantePago.REGISTRADO)) {
            throw new ModelReadOnlyException("Documento es de solo lectura");
        }

        OrganizacionInformacionAdicionalModel additionalInfo = additionalInfoProvider.getOrganizacionInformacionAdicional(organization)
                .orElseThrow(() -> new ModelRuntimeException("No se encontró información adicional de la organización:" + organization.getId()));

        Document firmaDigital;
        try {
            firmaDigital = getFirmaDigital(organization, additionalInfo);
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            throw new ModelRuntimeException("No se pudo general una firma digital valida para la organización:" + organization.getId());
        }

        byte[] bytes;
        try {
            InvoiceType invoiceType = ModelToType.toFactura(organization, additionalInfo, factura, firmaDigital);
            bytes = toBytes(invoiceType);
        } catch (JAXBException e) {
            throw new ModelRuntimeException("No se pudo transformar Type a bytes");
        }

        FileModel file = guardarInvoiceFile(factura, bytes);

        if (factura.getEnviarSUNAT()) {
            ResponseType responseType = sunatManager.enviarFactura(organization, additionalInfo, factura, file);
            if (responseType.getResponseCode().getValue().equals("0")) {

            }
        }
    }

    private FileModel guardarInvoiceFile(AbstractInvoiceModel invoice, byte[] bytes) {
        try {
            String fileName = ModelUtils.generateId() + ".xml";
            FileModel file = fileProvider.addFile(fileName, bytes);
            invoice.setFileId(file.getFileName());
            return file;
        } catch (FileException e) {
            throw new ModelRuntimeException("No se pudo guardar un archivo en el storage");
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
        String signID = "Sign" + additionalInfo.getRazonSocial().toUpperCase().replaceAll("\\s", "");
        return firmar(signID, activeRsaKey, newEmptyDocument());
    }

    private static Document newEmptyDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    private Document firmar(String referenceID, KeyManager.ActiveRsaKey rsaKey, Document node) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, MarshalException, XMLSignatureException {
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

        node.getDocumentElement().setAttribute("Id", referenceID);
        return node;
    }


}
