package org.openfact.pe.representations.idm;

import java.util.List;

public class ValidacionRepresentation {

    private Boolean estado;
    private List<ErrorRepresentation> error;

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<ErrorRepresentation> getError() {
        return error;
    }

    public void setError(List<ErrorRepresentation> error) {
        this.error = error;
    }
}
