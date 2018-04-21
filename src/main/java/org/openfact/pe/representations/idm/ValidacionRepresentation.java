package org.openfact.pe.representations.idm;

import java.util.List;

public class ValidacionRepresentation {

    private Boolean estado;
    private List<ErrorRepresentation> errores;

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<ErrorRepresentation> getErrores() {
        return errores;
    }

    public void setErrores(List<ErrorRepresentation> errores) {
        this.errores = errores;
    }
}
