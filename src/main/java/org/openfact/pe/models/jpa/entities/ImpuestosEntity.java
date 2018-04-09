package org.openfact.pe.models.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class ImpuestosEntity {

    @Column(name = "igv")
    private BigDecimal igv;

    @Column(name = "isc")
    private BigDecimal isc;

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIsc() {
        return isc;
    }

    public void setIsc(BigDecimal isc) {
        this.isc = isc;
    }

}
