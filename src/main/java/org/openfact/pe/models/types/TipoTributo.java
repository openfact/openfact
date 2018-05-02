package org.openfact.pe.models.types;

public enum TipoTributo {

    IGV("1000", "VAT", "IGV", "IMPUESTO GENERAL A LAS VENTAS"),
    ISC("2000", "EXC", "ISC", "IMPUESTO SELECTIVO AL CONSUMO"),
    OTROS("9999", "OTH", "OTROS", "OTROS CONCEPTOS DE PAGO");
    private final String id;
    private final String codigo;
    private final String abreviatura;
    private final String denominacion;

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public String getDenominacion() {
        return denominacion;
    }

    private TipoTributo(String id, String codigo, String abreviatura, String denominacion) {
        this.id = id;
        this.abreviatura = abreviatura;
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
