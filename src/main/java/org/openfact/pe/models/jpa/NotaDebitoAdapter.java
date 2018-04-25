package org.openfact.pe.models.jpa;

import org.openfact.pe.models.NotaDebitoModel;
import org.openfact.pe.models.jpa.entities.NotaDebitoEntity;
import org.openfact.pe.models.jpa.entities.NotaEntity;

import javax.persistence.EntityManager;

public class NotaDebitoAdapter extends AbstractNotaAdapter implements NotaDebitoModel {

    private NotaDebitoEntity notaDebito;

    public NotaDebitoAdapter(EntityManager em, NotaDebitoEntity notaDebito) {
        super(em, notaDebito);
        this.notaDebito = notaDebito;
    }

    @Override
    public NotaEntity getEntity() {
        return notaDebito;
    }
}
