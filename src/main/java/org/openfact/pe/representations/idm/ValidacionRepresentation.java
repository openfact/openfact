package org.openfact.pe.representations.idm;

import java.util.List;

public class ValidacionRepresentation {

    private Boolean estado;
    private String error;
    private String errorDescripcion;

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }
}
