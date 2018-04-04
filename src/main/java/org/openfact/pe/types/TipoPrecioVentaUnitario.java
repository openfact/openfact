package org.openfact.pe.types;

public enum TipoPrecioVentaUnitario {
    PRECIO_UNITARIO("01", "PRECIO UNITARIO (INCLUYE IGV)"),
    VALOR_REF_UNIT_EN_OPER_NO_ORENOSAS("02", "VALOR REFERNCIAL UNITARIO EN OPERACIONES NO ONEROSAS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    private TipoPrecioVentaUnitario(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
