package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.PeriodModel;

public class LocationAdapterCommAgg implements LocationCommAggModel, JpaModel<LocationCommAggEntity> {

    protected static final Logger logger = Logger.getLogger(LocationAdapterCommAgg.class);
    protected LocationCommAggEntity locationCommAgg;
    protected EntityManager em;
    protected OpenfactSession session;

public LocationCommAggAdapter(OpenfactSession session, EntityManager em, LocationCommAggEntity locationCommAgg){
this.session = session;
this.em = em;
this.locationCommAgg = locationCommAgg;
}

    @Override
    public String getID() {
        return this.locationCommAgg.getID();
    }

    @Override
    public void setID(String value) {
        this.locationCommAgg.setID(value);
    }

    @Override
    public String getDescription() {
        return this.locationCommAgg.getDescription();
    }

    @Override
    public void setDescription(String value) {
        this.locationCommAgg.setDescription(value);
    }

    @Override
    public String getConditions() {
        return this.locationCommAgg.getConditions();
    }

    @Override
    public void setConditions(String value) {
        this.locationCommAgg.setConditions(value);
    }

    @Override
    public String getCountrySubentity() {
        return this.locationCommAgg.getCountrySubentity();
    }

    @Override
    public void setCountrySubentity(String value) {
        this.locationCommAgg.setCountrySubentity(value);
    }

    @Override
    public String getCountrySubentityCode() {
        return this.locationCommAgg.getCountrySubentityCode();
    }

    @Override
    public void setCountrySubentityCode(String value) {
        this.locationCommAgg.setCountrySubentityCode(value);
    }

    @Override
    public List<PeriodModel> getValidityPeriod() {
        return this.locationCommAgg.getValidityPeriod();
    }

    @Override
    public void setValidityPeriod(List<PeriodAdapter> validityPeriod) {
        this.locationCommAgg.setValidityPeriod(validityPeriod);
    }

    @Override
    public AddressModel getAddress() {
        return this.locationCommAgg.getAddress();
    }

    @Override
    public void setAddress(AddressAdapter value) {
        this.locationCommAgg.setAddress(value);
    }

    @Override
    public String getId() {
        return this.locationCommAgg.getId();
    }

    @Override
    public void setId(String value) {
        this.locationCommAgg.setId(value);
    }

}
