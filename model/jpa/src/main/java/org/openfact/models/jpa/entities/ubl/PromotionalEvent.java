package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

/**
 * Agree can be renamed as PromotionalEvents
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:08 a. m.
 */
public class PromotionalEvent {

	/**
	 * The first day that products will be available to ship from buyer to
	 * seller if the proposal for this promotional event is accepted.
	 */
	private LocalDate firstShipmentAvailibilityDate;
	/**
	 * The deadline for acceptance of this promotional event.
	 */
	private LocalDate latestProposalAcceptanceDate;
	/**
	 * A code signifying the type of this promotional event. Examples can be:
	 * Holiday, Seasonal Event, Store Closing, Trade Item Introduction
	 */
	private String promotionalEventTypeCode;
	/**
	 * The date on which a proposal for this promotional event was submitted.
	 */
	private LocalDate submissionDate;
	private List<PromotionalSpecification> promotionalSpecifications=new ArrayList<>();

	public PromotionalEvent() {

	}

	public void finalize() throws Throwable {

	}

	public LocalDate getFirstShipmentAvailibilityDate() {
		return firstShipmentAvailibilityDate;
	}

	public void setFirstShipmentAvailibilityDate(LocalDate firstShipmentAvailibilityDate) {
		this.firstShipmentAvailibilityDate = firstShipmentAvailibilityDate;
	}

	public LocalDate getLatestProposalAcceptanceDate() {
		return latestProposalAcceptanceDate;
	}

	public void setLatestProposalAcceptanceDate(LocalDate latestProposalAcceptanceDate) {
		this.latestProposalAcceptanceDate = latestProposalAcceptanceDate;
	}

	public String getPromotionalEventTypeCode() {
		return promotionalEventTypeCode;
	}

	public void setPromotionalEventTypeCode(String promotionalEventTypeCode) {
		this.promotionalEventTypeCode = promotionalEventTypeCode;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}

	public List<PromotionalSpecification> getPromotionalSpecifications() {
		return promotionalSpecifications;
	}

	public void setPromotionalSpecifications(List<PromotionalSpecification> promotionalSpecifications) {
		this.promotionalSpecifications = promotionalSpecifications;
	}
}// end Promotional Event