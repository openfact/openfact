package org.openfact.models.enums;

public enum MonetaryTotalType {

    IMPORTE_TOTAL("01", "RUC"),
    DESCUENTO_TOTAL("03", "DNI");

    private final String description;
    private final String code;

    MonetaryTotalType(String code, String description) {
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
