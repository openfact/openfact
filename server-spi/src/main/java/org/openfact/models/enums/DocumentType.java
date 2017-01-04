package org.openfact.models.enums;

public enum DocumentType {
    INVOICE, CREDIT_NOTE, DEBIT_NOTE;

    public static DocumentType getFromString(String value) {
        DocumentType[] elements = DocumentType.values();
        for (int i = 0; i < elements.length; i++) {
            if(elements[i].toString().equals(value)) {
                return elements[i];
            }
        }
        return null;
    }
}
