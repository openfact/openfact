package org.openfact.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.openfact.provider.ProviderEvent;
import org.openfact.models.types.DestinyType;
import org.openfact.models.types.DocumentRequiredAction;
import org.w3c.dom.Document;

public interface DocumentModel {

    String DOCUMENT_TYPE = "documentType";
    String DOCUMENT_ID = "documentId";
    String DOCUMENT_CURRENCY_CODE = "documentCurrencyCode";
    String CUSTOMER_REGISTRATION_NAME = "customerRegistrationName";
    String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountId";
    String CUSTOMER_ELECTRONIC_MAIL = "customerElectronicMail";

    String CREATED_TIMESTAMP = "createdTimestamp";
    String ENABLED = "enabled";

    String getId();

    String getDocumentId();

    String getDocumentType();

    LocalDateTime getCreatedTimestamp();

    boolean isEnabled();

    void disable();

    /**
     * Document Line
     */
    List<DocumentLineModel> getDocumentLines();

    DocumentLineModel addDocumentLine();

    boolean removeDocumentLine(DocumentLineModel documentLine);

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * Document information
     */
    String getDocumentCurrencyCode();

    void setDocumentCurrencyCode(String currencyCode);

    String getCustomerRegistrationName();

    void setCustomerRegistrationName(String customerRegistrationName);

    String getCustomerAssignedAccountId();

    void setCustomerAssignedAccountId(String customerAssignedAccountId);

    String getCustomerElectronicMail();

    void setCustomerElectronicMail(String customerElectronicMail);

    /**
     * Xml
     */
    FileModel getXmlAsFile();
    void attachXmlFile(FileModel file);

    Document getXmlAsDocument();
    JSONObject getXmlAsJSONObject();

    /**
     * attributes
     */
    void setSingleAttribute(String name, String value);

    void setAttribute(String name, List<String> values);

    void removeAttribute(String name);

    String getFirstAttribute(String name);

    List<String> getAttribute(String name);

    Map<String, List<String>> getAttributes();

    /**
     * Required Actions
     */
    String REQUIRED_ACTIONS = "requiredActions";

    Set<String> getRequiredActions();

    void addRequiredAction(String action);

    void removeRequiredAction(String action);

    void addRequiredAction(DocumentRequiredAction action);

    void removeRequiredAction(DocumentRequiredAction action);

    /**
     * Send events
     */
    String SEND_EVENT_DESTINY = "destiny";
    String SEND_EVENT_STATUS = "status";

    int getCustomerSendEventFailures();

    void incrementCustomerSendEventFailures();

    int getThirdPartySendEventFailures();

    void incrementThirdPartySendEventFailures();

    SendEventModel addSendEvent(DestinyType destinyType);

    SendEventModel getSendEventById(String id);

    boolean removeSendEvent(SendEventModel sendEvent);

    List<SendEventModel> getSendEvents();

    List<SendEventModel> getSendEvents(Integer firstResult, Integer maxResults);

    List<SendEventModel> searchForSendEvent(Map<String, String> params);

    List<SendEventModel> searchForSendEvent(Map<String, String> params, int firstResult, int maxResults);

    /**
     * Attatched documents
     */
    List<DocumentModel> getAttachedDocumentsAsOrigin();

    List<DocumentModel> getAttachedDocumentsAsDestiny();

    void addAttachedDocument(DocumentModel document);

    boolean removeAttachedDocument(DocumentModel document);

    /**
     * Events interfaces
     */
    @FunctionalInterface
    interface DocumentCreationEvent extends ProviderEvent {
        DocumentModel getCreatedDocument();
    }

    @FunctionalInterface
    interface DocumentPostCreateEvent extends ProviderEvent {
        DocumentModel getCreatedDocument();
    }

    interface DocumentRemovedEvent extends ProviderEvent {
        OrganizationModel getOrganization();

        DocumentModel getDocument();
    }

}
