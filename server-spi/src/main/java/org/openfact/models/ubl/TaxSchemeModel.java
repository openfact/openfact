package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

public interface TaxSchemeModel {

    CurrencyCodeType getCodeTypeCurrencyCode();

    void setCodeTypeCurrencyCode(CurrencyCodeType codeTypeCurrencyCode);

    IdentifierType getID();

    void setID(IdentifierType iD);

    NameType getName();

    void setName(NameType name);

    CodeType getTaxTypeCode();

    void setTaxTypeCode(CodeType taxTypeCode);

    AddressModel getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(AddressModel jurisdictionRegionAddress);

}
