package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ContadorSerieNumeroPEModel;
import org.openfact.pe.models.jpa.entities.ContadorSerieNumeroEntity;

import javax.persistence.EntityManager;

public class ContadorSerieNumeroAdapter implements ContadorSerieNumeroPEModel {

    public ContadorSerieNumeroAdapter(EntityManager em, ContadorSerieNumeroEntity entity) {

    }

    @Override
    public String getSerie() {
        return null;
    }

    @Override
    public int getNumero() {
        return 0;
    }

    @Override
    public String getTipoDocumento() {
        return null;
    }
}
