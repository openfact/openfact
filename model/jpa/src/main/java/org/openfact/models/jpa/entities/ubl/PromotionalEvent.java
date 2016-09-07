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
	private LocalDate FirstShipmentAvailibilityDate;
	/**
	 * The deadline for acceptance of this promotional event.
	 */
	private LocalDate LatestProposalAcceptanceDate;
	/**
	 * A code signifying the type of this promotional event. Examples can be: Holiday,
	 * Seasonal Event, Store Closing, Trade Item Introduction
	 */
	private String PromotionalEventTypeCode;
	/**
	 * The date on which a proposal for this promotional event was submitted.
	 */
	private LocalDate SubmissionDate;
	private Promotional Specification m_Promotional Specification;

	public Promotional Event(){

	}

	public void finalize() throws Throwable {

	}
	public LocalDate getFirstShipmentAvailibilityDate(){
		return FirstShipmentAvailibilityDate;
	}

	public LocalDate getLatestProposalAcceptanceDate(){
		return LatestProposalAcceptanceDate;
	}

	public Promotional Specification getPromotional Specification(){
		return m_Promotional Specification;
	}

	public String getPromotionalEventTypeCode(){
		return PromotionalEventTypeCode;
	}

	public LocalDate getSubmissionDate(){
		return SubmissionDate;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFirstShipmentAvailibilityDate(LocalDate newVal){
		FirstShipmentAvailibilityDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestProposalAcceptanceDate(LocalDate newVal){
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
	public void setPromotionalEventTypeCode(String newVal){
		PromotionalEventTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubmissionDate(LocalDate newVal){
		SubmissionDate = newVal;
	}
}//end Promotional Event