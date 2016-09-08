package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

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
	private IdentifierType customizationID;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType id;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * The date on which the information in the response was created.
	 */
	private DateType responseDate;
	/**
	 * The time at which the information in the response was created.
	 */
	private TimeType responseTime;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private IdentifierType ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	/**
	 * Identifies the current version of this document.
	 */
	private IdentifierType versionID;
	private List<DocumentResponse> documentResponses= new ArrayList<>();
	private Party senderParty;
	private Party receiverParty;
	private List<Signature> signatures= new ArrayList<>();

	public ApplicationResponse() {

	}

	public void finalize() throws Throwable {

	}

	public IdentifierType getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(IdentifierType customizationID) {
		this.customizationID = customizationID;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public DateType getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(DateType issueDate) {
		this.issueDate = issueDate;
	}

	public TimeType getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(TimeType issueTime) {
		this.issueTime = issueTime;
	}

	public TextType getNote() {
		return note;
	}

	public void setNote(TextType note) {
		this.note = note;
	}

	public IdentifierType getProfileExecutionID() {
		return profileExecutionID;
	}

	public void setProfileExecutionID(IdentifierType profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	public IdentifierType getProfileID() {
		return profileID;
	}

	public void setProfileID(IdentifierType profileID) {
		this.profileID = profileID;
	}

	public DateType getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(DateType responseDate) {
		this.responseDate = responseDate;
	}

	public TimeType getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(TimeType responseTime) {
		this.responseTime = responseTime;
	}

	public IdentifierType getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(IdentifierType ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public IdentifierType getUUID() {
		return UUID;
	}

	public void setUUID(IdentifierType UUID) {
		this.UUID = UUID;
	}

	public IdentifierType getVersionID() {
		return versionID;
	}

	public void setVersionID(IdentifierType versionID) {
		this.versionID = versionID;
	}

	public List<DocumentResponse> getDocumentResponses() {
		return documentResponses;
	}

	public void setDocumentResponses(List<DocumentResponse> documentResponses) {
		this.documentResponses = documentResponses;
	}

	public Party getSenderParty() {
		return senderParty;
	}

	public void setSenderParty(Party senderParty) {
		this.senderParty = senderParty;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}
}// end Application Response