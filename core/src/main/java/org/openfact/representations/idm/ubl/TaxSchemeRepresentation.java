package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.CurrencyCodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.NameType;

/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class TaxSchemeRepresentation {

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
    private AddressRepresentation jurisdictionRegionAddress;

}
