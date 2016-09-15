package org.openfact.models.ubl.common;

import java.util.List;

public interface TaxSchemeModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    TaxModelCodeModel getTaxModelCode();

    void setTaxModelCode(TaxModelCodeModel value);

    CurrencyCodeModelCommBas getCurrencyCode();

    void setCurrencyCode(CurrencyCodeModelCommBas value);

    List<AddressModel> getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(List<AddressModel> jurisdictionRegionAddress);

    String getId();

    void setId(String value);

}
