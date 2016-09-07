package org.openfact.models.jpa.entities.ubl;

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
    private Period m_Period;
    private SalesItem m_SalesItem;

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

    public Period getM_Period() {
        return m_Period;
    }

    public void setM_Period(Period m_Period) {
        this.m_Period = m_Period;
    }

    public SalesItem getM_SalesItem() {
        return m_SalesItem;
    }

    public void setM_SalesItem(SalesItem m_SalesItem) {
        this.m_SalesItem = m_SalesItem;
    }
}// end Item Information Request Line