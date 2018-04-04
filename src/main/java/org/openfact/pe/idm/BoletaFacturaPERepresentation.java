package org.openfact.pe.idm;

import javax.validation.constraints.Pattern;

public class BoletaFacturaPERepresentation {

    private String id;
    private String serie;
    private Integer numero;
    private String tipoInvoice;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipoInvoice() {
        return tipoInvoice;
    }

    public void setTipoInvoice(String tipoInvoice) {
        this.tipoInvoice = tipoInvoice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
