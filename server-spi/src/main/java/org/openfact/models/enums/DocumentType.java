package org.openfact.models.enums;

public enum DocumentType {

    INVOICE_TYPE(false), ADDITIONAL_IDENTIFICATION_ID(false), TAX(true);

    private final boolean valuable;

    DocumentType(boolean valuable) {
        this.valuable = valuable;
    }

    public boolean isValuable() {
        return this.valuable;
    }

}
