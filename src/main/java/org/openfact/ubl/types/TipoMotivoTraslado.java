package org.openfact.ubl.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoMotivoTraslado {
    VENTA("01", "VENTA"),
    VENTA_SUJETA_CONFIRM_COMPRADOR("14", "VENTA SUJETA A CONFIRMACION DEL COMPRADOR"),
    COMPRA("02", "COMPRA"),
    TRASLADO_ESTABLE_MISMA_EMPRESA("04", "TRASLADO ENTRE ESTABLECIMIENTOS DE LA MISMA EMPRESA"),
    TRASLADO_EMISOR_ITINERANTE_CP("18", "TRASLADO EMISOR ITINERANTE CP"),
    IMPORTACION("08", "IMPORTACION"),
    EXPORTACION("09", "EXPORTACION"),
    TRASLADO_ZONA_PRIMARIA("19", "TRASLADO A ZONA PRIMARIA"),
    OTROS("13", "OTROS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }


    private TipoMotivoTraslado(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
