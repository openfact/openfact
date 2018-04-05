package org.openfact.pe.models.jpa;

import org.openfact.pe.models.BoletaFacturaModel;
import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.TipoInvoice;
import org.openfact.pe.models.jpa.entities.BoletaFacturaEntity;

import javax.persistence.EntityManager;
import java.util.Date;

public class BoletaFacturaAdapter implements BoletaFacturaModel {

    public BoletaFacturaAdapter(EntityManager em, BoletaFacturaEntity entity) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public TipoInvoice getTipoInvoice() {
        return null;
    }

    @Override
    public String getIdAsignado() {
        return null;
    }

    @Override
    public Date getFechaEmision() {
        return null;
    }

    @Override
    public Date getFechaVencimiento() {
        return null;
    }

    @Override
    public String getMoneda() {
        return null;
    }

    @Override
    public String getObservacion() {
        return null;
    }

    @Override
    public ClienteModel getCliente() {
        return null;
    }

}
