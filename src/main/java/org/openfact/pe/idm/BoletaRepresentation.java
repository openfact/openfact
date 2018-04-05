package org.openfact.pe.idm;

import javax.validation.constraints.Pattern;

public class BoletaRepresentation extends AbstractInvoiceRepresentation {

    @Pattern(regexp = "[B]{1}[A-Z]{1,}[0-9]{1,}")
    private String serie;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    
}
