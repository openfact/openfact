package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a planned effect of a retail event (e.g., a promotion or
 * a change in inventory policy) upon supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:35 a. m.
 */
public class RetailPlannedImpact {

	/**
	 * Estimated monetary value of the planned event as an impact
	 */
	private BigDecimal Amount;
	/**
	 * It will have impact on either Sales forecast or Order Forecast
	 */
	private String ForecastPurposeCode;
	/**
	 * A code signifying the type of forecast. Examples of values are: BASE
	 * PROMOTIONAL SEASONAL TOTAL
	 */
	private String ForecastTypeCode;
	private List<Period> periods = new ArrayList<>();

	public RetailPlannedImpact() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public String getForecastPurposeCode() {
		return ForecastPurposeCode;
	}

	public String getForecastTypeCode() {
		return ForecastTypeCode;
	}

	public Period getPeriod() {
		return m_Period;
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
	public void setForecastPurposeCode(String newVal) {
		ForecastPurposeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecastTypeCode(String newVal) {
		ForecastTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal) {
		m_Period = newVal;
	}
}// end Retail Planned Impact