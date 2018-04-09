package org.openfact.pe.models.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class TotalEntity {

    @Column(name = "total_pagar")
    private BigDecimal pagar;

    @Column(name = "total_descuento_global")
    private BigDecimal descuento;

    @Column(name = "total_otros_cargos")
    private BigDecimal otrosCargos;

    public BigDecimal getPagar() {
        return pagar;
    }

    public void setPagar(BigDecimal pagar) {
        this.pagar = pagar;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getOtrosCargos() {
        return otrosCargos;
    }

    public void setOtrosCargos(BigDecimal otrosCargos) {
        this.otrosCargos = otrosCargos;
    }
}
