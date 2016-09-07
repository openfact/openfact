package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe information related to an item in a sales context
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItem {

	/**
	 * The quantity the given information are related to
	 */
	private BigDecimal Quantity;
	private ActivityProperty m_ActivityProperty;
	private List<Item> items = new ArrayList<>();
	private Price TaxExclusivePrice;
	private Price TaxInclusivePrice;

	public SalesItem() {

	}

	public void finalize() throws Throwable {

	}

	public ActivityProperty getActivityProperty() {
		return m_ActivityProperty;
	}

	public Item getItem() {
		return m_Item;
	}

	public BigDecimal getQuantity() {
		return Quantity;
	}

	public Price getTaxExclusivePrice() {
		return TaxExclusivePrice;
	}

	public Price getTaxInclusivePrice() {
		return TaxInclusivePrice;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivityProperty(ActivityProperty newVal) {
		m_ActivityProperty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem(Item newVal) {
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal) {
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxExclusivePrice(Price newVal) {
		TaxExclusivePrice = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxInclusivePrice(Price newVal) {
		TaxInclusivePrice = newVal;
	}
}// end Sales Item