package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class TotalRepresentation {

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private Long pagar;

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private Long otrosCargos;


    @NotNull
    @Digits(integer = 10,fraction = 2)
    private Long descuentoGlobal;

    public Long getPagar() {
        return pagar;
    }

    public void setPagar(Long pagar) {
        this.pagar = pagar;
    }

    public Long getOtrosCargos() {
        return otrosCargos;
    }

    public void setOtrosCargos(Long otrosCargos) {
        this.otrosCargos = otrosCargos;
    }

    public Long getDescuentoGlobal() {
        return descuentoGlobal;
    }

    public void setDescuentoGlobal(Long descuentoGlobal) {
        this.descuentoGlobal = descuentoGlobal;
    }
}
