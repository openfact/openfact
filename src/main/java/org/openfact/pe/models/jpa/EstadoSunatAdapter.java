package org.openfact.pe.models.jpa;

import org.openfact.pe.models.Labels;
import org.openfact.pe.models.EstadoSunatModel;
import org.openfact.pe.models.jpa.entities.EstadoSunatEntity;

public class EstadoSunatAdapter implements EstadoSunatModel {

    private final EstadoSunatEntity validacion;

    public EstadoSunatAdapter(EstadoSunatEntity validacion) {
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
    public String getCodigo() {
        return validacion.getCodigo();
    }

    @Override
    public void setCodigo(String codigo) {
        validacion.setCodigo(codigo);
    }

    @Override
    public String getDescripcion() {
        return validacion.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        validacion.setDescripcion(descripcion);
    }

}
