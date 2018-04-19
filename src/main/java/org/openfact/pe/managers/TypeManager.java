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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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

        Document document;
        try {
            InvoiceType invoiceType = ModelToType.toBoleta(organization, additionalInfo, boleta);

            oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
            JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);

            document = JaxbUtils.marshalToDocument(InvoiceType.class, jaxbElement);
            firmar(organization, additionalInfo, document);
        } catch (JAXBException e) {
            throw new ModelRuntimeException("No se pudo crear un Document");
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            throw new ModelRuntimeException("No se pudo firmar un documento");
        }

        FileModel file;
        try {
            byte[] bytes = JaxbUtils.toBytes(document);
            file = guardarInvoiceFile(boleta, bytes);
        } catch (TransformerException e) {
            throw new ModelRuntimeException("No se pudo transformar Document a bytes");
        } catch (FileException e) {
            throw new ModelRuntimeException("No se pudo guardar xml al storage");
        }

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

        Document document;
        try {
            InvoiceType invoiceType = ModelToType.toFactura(organization, additionalInfo, factura);

            oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
            JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);

            document = JaxbUtils.marshalToDocument(InvoiceType.class, jaxbElement);
            firmar(organization, additionalInfo, document);
        } catch (JAXBException e) {
            throw new ModelRuntimeException("No se pudo crear un Document");
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            throw new ModelRuntimeException("No se pudo firmar un documento");
        }

        FileModel file;
        try {
            byte[] bytes = JaxbUtils.toBytes(document);
            file = guardarInvoiceFile(factura, bytes);
        } catch (TransformerException e) {
            throw new ModelRuntimeException("No se pudo transformar Document a bytes");
        } catch (FileException e) {
            throw new ModelRuntimeException("No se pudo guardar xml al storage");
        }

        if (factura.getEnviarSUNAT()) {
            ResponseType responseType = sunatManager.enviarFactura(organization, additionalInfo, factura, file);
            if (responseType.getResponseCode().getValue().equals("0")) {

            }
        }
    }

    private FileModel guardarInvoiceFile(AbstractInvoiceModel invoice, byte[] bytes) throws FileException {
        String fileName = ModelUtils.generateId() + ".xml";
        FileModel file = fileProvider.addFile(fileName, bytes);
        invoice.setFileId(file.getFileName());
        return file;
    }

    private KeyManager.ActiveRsaKey getActiveRsaKey(OrganizationModel organization) {
        if (organization.getUseCustomCertificates()) {
            return keystore.getActiveRsaKey(organization);
        } else {
            OrganizationModel masterOrganization = organizationProvider.getOrganization(OrganizationModel.MASTER_ID).orElseThrow(() -> new ModelRuntimeException("No se encontró la organización master"));
            return keystore.getActiveRsaKey(masterOrganization);
        }
    }

    private void firmar(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, Document document) throws ParserConfigurationException, NoSuchAlgorithmException, XMLSignatureException, InvalidAlgorithmParameterException, MarshalException {
        KeyManager.ActiveRsaKey activeRsaKey = getActiveRsaKey(organization);
        String signID = "Sign" + additionalInfo.getRazonSocial().toUpperCase().replaceAll("\\s", "");
        firmar(signID, activeRsaKey, document);
    }

    private void firmar(String referenceID, KeyManager.ActiveRsaKey rsaKey, Document document) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, MarshalException, XMLSignatureException {
        Node signParent = getSignExtensionContext(document);

        XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance();
        Reference reference = signatureFactory.newReference("", signatureFactory.newDigestMethod(DigestMethod.SHA1, null), Collections.singletonList(signatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null, null);
        SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), signatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(reference));

        KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
        List<X509Certificate> x509Content = new ArrayList<>();

        // Certificate
        x509Content.add(rsaKey.getCertificate());
        X509Data xData = keyInfoFactory.newX509Data(x509Content);
        KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(xData));

        DOMSignContext signContext = new DOMSignContext(rsaKey.getPrivateKey(), document);
        XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);

        signContext.setParent(signParent);
        signContext.setDefaultNamespacePrefix("ds");

        signature.sign(signContext);

        ((Element) signParent.getFirstChild()).setAttribute("Id", referenceID);
    }

    private Node getSignExtensionContext(Document document) {
        NodeList nodes = document.getElementsByTagName("ns2:ExtensionContent");
        int totalElements = nodes.getLength();
        return nodes.item(totalElements - 1);
    }

}
