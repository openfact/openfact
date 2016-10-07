package org.openfact.ubl.pe.constants;

public enum CodigoTipoAfectacionIgv {

    GRAVADO_OPERACION_ONEROSA("10"),
    GRAVADO_RETIRO_POR_PREMIO("11"),
    GRAVADO_RETIRO_POR_DONACION("12"),
    GRAVADO_RETIRO("13"),
    GRAVADO_RETIRO_POR_PUBLICIDAD("14"),
    GRAVADO_BONIFICACIONES("15"),
    GRAVADO_RETIRO_POR_ENTREGA_A_TRABAJADORES("16"),
    GRAVADO_IVAP("17"),
    EXONERADO_OPERACION_ONEROSA("20"),
    EXONERADO_TRANSFERENCIA_GRATUITA("21"),
    INAFECTO_OPERACION_ONEROSA("30"),
    INAFECTO_RETIRO_POR_BONIFICACION("31"),
    INAFECTO_RETIRO("32"),
    INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS("33"),
    INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO("34"),
    INAFECTO_RETIRO_POR_PREMIO("35"),
    INAFECTO_RETIRO_POR_PUBLICIDAD("36"),
    EXPORTACION("40");
    
    private final String codigo;

    public String getCodigo() {
        return codigo;
    }

    private CodigoTipoAfectacionIgv(String codigo) {
        this.codigo = codigo;
    }
}
