package org.openfact.representations.idm.ubl.common;

public interface PartyTaxSchemeModel {

    String getRegistrationName();

    void setRegistrationName(String value);

    String getCompanyID();

    void setCompanyID(String value);

    String getTaxLevelCode();

    void setTaxLevelCode(String value);

    String getExemptionReasonCode();

    void setExemptionReasonCode(String value);

    String getExemptionReason();

    void setExemptionReason(String value);

    AddressModel getRegistrationAddress();

    void setRegistrationAddress(AddressModel value);

    TaxSchemeModel getTaxScheme();

    void setTaxScheme(TaxSchemeModel value);

    String getId();

    void setId(String value);

}
