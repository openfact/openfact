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
	private String consumptionReportID;
	/**
	 * The reported consumption type, expressed as text.
	 */
	private String consumptionType;
	/**
	 * The reported consumption type, expressed as a code.
	 */
	private String consumptionTypeCode;
	/**
	 * The total quantity consumed during the period of the referenced report.
	 */
	private BigDecimal totalConsumedQuantity;
	private List<Period> periods= new ArrayList<>();

	public ConsumptionReportReference() {

	}

	public void finalize() throws Throwable {

	}

	public String getConsumptionReportID() {
		return consumptionReportID;
	}

	public void setConsumptionReportID(String consumptionReportID) {
		this.consumptionReportID = consumptionReportID;
	}

	public String getConsumptionType() {
		return consumptionType;
	}

	public void setConsumptionType(String consumptionType) {
		this.consumptionType = consumptionType;
	}

	public String getConsumptionTypeCode() {
		return consumptionTypeCode;
	}

	public void setConsumptionTypeCode(String consumptionTypeCode) {
		this.consumptionTypeCode = consumptionTypeCode;
	}

	public BigDecimal getTotalConsumedQuantity() {
		return totalConsumedQuantity;
	}

	public void setTotalConsumedQuantity(BigDecimal totalConsumedQuantity) {
		this.totalConsumedQuantity = totalConsumedQuantity;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
}// end Consumption Report Reference