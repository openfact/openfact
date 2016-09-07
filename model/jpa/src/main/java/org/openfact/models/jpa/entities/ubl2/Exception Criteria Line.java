

/**
 * A class to define a line in an ExceptionCriteria document that specifies a
 * threshold for forecast variance, product activity, or performance history, the
 * exceeding of which should trigger an exception message.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:04 a. m.
 */
public class Exception Criteria Line {

	/**
	 * A collaboratively assigned code signifying priority of the Exception. Possible
	 * values are: HIGH, LOW, MEDIUM
	 */
	private Code. Type CollaborationPriorityCode;
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private Code. Type ExceptionResolutionCode;
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private Code. Type ExceptionStatusCode;
	/**
	 * An identifier for this exception criteria line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * A code signifying a measure of performance.
	 */
	private Code. Type PerformanceMetricTypeCode;
	/**
	 * Establishes the criterion for one of the three types of exceptions. There can
	 * be three types of exception criteria: Operational, Metric and Forecast
	 * Exceptions. This will be set if this Exception is about an Operational
	 * Exception. Description could be: A 
	 */
	private Code. Type SupplyChainActivityTypeCode;
	/**
	 * A quantity beyond which an exception will be triggered.
	 */
	private Quantity. Type ThresholdQuantity;
	/**
	 * Type of comparison to be carried out in reference to the set threshold."
	 * Allowed values are: EXCEEDS_EXCEPTION_VALUE FALLS_BELOW_EXCEPTION_VALUE
	 */
	private Code. Type ThresholdValueComparisonCode;
	private Forecast Exception Criterion Line m_Forecast Exception Criterion Line;
	private Item Supply Item;
	private Period Effective Period;

	public Exception Criteria Line(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getCollaborationPriorityCode(){
		return CollaborationPriorityCode;
	}

	public Period getEffective Period(){
		return Effective Period;
	}

	public Code. Type getExceptionResolutionCode(){
		return ExceptionResolutionCode;
	}

	public Code. Type getExceptionStatusCode(){
		return ExceptionStatusCode;
	}

	public Forecast Exception Criterion Line getForecast Exception Criterion Line(){
		return m_Forecast Exception Criterion Line;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Code. Type getPerformanceMetricTypeCode(){
		return PerformanceMetricTypeCode;
	}

	public Item getSupply Item(){
		return Supply Item;
	}

	public Code. Type getSupplyChainActivityTypeCode(){
		return SupplyChainActivityTypeCode;
	}

	public Quantity. Type getThresholdQuantity(){
		return ThresholdQuantity;
	}

	public Code. Type getThresholdValueComparisonCode(){
		return ThresholdValueComparisonCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCollaborationPriorityCode(Code. Type newVal){
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
	public void setExceptionResolutionCode(Code. Type newVal){
		ExceptionResolutionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExceptionStatusCode(Code. Type newVal){
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPerformanceMetricTypeCode(Code. Type newVal){
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
	public void setSupplyChainActivityTypeCode(Code. Type newVal){
		SupplyChainActivityTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setThresholdQuantity(Quantity. Type newVal){
		ThresholdQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setThresholdValueComparisonCode(Code. Type newVal){
		ThresholdValueComparisonCode = newVal;
	}
}//end Exception Criteria Line