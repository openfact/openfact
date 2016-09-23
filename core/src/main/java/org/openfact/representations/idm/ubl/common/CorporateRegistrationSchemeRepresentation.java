package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class CorporateRegistrationSchemeRepresentation {
    private String idUbl;
    private String name;
    private String corporateRegistrationRepresentationCode;
    private List<AddressRepresentation> jurisdictionRegionAddress;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorporateRegistrationRepresentationCode() {
        return this.corporateRegistrationRepresentationCode;
    }

    public void setCorporateRegistrationRepresentationCode(String corporateRegistrationRepresentationCode) {
        this.corporateRegistrationRepresentationCode = corporateRegistrationRepresentationCode;
    }

    public List<AddressRepresentation> getJurisdictionRegionAddress() {
        return this.jurisdictionRegionAddress;
    }

    public void setJurisdictionRegionAddress(List<AddressRepresentation> jurisdictionRegionAddress) {
        this.jurisdictionRegionAddress = jurisdictionRegionAddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}