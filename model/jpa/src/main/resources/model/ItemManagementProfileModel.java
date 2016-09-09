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
public class ItemManagementProfileModel{

	/**
	 * The number of days in the future that an order forecast quantity automatically
	 * becomes a confirmed order for a product.
	 */
	private NumericType frozenPeriodDaysNumeric; 
	/**
	 * The quantity of the item that should trigger a replenishment order to avoid
	 * depleting the safety stock.
	 */
	private QuantityType minimumInventoryQuantity; 
	/**
	 * The order quantity multiples in which the product may be ordered.
	 */
	private QuantityType multipleOrderQuantity; 
	/**
	 * The number of days between regular replenishment orders for the product.
	 */
	private NumericType orderIntervalDaysNumeric; 
	/**
	 * The trading partner maintaining this item management profile.
	 */
	private TextType replenishmentOwnerDescription; 
	/**
	 * The target inventory quantity.
	 */
	private QuantityType targetInventoryQuantity; 
	/**
	 * The Unit Service Level the trading partners expect to be maintained, expressed
	 * as a percentage. Unite Service Level (USL) is a term used in Inventory
	 * Management, which is sometimes known as "fill rate", counts the average number
	 * of units short expressed a
	 */
	private PercentType targetServicePercent; 
	private List<ItemModel> items = new ArrayList<>(); 
	private List<ItemLocationQuantityModel> itemsLocationQuantity = new ArrayList<>(); 
	private PeriodModel effectivePeriod; 

}
