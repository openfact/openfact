package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class InformacionAdicionalTotalPERepresentation {

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private Long totalGravada;

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private Long totalGratuita;

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private Long totalInfafecta;

    @NotNull
    @Digits(integer = 10,fraction = 2)
    private Long totalExonerada;

    public Long getTotalGravada() {
        return totalGravada;
    }

    public void setTotalGravada(Long totalGravada) {
        this.totalGravada = totalGravada;
    }

    public Long getTotalGratuita() {
        return totalGratuita;
    }

    public void setTotalGratuita(Long totalGratuita) {
        this.totalGratuita = totalGratuita;
    }

    public Long getTotalInfafecta() {
        return totalInfafecta;
    }

    public void setTotalInfafecta(Long totalInfafecta) {
        this.totalInfafecta = totalInfafecta;
    }

    public Long getTotalExonerada() {
        return totalExonerada;
    }

    public void setTotalExonerada(Long totalExonerada) {
        this.totalExonerada = totalExonerada;
    }
}
