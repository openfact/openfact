package org.openfact.representations.idm.ubl.common;

public class PartyLegalEntityRepresentation {
    private String registrationName;
    private String companyID;
    private AddressRepresentation registrationAddress;
    private CorporateRegistrationSchemeRepresentation corporateRegistrationScheme;
    private String id;

    public String getRegistrationName() {
        return this.registrationName;
    }

    public void setRegistrationName(String registrationName) {
        this.registrationName = registrationName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AddressRepresentation getRegistrationAddress() {
        return this.registrationAddress;
    }

    public void setRegistrationAddress(AddressRepresentation registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public CorporateRegistrationSchemeRepresentation getCorporateRegistrationScheme() {
        return this.corporateRegistrationScheme;
    }

    public void setCorporateRegistrationScheme(
            CorporateRegistrationSchemeRepresentation corporateRegistrationScheme) {
        this.corporateRegistrationScheme = corporateRegistrationScheme;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }
}