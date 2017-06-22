package org.openfact.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface DocumentModel {

    String DOCUMENT_TYPE = "documentType";
    String DOCUMENT_ID = "documentId";
    String DOCUMENT_CURRENCY_CODE = "documentCurrencyCode";
    String CUSTOMER_REGISTRATION_NAME = "customerRegistrationName";
    String CUSTOMER_ASSIGNED_ACCOUNT_ID = "customerAssignedAccountId";
    String CUSTOMER_ELECTRONIC_MAIL = "customerElectronicMail";

    String CREATED_TIMESTAMP = "createdTimestamp";
    String ENABLED = "enabled";

    String[] FILTER_TEXT_FIELDS = { DOCUMENT_ID, CUSTOMER_REGISTRATION_NAME, CUSTOMER_ASSIGNED_ACCOUNT_ID, CUSTOMER_ELECTRONIC_MAIL };
    String[] ORDER_BY_FIELDS = { DOCUMENT_ID, CREATED_TIMESTAMP };

    String getId();
    String getID();
    String getDocumentType();
    LocalDateTime getCreatedTimestamp();

    boolean isEnabled();
    void disable();

    /**
     * Organization
     */
    OrganizationModel getOrganization();

    /**
     * Document information
     */
    String getCurrencyCode();
    void setCurrencyCode(String currencyCode);

    String getCustomerRegistrationName();
    void setCustomerRegistrationName(String customerRegistrationName);

    String getCustomerAssignedAccountId();
    void setCustomerAssignedAccountId(String customerAssignedAccountId);

    String getCustomerElectronicMail();
    void setCustomerElectronicMail(String customerElectronicMail);

    /**
     * Document Line
     */
    DocumentLineModel addLine();
    List<DocumentLineModel> getLines();
    boolean removeLine(DocumentLineModel line);

    /**
     * Required Actions
     */
    String REQUIRED_ACTIONS = "requiredActions";

    Set<String> getRequiredActions();
    void addRequiredAction(String action);
    void addRequiredAction(RequiredAction action);
    void removeRequiredAction(String action);
    void removeRequiredAction(RequiredAction action);

    enum DocumentType {

        INVOICE("Invoice"), CREDIT_NOTE("CreditNote"), DEBIT_NOTE("DebitNote");

        private String xmlWrapper;

        DocumentType(String xmlWrapper) {
            this.xmlWrapper = xmlWrapper;
        }

        public String getXmlWrapper() {
            return this.xmlWrapper;
        }

        public static DocumentType getFromString(String value) {
            DocumentType[] elements = DocumentType.values();
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].toString().equals(value)) {
                    return elements[i];
                }
            }
            return null;
        }

    }

    enum RequiredAction {
        SEND_TO_CUSTOMER, SEND_TO_THIRD_PARTY;
    }

}
