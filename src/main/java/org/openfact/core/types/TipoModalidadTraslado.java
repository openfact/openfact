package org.openfact.core.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoModalidadTraslado {
    PUBLICO("01", "TRANSPORTE PUBLICO"),
    PRIVADO("02", "TRANSPORTE PRIVADO");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }


    private TipoModalidadTraslado(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
