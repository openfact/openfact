package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a price extension, calculated by multiplying the price
 * per unit by the quantity of items.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:54 a. m.
 */
public class PriceExtensionEntity {

    /**
     * The amount of this price extension.
     */
    private BigDecimal amount;
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
