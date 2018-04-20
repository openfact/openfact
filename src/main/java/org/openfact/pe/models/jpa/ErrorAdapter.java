package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ErrorModel;
import org.openfact.pe.models.ErrorType;
import org.openfact.pe.models.jpa.entities.ErrorEntity;

public class ErrorAdapter implements ErrorModel {

    private ErrorEntity error;

    public ErrorAdapter(ErrorEntity error) {
        this.error = error;
    }

    @Override
    public String getId() {
        return error.getId();
    }

    @Override
    public ErrorType getTipo() {
        return error.getTipo();
    }

    @Override
    public String getDescripcion() {
        return error.getDescripcion();
    }
}
