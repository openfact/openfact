package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to describe the condition or position of an object.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:51 a. m.
 */
public class Status {

	/**
	 * Provides any textual information related to this status.
	 */
	private Text. Type ;
	/**
	 * Specifies the status condition of the related object.
	 */
	private Code. Type ConditionCode;
	/**
	 * Text describing this status.
	 */
	private Text. Type Description;
	/**
	 * Specifies an indicator relevant to a specific status.
	 */
	private Indicator. Type IndicationIndicator;
	/**
	 * A percentage meaningful in the context of this status.
	 */
	private Percent. Type Percent;
	/**
	 * The reference date for this status.
	 */
	private Date. Type ReferenceDate;
	/**
	 * The reference time for this status.
	 */
	private Time. Type ReferenceTime;
	/**
	 * The reliability of this status, expressed as a percentage.
	 */
	private Percent. Type ReliabilityPercent;
	/**
	 * A sequence identifier for this status.
	 */
	private Identifier. Type SequenceID;
	/**
	 * The reason for this status condition or position, expressed as text.
	 */
	private Text. Type StatusReason;
	/**
	 * The reason for this status condition or position, expressed as a code.
	 */
	private Code. Type StatusReasonCode;
	private Condition m_Condition;

	public Status(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type get(){
		return ;
	}

	public Condition getCondition(){
		return m_Condition;
	}

	public Code. Type getConditionCode(){
		return ConditionCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Indicator. Type getIndicationIndicator(){
		return IndicationIndicator;
	}

	public Percent. Type getPercent(){
		return Percent;
	}

	public Date. Type getReferenceDate(){
		return ReferenceDate;
	}

	public Time. Type getReferenceTime(){
		return ReferenceTime;
	}

	public Percent. Type getReliabilityPercent(){
		return ReliabilityPercent;
	}

	public Identifier. Type getSequenceID(){
		return SequenceID;
	}

	public Text. Type getStatusReason(){
		return StatusReason;
	}

	public Code. Type getStatusReasonCode(){
		return StatusReasonCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void set(Text. Type newVal){
		 = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCondition(Condition newVal){
		m_Condition = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConditionCode(Code. Type newVal){
		ConditionCode = newVal;
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
	public void setIndicationIndicator(Indicator. Type newVal){
		IndicationIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPercent(Percent. Type newVal){
		Percent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenceDate(Date. Type newVal){
		ReferenceDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenceTime(Time. Type newVal){
		ReferenceTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReliabilityPercent(Percent. Type newVal){
		ReliabilityPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceID(Identifier. Type newVal){
		SequenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatusReason(Text. Type newVal){
		StatusReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatusReasonCode(Code. Type newVal){
		StatusReasonCode = newVal;
	}
}//end Status