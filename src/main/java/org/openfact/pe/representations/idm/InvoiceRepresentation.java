package org.openfact.pe.representations.idm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InvoiceRepresentation extends DocumentoBaseRepresentation {

    @NotNull
    @Size(max = 2)
    private String codigoTipoComprobante;

    public String getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }

    public void setCodigoTipoComprobante(String codigoTipoComprobante) {
        this.codigoTipoComprobante = codigoTipoComprobante;
    }

}
