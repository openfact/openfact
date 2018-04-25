package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ErrorType;
import org.openfact.pe.models.ValidacionModel;
import org.openfact.pe.models.jpa.entities.ValidacionEntity;

import javax.persistence.EntityManager;

public class ValidacionAdapter implements ValidacionModel {

    private final ValidacionEntity validacion;

    public ValidacionAdapter(ValidacionEntity validacion) {
        this.validacion = validacion;
    }

    @Override
    public String getId() {
        return validacion.getId();
    }

    @Override
    public boolean getEstado() {
        return validacion.isEstado();
    }

    @Override
    public void setEstado(boolean estado) {
        validacion.setEstado(estado);
    }

    @Override
    public ErrorType getError() {
        return validacion.getError();
    }

    @Override
    public void setError(ErrorType error) {
        validacion.setError(error);
    }

    @Override
    public String getErrorDescripcion() {
        return validacion.getErrorDescripcion();
    }

    @Override
    public void setErrorDescripcion(String descripcion) {
        validacion.setErrorDescripcion(descripcion);
    }

}
