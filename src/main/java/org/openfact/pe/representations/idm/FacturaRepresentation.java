package org.openfact.pe.representations.idm;

import javax.validation.constraints.Pattern;

public class FacturaRepresentation extends AbstractDocumentoRepresentation {

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
