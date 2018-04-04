package org.openfact.pe.models.jpa;

import org.openfact.pe.models.BoletaFacturaPEModel;
import org.openfact.pe.models.jpa.entities.BoletaFacturaPEEntity;

import javax.persistence.EntityManager;

public class BoletaFacturaPEAdapter implements BoletaFacturaPEModel {

    public BoletaFacturaPEAdapter(EntityManager em, BoletaFacturaPEEntity entity) {

    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getIdAsignado() {
        return null;
    }

}
