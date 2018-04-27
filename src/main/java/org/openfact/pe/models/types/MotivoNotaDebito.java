package org.openfact.pe.models.types;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by lxpary on 11/01/17.
 */
public enum MotivoNotaDebito {

    INTERES("01", "INTERES POR MORA"),
    AUMENTO("02", "AUMENTO EN EL VALOR"),
    PENALIDAD("03", "PENALIDADES / OTROS CONCEPTOS");

    private final String codigo;
    private final String denominacion;

    public String getCodigo() {
        return codigo;
    }


    public String getDenominacion() {
        return denominacion;
    }

    MotivoNotaDebito(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public static Optional<MotivoNotaDebito> buscarPorCodigo(String codigo) {
        return Stream.of(MotivoNotaDebito.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

}
