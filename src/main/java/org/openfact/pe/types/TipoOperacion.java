package org.openfact.pe.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoOperacion {
    VENTA_INTERNA("01", "VENTA INTERNA"),
    EXPORTACION("02", "EXPORTACION"),
    NO_DOMICIALIADOS("03", "NO DOMICILIADOS"),
    VENTA_INTERNA_ANTICIPOS("04", "VENTA INTERNA - ANTICIPOS"),
    VENTA_ITINERANTE("05", "VENTA ITINERANTE"),
    FACTURA_GUIA("06", "FACTURA GUIA"),
    VENTA_ARROZ_PILADO("07", "VENTA ARROZ PILADO"),
    FACTURA_COMPROBANTE_PERCEPCION("08", "FACTURA COMPROBANTE DE PERCEPCION"),
    FACTURA_GUIA_REMITENTE("10", "FACTURA - GUIA REMITENTE"),
    FACTURA_GUIA_TRANSPORTISTA("11", "FACTURA - GUIA TRANSPORTISTA"),
    BOLETA_VENTA_COMPROBANTE_PERCEPCION("12", "BOLETA DE VENTA - COMPROBANTE DE PERCEPCION");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }


    private TipoOperacion(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
