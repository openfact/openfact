package org.openfact.pe.models.jpa;

import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.NotaCreditoEntity;
import org.openfact.pe.models.jpa.entities.NotaEntity;

import javax.persistence.EntityManager;

public class NotaCreditoAdapter extends AbstractNotaAdapter implements NotaCreditoModel {

    private final NotaCreditoEntity notaCredito;

    public NotaCreditoAdapter(EntityManager em, NotaCreditoEntity notaCredito) {
        super(em, notaCredito);
        this.notaCredito = notaCredito;
    }

    @Override
    public NotaEntity getEntity() {
        return notaCredito;
    }
}
