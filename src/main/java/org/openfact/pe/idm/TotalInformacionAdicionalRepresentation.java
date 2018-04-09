package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class TotalInformacionAdicionalRepresentation {

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Long totalGravado;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Long totalGratuito;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Long totalInafecto;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Long totalExonerado;

    public Long getTotalGravado() {
        return totalGravado;
    }

    public void setTotalGravado(Long totalGravado) {
        this.totalGravado = totalGravado;
    }

    public Long getTotalGratuito() {
        return totalGratuito;
    }

    public void setTotalGratuito(Long totalGratuito) {
        this.totalGratuito = totalGratuito;
    }

    public Long getTotalInafecto() {
        return totalInafecto;
    }

    public void setTotalInafecto(Long totalInafecto) {
        this.totalInafecto = totalInafecto;
    }

    public Long getTotalExonerado() {
        return totalExonerado;
    }

    public void setTotalExonerado(Long totalExonerado) {
        this.totalExonerado = totalExonerado;
    }
}
