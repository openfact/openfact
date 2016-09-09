package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.CurrencyCodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;

/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class TaxSchemeEntity {

    /**
     * A code signifying the currency in which the tax is collected and
     * reported.
     */
    private CurrencyCodeType CodeTypeCurrencyCode;
    /**
     * An identifier for this taxation scheme.
     */
    private IdentifierType ID;
    /**
     * The name of this taxation scheme.
     */
    private NameType Name;
    /**
     * A code signifying the type of tax.
     */
    private CodeType TaxTypeCode;
    private AddressEntity JurisdictionRegionAddress;

}
