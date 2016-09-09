package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a management profile for an item.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:48 a. m.
 */
public class ItemManagementProfile{

	/**
	 * The number of days in the future that an order forecast quantity automatically
	 * becomes a confirmed order for a product.
	 */
	private NumericType FrozenPeriodDaysNumeric;
	/**
	 * The quantity of the item that should trigger a replenishment order to avoid
	 * depleting the safety stock.
	 */
	private QuantityType MinimumInventoryQuantity;
	/**
	 * The order quantity multiples in which the product may be ordered.
	 */
	private QuantityType MultipleOrderQuantity;
	/**
	 * The number of days between regular replenishment orders for the product.
	 */
	private NumericType OrderIntervalDaysNumeric;
	/**
	 * The trading partner maintaining this item management profile.
	 */
	private TextType ReplenishmentOwnerDescription;
	/**
	 * The target inventory quantity.
	 */
	private QuantityType TargetInventoryQuantity;
	/**
	 * The Unit Service Level the trading partners expect to be maintained, expressed
	 * as a percentage. Unite Service Level (USL) is a term used in Inventory
	 * Management, which is sometimes known as "fill rate", counts the average number
	 * of units short expressed a
	 */
	private PercentType TargetServicePercent;
	private List<Item> Items = new ArrayList<>();
	private List<ItemLocationQuantity> ItemsLocationQuantity = new ArrayList<>();
	private Period EffectivePeriod;

}
