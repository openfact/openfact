package org.openfact.models.jpa.entities.ubl;


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
	private String CollaborationPriorityCode;
	/**
	 * The value that was compared with the source value that resulted in the exception
	 */
	private Measure. Type ComparedValueMeasure;
	/**
	 * Text describing the exception.
	 */
	private String Description;
	/**
	 * A code signifying status specific to a shipment exception.
	 */
	private String ExceptionStatusCode;
	/**
	 * An identifier for this exception notification line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * A code used to identify a measure of performance. It defines the type of the
	 * Performance Metric on which an exception criteria is being defined
	 */
	private String PerformanceMetricTypeCode;
	/**
	 * Coded representation of possible resolution methods". Possible values are:
	 * DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
	 * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
	 * MANUAL_RESOLUTION MUTUALLY_DEFINED
	 */
	private String ResolutionCode;
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
	private String SupplyChainActivityTypeCode;
	/**
	 * The variance of a data item from an expected value during a particular time
	 * interval.
	 */
	private BigDecimal VarianceQuantity;
	private DocumentReference m_DocumentReference;
	private Forecast Exception m_Forecast Exception;
	private Item Supply Item;
	private Period Exception Observation Period;

	public Exception Notification Line(){

	}

	public void finalize() throws Throwable {

	}
	public String getCollaborationPriorityCode(){
		return CollaborationPriorityCode;
	}

	public Measure. Type getComparedValueMeasure(){
		return ComparedValueMeasure;
	}

	public String getDescription(){
		return Description;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
	}

	public Period getException Observation Period(){
		return Exception Observation Period;
	}

	public String getExceptionStatusCode(){
		return ExceptionStatusCode;
	}

	public Forecast Exception getForecast Exception(){
		return m_Forecast Exception;
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

	public String getResolutionCode(){
		return ResolutionCode;
	}

	public Measure. Type getSourceValueMeasure(){
		return SourceValueMeasure;
	}

	public Item getSupply Item(){
		return Supply Item;
	}

	public String getSupplyChainActivityTypeCode(){
		return SupplyChainActivityTypeCode;
	}

	public BigDecimal getVarianceQuantity(){
		return VarianceQuantity;
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
	public void setComparedValueMeasure(Measure. Type newVal){
		ComparedValueMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal){
		m_DocumentReference = newVal;
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
	public void setExceptionStatusCode(String newVal){
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
	public void setResolutionCode(String newVal){
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
	public void setSupplyChainActivityTypeCode(String newVal){
		SupplyChainActivityTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVarianceQuantity(BigDecimal newVal){
		VarianceQuantity = newVal;
	}
}//end Exception Notification Line