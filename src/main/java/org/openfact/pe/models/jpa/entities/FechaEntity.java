package org.openfact.pe.models.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class FechaEntity {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_emision")
    private Date emision;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_vencimiento")
    private Date vencimiento;

    public Date getEmision() {
        return emision;
    }

    public void setEmision(Date emision) {
        this.emision = emision;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }
}
