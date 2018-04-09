package org.openfact.pe.models;

import java.math.BigDecimal;

public interface TotalModel {
    BigDecimal getTotalPagar();
    void setTotalPagar(BigDecimal pagar);

    BigDecimal getDescuentoGlobal();
    void setDescuentoGlobal(BigDecimal descuentoGlobal);

    BigDecimal getOtrosCargos();
    void setOtrosCargos(BigDecimal otrosCargos);
}
