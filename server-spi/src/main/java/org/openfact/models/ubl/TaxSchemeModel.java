package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

public interface TaxSchemeModel {

    CurrencyCodeModel getCodeTypeCurrencyCode();

    void setCodeTypeCurrencyCode(CurrencyCodeModel codeTypeCurrencyCode);

    IdentifierModel getID();

    void setID(IdentifierModel iD);

    NameModel getName();

    void setName(NameModel name);

    CodeModel getTaxTypeCode();

    void setTaxTypeCode(CodeModel taxTypeCode);

    AddressModel getJurisdictionRegionAddress();

    void setJurisdictionRegionAddress(AddressModel jurisdictionRegionAddress);

}
