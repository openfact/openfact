package org.openfact.pe.models.types;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoNota {

    NOTA_CREDITO("07", "NOTA DE CREDITO"),
    NOTA_DEBITO("08", "NOTA DE DEBITO");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    TipoNota(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public static Optional<TipoNota> getByCodigo(String codigo) {
        return Stream.of(TipoNota.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }
}
