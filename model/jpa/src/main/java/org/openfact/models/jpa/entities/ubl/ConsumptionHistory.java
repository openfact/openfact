package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe the measurement of a type of consumption during a
 * particular period, used for the subscriber to get an overview of his
 * consumption
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:50 a. m.
 */
public class ConsumptionHistory {

	/**
	 * The monetary amount to be charged for the quantity consumed.
	 */
	private BigDecimal Amount;
	/**
	 * The consumption level, expressed as text, used explain the consumption
	 * quantity, e.g.. diversion from the normal.
	 */
	private String ConsumptionLevel;
	/**
	 * The consumption level, expressed as a code used explain the consumption
	 * quantity, e.g.. diversion from the normal.
	 */
	private String ConsumptionLevelCode;
	/**
	 * Text describing the consumption itself.
	 */
	private String Description;
	/**
	 * A text identifier for the meter measuring the consumption.
	 */
	private String MeterNumber;
	/**
	 * The quantity consumed.
	 */
	private BigDecimal Quantity;
	private Period m_Period;

	public ConsumptionHistory() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public String getConsumptionLevel() {
		return ConsumptionLevel;
	}

	public String getConsumptionLevelCode() {
		return ConsumptionLevelCode;
	}

	public String getDescription() {
		return Description;
	}

	public String getMeterNumber() {
		return MeterNumber;
	}

	public Period getPeriod() {
		return m_Period;
	}

	public BigDecimal getQuantity() {
		return Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(BigDecimal newVal) {
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionLevel(String newVal) {
		ConsumptionLevel = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionLevelCode(String newVal) {
		ConsumptionLevelCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeterNumber(String newVal) {
		MeterNumber = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal) {
		m_Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal) {
		Quantity = newVal;
	}
}// end Consumption History