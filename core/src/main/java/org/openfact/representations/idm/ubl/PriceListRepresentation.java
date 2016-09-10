package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;

/**
 * A class to describe a price list.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:56 a. m.
 */
public class PriceListRepresentation {

    /**
     * An identifier for this price list.
     */
    private IdentifierType ID;
    /**
     * A code signifying whether this price list is an original, copy, revision,
     * or cancellation.
     */
    private CodeType statusCode;
    private PeriodRepresentation validityPeriod;
    private PriceListRepresentation previousPriceList;

}
