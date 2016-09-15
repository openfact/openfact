package org.openfact.models.ubl.common;

public interface PartyLegalEntityModel {

    RegistrationNameModel getRegistrationName();

    void setRegistrationName(RegistrationNameModel value);

    CompanyIDModel getCompanyID();

    void setCompanyID(CompanyIDModel value);

    AddressModel getRegistrationAddress();

    void setRegistrationAddress(AddressModel value);

    CorporateRegistrationSchemeModel getCorporateRegistrationScheme();

    void setCorporateRegistrationScheme(CorporateRegistrationSchemeModel value);

    String getId();

    void setId(String value);

}
