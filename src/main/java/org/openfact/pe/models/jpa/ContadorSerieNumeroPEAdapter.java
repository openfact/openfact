package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ContadorSerieNumeroPEModel;
import org.openfact.pe.models.jpa.entities.ContadorSerieNumeroPEEntity;

import javax.persistence.EntityManager;

public class ContadorSerieNumeroPEAdapter implements ContadorSerieNumeroPEModel {

    public ContadorSerieNumeroPEAdapter(EntityManager em, ContadorSerieNumeroPEEntity entity) {

    }

    @Override
    public String getTipoDocumento() {
        return null;
    }

    @Override
    public int getSerie() {
        return 0;
    }

    @Override
    public int getNumero() {
        return 0;
    }

    @Override
    public String getPrefijo() {
        return null;
    }

}
