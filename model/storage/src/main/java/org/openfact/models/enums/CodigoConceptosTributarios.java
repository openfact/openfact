package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 20/07/2016.
 */
public enum CodigoConceptosTributarios {

    TOTAL_VALO_VENTA_OPERACIONES_GRABADAS("1001"),
    TOTAL_VALO_VENTA_OPERACIONES_INAFECTAS("1002"),
    TOTAL_VALO_VENTA_OPERACIONES_EXONERADAS("1003"),
    TOTAL_VALO_VENTA_OPERACIONES_GRATUITAS("1004"),
    SUB_TOTAL_VENTA("1005"),
    PERCEPCIONES("2001"),
    RETENCIONES("2002"),
    DETRACCIONES("2003"),
    BONIFICACIONES("2004"),
    TOTAL_DESCUENTO("2005"),
    FISE("3001");
    private final String codigo;

    CodigoConceptosTributarios(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
