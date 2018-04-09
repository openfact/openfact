package org.openfact.pe.models;

import java.math.BigDecimal;

public interface MonedaModel {
    String getMoneda();
    void setMoneda(String moneda);

    BigDecimal getTipoCambio();
    void setTipoCambio(BigDecimal tipoCambio);
}
