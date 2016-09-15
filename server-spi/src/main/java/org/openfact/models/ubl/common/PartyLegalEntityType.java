package org.openfact.models.ubl.common;

public interface PartyLegalEntityType {

    RegistrationNameType getRegistrationName();

    void setRegistrationName(RegistrationNameType value);

    CompanyIDType getCompanyID();

    void setCompanyID(CompanyIDType value);

    AddressType getRegistrationAddress();

    void setRegistrationAddress(AddressType value);

    CorporateRegistrationSchemeType getCorporateRegistrationScheme();

    void setCorporateRegistrationScheme(CorporateRegistrationSchemeType value);

    String getId();

    void setId(String value);

}
