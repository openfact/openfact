package org.openfact.models.enums;

public enum InvoiceType {

    FACTURA("01", "FACTURA"),
    BOLETA("03", "BOLETA DE VENTA"), 
    NOTA_CREDITO("07", "NOTA DE CREDITO"), 
    NOTA_DEBITO("08", "NOTA DE DEBITO");

    private final String description;
    private final String code;

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
