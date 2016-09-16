package org.openfact.representations.idm.ubl.common;

public interface PartyLegalEntityModel {

    String getRegistrationName();

    void setRegistrationName(String value);

    String getCompanyID();

    void setCompanyID(String value);

    AddressModel getRegistrationAddress();

    void setRegistrationAddress(AddressModel value);

    CorporateRegistrationSchemeModel getCorporateRegistrationScheme();

    void setCorporateRegistrationScheme(CorporateRegistrationSchemeModel value);

    String getId();

    void setId(String value);

}
