package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a power of attorney.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorney {

	/**
	 * Text describing this power of attorney.
	 */
	private String description;
	/**
	 * An identifier for this power of attorney.
	 */
	private String ID;
	/**
	 * The date on which this power of attorney was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time at which this power of attorney was issued.
	 */
	private LocalTime issueTime;
	private DocumentReference mandateDocumentReference;
	private Party agentParty;
	private Party notaryParty;
	private Party witnessParty;

	public PowerOfAttorney() {

	}

	public void finalize() throws Throwable {

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

	public DocumentReference getMandateDocumentReference() {
		return mandateDocumentReference;
	}

	public void setMandateDocumentReference(DocumentReference mandateDocumentReference) {
		this.mandateDocumentReference = mandateDocumentReference;
	}

	public Party getAgentParty() {
		return agentParty;
	}

	public void setAgentParty(Party agentParty) {
		this.agentParty = agentParty;
	}

	public Party getNotaryParty() {
		return notaryParty;
	}

	public void setNotaryParty(Party notaryParty) {
		this.notaryParty = notaryParty;
	}

	public Party getWitnessParty() {
		return witnessParty;
	}

	public void setWitnessParty(Party witnessParty) {
		this.witnessParty = witnessParty;
	}
}// end Power Of Attorney