package org.openfact.models.ubl.common;

import java.util.List;

public interface CorporateRegistrationSchemeModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    CorporateRegistrationModelCodeModel getCorporateRegistrationModelCode();

    void setCorporateRegistrationModelCode(CorporateRegistrationModelCodeModel value);

    List<AddressModel> getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress);

    String getId();

    void setId(String value);

}
