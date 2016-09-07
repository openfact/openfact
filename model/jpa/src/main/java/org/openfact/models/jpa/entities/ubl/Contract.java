package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a contract.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:59 a. m.
 */
public class Contract {

	/**
	 * The type of this contract, expressed as text, such as "Cost plus award
	 * fee" and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
	 */
	private String contractType;
	/**
	 * The type of this contract, expressed as a code, such as "Cost plus award
	 * fee" and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
	 */
	private String contractTypeCode;
	/**
	 * Text describing this contract.
	 */
	private String description;
	/**
	 * An identifier for this contract.
	 */
	private String ID;
	/**
	 * The date on which this contract was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time at which this contract was issued.
	 */
	private LocalTime issueTime;
	/**
	 * In a transportation contract, the deadline date by which the services
	 * referred to in the transport execution plan have to be booked. For
	 * example, if this service is a carrier service scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination
	 */
	private LocalDate nominationDate;
	/**
	 * In a transportation contract, the deadline time by which the services
	 * referred to in the transport execution plan have to be booked. For
	 * example, if this service is a carrier service scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination
	 */
	private LocalTime nominationTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * An identifier for the current version of this contract.
	 */
	private String versionID;
	private Delivery contractualDelivery;
	private DocumentReference contractDocumentReference;
	private Period validityPeriod;
	private Period nominationPeriod;

	public Contract() {

	}

	public void finalize() throws Throwable {

	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getContractTypeCode() {
		return contractTypeCode;
	}

	public void setContractTypeCode(String contractTypeCode) {
		this.contractTypeCode = contractTypeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalTime getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}

	public LocalDate getNominationDate() {
		return nominationDate;
	}

	public void setNominationDate(LocalDate nominationDate) {
		this.nominationDate = nominationDate;
	}

	public LocalTime getNominationTime() {
		return nominationTime;
	}

	public void setNominationTime(LocalTime nominationTime) {
		this.nominationTime = nominationTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	public Delivery getContractualDelivery() {
		return contractualDelivery;
	}

	public void setContractualDelivery(Delivery contractualDelivery) {
		this.contractualDelivery = contractualDelivery;
	}

	public DocumentReference getContractDocumentReference() {
		return contractDocumentReference;
	}

	public void setContractDocumentReference(DocumentReference contractDocumentReference) {
		this.contractDocumentReference = contractDocumentReference;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Period getNominationPeriod() {
		return nominationPeriod;
	}

	public void setNominationPeriod(Period nominationPeriod) {
		this.nominationPeriod = nominationPeriod;
	}
}// end Contract