package org.openfact.core.types;

/**
 * Created by lxpary on 11/01/17.
 */
public enum TipoReciboServiciosPublicos {
    AT("L001", "AT", "LUZ"),
    MT2("L002", "MT2", "LUZ"),
    MT3("L003", "MT3", "LUZ"),
    MT4("L004", "MT4", "LUZ"),
    BT2("L005", "BT2", "LUZ"),
    BT3("L006", "BT3", "LUZ"),
    BT5B("L009", "BT5B NO RESIDENCIAL", "LUZ"),
    BT6("L010", "BT6", "LUZ"),
    COMERCIAL("A011", "COMERCIAL", "AGUA"),
    INDUSTRIAL("A012", "INDUSTRIAL", "AGUA"),
    DOMESTICO("A014", "DOMESTICO", "AGUA"),
    SOCIAL("A015", "SOCIAL", "AGUA");

    private final String id;
    private final String codigo;
    private final String denominacion;

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    private TipoReciboServiciosPublicos(String id, String codigo, String denominacion) {
        this.codigo = codigo;
        this.id = id;
        this.denominacion = denominacion;
    }
}
