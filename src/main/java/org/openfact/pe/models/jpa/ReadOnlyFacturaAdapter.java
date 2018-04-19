package org.openfact.pe.models.jpa;

import org.openfact.pe.models.DetalleComprobantePagoBean;
import org.openfact.pe.models.DetalleComprobantePagoModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.ModelReadOnlyException;
import org.openfact.pe.models.jpa.entities.FacturaEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ReadOnlyFacturaAdapter extends FacturaAdapter {

    public ReadOnlyFacturaAdapter(EntityManager em, FacturaEntity factura) {
        super(em, factura);
    }

    @Override
    public void setObservaciones(String observaciones) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setFileId(String fileId) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setCdrFileId(String fileId) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setEstadoDescripcion(String estadoDescripcion) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setEnviarSunat(boolean enviarSUNAT) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public List<DetalleComprobantePagoModel> setDetalle(List<DetalleComprobantePagoBean> beans) {
        throw new ModelReadOnlyException();
    }
}
