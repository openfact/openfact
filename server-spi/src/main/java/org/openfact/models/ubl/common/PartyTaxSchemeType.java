package org.openfact.models.ubl.common;

public interface PartyTaxSchemeType {

    RegistrationNameType getRegistrationName();

    void setRegistrationName(RegistrationNameType value);

    CompanyIDType getCompanyID();

    void setCompanyID(CompanyIDType value);

    TaxLevelCodeType getTaxLevelCode();

    void setTaxLevelCode(TaxLevelCodeType value);

    ExemptionReasonCodeType getExemptionReasonCode();

    void setExemptionReasonCode(ExemptionReasonCodeType value);

    ExemptionReasonType getExemptionReason();

    void setExemptionReason(ExemptionReasonType value);

    AddressType getRegistrationAddress();

    void setRegistrationAddress(AddressType value);

    TaxSchemeType getTaxScheme();

    void setTaxScheme(TaxSchemeType value);

    String getId();

    void setId(String value);

}
