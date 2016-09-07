package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document to indicate the application's response to a transaction. This may
 * be a business response initiated by a user or a technical response sent
 * automatically by an application.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:06 a. m.
 */
public class ApplicationResponse {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String customizationID;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String profileID;
	/**
	 * The date on which the information in the response was created.
	 */
	private LocalDate responseDate;
	/**
	 * The time at which the information in the response was created.
	 */
	private LocalTime responseTime;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	/**
	 * Identifies the current version of this document.
	 */
	private String versionID;
	private DocumentResponse m_DocumentResponse;
	private Party senderParty;
	private Party receiverParty;
	private List<Signature> signatures = new ArrayList<>();

	public ApplicationResponse() {

	}

	public void finalize() throws Throwable {

	}

	public String getCustomizationID() {
		return customizationID;
	}

	public DocumentResponse getDocumentResponse() {
		return m_DocumentResponse;
	}

	public String getID() {
		return ID;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public LocalTime getIssueTime() {
		return issueTime;
	}

	public String getNote() {
		return note;
	}

	public String getProfileExecutionID() {
		return profileExecutionID;
	}

	public String getProfileID() {
		return profileID;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public LocalDate getResponseDate() {
		return responseDate;
	}

	public LocalTime getResponseTime() {
		return responseTime;
	}

	public Party getSenderParty() {
		return senderParty;
	}

	public Signature getSignature() {
		return m_Signature;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public String getVersionID() {
		return versionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(String newVal) {
		customizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentResponse(DocumentResponse newVal) {
		m_DocumentResponse = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal) {
		issueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal) {
		issueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal) {
		note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileExecutionID(String newVal) {
		profileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(String newVal) {
		profileID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceiverParty(Party newVal) {
		receiverParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponseDate(LocalDate newVal) {
		responseDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponseTime(LocalTime newVal) {
		responseTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSenderParty(Party newVal) {
		senderParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignature(Signature newVal) {
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUBLVersionID(String newVal) {
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal) {
		UUID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(String newVal) {
		versionID = newVal;
	}
}// end Application Response