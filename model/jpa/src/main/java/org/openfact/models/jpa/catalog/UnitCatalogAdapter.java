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

    public UnitCatalogAdapter(OpenfactSession session, EntityManager em, UnitCatalogEntity unitCatalog) {
        this.unitCatalog = unitCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public UnitCatalogEntity getEntity() {
        return unitCatalog;
    }

    @Override
    public String getId() {
        return unitCatalog.getId();
    }

    @Override
    public String getName() {
        return unitCatalog.getName();
    }

    @Override
    public void setName(String name) {
        unitCatalog.setName(name);
    }

    @Override
    public String getSymbol() {
        return unitCatalog.getSymbol();
    }

    @Override
    public void setSymbol(String symbol) {
        unitCatalog.setSymbol(symbol);
    }

    @Override
    public String getDescription() {
        return getDescription();
    }

    @Override
    public void setDescription(String description) {
        unitCatalog.setDescription(description);
    }

}
