package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A wrapper that allows a document of any kind to be packaged with the UBL
 * document that references it.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:08 a. m.
 */
public class AttachedDocument {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String customizationID;
	/**
	 * Text specifying the type of document.
	 */
	private String documentType;
	/**
	 * A code signifying the type of document.
	 */
	private String documentTypeCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String id;
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
	 * The Identifier of the parent document.
	 */
	private String parentDocumentID;
	/**
	 * A code signifying the type of parent document.
	 */
	private String parentDocumentTypeCode;
	/**
	 * Indicates the current version of the referred document.
	 */
	private String parentDocumentVersionID;
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
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private List<Attachment> attachments= new ArrayList<>();
	private LineReference parentDocumentLineReference;
	private Party receiverParty;
	private Party senderParty;
	private List<Signature> signatures= new ArrayList<>();

	public AttachedDocument() {

	}

	public void finalize() throws Throwable {

	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentTypeCode() {
		return documentTypeCode;
	}

	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getParentDocumentID() {
		return parentDocumentID;
	}

	public void setParentDocumentID(String parentDocumentID) {
		this.parentDocumentID = parentDocumentID;
	}

	public String getParentDocumentTypeCode() {
		return parentDocumentTypeCode;
	}

	public void setParentDocumentTypeCode(String parentDocumentTypeCode) {
		this.parentDocumentTypeCode = parentDocumentTypeCode;
	}

	public String getParentDocumentVersionID() {
		return parentDocumentVersionID;
	}

	public void setParentDocumentVersionID(String parentDocumentVersionID) {
		this.parentDocumentVersionID = parentDocumentVersionID;
	}

	public String getProfileExecutionID() {
		return profileExecutionID;
	}

	public void setProfileExecutionID(String profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(String ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		attachments = attachments;
	}

	public LineReference getParentDocumentLineReference() {
		return parentDocumentLineReference;
	}

	public void setParentDocumentLineReference(LineReference parentDocumentLineReference) {
		this.parentDocumentLineReference = parentDocumentLineReference;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public Party getSenderParty() {
		return senderParty;
	}

	public void setSenderParty(Party senderParty) {
		this.senderParty = senderParty;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		signatures = signatures;
	}
}// end Attached Document