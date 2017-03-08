package org.openfact.services.managers;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.types.DocumentType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Stateless
public class DocumentManager {

    protected static final Logger logger = Logger.getLogger(DocumentManager.class);

    @Inject
    protected DocumentProvider model;

    @Inject
    private FileProvider fileProvider;

    public DocumentModel getDocumentById(String id, OrganizationModel organization) {
        return model.getDocumentById(id, organization);
    }

    public DocumentModel getDocumentByTypeAndDocumentId(String type, String documentId, OrganizationModel organization) {
        return model.getDocumentByTypeAndDocumentId(type, documentId, organization);
    }

    public DocumentModel getDocumentByTypeAndDocumentId(DocumentType type, String documentId, OrganizationModel organization) {
        return model.getDocumentByTypeAndDocumentId(type.toString(), documentId, organization);
    }

    public DocumentModel addInvoice(InvoiceType invoiceType, OrganizationModel organization) {
        UBLInvoiceProvider ublProvider = session.getProvider(UBLInvoiceProvider.class);

        // Model persist
        IDType documentId = invoiceType.getID();
        if (documentId == null) {
            String newDocumentId = ublProvider.idGenerator().generateID(organization, invoiceType);
            documentId = new IDType(newDocumentId);
            invoiceType.setID(documentId);
        }
        DocumentModel documentModel = model.addDocument(String.valueOf(DocumentType.INVOICE), documentId.getValue(), organization);

        // Attributes
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            documentModel.setAttribute(entry.getKey(), entry.getValue());
        }

        // Type to Model
        TypeToModel.importInvoice(session, organization, documentModel, invoiceType);

        // Required actions
        Arrays.stream(RequiredAction.values()).forEach(c -> documentModel.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ublProvider.writer().write(organization, invoiceType);
            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);

            // File
            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, documentModel.getDocumentId() + ".xml", signedDocumentBytes);
            documentModel.attachXmlFile(xmlFile);
        } catch (TransformerException e) {
            logger.error("Error parsing XML to byte", e);
            throw new ModelException(e);
        }

        fireDocumentPostCreate(documentModel);
        return documentModel;
    }

    public DocumentModel addCreditNote(CreditNoteType creditNoteType, OrganizationModel organization) {
        return null;
    }

    public DocumentModel addCreditNote(CreditNoteType creditNoteType, Map<String, List<String>> attributes, OrganizationModel organization) {
//        UBLCreditNoteProvider ublProvider = session.getProvider(UBLCreditNoteProvider.class);
//
//        // Model persist
//        IDType documentId = creditNoteType.getID();
//        if (documentId == null) {
//            String newDocumentId = ublProvider.idGenerator().generateID(organization, creditNoteType);
//            documentId = new IDType(newDocumentId);
//            creditNoteType.setID(documentId);
//        }
//        DocumentModel documentModel = model.addDocument(String.valueOf(DocumentType.CREDIT_NOTE), documentId.getValue(), organization);
//
//        // Attributes
//        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
//            documentModel.setAttribute(entry.getKey(), entry.getValue());
//        }
//
//        // Type to Model
//        TypeToModel.importCreditNote(session, organization, documentModel, creditNoteType);
//
//        // Required actions
//        Arrays.stream(RequiredAction.values()).forEach(c -> documentModel.addRequiredAction(c));
//
//        try {
//            // Generate Document
//            Document baseDocument = ublProvider.writer().write(organization, creditNoteType);
//            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
//            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);
//
//            // File
//            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, documentModel.getDocumentId() + ".xml", signedDocumentBytes);
//            documentModel.attachXmlFile(xmlFile);
//        } catch (TransformerException e) {
//            logger.error("Error parsing XML to byte", e);
//            throw new ModelException(e);
//        }
//
//        // attach file
//        if (creditNoteType.getBillingReference() != null && !creditNoteType.getBillingReference().isEmpty()) {
//            creditNoteType.getBillingReference().stream()
//                    .filter(p -> p.getInvoiceDocumentReference() != null)
//                    .forEach(c -> {
//                        String invoiceDocumentId = c.getInvoiceDocumentReference().getIDValue();
//                        DocumentModel attachedDocument = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, invoiceDocumentId, organization);
//                        if (attachedDocument != null) {
//                            documentModel.addAttachedDocument(attachedDocument);
//                        }
//                    });
//        }
//
//        fireDocumentPostCreate(documentModel);
//        return documentModel;
        return null;
    }

    public DocumentModel addDebitNote(DebitNoteType debitNoteType, OrganizationModel organization) {
        return null;
    }

    public DocumentModel addDebitNote(DebitNoteType debitNoteType, Map<String, List<String>> attributes, OrganizationModel organization) {
//        UBLDebitNoteProvider ublProvider = session.getProvider(UBLDebitNoteProvider.class);
//
//        // Model persist
//        IDType documentId = debitNoteType.getID();
//        if (documentId == null) {
//            String newDocumentId = ublProvider.idGenerator().generateID(organization, debitNoteType);
//            documentId = new IDType(newDocumentId);
//            debitNoteType.setID(documentId);
//        }
//        DocumentModel documentModel = model.addDocument(String.valueOf(DocumentType.DEBIT_NOTE), documentId.getValue(), organization);
//
//        // Attributes
//        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
//            documentModel.setAttribute(entry.getKey(), entry.getValue());
//        }
//
//        // Type to Model
//        TypeToModel.importDebitNote(session, organization, documentModel, debitNoteType);
//
//        // Required actions
//        Arrays.stream(RequiredAction.values()).forEach(c -> documentModel.addRequiredAction(c));
//
//        try {
//            // Generate Document
//            Document baseDocument = ublProvider.writer().write(organization, debitNoteType);
//            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
//            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);
//
//            // File
//            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, documentModel.getDocumentId() + ".xml", signedDocumentBytes);
//            documentModel.attachXmlFile(xmlFile);
//        } catch (TransformerException e) {
//            logger.error("Error parsing XML to byte", e);
//            throw new ModelException(e);
//        }
//
//        // attach file
//        if (debitNoteType.getBillingReference() != null && !debitNoteType.getBillingReference().isEmpty()) {
//            debitNoteType.getBillingReference().stream()
//                    .filter(p -> p.getInvoiceDocumentReference() != null)
//                    .forEach(c -> {
//                        String invoiceDocumentId = c.getInvoiceDocumentReference().getIDValue();
//                        DocumentModel attachedDocument = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, invoiceDocumentId, organization);
//                        if (attachedDocument != null) {
//                            documentModel.addAttachedDocument(attachedDocument);
//                        }
//                    });
//        }
//
//        fireDocumentPostCreate(documentModel);
//        return documentModel;
        return null;
    }

    public boolean removeDocument(OrganizationModel organization, DocumentModel document) {
//        return removeDocument(organization, document, session.documents());
        return false;
    }

    public boolean removeDocument(OrganizationModel organization, DocumentModel document, DocumentProvider documentProvider) {
//        if (documentProvider.removeDocument(document.getId(), organization)) {
//            session.getOpenfactSessionFactory().publish(new DocumentModel.DocumentRemovedEvent() {
//
//                @Override
//                public OrganizationModel getOrganization() {
//                    return organization;
//                }
//
//                @Override
//                public DocumentModel getDocument() {
//                    return document;
//                }
//
//                @Override
//                public OpenfactSession getOpenfactSession() {
//                    return session;
//                }
//
//            });
//            return true;
//        }
//        return false;
        return false;
    }

    protected void fireDocumentPostCreate(DocumentModel document) {
//        session.getOpenfactSessionFactory().publish(new DocumentModel.DocumentPostCreateEvent() {
//            @Override
//            public DocumentModel getCreatedDocument() {
//                return document;
//            }
//
//            @Override
//            public OpenfactSession getOpenfactSession() {
//                return session;
//            }
//        });        
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, DocumentModel document) throws ModelInsuficientData, SendEventException {
//        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOMER);
//        sendToCustomerParty(organization, document, sendEvent);
//        return sendEvent;
        return null;
    }

    public void sendToCustomerParty(OrganizationModel organization, DocumentModel document, SendEventModel sendEvent) throws ModelInsuficientData, SendEventException {
//        DocumentType documentType = DocumentType.getFromString(document.getDocumentType());
//        UBLProvider ublProvider = null;
//        if (documentType != null) {
//            switch (documentType) {
//                case INVOICE:
//                    ublProvider = session.getProvider(UBLInvoiceProvider.class);
//                    break;
//                case CREDIT_NOTE:
//                    ublProvider = session.getProvider(UBLInvoiceProvider.class);
//                    break;
//                case DEBIT_NOTE:
//                    ublProvider = session.getProvider(UBLInvoiceProvider.class);
//                    break;
//            }
//        }
//        if (ublProvider != null) {
//            ublProvider.sender().sendToCustomer(organization, document, sendEvent);
//        } else {
//            sendToThirdPartyByEmail(organization, document, sendEvent, document.getCustomerElectronicMail());
//        }
    }

    public SendEventModel sendToThirdParty(OrganizationModel organization, DocumentModel document) throws ModelInsuficientData, SendEventException {
//        SendEventModel sendEvent = document.addSendEvent(DestinyType.THIRD_PARTY);
//        sendToThirdParty(organization, document, sendEvent);
//        return sendEvent;
        return null;
    }

    public void sendToThirdParty(OrganizationModel organization, DocumentModel document, SendEventModel sendEvent) throws ModelInsuficientData, SendEventException {
//        DocumentType documentType = DocumentType.getFromString(document.getDocumentType());
//        UBLProvider ublProvider = null;
//        if (documentType != null) {
//            switch (documentType) {
//                case INVOICE:
//                    ublProvider = session.getProvider(UBLInvoiceProvider.class);
//                    break;
//                case CREDIT_NOTE:
//                    ublProvider = session.getProvider(UBLCreditNoteProvider.class);
//                    break;
//                case DEBIT_NOTE:
//                    ublProvider = session.getProvider(UBLDebitNoteProvider.class);
//                    break;
//            }
//        }
//        if (ublProvider != null) {
//            ublProvider.sender().sendToThirdParty(organization, document, sendEvent);
//        } else {
//            logger.warn("UBL Provider not found to send to Third Party");
//        }
    }

    public SendEventModel sendToThirdPartyByEmail(OrganizationModel organization, DocumentModel document, String email) throws ModelInsuficientData, SendEventException {
//        SendEventModel sendEvent = document.addSendEvent(DestinyType.CUSTOM_EMAIL);
//        sendToThirdPartyByEmail(organization, document, sendEvent, email);
//        return sendEvent;
        return null;
    }

    public void sendToThirdPartyByEmail(OrganizationModel organization, DocumentModel document, SendEventModel sendEvent, String email) throws ModelInsuficientData, SendEventException {
//        if (email == null || !EmailValidator.getInstance().isValid(email)) {
//            throw new ModelInsuficientData("Invalid Email");
//        }
//        if (organization.getSmtpConfig().size() == 0) {
//            throw new ModelInsuficientData("Could not find a valid smtp configuration on organization");
//        }
//
//        // User where the email will be send
//        EmailUserModel user = new EmailUserModel(email);
//
//        try {
//            FileProvider fileProvider = session.getProvider(FileProvider.class);
//
//            // Attatchments
//            FileModel xmlFile = fileProvider.createFile(organization, document.getDocumentId() + ".xml", document.getXmlAsFile().getFile());
//            EmailFileModel xmlFileMymeType = new EmailFileModel(xmlFile, "application/xml");
//
//            byte[] pdfFileBytes = session.getProvider(UBLReportProvider.class)
//                    .document()
//                    .setOrganization(organization)
//                    .getReport(document, ExportFormat.PDF);
//
//            FileModel pdfFile = fileProvider.createFile(organization, document.getDocumentId() + ".pdf", pdfFileBytes);
//            EmailFileModel pdfFileMymeType = new EmailFileModel(pdfFile, "application/pdf");
//
//            session.getProvider(EmailTemplateProvider.class)
//                    .setOrganization(organization).setUser(user)
//                    .setAttachments(Arrays.asList(xmlFileMymeType, pdfFileMymeType))
//                    .sendDocument(document);
//
//            // Write event to the database
//            sendEvent.setDescription("Document successfully sended");
//            sendEvent.setResult(SendEventStatus.SUCCESS);
//        } catch (ReportException e) {
//            throw new SendEventException("Could not generate pdf report to attach file", e);
//        } catch (EmailException e) {
//            throw new SendEventException("Could not send email", e);
//        } catch (Throwable e) {
//            throw new SendEventException("Internal Server Error", e);
//        }
    }

}
