package org.openfact.models.types;

public enum DocumentType {

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
