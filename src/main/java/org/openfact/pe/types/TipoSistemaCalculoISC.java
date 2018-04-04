package org.openfact.pe.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoSistemaCalculoISC {
    SISTEMA_VALOR("01", "SISTEMA AL VALOR", "SISTEMA AL VALOR (APENDICE IV, LIT. A - T.O.U. IGV E ISC)"),
    MONTO_FIJO("02", "APLICACION DEL MONTO FIJO", "APLICACION DEL MONTO FIJO (APENDICE IV, LIT. B - T.O.U. IGV E ISC)"),
    VENTA_PUBLICO("03", "SISTEMA DE PRECIO DE VENTA AL PUBLICO", "SISTEMA DE PRECIO DE VENTA AL PUBLICO (APENDICE IV, LIT. C - T.O.U. IGV E ISC)");

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


    private TipoSistemaCalculoISC(String codigo, String abreviatura, String denominacion) {
        this.codigo = codigo;
        this.abreviatura = abreviatura;
        this.denominacion = denominacion;
    }
}
