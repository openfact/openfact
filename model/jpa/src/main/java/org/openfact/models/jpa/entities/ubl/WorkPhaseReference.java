package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class that refers to a phase of work. Used for instance to specify what
 * part of the contract the billing is referring to.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:01 a. m.
 */
public class WorkPhaseReference {

	/**
	 * The date on which this phase of work ends.
	 */
	private LocalDate endDate;
	/**
	 * An identifier for this phase of work.
	 */
	private String id;
	/**
	 * The progress percentage of the work phase.
	 */
	private BigDecimal progressPercent;
	/**
	 * The date on which this phase of work begins.
	 */
	private LocalDate startDate;
	/**
	 * Text describing this phase of work.
	 */
	private String workPhase;
	/**
	 * A code signifying this phase of work.
	 */
	private String workPhaseCode;
	private DocumentReference workOrderDocumentReference;

	public WorkPhaseReference() {

	}

	public void finalize() throws Throwable {

	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getProgressPercent() {
		return progressPercent;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public DocumentReference getWorkOrderDocumentReference() {
		return workOrderDocumentReference;
	}

	public String getWorkPhase() {
		return workPhase;
	}

	public String getWorkPhaseCode() {
		return workPhaseCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEndDate(LocalDate newVal) {
		endDate = newVal;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProgressPercent(BigDecimal newVal) {
		progressPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStartDate(LocalDate newVal) {
		startDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWorkOrderDocumentReference(DocumentReference newVal) {
		workOrderDocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWorkPhase(String newVal) {
		workPhase = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWorkPhaseCode(String newVal) {
		workPhaseCode = newVal;
	}
}// end WorkPhaseReference