package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class TaxSchemeModel {

    /**
     * A code signifying the currency in which the tax is collected and
     * reported.
     */
    private CurrencyCodeType codeTypeCurrencyCode;
    /**
     * An identifier for this taxation scheme.
     */
    private IdentifierType ID;
    /**
     * The name of this taxation scheme.
     */
    private NameType name;
    /**
     * A code signifying the type of tax.
     */
    private CodeType taxTypeCode;
    private AddressModel jurisdictionRegionAddress;

}
