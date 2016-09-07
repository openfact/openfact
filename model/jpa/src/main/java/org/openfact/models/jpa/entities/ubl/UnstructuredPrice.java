package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

import org.openfact.models.jpa.entities.ubl2.Unstructured;

/**
 * A simplified version of the Price class intended for applications such as
 * telephone billing.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:54 a. m.
 */
public class UnstructuredPrice {

	/**
	 * The price amount.
	 */
	private BigDecimal PriceAmount;
	/**
	 * The usage time upon which the price is based.
	 */
	private String TimeAmount;

	public Unstructured Price(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getPriceAmount(){
		return PriceAmount;
	}

	public String getTimeAmount(){
		return TimeAmount;
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
	public void setTimeAmount(String newVal){
		TimeAmount = newVal;
	}
}//end Unstructured Price