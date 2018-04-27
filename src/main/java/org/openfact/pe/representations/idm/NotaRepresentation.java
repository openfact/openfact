package org.openfact.pe.representations.idm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NotaRepresentation extends DocumentoBaseRepresentation {

    @NotNull
    @Size(max = 2)
    private String codigoTipoComprobante;

    @NotNull
    @Size(max = 2)
    private String codigoMotivo;

    @NotNull
    private String invoiceAfectado;


    public String getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }

    public void setCodigoTipoComprobante(String codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }

    public String getCodigoMotivo() {
        return codigoMotivo;
    }

    public void setCodigoMotivo(String codigoMotivo) {
        this.codigoMotivo = codigoMotivo;
    }

    public String getInvoiceAfectado() {
        return invoiceAfectado;
    }

    public void setInvoiceAfectado(String invoiceAfectado) {
        this.invoiceAfectado = invoiceAfectado;
    }
}
