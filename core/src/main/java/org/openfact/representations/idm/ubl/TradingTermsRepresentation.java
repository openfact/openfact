package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class for describing the terms of a trade agreement.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:33 a. m.
 */
public class TradingTermsRepresentation {

    /**
     * Text describing the terms of a trade agreement.
     */
    private TextRepresentation information;
    /**
     * A reference quoting the basis of the terms
     */
    private TextRepresentation reference;
    private AddressRepresentation applicableAddress;

}
