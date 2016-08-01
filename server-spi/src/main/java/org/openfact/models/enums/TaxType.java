package org.openfact.models.enums;

public enum TaxType {

    /**
     * Total valor de venta - operaciones gravadas
     */
    IGV("1000", "VAT","IMPUESTO GENERAL A LAS VENTAS"),

    /**
     * Total valor de venta - operaciones inafectas
     */
    ISC("2000", "EXC", "ISC"),

    /**
     * Total valor de venta - operaciones exoneradas
     */
    OTROS("9999", "OTH","OTROS");

    private final String id;
    private final String code;
    private final String description;

    TaxType(String id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public String getId() {
        return this.id;
    }
    
    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

}
