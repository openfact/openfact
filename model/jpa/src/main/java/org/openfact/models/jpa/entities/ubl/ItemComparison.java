package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to provide information about price and quantity of an item for use in
 * price comparisons based on price, quantity, or measurements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:40 a. m.
 */
public class ItemComparison {

	/**
	 * The price for the Item Comparison
	 */
	private BigDecimal PriceAmount;
	/**
	 * The quantity for which this comparison is valid.
	 */
	private BigDecimal Quantity;

	public Item Comparison(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getPriceAmount(){
		return PriceAmount;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriceAmount(BigDecimal newVal){
		PriceAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}
}//end Item Comparison