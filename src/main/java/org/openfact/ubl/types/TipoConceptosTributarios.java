package org.openfact.ubl.types;

public enum TipoConceptosTributarios {
    TOTAL_VALOR_VENTA_OPERACIONES_GRAVADAS("1001", "TOTAL VALOR DE VENTA - OPERACIONES GRAVADAS"),
    TOTAL_VALOR_VENTA_OPERACIONES_INAFECTAS("1002", "TOTAL VALOR DE VENTA - OPERACIONES INAFCTAS"),
    TOTAL_VALOR_VENTA_OPERACIONES_EXONERADAS("1003", "TOTAL VALOR DE VENTA - OPERACIONES EXONERADAS"),
    TOTAL_VALOR_VENTA_OPERACIONES_GRATUITAS("1004", "TOTAL VALOR DE VENTA - OPERACIONES GRATUITAS"),
    SUB_TOTAL_VENTA("1005", "SUB TOTAL DE VENTA"),
    PERCEPCIONES("2001", "PERCEPCIONES"),
    RETENCIONES("2002", "RETENCIONES"),
    DETRACCIONES("2003", "DETRACCIONES"),
    BONIFICACIONES("2004", "BONIFICACIONES"),
    TOTAL_DESCUENTO("2005", "TOTAL DESCUENTOS"),
    FISE("3001", "FISE (LEY 29852) FONDO INCLUSION SOCIAL ENERGETICO");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    private TipoConceptosTributarios(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
