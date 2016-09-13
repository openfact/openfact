package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class for describing the terms of a trade agreement.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:33 a. m.
 */
public class TradingTermsModel {

    /**
     * Text describing the terms of a trade agreement.
     */
    private TextModel information;
    /**
     * A reference quoting the basis of the terms
     */
    private TextModel reference;
    private AddressModel applicableAddress;

}