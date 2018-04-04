package org.openfact.pe.types;

import java.math.BigDecimal;

/**
 * Created by lxpary on 10/01/17.
 */
public enum TipoRegimenRetencion {

    TASA_RETENCION("01", "TASA 3%", new BigDecimal(3));

    private final String codigo;
    private final String denominacion;
    private final BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }


    public String getDenominacion() {
        return denominacion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    private TipoRegimenRetencion(String codigo, String denominacion, BigDecimal valor) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.valor = valor;
    }
}
