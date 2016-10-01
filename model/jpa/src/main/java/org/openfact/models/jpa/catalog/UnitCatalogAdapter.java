package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.UnitCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.UnitCatalogEntity;

public class UnitCatalogAdapter implements UnitCatalogModel, JpaModel<UnitCatalogEntity> {

    protected static final Logger logger = Logger.getLogger(UnitCatalogAdapter.class);
    protected UnitCatalogEntity unitCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public UnitCatalogAdapter(UnitCatalogEntity unitCatalog, EntityManager em, OpenfactSession session) {
        this.unitCatalog = unitCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public UnitCatalogEntity getEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getSymbol() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSymbol(String symbol) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDescription(String description) {
        // TODO Auto-generated method stub

    }

}
