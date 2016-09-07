package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
	private String value;
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
	private BigDecimal Percent;
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
	private BigDecimal ReliabilityPercent;
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

	/**
	 * @return the conditionCode
	 */
	public String getConditionCode() {
		return ConditionCode;
	}

	/**
	 * @param conditionCode
	 *            the conditionCode to set
	 */
	public void setConditionCode(String conditionCode) {
		ConditionCode = conditionCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * @return the indicationIndicator
	 */
	public boolean isIndicationIndicator() {
		return IndicationIndicator;
	}

	/**
	 * @param indicationIndicator
	 *            the indicationIndicator to set
	 */
	public void setIndicationIndicator(boolean indicationIndicator) {
		IndicationIndicator = indicationIndicator;
	}

	/**
	 * @return the percent
	 */
	public BigDecimal getPercent() {
		return Percent;
	}

	/**
	 * @param percent
	 *            the percent to set
	 */
	public void setPercent(BigDecimal percent) {
		Percent = percent;
	}

	/**
	 * @return the referenceDate
	 */
	public LocalDate getReferenceDate() {
		return ReferenceDate;
	}

	/**
	 * @param referenceDate
	 *            the referenceDate to set
	 */
	public void setReferenceDate(LocalDate referenceDate) {
		ReferenceDate = referenceDate;
	}

	/**
	 * @return the referenceTime
	 */
	public LocalTime getReferenceTime() {
		return ReferenceTime;
	}

	/**
	 * @param referenceTime
	 *            the referenceTime to set
	 */
	public void setReferenceTime(LocalTime referenceTime) {
		ReferenceTime = referenceTime;
	}

	/**
	 * @return the reliabilityPercent
	 */
	public BigDecimal getReliabilityPercent() {
		return ReliabilityPercent;
	}

	/**
	 * @param reliabilityPercent
	 *            the reliabilityPercent to set
	 */
	public void setReliabilityPercent(BigDecimal reliabilityPercent) {
		ReliabilityPercent = reliabilityPercent;
	}

	/**
	 * @return the sequenceID
	 */
	public String getSequenceID() {
		return SequenceID;
	}

	/**
	 * @param sequenceID
	 *            the sequenceID to set
	 */
	public void setSequenceID(String sequenceID) {
		SequenceID = sequenceID;
	}

	/**
	 * @return the statusReason
	 */
	public String getStatusReason() {
		return StatusReason;
	}

	/**
	 * @param statusReason
	 *            the statusReason to set
	 */
	public void setStatusReason(String statusReason) {
		StatusReason = statusReason;
	}

	/**
	 * @return the statusReasonCode
	 */
	public String getStatusReasonCode() {
		return StatusReasonCode;
	}

	/**
	 * @param statusReasonCode
	 *            the statusReasonCode to set
	 */
	public void setStatusReasonCode(String statusReasonCode) {
		StatusReasonCode = statusReasonCode;
	}

	/**
	 * @return the m_Condition
	 */
	public Condition getM_Condition() {
		return m_Condition;
	}

	/**
	 * @param m_Condition
	 *            the m_Condition to set
	 */
	public void setM_Condition(Condition m_Condition) {
		this.m_Condition = m_Condition;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}// end Status