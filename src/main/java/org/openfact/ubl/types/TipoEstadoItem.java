package org.openfact.ubl.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoEstadoItem {
    ADICIONAR("1", "ADICIONAR"),
    MODIFICAR("2", "MODIFICAR"),
    ANULADO("3", "ANULADO"),
    ANULADO_EN_EL_DIA("4", "ANULADO EN EL DIA (ANULADO ANTES DE INFORMAR COMPROBANTE)");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }


    private TipoEstadoItem(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
