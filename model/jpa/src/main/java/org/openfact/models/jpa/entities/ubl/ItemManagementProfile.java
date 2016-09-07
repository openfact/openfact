package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a management profile for an item.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:48 a. m.
 */
public class ItemManagementProfile {

	/**
	 * The number of days in the future that an order forecast quantity automatically
	 * becomes a confirmed order for a product.
	 */
	private BigDecimal FrozenPeriodDaysNumeric;
	/**
	 * The quantity of the item that should trigger a replenishment order to avoid
	 * depleting the safety stock.
	 */
	private BigDecimal MinimumInventoryQuantity;
	/**
	 * The order quantity multiples in which the product may be ordered.
	 */
	private BigDecimal MultipleOrderQuantity;
	/**
	 * The number of days between regular replenishment orders for the product.
	 */
	private BigDecimal OrderIntervalDaysNumeric;
	/**
	 * The trading partner maintaining this item management profile.
	 */
	private String ReplenishmentOwnerDescription;
	/**
	 * The target inventory quantity.
	 */
	private BigDecimal TargetInventoryQuantity;
	/**
	 * The Unit Service Level the trading partners expect to be maintained, expressed
	 * as a percentage. Unite Service Level (USL) is a term used in Inventory
	 * Management, which is sometimes known as "fill rate", counts the average number
	 * of units short expressed a
	 */
	private BigDecimal TargetServicePercent;
	private Item m_Item;
	private Item Location Quantity m_Item Location Quantity;
	private Period Effective Period;

	public Item Management Profile(){

	}

	public void finalize() throws Throwable {

	}
	public Period getEffective Period(){
		return Effective Period;
	}

	public BigDecimal getFrozenPeriodDaysNumeric(){
		return FrozenPeriodDaysNumeric;
	}

	public Item getItem(){
		return m_Item;
	}

	public Item Location Quantity getItem Location Quantity(){
		return m_Item Location Quantity;
	}

	public BigDecimal getMinimumInventoryQuantity(){
		return MinimumInventoryQuantity;
	}

	public BigDecimal getMultipleOrderQuantity(){
		return MultipleOrderQuantity;
	}

	public BigDecimal getOrderIntervalDaysNumeric(){
		return OrderIntervalDaysNumeric;
	}

	public String getReplenishmentOwnerDescription(){
		return ReplenishmentOwnerDescription;
	}

	public BigDecimal getTargetInventoryQuantity(){
		return TargetInventoryQuantity;
	}

	public BigDecimal getTargetServicePercent(){
		return TargetServicePercent;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEffective Period(Period newVal){
		Effective Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFrozenPeriodDaysNumeric(BigDecimal newVal){
		FrozenPeriodDaysNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem(Item newVal){
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem Location Quantity(Item Location Quantity newVal){
		m_Item Location Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumInventoryQuantity(BigDecimal newVal){
		MinimumInventoryQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMultipleOrderQuantity(BigDecimal newVal){
		MultipleOrderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderIntervalDaysNumeric(BigDecimal newVal){
		OrderIntervalDaysNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReplenishmentOwnerDescription(String newVal){
		ReplenishmentOwnerDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTargetInventoryQuantity(BigDecimal newVal){
		TargetInventoryQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTargetServicePercent(BigDecimal newVal){
		TargetServicePercent = newVal;
	}
}//end Item Management Profile