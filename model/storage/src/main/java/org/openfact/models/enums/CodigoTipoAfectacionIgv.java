package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 20/07/2016.
 */
public enum CodigoTipoAfectacionIgv {
    GRABADO_OPERACION_ONEROSA("10"),
    GRABADO_RETIRO_POR_PREMIO("11"),
    GRABADO_RETIRO_POR_DONACION("12"),
    GRABADO_RETIRO("13"),
    GRABADO_RETIRO_POR_PUBLICIDAD("14"),
    GRABADO_BONIFICACIONES("15"),
    GRABADO_RETIRO_POR_ENTREGA_A_TRABAJADORES("16"),
    EXONERADO_OPERACION_ONEROSA("20"),
    INAFECTO_OPERACION_ONEROSA("30"),
    INAFECTO_RETIRO_POR_BONIFICACION("31"),
    INAFECTO_RETIRO("32"),
    INAFECTO_RETIRO_POR_MUESTRAS_MEDICAS("33"),
    INAFECTO_RETIRO_POR_CONVENIO_COLECTIVO("34"),
    INAFECTO_RETIRO_POR_PREMIO("35"),
    INAFECTO_RETIRO_POR_PUBLICIDAD("36"),
    EXPORTACION("40");
    private final String codigo;

    CodigoTipoAfectacionIgv(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
