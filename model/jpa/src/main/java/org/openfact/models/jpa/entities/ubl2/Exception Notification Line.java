

/**
 * A class to define a line in an Exception Notification.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:07 a. m.
 */
public class ExceptionNotificationLine {

	/**
	 * Priority of Exception.
	 */
	private Code. Type CollaborationPriorityCode;
	/**
	 * The value that was compared with the source value that resulted in the exception
	 */
	private Measure. Type ComparedValueMeasure;
	/**
	 * Text describing the exception.
	 */
	private Text. Type Description;
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private Code. Type ExceptionStatusCode;
	/**
	 * An identifier for this exception notification line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * A code used to identify a measure of performance. It defines the type of the
	 * Performance Metric on which an exception criteria is being defined
	 */
	private Code. Type PerformanceMetricTypeCode;
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private Code. Type ResolutionCode;
	/**
	 * The value used as the basis of comparison
	 */
	private Measure. Type SourceValueMeasure;
	/**
	 * Establishes the criterion for one of the three types of exceptions: Operational,
	 * performance metric and forecast. This reports an exception notification about
	 * an operational exception. Description could be: A code used to identify an
	 * operational exception
	 */
	private Code. Type SupplyChainActivityTypeCode;
	/**
	 * The variance of a data item from an expected value during a particular time
	 * interval.
	 */
	private Quantity. Type VarianceQuantity;
	private Document Reference m_Document Reference;
	private Forecast Exception m_Forecast Exception;
	private Item Supply Item;
	private Period Exception Observation Period;

	public Exception Notification Line(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getCollaborationPriorityCode(){
		return CollaborationPriorityCode;
	}

	public Measure. Type getComparedValueMeasure(){
		return ComparedValueMeasure;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Period getException Observation Period(){
		return Exception Observation Period;
	}

	public Code. Type getExceptionStatusCode(){
		return ExceptionStatusCode;
	}

	public Forecast Exception getForecast Exception(){
		return m_Forecast Exception;
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

	public Code. Type getResolutionCode(){
		return ResolutionCode;
	}

	public Measure. Type getSourceValueMeasure(){
		return SourceValueMeasure;
	}

	public Item getSupply Item(){
		return Supply Item;
	}

	public Code. Type getSupplyChainActivityTypeCode(){
		return SupplyChainActivityTypeCode;
	}

	public Quantity. Type getVarianceQuantity(){
		return VarianceQuantity;
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
	public void setComparedValueMeasure(Measure. Type newVal){
		ComparedValueMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setException Observation Period(Period newVal){
		Exception Observation Period = newVal;
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
	public void setForecast Exception(Forecast Exception newVal){
		m_Forecast Exception = newVal;
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
	public void setResolutionCode(Code. Type newVal){
		ResolutionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSourceValueMeasure(Measure. Type newVal){
		SourceValueMeasure = newVal;
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
	public void setVarianceQuantity(Quantity. Type newVal){
		VarianceQuantity = newVal;
	}
}//end Exception Notification Line