package org.openfact.ubl.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoValorVenta {
    GRAVADO("01", "GRAVADO"),
    EXONERADO("02", "EXONERADO"),
    INAFECTO("03", "INAFECTO"),
    EXPORTACION("04", "EXPORTACION"),
    GRATUITA("05", "GRATUITAS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }


    public String getDenominacion() {
        return denominacion;
    }


    private TipoValorVenta(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
