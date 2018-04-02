package org.openfact.ubl.types;

import java.math.BigDecimal;

/**
 * Created by lxpary on 10/01/17.
 */
public enum TipoRegimenPercepcion {

    PERCEPCION_VENTA_INTERNA("01", "PERCEPCION VENTA INTERNA", new BigDecimal(2)),
    PERCEPCION_ADQUISION_COMBUSTIBLE("02", "PERCEPCION A LA ADQUISICION DE COMBUSTIBLE", new BigDecimal(1)),
    PERCEPCION_AGENTE_TASA_ESPECIAL("03", "PERCEPCION REALIZADA AL AGENTE DE PERCEPCION CON TASA ESPECIAL", new BigDecimal(0.5));

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

    private TipoRegimenPercepcion(String codigo, String denominacion, BigDecimal valor) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.valor = valor;
    }
}
