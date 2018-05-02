package org.openfact.pe.representations.idm;

import java.util.Date;

public class FechaRepresentation {

    private Date emision;
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
