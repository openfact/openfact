package org.openfact.core.types;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoComprobante {

    /*CODIGO,DENOMINACION,MASK,TAMAÑO-MASK,VISIBLE*/
    NOTA_CREDITO("07", "NOTA DE CREDITO ELECTRONICA", "^[f|F|b|B]{1}\\d{1,3}[-]\\d{1,8}$", 13, false),
    NOTA_DEBITO("08", "NOTA DE DEBITO ELECTRONICA", "^[f|F|b|B]{1}\\d{1,3}[-]\\d{1,8}$", 13, false),
    PERCEPCION("40", "PERCEPCION ELECTRONICA", "^[P]{1}\\d{1,3}[-]\\d{1,8}$", 13, false),
    RETENCION("20", "RETENCION ELECTRONICA", "^[R]{1}\\d{1,3}[-]\\d{1,8}$", 13, false),
    RESUMEN_DIARIO("", "RESUMEN DIARIO DE BOLETAS", "^[RC]{2}[-]\\d{8}[-]\\d{1,5}$", 17, false),
    BAJA("", "BAJA DE DOCUMENTOS", "^[RA]{2}[-]\\d{8}[-]\\d{1,5}$", 17, false),

    GUIA_REMITENTE("09", "GUIA DE REMISIÓN REMITENTE", "", 0, false),
    TICKET("12", "TICKET DE MAQUINA REGISTRADORA", "", 0, false),
    DOCUMENTO_FINANCIERA("13", "DOCUMENTO EMITIDO POR BANCOS, INSTITUCIONES FINANCIERAS, CREDITICIAS Y DE SEGUROS QUE SE ENCUENTREN BAJO EL CONTROL DE LA SUPERINTENDENCIA DE BANCA Y SEGUROS", "", 0, false),
    RECIBO("14", "RECIBO SERVICIOS PUBLICOS", "", 0, false),
    AFP("18", "DOCUMENTOS EMITIDOS POR LAS AFP", "", 0, false),
    GUIA_TRANSPORTISTA("31", "GUIA DE REMISIÓN TRANSPORTISTA", "", 0, false),
    GUIA_SEAE("56", "COMPROBANTE DE PAGO SEAE", "", 0, false),
    GUIA_REMITENTE_COMPLEMENTARIA("71", "GUIA DE REMISIÓN REMITENTE COMPLEMENTARIA", "", 0, false),
    GUIA_TRANSPORTISTA_COMPLEMENTARIA("72", "GUIA DE REMISION TRANSPORTISTA COMPLEMENTARIA", "", 0, false);

    private final String codigo;
    private final String denominacion;
    private final String mask;
    private final int length;
    private final boolean visible;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getMask() {
        return mask;
    }

    public int getLength() {
        return length;
    }

    public boolean getVisible() {
        return visible;
    }

    TipoComprobante(String codigo, String denominacion, String mask, int length, boolean visible) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.mask = mask;
        this.length = length;
        this.visible = visible;
    }

    public static TipoComprobante getFromCode(String codigo) {
        Optional<TipoComprobante> op = Stream.of(TipoComprobante.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }
    }

}
