package org.openfact.pe.models.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoDocumentoRelacionadoGuia {
    NUMERO_DAM("01", "NUMERACION DAM"),
    NUMERO_ORDEN_ENTREGA("02", "NUMERO DE ORDEN DE ENTREGA"),
    NUMERO_SCOP("03", "NUMERO SCOP"),
    NUMERO_MANIFIESTO_CARGA("04", "NUMERO DE MANIFIESTO DE CARGA"),
    NUMERO_CONSTANCIA_DETRACCION("05", "NUMERO DE CONSTANCIA DE DETRACCION"),
    OTROS("06", "OTROS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    private TipoDocumentoRelacionadoGuia(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
}
