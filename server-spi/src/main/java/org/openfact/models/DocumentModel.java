package org.openfact.models;

import java.time.LocalDateTime;

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
    String getDocumentCurrencyCode();
    void setDocumentCurrencyCode(String currencyCode);

    String getCustomerRegistrationName();
    void setCustomerRegistrationName(String customerRegistrationName);

    String getCustomerAssignedAccountId();
    void setCustomerAssignedAccountId(String customerAssignedAccountId);

    String getCustomerElectronicMail();
    void setCustomerElectronicMail(String customerElectronicMail);

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
}
