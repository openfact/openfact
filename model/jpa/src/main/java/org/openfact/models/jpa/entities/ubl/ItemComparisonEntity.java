package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.QuantityType;

/**
 * A class to provide information about price and quantity of an item for use in
 * price comparisons based on price, quantity, or measurements.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:40 a. m.
 */
public class ItemComparisonEntity {

    /**
     * The price for the ItemComparison
     */
    private AmountType PriceAmount;
    /**
     * The quantity for which this comparison is valid.
     */
    private QuantityType Quantity;

}
