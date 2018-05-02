package org.openfact.pe.representations.idm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class BajaRepresentation {

    private Date fechaEmisionBaja;
    private Integer numero;

    @NotNull
    private String invoiceAfectado;

    @NotNull
    private String motivoBaja;

    public String getInvoiceAfectado() {
        return invoiceAfectado;
    }

    public void setInvoiceAfectado(String invoiceAfectado) {
        this.invoiceAfectado = invoiceAfectado;
    }

    public Date getFechaEmisionBaja() {
        return fechaEmisionBaja;
    }

    public void setFechaEmisionBaja(Date fechaEmisionBaja) {
        this.fechaEmisionBaja = fechaEmisionBaja;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }
}
