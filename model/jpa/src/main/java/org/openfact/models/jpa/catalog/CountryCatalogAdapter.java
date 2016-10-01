package org.openfact.models.jpa.catalog;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.catalog.CountryCatalogModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.catalog.CountryCatalogEntity;

public class CountryCatalogAdapter implements CountryCatalogModel, JpaModel<CountryCatalogEntity> {

    protected static final Logger logger = Logger.getLogger(CountryCatalogAdapter.class);
    protected CountryCatalogEntity countryCatalog;
    protected EntityManager em;
    protected OpenfactSession session;

    public CountryCatalogAdapter(CountryCatalogEntity countryCatalog, EntityManager em,
            OpenfactSession session) {

        this.countryCatalog = countryCatalog;
        this.em = em;
        this.session = session;
    }

    @Override
    public CountryCatalogEntity getEntity() {
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
    public String getShortName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setShortName(String shortName) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAlpha2Code() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAlpha2Code(String alpha2Code) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getAlpha3Code() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAlpha3Code(String alpha3Code) {
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

}
