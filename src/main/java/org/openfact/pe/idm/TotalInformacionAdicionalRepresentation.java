package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TotalInformacionAdicionalRepresentation {

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalGravado;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalGratuito;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalInafecto;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalExonerado;

    public BigDecimal getTotalGravado() {
        return totalGravado;
    }

    public void setTotalGravado(BigDecimal totalGravado) {
        this.totalGravado = totalGravado;
    }

    public BigDecimal getTotalGratuito() {
        return totalGratuito;
    }

    public void setTotalGratuito(BigDecimal totalGratuito) {
        this.totalGratuito = totalGratuito;
    }

    public BigDecimal getTotalInafecto() {
        return totalInafecto;
    }

    public void setTotalInafecto(BigDecimal totalInafecto) {
        this.totalInafecto = totalInafecto;
    }

    public BigDecimal getTotalExonerado() {
        return totalExonerado;
    }

    public void setTotalExonerado(BigDecimal totalExonerado) {
        this.totalExonerado = totalExonerado;
    }
}
