package org.openfact.models.jpa.entities.ubl;


/**
 * Agree can be renamed as PromotionalEvents
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:08 a. m.
 */
public class PromotionalEvent {

	/**
	 * The first day that products will be available to ship from buyer to seller if
	 * the proposal for this promotional event is accepted.
	 */
	private Date. Type FirstShipmentAvailibilityDate;
	/**
	 * The deadline for acceptance of this promotional event.
	 */
	private Date. Type LatestProposalAcceptanceDate;
	/**
	 * A code signifying the type of this promotional event. Examples can be: Holiday,
	 * Seasonal Event, Store Closing, Trade Item Introduction
	 */
	private Code. Type PromotionalEventTypeCode;
	/**
	 * The date on which a proposal for this promotional event was submitted.
	 */
	private Date. Type SubmissionDate;
	private Promotional Specification m_Promotional Specification;

	public Promotional Event(){

	}

	public void finalize() throws Throwable {

	}
	public Date. Type getFirstShipmentAvailibilityDate(){
		return FirstShipmentAvailibilityDate;
	}

	public Date. Type getLatestProposalAcceptanceDate(){
		return LatestProposalAcceptanceDate;
	}

	public Promotional Specification getPromotional Specification(){
		return m_Promotional Specification;
	}

	public Code. Type getPromotionalEventTypeCode(){
		return PromotionalEventTypeCode;
	}

	public Date. Type getSubmissionDate(){
		return SubmissionDate;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFirstShipmentAvailibilityDate(Date. Type newVal){
		FirstShipmentAvailibilityDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestProposalAcceptanceDate(Date. Type newVal){
		LatestProposalAcceptanceDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPromotional Specification(Promotional Specification newVal){
		m_Promotional Specification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPromotionalEventTypeCode(Code. Type newVal){
		PromotionalEventTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubmissionDate(Date. Type newVal){
		SubmissionDate = newVal;
	}
}//end Promotional Event