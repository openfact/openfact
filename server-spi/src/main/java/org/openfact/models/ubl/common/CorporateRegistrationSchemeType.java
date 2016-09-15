package org.openfact.models.ubl.common;

import java.util.List;

public interface CorporateRegistrationSchemeType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    CorporateRegistrationTypeCodeType getCorporateRegistrationTypeCode();

    void setCorporateRegistrationTypeCode(CorporateRegistrationTypeCodeType value);

    List<AddressType> getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(List<AddressType> jurisdictionRegionAddress);

    String getId();

    void setId(String value);

}
