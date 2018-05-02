package org.openfact.pe.models.types;

/**
 * Created by lxpary on 10/01/17.
 */
public enum TipoMoneda {

    PEN("PEN", "S/.", "SOLES"),
    USD("USD", "$", "DOLARES AMERICANOS");

    private final String codigo;
    private final String abreviatura;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public String getDenominacion() {
        return denominacion;
    }

    private TipoMoneda(String codigo, String abreviatura, String denominacion) {
        this.codigo = codigo;
        this.abreviatura = abreviatura;
        this.denominacion = denominacion;
    }
}
