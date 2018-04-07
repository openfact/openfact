package org.openfact.pe.idm;

import javax.validation.constraints.Pattern;

public class FacturaRepresentation extends AbstractInvoiceRepresentation {

    @Pattern(regexp = "[F][A-Z]+[0-9]+")
    private String serie;

    public FacturaRepresentation() {

    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

}
