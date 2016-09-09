package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.percentType;

/**
 * A class to define the price of an item as a percentage of the price of a
 * different item.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:26 a. m.
 */
public class DependentPriceReferenceEntity {

    /**
     * The percentage by which the price of the different item is multiplied to
     * calculate the price of the item.
     */
    private percentType percent;
    private AddressEntity locationAddress;
    private LineReferenceEntity dependentLineReference;

}
