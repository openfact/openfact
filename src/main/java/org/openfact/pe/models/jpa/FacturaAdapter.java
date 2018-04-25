package org.openfact.pe.models.jpa;

import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.jpa.entities.FacturaEntity;
import org.openfact.pe.models.jpa.entities.InvoiceEntity;

import javax.persistence.EntityManager;

public class FacturaAdapter extends AbstractInvoiceAdapter implements FacturaModel {

    private final FacturaEntity factura;

    public FacturaAdapter(EntityManager em, FacturaEntity factura) {
        super(em, factura);
        this.factura = factura;
    }

    @Override
    public InvoiceEntity getEntity() {
        return factura;
    }
}
