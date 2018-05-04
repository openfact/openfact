package org.openfact.pe.managers;

import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.core.files.FileException;
import org.openfact.core.files.FileModel;
import org.openfact.core.files.FileProvider;
import org.openfact.core.models.*;
import org.openfact.core.models.utils.ModelUtils;
import org.openfact.pe.models.*;
import org.openfact.pe.models.types.TipoNota;
import org.openfact.pe.models.utils.JaxbUtils;
import org.openfact.pe.models.utils.ModelToType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType;

import javax.ejb.*;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
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
import java.util.concurrent.Future;

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
    private InvoiceProvider invoiceProvider;

    @Inject
    private NotaProvider notaProvider;

    @Inject
    private BajaProvider bajaProvider;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private OrganizationInformacionAdicionalProvider additionalInfoProvider;

    @Inject
    private MessageManager messageManager;

    private void guardarDocumentoNoEnviado(EstadoSunatModel validacion) {
        validacion.setEstado(false);
        validacion.setCodigo("-1");
        validacion.setDescripcion("El documento todavía no fue enviado a la Sunat");
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Future<InvoiceModel> buildInvoice(String invoiceId) {
        InvoiceModel invoice = invoiceProvider.getInvoice(invoiceId).orElseThrow(() -> new ModelRuntimeException("Boleta no encontrada"));
        OrganizationModel organization = invoice.getOrganization();

        if (invoice.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new ModelReadOnlyException("Documento es de solo lectura");
        }

        OrganizacionInformacionAdicionalModel additionalInfo = additionalInfoProvider.getOrganizacionInformacionAdicional(organization).orElseThrow(() -> new ModelRuntimeException("No se encontró información adicional de la organización:" + organization.getId()));

        // Procesar el xml
        Document xmlDocument;
        try {
            InvoiceType invoiceType = ModelToType.toInvoiceType(organization, additionalInfo, invoice);

            oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory factory = new oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory();
            JAXBElement<InvoiceType> jaxbElement = factory.createInvoice(invoiceType);
            xmlDocument = JaxbUtils.marshalToDocument(InvoiceType.class, jaxbElement);

            firmarXml(organization, additionalInfo, xmlDocument);
        } catch (JAXBException e) {
            throw new ModelRuntimeException("Error al hacer marshal de documento xml");
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            throw new ModelRuntimeException("Error al firmar el documento");
        }

        byte[] xmlDocumentBytes;
        try {
            xmlDocumentBytes = JaxbUtils.toBytes(xmlDocument);
        } catch (TransformerException e) {
            throw new ModelRuntimeException("Error al convertir documento xml a byte[]");
        }

        // Guardar el archivo xml
        FileModel xmlFile;
        String currentFileId = invoice.getFileId();
        try {
            String fileName = ModelUtils.generateId() + ".xml";
            xmlFile = fileProvider.addFile(fileName, xmlDocumentBytes);
            invoice.setFileId(xmlFile.getFileName());
        } catch (FileException e) {
            throw new ModelRuntimeException("Error al guardar el documento xml del invoice:" + invoiceId);
        }
        if (currentFileId != null) {
            boolean result = fileProvider.removeFile(currentFileId);
            if (!result) {
                logger.warnf("No se pudo eliminar el archivo %s", currentFileId);
            }
        }

        // Enviar a la sunat
        if (invoice.getEnviarSunat()) {
            boolean resultado = sunatManager.enviarInvoice(organization, additionalInfo, invoice, xmlFile);
            if (resultado) {
                messageManager.enviarInvoice(invoice);
            }
        } else {
            guardarDocumentoNoEnviado(invoice.getEstadoSunat());
        }

        return new AsyncResult<>(invoice);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Future<NotaModel> buildNota(String notaId) {
        NotaModel nota = notaProvider.getNota(notaId).orElseThrow(() -> new ModelRuntimeException("Nota de crédito no encontrada"));
        OrganizationModel organization = nota.getOrganization();

        if (nota.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new ModelReadOnlyException("Documento es de solo lectura");
        }

        OrganizacionInformacionAdicionalModel additionalInfo = additionalInfoProvider.getOrganizacionInformacionAdicional(organization).orElseThrow(() -> new ModelRuntimeException("No se encontró información adicional de la organización:" + organization.getId()));

        TipoNota tipoNota = TipoNota.getByCodigo(nota.getCodigoTipoComprobante()).orElseThrow(() -> new BadRequestException("Código de comprobante no válido"));

        // Procesar el xml
        Document xmlDocument;
        try {
            switch (tipoNota) {
                case NOTA_CREDITO:
                    CreditNoteType creditNoteType = ModelToType.toCreditNoteType(organization, additionalInfo, nota, nota.getInvoiceAfectado());

                    oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory creditNoteFactory = new oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory();
                    JAXBElement<CreditNoteType> creditNoteJaxbElement = creditNoteFactory.createCreditNote(creditNoteType);
                    xmlDocument = JaxbUtils.marshalToDocument(CreditNoteType.class, creditNoteJaxbElement);
                    break;
                case NOTA_DEBITO:
                    DebitNoteType debitNoteType = ModelToType.toDebitNoteType(organization, additionalInfo, nota, nota.getInvoiceAfectado());

                    oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory debitNoteFactory = new oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory();
                    JAXBElement<DebitNoteType> debitNoteJaxbElement = debitNoteFactory.createDebitNote(debitNoteType);
                    xmlDocument = JaxbUtils.marshalToDocument(DebitNoteType.class, debitNoteJaxbElement);
                    break;
                default:
                    throw new ModelRuntimeException("Tipo de nota no soportado para construir xml Type");
            }

            firmarXml(organization, additionalInfo, xmlDocument);
        } catch (JAXBException e) {
            throw new ModelRuntimeException("Error al hacer marshal de documento xml");
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            throw new ModelRuntimeException("Error al firmar el documento");
        }

        byte[] xmlDocumentBytes;
        try {
            xmlDocumentBytes = JaxbUtils.toBytes(xmlDocument);
        } catch (TransformerException e) {
            throw new ModelRuntimeException("Error al convertir documento xml a byte[]");
        }

        // Guardar el archivo xml
        FileModel xmlFile;
        String currentFileId = nota.getFileId();
        try {
            String fileName = ModelUtils.generateId() + ".xml";
            xmlFile = fileProvider.addFile(fileName, xmlDocumentBytes);
            nota.setFileId(xmlFile.getFileName());
        } catch (FileException e) {
            throw new ModelRuntimeException("Error al guardar el documento xml de la nota:" + notaId);
        }
        if (currentFileId != null) {
            boolean result = fileProvider.removeFile(currentFileId);
            if (!result) {
                logger.warnf("No se pudo eliminar el archivo %s", currentFileId);
            }
        }

        // Enviar a la sunat
        if (nota.getEnviarSunat()) {
            boolean resultado = sunatManager.enviarNota(organization, additionalInfo, nota, xmlFile);
            if (resultado) {
                messageManager.enviarNota(nota);
            }
        } else {
            guardarDocumentoNoEnviado(nota.getEstadoSunat());
        }

        return new AsyncResult<>(nota);
    }

    @Asynchronous
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Future<BajaModel> buildBaja(String organizationId, String bajaId) {
        OrganizationModel organization = organizationProvider.getOrganization(organizationId).orElseThrow(NotFoundException::new);
        BajaModel baja = bajaProvider.getBaja(organization, bajaId).orElseThrow(() -> new ModelRuntimeException("Baja no encontrada"));

        if (baja.getEstado().equals(EstadoComprobantePago.CERRADO)) {
            throw new ModelReadOnlyException("Documento es de solo lectura");
        }

        OrganizacionInformacionAdicionalModel additionalInfo = additionalInfoProvider.getOrganizacionInformacionAdicional(organization).orElseThrow(() -> new ModelRuntimeException("No se encontró información adicional de la organización:" + organization.getId()));

        // Procesar el xml
        Document xmlDocument;
        try {
            sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType voidedDocumentsType = ModelToType.toVoidedDocumentsType(organization, additionalInfo, baja, baja.getInvoiceAfectado());

            sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.ObjectFactory voidedVoidedDocuments = new sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.ObjectFactory();
            JAXBElement<VoidedDocumentsType> jaxbElement = voidedVoidedDocuments.createVoidedDocuments(voidedDocumentsType);
            xmlDocument = JaxbUtils.marshalToDocument(VoidedDocumentsType.class, jaxbElement);

            firmarXml(organization, additionalInfo, xmlDocument);
        } catch (JAXBException e) {
            throw new ModelRuntimeException("Error al hacer marshal de documento xml");
        } catch (ParserConfigurationException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | XMLSignatureException | MarshalException e) {
            throw new ModelRuntimeException("Error al firmar el documento");
        }

        byte[] xmlDocumentBytes;
        try {
            xmlDocumentBytes = JaxbUtils.toBytes(xmlDocument);
        } catch (TransformerException e) {
            throw new ModelRuntimeException("Error al convertir documento xml a byte[]");
        }

        // Guardar el archivo xml
        FileModel xmlFile;
        String currentFileId = baja.getFileId();
        try {
            String fileName = ModelUtils.generateId() + ".xml";
            xmlFile = fileProvider.addFile(fileName, xmlDocumentBytes);
            baja.setFileId(xmlFile.getFileName());
        } catch (FileException e) {
            throw new ModelRuntimeException("Error al guardar el documento xml de la baja:" + bajaId);
        }
        if (currentFileId != null) {
            boolean result = fileProvider.removeFile(currentFileId);
            if (!result) {
                logger.warnf("No se pudo eliminar el archivo %s", currentFileId);
            }
        }

        // Enviar a la sunat
        if (baja.getEnviarSunat()) {
            boolean resultado = sunatManager.enviarBaja(organization, additionalInfo, baja, xmlFile);
            if (resultado) {
                messageManager.enviarBaja(baja);
            }
        } else {
            guardarDocumentoNoEnviado(baja.getEstadoSunat());
        }

        return new AsyncResult<>(baja);

    }

    private void firmarXml(OrganizationModel organization, OrganizacionInformacionAdicionalModel additionalInfo, Document document) throws ParserConfigurationException, NoSuchAlgorithmException, XMLSignatureException, InvalidAlgorithmParameterException, MarshalException {
        KeyManager.ActiveRsaKey activeRsaKey = getActiveRsaKey(organization);
        String signID = "Sign" + additionalInfo.getRazonSocial().toUpperCase().replaceAll("\\s", "");
        firmarXml(signID, activeRsaKey, document);
    }

    private KeyManager.ActiveRsaKey getActiveRsaKey(OrganizationModel organization) {
        if (organization.getUseCustomCertificates()) {
            return keystore.getActiveRsaKey(organization);
        } else {
            OrganizationModel masterOrganization = organizationProvider.getOrganization(OrganizationModel.MASTER_ID).orElseThrow(() -> new ModelRuntimeException("No se encontró la organización master"));
            return keystore.getActiveRsaKey(masterOrganization);
        }
    }

    private void firmarXml(String referenceID, KeyManager.ActiveRsaKey rsaKey, Document document) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, MarshalException, XMLSignatureException {
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
