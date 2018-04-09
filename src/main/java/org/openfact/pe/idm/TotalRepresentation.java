package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TotalRepresentation {

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal pagar;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal otrosCargos;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal descuentoGlobal;

    public BigDecimal getPagar() {
        return pagar;
    }

    public void setPagar(BigDecimal pagar) {
        this.pagar = pagar;
    }

    public BigDecimal getOtrosCargos() {
        return otrosCargos;
    }

    public void setOtrosCargos(BigDecimal otrosCargos) {
        this.otrosCargos = otrosCargos;
    }

    public BigDecimal getDescuentoGlobal() {
        return descuentoGlobal;
    }

    public void setDescuentoGlobal(BigDecimal descuentoGlobal) {
        this.descuentoGlobal = descuentoGlobal;
    }
}
