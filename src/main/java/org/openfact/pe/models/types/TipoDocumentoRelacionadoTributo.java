package org.openfact.pe.models.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoDocumentoRelacionadoTributo {
    TICKET_ENAPU("04", "TICKET DE SALIDA - ENAPU"),
    SCOP("05", "CODIGO SCOP"),
    OTRO("99", "OTROS"),
    FACTURA_ERROR_RUC("01", "FACTURA - EMITIDA PARA CORREGIR ERROR EN EL RUC"),
    FACTURA_ANTICIPO("02", "FACTURA - EMITIDA POR ANTICIPOS"),
    BOLETA_ANTICIPO("03", "BOLETA DE VENTA - EMITIDA POR ANTICIPOS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    private TipoDocumentoRelacionadoTributo(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
