package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a management profile for an item.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:48 a. m.
 */
public class ItemManagementProfile {

	/**
	 * The number of days in the future that an order forecast quantity
	 * automatically becomes a confirmed order for a product.
	 */
	private BigDecimal frozenPeriodDaysNumeric;
	/**
	 * The quantity of the item that should trigger a replenishment order to
	 * avoid depleting the safety stock.
	 */
	private BigDecimal minimumInventoryQuantity;
	/**
	 * The order quantity multiples in which the product may be ordered.
	 */
	private BigDecimal multipleOrderQuantity;
	/**
	 * The number of days between regular replenishment orders for the product.
	 */
	private BigDecimal orderIntervalDaysNumeric;
	/**
	 * The trading partner maintaining this item management profile.
	 */
	private String replenishmentOwnerDescription;
	/**
	 * The target inventory quantity.
	 */
	private BigDecimal targetInventoryQuantity;
	/**
	 * The Unit Service Level the trading partners expect to be maintained,
	 * expressed as a percentage. Unite Service Level (USL) is a term used in
	 * Inventory Management, which is sometimes known as "fill rate", counts the
	 * average number of units short expressed a
	 */
	private BigDecimal targetServicePercent;
	private List<Item> items = new ArrayList<>();
	private List<ItemLocationQuantity> itemLocationQuantities=new ArrayList<>();
	private Period effectivePeriod;

	public BigDecimal getFrozenPeriodDaysNumeric() {
		return frozenPeriodDaysNumeric;
	}

	public void setFrozenPeriodDaysNumeric(BigDecimal frozenPeriodDaysNumeric) {
		this.frozenPeriodDaysNumeric = frozenPeriodDaysNumeric;
	}

	public BigDecimal getMinimumInventoryQuantity() {
		return minimumInventoryQuantity;
	}

	public void setMinimumInventoryQuantity(BigDecimal minimumInventoryQuantity) {
		this.minimumInventoryQuantity = minimumInventoryQuantity;
	}

	public BigDecimal getMultipleOrderQuantity() {
		return multipleOrderQuantity;
	}

	public void setMultipleOrderQuantity(BigDecimal multipleOrderQuantity) {
		this.multipleOrderQuantity = multipleOrderQuantity;
	}

	public BigDecimal getOrderIntervalDaysNumeric() {
		return orderIntervalDaysNumeric;
	}

	public void setOrderIntervalDaysNumeric(BigDecimal orderIntervalDaysNumeric) {
		this.orderIntervalDaysNumeric = orderIntervalDaysNumeric;
	}

	public String getReplenishmentOwnerDescription() {
		return replenishmentOwnerDescription;
	}

	public void setReplenishmentOwnerDescription(String replenishmentOwnerDescription) {
		this.replenishmentOwnerDescription = replenishmentOwnerDescription;
	}

	public BigDecimal getTargetInventoryQuantity() {
		return targetInventoryQuantity;
	}

	public void setTargetInventoryQuantity(BigDecimal targetInventoryQuantity) {
		this.targetInventoryQuantity = targetInventoryQuantity;
	}

	public BigDecimal getTargetServicePercent() {
		return targetServicePercent;
	}

	public void setTargetServicePercent(BigDecimal targetServicePercent) {
		this.targetServicePercent = targetServicePercent;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<ItemLocationQuantity> getItemLocationQuantities() {
		return itemLocationQuantities;
	}

	public void setItemLocationQuantities(List<ItemLocationQuantity> itemLocationQuantities) {
		this.itemLocationQuantities = itemLocationQuantities;
	}

	public Period getEffectivePeriod() {
		return effectivePeriod;
	}

	public void setEffectivePeriod(Period effectivePeriod) {
		this.effectivePeriod = effectivePeriod;
	}
}// end ItemManagementProfile