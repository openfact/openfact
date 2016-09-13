package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A simplified version of the PriceRepresentation class intended for
 * applications such as telephone billing.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:54 a. m.
 */
public class UnstructuredPriceRepresentation {

    /**
     * The price amount.
     */
    private BigDecimal priceAmount;
    /**
     * The usage time upon which the price is based.
     */
    private TextRepresentation timeAmount;

}
