package org.openfact.representations.idm.ubl.common;

import java.util.List;

public interface CorporateRegistrationSchemeModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    String getCorporateRegistrationModelCode();

    void setCorporateRegistrationModelCode(String value);

    List<AddressModel> getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress);

    String getId();

    void setId(String value);

}
