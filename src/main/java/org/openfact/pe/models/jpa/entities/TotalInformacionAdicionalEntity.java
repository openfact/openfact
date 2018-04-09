package org.openfact.pe.models.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class TotalInformacionAdicionalEntity {

    @Column(name = "total_gravado")
    private BigDecimal gravado;

    @Column(name = "total_gratuito")
    private BigDecimal gratuito;

    @Column(name = "total_inafecto")
    private BigDecimal inafecto;

    @Column(name = "total_exonerado")
    private BigDecimal exonerado;

    public BigDecimal getGravado() {
        return gravado;
    }

    public void setGravado(BigDecimal gravado) {
        this.gravado = gravado;
    }

    public BigDecimal getGratuito() {
        return gratuito;
    }

    public void setGratuito(BigDecimal gratuito) {
        this.gratuito = gratuito;
    }

    public BigDecimal getInafecto() {
        return inafecto;
    }

    public void setInafecto(BigDecimal inafecto) {
        this.inafecto = inafecto;
    }

    public BigDecimal getExonerado() {
        return exonerado;
    }

    public void setExonerado(BigDecimal exonerado) {
        this.exonerado = exonerado;
    }

}
