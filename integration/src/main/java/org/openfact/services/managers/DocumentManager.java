package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.models.*;
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.DocumentRequiredAction;
import org.openfact.models.types.DocumentType;
import org.openfact.ubl.*;
import org.openfact.ubl.utils.DefaultUBLUtil;
import org.openfact.ubl.utils.UBLUtil;
import org.w3c.dom.Document;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.xml.transform.TransformerException;

@Stateless
public class DocumentManager {

    protected static final Logger logger = Logger.getLogger(DocumentManager.class);

    @Inject
    protected DocumentProvider model;

    @Inject
    private FileProvider fileProvider;

    @Inject
    private UBLUtil ublUtil;

    @Inject
    private UBLSigner signerProvider;

    @Inject
    private Event<DocumentModel.DocumentPostCreateEvent> postCreatedEvent;

    @Inject
    private Event<DocumentModel.DocumentRemovedEvent> removedEvent;

    @Inject
    private UBLEmailSender emailSender;

    public DocumentModel getDocumentById(String id, OrganizationModel organization) {
        return model.getDocumentById(id, organization);
    }

    public DocumentModel getDocumentByTypeAndDocumentId(String type, String documentId, OrganizationModel organization) {
        return model.getDocumentByTypeAndDocumentId(type, documentId, organization);
    }

    public DocumentModel getDocumentByTypeAndDocumentId(DocumentType type, String documentId, OrganizationModel organization) {
        return model.getDocumentByTypeAndDocumentId(type.toString(), documentId, organization);
    }

    public DocumentModel addDocument(OrganizationModel organization, String documentId, DocumentType documentType, Object type) throws ModelException {
        return addDocument(organization, documentId, documentType.toString(), type);
    }

    public DocumentModel addDocument(OrganizationModel organization, String documentId, String documentType, Object type) throws ModelException {
        Config.Scope documentConfig = Config.scope(documentType.toLowerCase());

        String readerWriterProviderType = documentConfig.get(DefaultUBLUtil.READER_WRITER, "default");
        String customizationProviderType = documentConfig.get(DefaultUBLUtil.MODEL_CUSTOMIZATION, "default");
        UBLReaderWriter readerWriter = ublUtil.getReaderWriter(readerWriterProviderType, documentType);
        UBLCustomizator customizator = ublUtil.getCustomizationProvider(customizationProviderType, documentType);
        if (readerWriter == null) {
            throw new ModelException("Could not find a valid " + UBLReaderWriter.class.getSimpleName() + " for type[" + documentType + "]");
        }
        if (customizator == null) {
            throw new ModelException("Could not find a valid " + UBLCustomizator.class.getSimpleName() + " for type[" + documentType + "]");
        }

        readerWriter.validate(organization, type);
        Document documentXml = readerWriter.writer().write(organization, type);
        if (documentXml == null) {
            logger.error("Could not create Xml Document from " + type.getClass().getName() + " Instance");
            throw new ModelException("Could not create Xml Document from " + type.getClass().getName() + " Instance");
        }

        documentXml = signerProvider.sign(documentXml, organization);
        DocumentModel documentModel = model.addDocument(documentType, documentId, organization);

        customizator.config(organization, documentModel, type);
        for (DocumentRequiredAction requiredAction: customizator.getRequiredActions()) {
            documentModel.addRequiredAction(requiredAction);
        }
        for (String requiredAction: customizator.getExtraRequiredActions()) {
            documentModel.addRequiredAction(requiredAction);
        }

        try {
            FileModel fileModel = fileProvider.createFile(organization, documentModel.getDocumentId() + ".xml", DocumentUtils.getBytesFromDocument(documentXml));
            documentModel.attachXmlFile(fileModel);
        } catch (TransformerException e) {
            throw new ModelException("Error transforming xml to bytes[]", e);
        }

        postCreatedEvent.fire(() -> documentModel);
        return documentModel;
    }

    public boolean removeDocument(OrganizationModel organization, DocumentModel document) {
        if (model.removeDocument(document.getId(), organization)) {
            removedEvent.fire(new DocumentModel.DocumentRemovedEvent() {
                @Override
                public OrganizationModel getOrganization() {
                    return organization;
                }

                @Override
                public DocumentModel getDocument() {
                    return document;
                }
            });
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, DocumentModel document) throws ModelInsuficientData, SendEventException {
        SendEventModel sendEvent = emailSender.send(organization, document, document.getCustomerElectronicMail(), DestinyType.CUSTOMER);
        document.removeRequiredAction(DocumentRequiredAction.SEND_TO_CUSTOMER);
        return sendEvent;
    }

    public SendEventModel sendToThirdParty(OrganizationModel organization, DocumentModel document) throws ModelInsuficientData, SendEventException {
        Config.Scope documentConfig = Config.scope(document.getDocumentType().toLowerCase());
        String providerType = documentConfig.get(DefaultUBLUtil.THIRD_PARTY_SENDER, "default");

        UBLThirdPartySender thirdPartySender = ublUtil.getThirdPartySender(providerType, document.getDocumentType());
        if (thirdPartySender == null) {
            throw new SendEventException("Could not find a valid " + UBLCustomizator.class.getSimpleName() + " for type[" + document.getDocumentType() + "]");
        }

        SendEventModel sendEvent = thirdPartySender.send(organization, document);
        document.removeRequiredAction(DocumentRequiredAction.SEND_TO_THIRD_PARTY);
        return sendEvent;
    }

    public SendEventModel sendToCustomEmail(OrganizationModel organization, DocumentModel document, String email) throws ModelInsuficientData, SendEventException {
        return emailSender.send(organization, document, email, DestinyType.CUSTOM_EMAIL);
    }

}
