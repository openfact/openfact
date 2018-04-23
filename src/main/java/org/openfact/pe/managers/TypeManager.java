package org.openfact.pe.managers;

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
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TypeManager {

    private static final Logger logger = Logger.getLogger(TypeManager.class);

    @Inject
    private KeyManager keystore;

    @Inject
    private SunatManager sunatManager;

    @Inject
    private FileProvider fileProvider;

    @Inject
    private BoletaProvider boletaProvider;

    @Inject
    private FacturaProvider facturaProvider;

//    @Inject
//    private NotaDebitoProvider notaDebitoProvider;
//
//    @Inject
//    private NotaCreditoProvider notaCreditoProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private OrganizationInformacionAdicionalProvider additionalInfoProvider;

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/jms/topic/my-topic")
    private Topic topic;

    private void guardarDocumentoNoEnviado(ValidacionModel validacion) {
        validacion.setEstado(false);
        validacion.setError(ErrorType.no_enviado_sunat);
        validacion.setErrorDescripcion("El documento todavía no fue enviado a la Sunat");
    }

    private void validacionOk(ValidacionModel validacion) {
        validacion.setEstado(true);
        validacion.setError(null);
        validacion.setErrorDescripcion(null);
    }

    @Asynchronous
    public void buildBoleta(String boletaId) {
        BoletaModel boleta = boletaProvider.getBoleta(boletaId).orElseThrow(() -> new ModelRuntimeException("Boleta no encontrada"));
        OrganizationModel organization = boleta.getOrganization();

        if (boleta.getEstado().equals(EstadoComprobantePago.CERRADO)) {
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

        byte[] documentBytes;
        try {
            documentBytes = JaxbUtils.toBytes(document);
        } catch (TransformerException e) {
            throw new ModelRuntimeException("No se pudo transformar Document a bytes");
        }

        FileModel file = guardarDocumentFile(boleta, documentBytes);

        if (boleta.getEnviarSUNAT()) {
            boolean resultado = sunatManager.enviarBoleta(organization, additionalInfo, boleta, file);
            if (resultado) {
                validacionOk(boleta.getValidacion());
            }
        } else {
            guardarDocumentoNoEnviado(boleta.getValidacion());
        }
    }

    @Asynchronous
    public void buildFactura(String facturaId) {
        FacturaModel factura = facturaProvider.getFactura(facturaId).orElseThrow(() -> new ModelRuntimeException("Factura no encontrada"));
        OrganizationModel organization = factura.getOrganization();

        if (factura.getEstado().equals(EstadoComprobantePago.CERRADO)) {
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

        byte[] documentBytes;
        try {
            documentBytes = JaxbUtils.toBytes(document);
        } catch (TransformerException e) {
            throw new ModelRuntimeException("No se pudo transformar Document a bytes");
        }

        FileModel file = guardarDocumentFile(factura, documentBytes);

        if (factura.getEnviarSUNAT()) {
            boolean resultado = sunatManager.enviarFactura(organization, additionalInfo, factura, file);
            if (resultado) {
                validacionOk(factura.getValidacion());
            }
        } else {
            guardarDocumentoNoEnviado(factura.getValidacion());
        }
    }

    @Asynchronous
    public void buildCreditNote(String notaCreditoId) {
//        if (creditNote.getEstado().equals(EstadoComprobantePago.CERRADO)) {
//            throw new ModelReadOnlyException("Documento es de solo lectura");
//        }
//
//        OrganizacionInformacionAdicionalModel additionalInfo = additionalInfoProvider.getOrganizacionInformacionAdicional(organization)
//                .orElseThrow(() -> new ModelRuntimeException("No se encontró información adicional de la organización:" + organization.getId()));
//
//        Document document;
//        try {
//            CreditNoteType creditNoteType = ModelToType.toCreditNote(organization, additionalInfo, creditNote);
//
//            oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory();
//            JAXBElement<CreditNoteType> jaxbElement = factory.createCreditNote(creditNoteType);
//
//            document = JaxbUtils.marshalToDocument(CreditNoteType.class, jaxbElement);
//            firmar(organization, additionalInfo, document);
//        } catch (JAXBException e) {
//            throw new ModelRuntimeException("No se pudo crear un Document");
//        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
//            throw new ModelRuntimeException("No se pudo firmar un documento");
//        }
//
//        byte[] documentBytes;
//        try {
//            documentBytes = JaxbUtils.toBytes(document);
//        } catch (TransformerException e) {
//            throw new ModelRuntimeException("No se pudo transformar Document a bytes");
//        }
//
//        FileModel file = guardarDocumentFile(creditNote, documentBytes);
//
//        if (creditNote.getEnviarSUNAT()) {
//            boolean resultado = sunatManager.enviarCreditNote(organization, additionalInfo, creditNote, file);
//            if (resultado) {
//                validacionOk(creditNote.getValidacion());
//            }
//        } else {
//            guardarDocumentoNoEnviado(creditNote.getValidacion());
//        }
    }

    @Asynchronous
    public void buildDebitNote(String notaDebitoId) {
//        if (debitNote.getEstado().equals(EstadoComprobantePago.CERRADO)) {
//            throw new ModelReadOnlyException("Documento es de solo lectura");
//        }
//
//        OrganizacionInformacionAdicionalModel additionalInfo = additionalInfoProvider.getOrganizacionInformacionAdicional(organization)
//                .orElseThrow(() -> new ModelRuntimeException("No se encontró información adicional de la organización:" + organization.getId()));
//
//        Document document;
//        try {
//            DebitNoteType debitNoteType = ModelToType.toDebitNote(organization, additionalInfo, debitNote);
//
//            oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory();
//            JAXBElement<DebitNoteType> jaxbElement = factory.createDebitNote(debitNoteType);
//
//            document = JaxbUtils.marshalToDocument(DebitNoteType.class, jaxbElement);
//            firmar(organization, additionalInfo, document);
//        } catch (JAXBException e) {
//            throw new ModelRuntimeException("No se pudo crear un Document");
//        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
//            throw new ModelRuntimeException("No se pudo firmar un documento");
//        }
//
//        byte[] documentBytes;
//        try {
//            documentBytes = JaxbUtils.toBytes(document);
//        } catch (TransformerException e) {
//            throw new ModelRuntimeException("No se pudo transformar Document a bytes");
//        }
//
//        FileModel file = guardarDocumentFile(debitNote, documentBytes);
//
//        if (debitNote.getEnviarSUNAT()) {
//            boolean resultado = sunatManager.enviarDebitNote(organization, additionalInfo, debitNote, file);
//            if (resultado) {
//                validacionOk(debitNote.getValidacion());
//            }
//        } else {
//            guardarDocumentoNoEnviado(debitNote.getValidacion());
//        }
    }

    private FileModel guardarDocumentFile(DocumentoModel documentModel, byte[] documentBytes) {
        FileModel file;
        String currentFileId = documentModel.getFileId();
        try {
            String fileName = ModelUtils.generateId() + ".xml";
            file = fileProvider.addFile(fileName, documentBytes);
            documentModel.setFileId(file.getFileName());
        } catch (FileException e) {
            throw new ModelRuntimeException("No se pudo guardar xml de documento");
        }
        if (currentFileId != null) {
            boolean result = fileProvider.removeFile(currentFileId);
            if (!result) {
                logger.warnf("No se pudo eliminar el archivo %s", currentFileId);
            }
        }
        return file;
    }

    private void firmar(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, Document document) throws ParserConfigurationException, NoSuchAlgorithmException, XMLSignatureException, InvalidAlgorithmParameterException, MarshalException {
        KeyManager.ActiveRsaKey activeRsaKey = getActiveRsaKey(organization);
        String signID = "Sign" + additionalInfo.getRazonSocial().toUpperCase().replaceAll("\\s", "");
        firmar(signID, activeRsaKey, document);
    }

    private KeyManager.ActiveRsaKey getActiveRsaKey(OrganizationModel organization) {
        if (organization.getUseCustomCertificates()) {
            return keystore.getActiveRsaKey(organization);
        } else {
            OrganizationModel masterOrganization = organizationProvider.getOrganization(OrganizationModel.MASTER_ID).orElseThrow(() -> new ModelRuntimeException("No se encontró la organización master"));
            return keystore.getActiveRsaKey(masterOrganization);
        }
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
