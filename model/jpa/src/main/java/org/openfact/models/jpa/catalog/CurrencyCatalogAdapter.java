package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CurrencyCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.CurrencyCatalogEntity;

public class CurrencyCatalogAdapter implements CurrencyCatalogModel, JpaModel<CurrencyCatalogEntity> {

    protected static final Logger logger = Logger.getLogger(CurrencyCatalogAdapter.class);
    protected CurrencyCatalogEntity currencyCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public CurrencyCatalogAdapter(CurrencyCatalogEntity currencyCatalog, EntityManager em,
            OpenfactSession session) {
        this.currencyCatalog = currencyCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public CurrencyCatalogEntity getEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getEntityName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setEntityName(String entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCurrency() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCurrency(String currency) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAlphabeticCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAlphabeticCode(String alphabeticCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getNumericCode() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setNumericCode(String numericCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMinorUnit() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMinorUnit(int minorUnit) {
        // TODO Auto-generated method stub

    }

}
