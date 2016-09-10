package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a management profile for an item.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:48 a. m.
 */
public class ItemManagementProfileModel {

    /**
     * The number of days in the future that an order forecast quantity
     * automatically becomes a confirmed order for a product.
     */
    private BigDecimal frozenPeriodDaysNumeric;
    /**
     * The quantity of the item that should trigger a replenishment order to
     * avoid depleting the safety stock.
     */
    private QuantityType minimumInventoryQuantity;
    /**
     * The order quantity multiples in which the product may be ordered.
     */
    private QuantityType multipleOrderQuantity;
    /**
     * The number of days between regular replenishment orders for the product.
     */
    private BigDecimal orderIntervalDaysNumeric;
    /**
     * The trading partner maintaining this item management profile.
     */
    private TextType replenishmentOwnerDescription;
    /**
     * The target inventory quantity.
     */
    private QuantityType targetInventoryQuantity;
    /**
     * The Unit Service Level the trading partners expect to be maintained,
     * expressed as a percentage. Unite Service Level (USL) is a term used in
     * Inventory Management, which is sometimes known as "fill rate", counts the
     * average number of units short expressed a
     */
    private BigDecimal targetServicePercent;
    private List<ItemModel> items = new ArrayList<>();
    private List<ItemLocationQuantityModel> itemsLocationQuantity = new ArrayList<>();
    private PeriodModel effectivePeriod;

}
