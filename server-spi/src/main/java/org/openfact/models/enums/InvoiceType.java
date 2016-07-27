package org.openfact.models.enums;

public enum InvoiceType {

    /**
     * Factura
     */
    FACTURA("01", "FACTURA"),

    /**
     * Boleta
     */
    BOLETA("03", "BOLETA DE VENTA"),

    /**
     * Nota de credito
     */
    NOTA_CREDITO("07", "NOTA DE CREDITO"),

    /**
     * Nota de debito
     */
    NOTA_DEBITO("08", "NOTA DE DEBITO");

    private final String code;
    private final String description;

    InvoiceType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

}
