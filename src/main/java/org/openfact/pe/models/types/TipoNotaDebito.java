package org.openfact.pe.models.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoNotaDebito {

    INTERES("01", "INTERES POR MORA"),
    AUMENTO("02", "AUMENTO EN EL VALOR"),
    PENALIDAD("03", "PENALIDADES / OTROS CONCEPTOS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }


    public String getDenominacion() {
        return denominacion;
    }


    private TipoNotaDebito(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
