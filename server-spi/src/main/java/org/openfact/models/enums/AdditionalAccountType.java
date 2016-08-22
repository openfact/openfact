package org.openfact.models.enums;

@Deprecated
public enum AdditionalAccountType {

    RUC("01", "RUC"),
    DNI("03", "DNI");

    private final String description;
    private final String code;

    AdditionalAccountType(String code, String description) {
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
