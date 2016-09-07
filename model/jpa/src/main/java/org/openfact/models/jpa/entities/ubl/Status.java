package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the condition or position of an object.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:51 a. m.
 */
public class Status {

    /**
     * Provides any textual information related to this status.
     */
    private String;
    /**
     * Specifies the status condition of the related object.
     */
    private String ConditionCode;
    /**
     * Text describing this status.
     */
    private String Description;
    /**
     * Specifies an indicator relevant to a specific status.
     */
    private boolean IndicationIndicator;
    /**
     * A percentage meaningful in the context of this status.
     */
    private Percent.Type Percent;
    /**
     * The reference date for this status.
     */
    private LocalDate ReferenceDate;
    /**
     * The reference time for this status.
     */
    private LocalTime ReferenceTime;
    /**
     * The reliability of this status, expressed as a percentage.
     */
    private Percent.Type ReliabilityPercent;
    /**
     * A sequence identifier for this status.
     */
    private String SequenceID;
    /**
     * The reason for this status condition or position, expressed as text.
     */
    private String StatusReason;
    /**
     * The reason for this status condition or position, expressed as a code.
     */
    private String StatusReasonCode;
    private Condition m_Condition;

    public Status() {

    }

    public void finalize() throws Throwable {

    }

    public String get() {
        return;
    }

    public Condition getCondition() {
        return m_Condition;
    }

    public String getConditionCode() {
        return ConditionCode;
    }

    public String getDescription() {
        return Description;
    }

    public boolean getIndicationIndicator() {
        return IndicationIndicator;
    }

    public Percent.Type getPercent() {
        return Percent;
    }

    public LocalDate getReferenceDate() {
        return ReferenceDate;
    }

    public LocalTime getReferenceTime() {
        return ReferenceTime;
    }

    public Percent.Type getReliabilityPercent() {
        return ReliabilityPercent;
    }

    public String getSequenceID() {
        return SequenceID;
    }

    public String getStatusReason() {
        return StatusReason;
    }

    public String getStatusReasonCode() {
        return StatusReasonCode;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void set(String newVal){
		 = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setCondition(Condition newVal) {
        m_Condition = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConditionCode(String newVal) {
        ConditionCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIndicationIndicator(boolean newVal) {
        IndicationIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPercent(Percent.Type newVal) {
        Percent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReferenceDate(LocalDate newVal) {
        ReferenceDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReferenceTime(LocalTime newVal) {
        ReferenceTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setReliabilityPercent(Percent.Type newVal) {
        ReliabilityPercent = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSequenceID(String newVal) {
        SequenceID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setStatusReason(String newVal) {
        StatusReason = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setStatusReasonCode(String newVal) {
        StatusReasonCode = newVal;
    }
}// end Status