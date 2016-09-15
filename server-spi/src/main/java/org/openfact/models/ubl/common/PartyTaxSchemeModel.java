package org.openfact.models.ubl.common;

public interface PartyTaxSchemeModel {

    RegistrationNameModel getRegistrationName();

    void setRegistrationName(RegistrationNameModel value);

    CompanyIDModel getCompanyID();

    void setCompanyID(CompanyIDModel value);

    TaxLevelCodeModel getTaxLevelCode();

    void setTaxLevelCode(TaxLevelCodeModel value);

    ExemptionReasonCodeModel getExemptionReasonCode();

    void setExemptionReasonCode(ExemptionReasonCodeModel value);

    ExemptionReasonModel getExemptionReason();

    void setExemptionReason(ExemptionReasonModel value);

    AddressModel getRegistrationAddress();

    void setRegistrationAddress(AddressModel value);

    TaxSchemeModel getTaxScheme();

    void setTaxScheme(TaxSchemeModel value);

    String getId();

    void setId(String value);

}
