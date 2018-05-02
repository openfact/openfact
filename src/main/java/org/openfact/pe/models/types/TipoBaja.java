package org.openfact.pe.models.types;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoBaja {

    BAJA("", "BAJA DE DOCUMENTOS", "RA");

    private final String codigo;
    private final String denominacion;
    private final String prefijo;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    TipoBaja(String codigo, String denominacion, String prefijo) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.prefijo = prefijo;
    }

    public static Optional<TipoNota> getByCodigo(String codigo) {
        return Stream.of(TipoNota.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

    public String getPrefijo() {
        return prefijo;
    }
}
