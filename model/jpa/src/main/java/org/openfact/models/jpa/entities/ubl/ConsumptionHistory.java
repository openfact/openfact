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
	private BigDecimal amount;
	/**
	 * The consumption level, expressed as text, used explain the consumption
	 * quantity, e.g.. diversion from the normal.
	 */
	private String consumptionLevel;
	/**
	 * The consumption level, expressed as a code used explain the consumption
	 * quantity, e.g.. diversion from the normal.
	 */
	private String consumptionLevelCode;
	/**
	 * Text describing the consumption itself.
	 */
	private String description;
	/**
	 * A text identifier for the meter measuring the consumption.
	 */
	private String meterNumber;
	/**
	 * The quantity consumed.
	 */
	private BigDecimal quantity;
	private List<Period> periods= new ArrayList<>();

	public ConsumptionHistory() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getConsumptionLevel() {
		return consumptionLevel;
	}

	public void setConsumptionLevel(String consumptionLevel) {
		this.consumptionLevel = consumptionLevel;
	}

	public String getConsumptionLevelCode() {
		return consumptionLevelCode;
	}

	public void setConsumptionLevelCode(String consumptionLevelCode) {
		this.consumptionLevelCode = consumptionLevelCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
}// end Consumption History