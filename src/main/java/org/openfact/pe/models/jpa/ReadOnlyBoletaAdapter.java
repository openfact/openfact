package org.openfact.pe.models.jpa;

import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.jpa.entities.BoletaEntity;

import javax.persistence.EntityManager;
import java.util.Date;

public class ReadOnlyBoletaAdapter extends BoletaAdapter {

    public ReadOnlyBoletaAdapter(EntityManager em, BoletaEntity boleta) {
        super(em, boleta);
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setEnviarSUNAT(boolean enviarSUNAT) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setError(String error) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setFileId(String fileId) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setFileProvider(String fileProvider) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setObservaciones(String observaciones) {
        ReadOnlyUtils.throwException();
    }

}
