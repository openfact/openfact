package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

/**
 * A class to define the price of an item as a percentage of the price of a
 * different item.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:26 a. m.
 */
public class DependentPriceReferenceRepresentation {

    /**
     * The percentage by which the price of the different item is multiplied to
     * calculate the price of the item.
     */
    private BigDecimal percent;
    private AddressRepresentation locationAddress;
    private LineReferenceRepresentation dependentLineReference;

}
