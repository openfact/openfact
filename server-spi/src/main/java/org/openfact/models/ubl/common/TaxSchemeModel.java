package org.openfact.models.ubl.common;

import java.util.List;

public interface TaxSchemeModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    String getTaxModelCode();

    void setTaxModelCode(String value);

    String getCurrencyCode();

    void setCurrencyCode(String value);

    List<AddressModel> getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress);

    String getId();

    void setId(String value);

}
