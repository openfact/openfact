package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in an Item Information Request asking a trading
 * partner for item information.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:44 a. m.
 */
public class ItemInformationRequestLine {

	/**
	 * The information request can be either about supply chain activity or about
	 * forecasts or about performance metrics, so it should be optional
	 */
	private String ForecastTypeCode;
	/**
	 * A code signifying a measure of performance.
	 */
	private String PerformanceMetricTypeCode;
	/**
	 * A code used to identify the type of supply chain activity about which
	 * information request is issued. Examples: CANCELED_ORDERS EMERGENCY_ORDERS
	 * ON_HAND ORDERS
	 */
	private String SupplyChainActivityTypeCode;
	/**
	 * A code signifying the frequency with which item information should be sent to
	 * the requester.
	 */
	private String TimeFrequencyCode;
	private Period m_Period;
	private Sales Item m_Sales Item;

	public Item Information Request Line(){

	}

	public void finalize() throws Throwable {

	}
	public String getForecastTypeCode(){
		return ForecastTypeCode;
	}

	public String getPerformanceMetricTypeCode(){
		return PerformanceMetricTypeCode;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Sales Item getSales Item(){
		return m_Sales Item;
	}

	public String getSupplyChainActivityTypeCode(){
		return SupplyChainActivityTypeCode;
	}

	public String getTimeFrequencyCode(){
		return TimeFrequencyCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecastTypeCode(String newVal){
		ForecastTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPerformanceMetricTypeCode(String newVal){
		PerformanceMetricTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSales Item(Sales Item newVal){
		m_Sales Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSupplyChainActivityTypeCode(String newVal){
		SupplyChainActivityTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTimeFrequencyCode(String newVal){
		TimeFrequencyCode = newVal;
	}
}//end Item Information Request Line