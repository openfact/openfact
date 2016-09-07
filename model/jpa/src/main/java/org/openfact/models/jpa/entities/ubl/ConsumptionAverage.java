package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define an average consumption as a monetary amount.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:47 a. m.
 */
public class ConsumptionAverage {

	/**
	 * The average monetary amount of the consumption.
	 */
	private BigDecimal AverageAmount;
	/**
	 * A description of the average consumed.
	 */
	private String Description;

	public ConsumptionAverage() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAverageAmount() {
		return AverageAmount;
	}

	public String getDescription() {
		return Description;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAverageAmount(BigDecimal newVal) {
		AverageAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}
}// end Consumption Average