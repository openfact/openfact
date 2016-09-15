package org.openfact.models.ubl.common;

import java.util.List;

public interface TaxSchemeType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    TaxTypeCodeType getTaxTypeCode();

    void setTaxTypeCode(TaxTypeCodeType value);

    CurrencyCodeTypeCommBas getCurrencyCode();

    void setCurrencyCode(CurrencyCodeTypeCommBas value);

    List<AddressType> getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(List<AddressType> jurisdictionRegionAddress);

    String getId();

    void setId(String value);

}
