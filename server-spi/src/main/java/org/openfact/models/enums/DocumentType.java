package org.openfact.models.enums;

public enum DocumentType {

    /** BOLETA, FACTURA */
    INVOICE_TYPE(false, false, false),

    /** RUC, DNI */
    ADDITIONAL_IDENTIFICATION_ID(false, false, false),

    /** GRAVADO, EXONERADO */
    ADDITIONAL_INFORMATION(false, false, true), ADDITIONAL_INFORMATION_CHILDREN(false, true, false),

    /** IGV, ISC, OTHER */
    TOTAL_TAX(true, false, false);

    private final boolean valuable;
    private final boolean checked;
    private final boolean composed;

    DocumentType(boolean valuable, boolean checked, boolean composed) {
        this.valuable = valuable;
        this.checked = checked;
        this.composed = composed;
    }

    public boolean isValuable() {
        return this.valuable;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isComposed() {
        return this.composed;
    }

}
