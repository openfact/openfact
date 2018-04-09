package org.openfact.pe.models.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class MonedaEntity {

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "tipo_cambio")
    private BigDecimal tipoCambio;

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String codigo) {
        this.moneda = codigo;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
