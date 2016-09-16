package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class LocationRepresentationCommAgg {
    private String ID;
    private String description;
    private String conditions;
    private String countrySubentity;
    private String countrySubentityCode;
    private List<PeriodRepresentation> validityPeriod;
    private AddressRepresentation address;
    private String id;

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getConditions() {
        return this.conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getCountrySubentity() {
        return this.countrySubentity;
    }

    public void setCountrySubentity(String countrySubentity) {
        this.countrySubentity = countrySubentity;
    }

    public List<PeriodRepresentation> getValidityPeriod() {
        return this.validityPeriod;
    }

    public void setValidityPeriod(List<PeriodRepresentation> validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountrySubentityCode() {
        return this.countrySubentityCode;
    }

    public void setCountrySubentityCode(String countrySubentityCode) {
        this.countrySubentityCode = countrySubentityCode;
    }

    public AddressRepresentation getAddress() {
        return this.address;
    }

    public void setAddress(AddressRepresentation address) {
        this.address = address;
    }
}