package org.openfact.models.enums;

public enum DocumentType {

    /** BOLETA, FACTURA */
    INVOICE_TYPE(false),

    /** RUC, DNI */
    ADDITIONAL_IDENTIFICATION_ID(false),

    /** GRAVADO, EXONERADO */
    ADDITIONAL_INFORMATION(false),

    /** IGV, ISC, OTHER */
    TOTAL_TAX(true), TAX_REASON(false);

    private final boolean valuable;

    DocumentType(boolean valuable) {
        this.valuable = valuable;
    }

    public boolean isValuable() {
        return this.valuable;
    }

}
