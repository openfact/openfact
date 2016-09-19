package org.openfact.models.jpa.ubl.common;

import java.util.List;

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

    String getID() {
        return this.locationCommAgg.getID();
    }

    void setID(String value) {
        this.locationCommAgg.setID(value);
    }

    String getDescription() {
        return this.locationCommAgg.getDescription();
    }

    void setDescription(String value) {
        this.locationCommAgg.setDescription(value);
    }

    String getConditions() {
        return this.locationCommAgg.getConditions();
    }

    void setConditions(String value) {
        this.locationCommAgg.setConditions(value);
    }

    String getCountrySubentity() {
        return this.locationCommAgg.getCountrySubentity();
    }

    void setCountrySubentity(String value) {
        this.locationCommAgg.setCountrySubentity(value);
    }

    String getCountrySubentityCode() {
        return this.locationCommAgg.getCountrySubentityCode();
    }

    void setCountrySubentityCode(String value) {
        this.locationCommAgg.setCountrySubentityCode(value);
    }

    List<PeriodAdapter> getValidityPeriod() {
        return this.locationCommAgg.getValidityPeriod();
    }

    void setValidityPeriod(List<PeriodAdapter> validityPeriod) {
        this.locationCommAgg.setValidityPeriod(validityPeriod);
    }

    AddressAdapter getAddress() {
        return this.locationCommAgg.getAddress();
    }

    void setAddress(AddressAdapter value) {
        this.locationCommAgg.setAddress(value);
    }

    String getId() {
        return this.locationCommAgg.getId();
    }

    void setId(String value) {
        this.locationCommAgg.setId(value);
    }

}
