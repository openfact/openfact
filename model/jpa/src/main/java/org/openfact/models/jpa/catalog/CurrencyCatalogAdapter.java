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

    public CurrencyCatalogAdapter(OpenfactSession session, EntityManager em,
            CurrencyCatalogEntity currencyCatalog) {
        this.currencyCatalog = currencyCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public CurrencyCatalogEntity getEntity() {
        return currencyCatalog;
    }

    @Override
    public String getId() {
        return currencyCatalog.getId();
    }

    @Override
    public void setId(String id) {
        currencyCatalog.setId(id);
    }

    @Override
    public String getEntityName() {
        return currencyCatalog.getEntityName();
    }

    @Override
    public void setEntityName(String entity) {
        currencyCatalog.setEntityName(entity);
    }

    @Override
    public String getCurrency() {
        return currencyCatalog.getCurrency();
    }

    @Override
    public void setCurrency(String currency) {
        currencyCatalog.setCurrency(currency);
    }

    @Override
    public String getAlphabeticCode() {
        return currencyCatalog.getAlphabeticCode();
    }

    @Override
    public void setAlphabeticCode(String alphabeticCode) {
        currencyCatalog.setAlphabeticCode(alphabeticCode);
    }

    @Override
    public String getNumericCode() {
        return currencyCatalog.getNumericCode();
    }

    @Override
    public void setNumericCode(String numericCode) {
        currencyCatalog.setNumericCode(numericCode);
    }

    @Override
    public int getMinorUnit() {
        return currencyCatalog.getMinorUnit();
    }

    @Override
    public void setMinorUnit(int minorUnit) {
        currencyCatalog.setMinorUnit(minorUnit);
    }

}
