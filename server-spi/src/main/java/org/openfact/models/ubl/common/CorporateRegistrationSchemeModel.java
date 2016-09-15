package org.openfact.models.ubl.common;

import java.util.List;

public interface CorporateRegistrationSchemeModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    String getCorporateRegistrationModelCode();

    void setCorporateRegistrationModelCode(String value);

    List<AddressModel> getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress);

    String getId();

    void setId(String value);

}
