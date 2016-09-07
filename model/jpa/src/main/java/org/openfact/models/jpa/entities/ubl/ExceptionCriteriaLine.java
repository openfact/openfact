package org.openfact.models.jpa.entities.ubl;


import java.math.BigDecimal;

/**
 * A class to define a line in an ExceptionCriteria document that specifies a
 * threshold for forecast variance, product activity, or performance history, the
 * exceeding of which should trigger an exception message.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:04 a. m.
 */
public class ExceptionCriteriaLine {

	/**
	 * A collaboratively assigned code signifying priority of the Exception. Possible
	 * values are: HIGH, LOW, MEDIUM
	 */
	private String collaborationPriorityCode;
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private String exceptionResolutionCode;
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private String exceptionStatusCode;
	/**
	 * An identifier for this exception criteria line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String note;
	/**
	 * A code signifying a measure of performance.
	 */
	private String performanceMetricTypeCode;
	/**
	 * Establishes the criterion for one of the three types of exceptions. There can
	 * be three types of exception criteria: Operational, Metric and Forecast
	 * Exceptions. This will be set if this Exception is about an Operational
	 * Exception. Description could be: A 
	 */
	private String supplyChainActivityTypeCode;

	public BigDecimal getThresholdQuantity() {
		return thresholdQuantity;
	}

	public void setThresholdQuantity(BigDecimal thresholdQuantity) {
		this.thresholdQuantity = thresholdQuantity;
	}

	public String getCollaborationPriorityCode() {
		return collaborationPriorityCode;
	}

	public void setCollaborationPriorityCode(String collaborationPriorityCode) {
		this.collaborationPriorityCode = collaborationPriorityCode;
	}

	public String getExceptionResolutionCode() {
		return exceptionResolutionCode;
	}

	public void setExceptionResolutionCode(String exceptionResolutionCode) {
		this.exceptionResolutionCode = exceptionResolutionCode;
	}

	public String getExceptionStatusCode() {
		return exceptionStatusCode;
	}

	public void setExceptionStatusCode(String exceptionStatusCode) {
		this.exceptionStatusCode = exceptionStatusCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public String getThresholdValueComparisonCode() {
		return thresholdValueComparisonCode;
	}

	public void setThresholdValueComparisonCode(String thresholdValueComparisonCode) {
		this.thresholdValueComparisonCode = thresholdValueComparisonCode;
	}

	public ForecastExceptionCriterionLine getM_ForecastExceptionCriterionLine() {
		return m_ForecastExceptionCriterionLine;
	}

	public void setM_ForecastExceptionCriterionLine(ForecastExceptionCriterionLine m_ForecastExceptionCriterionLine) {
		this.m_ForecastExceptionCriterionLine = m_ForecastExceptionCriterionLine;
	}

	public Item getSupplyItem() {
		return supplyItem;
	}

	public void setSupplyItem(Item supplyItem) {
		this.supplyItem = supplyItem;
	}

	public Period getEffectivePeriod() {
		return effectivePeriod;
	}

	public void setEffectivePeriod(Period effectivePeriod) {
		this.effectivePeriod = effectivePeriod;
	}

	/**
	 * A quantity beyond which an exception will be triggered.

	 */
	private BigDecimal thresholdQuantity;
	/**
	 * Type of comparison to be carried out in reference to the set threshold."
	 * Allowed values are: EXCEEDS_EXCEPTION_VALUE FALLS_BELOW_EXCEPTION_VALUE
	 */
	private String thresholdValueComparisonCode;
	private ForecastExceptionCriterionLine m_ForecastExceptionCriterionLine;
	private Item supplyItem;
	private Period effectivePeriod;


}//end Exception Criteria Line