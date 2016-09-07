package org.openfact.models.jpa.entities.ubl;


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
	private String CollaborationPriorityCode;
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private String ExceptionResolutionCode;
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private String ExceptionStatusCode;
	/**
	 * An identifier for this exception criteria line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * A code signifying a measure of performance.
	 */
	private String PerformanceMetricTypeCode;
	/**
	 * Establishes the criterion for one of the three types of exceptions. There can
	 * be three types of exception criteria: Operational, Metric and Forecast
	 * Exceptions. This will be set if this Exception is about an Operational
	 * Exception. Description could be: A 
	 */
	private String SupplyChainActivityTypeCode;
	/**
	 * A quantity beyond which an exception will be triggered.
	 */
	private BigDecimal ThresholdQuantity;
	/**
	 * Type of comparison to be carried out in reference to the set threshold."
	 * Allowed values are: EXCEEDS_EXCEPTION_VALUE FALLS_BELOW_EXCEPTION_VALUE
	 */
	private String ThresholdValueComparisonCode;
	private Forecast Exception Criterion Line m_Forecast Exception Criterion Line;
	private Item Supply Item;
	private Period Effective Period;

	public Exception Criteria Line(){

	}

	public void finalize() throws Throwable {

	}
	public String getCollaborationPriorityCode(){
		return CollaborationPriorityCode;
	}

	public Period getEffective Period(){
		return Effective Period;
	}

	public String getExceptionResolutionCode(){
		return ExceptionResolutionCode;
	}

	public String getExceptionStatusCode(){
		return ExceptionStatusCode;
	}

	public Forecast Exception Criterion Line getForecast Exception Criterion Line(){
		return m_Forecast Exception Criterion Line;
	}

	public String getID(){
		return ID;
	}

	public String getNote(){
		return Note;
	}

	public String getPerformanceMetricTypeCode(){
		return PerformanceMetricTypeCode;
	}

	public Item getSupply Item(){
		return Supply Item;
	}

	public String getSupplyChainActivityTypeCode(){
		return SupplyChainActivityTypeCode;
	}

	public BigDecimal getThresholdQuantity(){
		return ThresholdQuantity;
	}

	public String getThresholdValueComparisonCode(){
		return ThresholdValueComparisonCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCollaborationPriorityCode(String newVal){
		CollaborationPriorityCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEffective Period(Period newVal){
		Effective Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExceptionResolutionCode(String newVal){
		ExceptionResolutionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExceptionStatusCode(String newVal){
		ExceptionStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecast Exception Criterion Line(Forecast Exception Criterion Line newVal){
		m_Forecast Exception Criterion Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
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
	public void setSupply Item(Item newVal){
		Supply Item = newVal;
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
	public void setThresholdQuantity(BigDecimal newVal){
		ThresholdQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setThresholdValueComparisonCode(String newVal){
		ThresholdValueComparisonCode = newVal;
	}
}//end Exception Criteria Line