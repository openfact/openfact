package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a reference to an earlier consumption report (e.g., last
 * year's consumption).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:56 a. m.
 */
public class ConsumptionReportReference {

	/**
	 * An identifier for the referenced consumption report.
	 */
	private String ConsumptionReportID;
	/**
	 * The reported consumption type, expressed as text.
	 */
	private String ConsumptionType;
	/**
	 * The reported consumption type, expressed as a code.
	 */
	private String ConsumptionTypeCode;
	/**
	 * The total quantity consumed during the period of the referenced report.
	 */
	private BigDecimal TotalConsumedQuantity;
	private Period m_Period;

	public ConsumptionReportReference() {

	}

	public void finalize() throws Throwable {

	}

	public String getConsumptionReportID() {
		return ConsumptionReportID;
	}

	public String getConsumptionType() {
		return ConsumptionType;
	}

	public String getConsumptionTypeCode() {
		return ConsumptionTypeCode;
	}

	public Period getPeriod() {
		return m_Period;
	}

	public BigDecimal getTotalConsumedQuantity() {
		return TotalConsumedQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionReportID(String newVal) {
		ConsumptionReportID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionType(String newVal) {
		ConsumptionType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionTypeCode(String newVal) {
		ConsumptionTypeCode = newVal;
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
	public void setTotalConsumedQuantity(BigDecimal newVal) {
		TotalConsumedQuantity = newVal;
	}
}// end Consumption Report Reference