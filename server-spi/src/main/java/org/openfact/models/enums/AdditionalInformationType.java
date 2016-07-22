package org.openfact.models.enums;

public enum AdditionalInformationType {

    GRAVADO("01", "RUC"),
    INACFECTO("03", "DNI"),
    EXONERADO("03", "DNI"),
    GRATUITO("03", "DNI"),
    DESCUENTO("03", "DNI");

    private final String description;
    private final String code;

    AdditionalInformationType(String code, String description) {
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
