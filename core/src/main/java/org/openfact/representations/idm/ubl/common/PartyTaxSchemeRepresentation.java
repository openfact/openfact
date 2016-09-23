package org.openfact.representations.idm.ubl.common;

public class PartyTaxSchemeRepresentation {
    private String registrationName;
    private String companyID;
    private String taxLevelCode;
    private String exemptionReasonCode;
    private String exemptionReason;
    private AddressRepresentation registrationAddress;
    private TaxSchemeRepresentation taxScheme;
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

    public String getExemptionReason() {
        return this.exemptionReason;
    }

    public void setExemptionReason(String exemptionReason) {
        this.exemptionReason = exemptionReason;
    }

    public AddressRepresentation getRegistrationAddress() {
        return this.registrationAddress;
    }

    public void setRegistrationAddress(AddressRepresentation registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getTaxLevelCode() {
        return this.taxLevelCode;
    }

    public void setTaxLevelCode(String taxLevelCode) {
        this.taxLevelCode = taxLevelCode;
    }

    public TaxSchemeRepresentation getTaxScheme() {
        return this.taxScheme;
    }

    public void setTaxScheme(TaxSchemeRepresentation taxScheme) {
        this.taxScheme = taxScheme;
    }

    public String getExemptionReasonCode() {
        return this.exemptionReasonCode;
    }

    public void setExemptionReasonCode(String exemptionReasonCode) {
        this.exemptionReasonCode = exemptionReasonCode;
    }
}