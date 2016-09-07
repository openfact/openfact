package org.openfact.models.jpa.entities.ubl;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.LossRiskResponsibilityCodeType;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a line in an Item Information Request asking a trading
 * partner for item information.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:44 a. m.
 */
public class ItemInformationRequestLine {

	/**
	 * The information request can be either about supply chain activity or
	 * about forecasts or about performance metrics, so it should be optional
	 */
	private String forecastTypeCode;
	/**
	 * A code signifying a measure of performance.
	 */
	private String performanceMetricTypeCode;
	/**
	 * A code used to identify the type of supply chain activity about which
	 * information request is issued. Examples: CANCELED_ORDERS EMERGENCY_ORDERS
	 * ON_HAND ORDERS
	 */
	private String supplyChainActivityTypeCode;
	/**
	 * A code signifying the frequency with which item information should be
	 * sent to the requester.
	 */
	private String timeFrequencyCode;
	private List<Period> periods = new ArrayList<>();
	private List<SalesItem> salesItems=new ArrayList<>();

	public String getForecastTypeCode() {
		return forecastTypeCode;
	}

	public void setForecastTypeCode(String forecastTypeCode) {
		this.forecastTypeCode = forecastTypeCode;
	}

	public String getPerformanceMetricTypeCode() {
		return performanceMetricTypeCode;
	}

	public void setPerformanceMetricTypeCode(String performanceMetricTypeCode) {
		this.performanceMetricTypeCode = performanceMetricTypeCode;
	}

	public String getSupplyChainActivityTypeCode() {
		return supplyChainActivityTypeCode;
	}

	public void setSupplyChainActivityTypeCode(String supplyChainActivityTypeCode) {
		this.supplyChainActivityTypeCode = supplyChainActivityTypeCode;
	}

	public String getTimeFrequencyCode() {
		return timeFrequencyCode;
	}

	public void setTimeFrequencyCode(String timeFrequencyCode) {
		this.timeFrequencyCode = timeFrequencyCode;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public List<SalesItem> getSalesItems() {
		return salesItems;
	}

	public void setSalesItems(List<SalesItem> salesItems) {
		this.salesItems = salesItems;
	}
}// end Item Information Request Line