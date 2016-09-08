package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

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
	private IdentifierType customizationID;
	/**
	 * Text specifying the type of document.
	 */
	private TextType documentType;
	/**
	 * A code signifying the type of document.
	 */
	private CodeType documentTypeCode;
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
	 * The Identifier of the parent document.
	 */
	private IdentifierType parentDocumentID;
	/**
	 * A code signifying the type of parent document.
	 */
	private CodeType parentDocumentTypeCode;
	/**
	 * Indicates the current version of the referred document.
	 */
	private IdentifierType parentDocumentVersionID;
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
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private IdentifierType ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<Attachment> attachments= new ArrayList<>();
	private LineReference parentDocumentLineReference;
	private Party receiverParty;
	private Party senderParty;
	private List<Signature> signatures= new ArrayList<>();

	public AttachedDocument() {

	}

	public void finalize() throws Throwable {

	}

	public IdentifierType getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(IdentifierType customizationID) {
		this.customizationID = customizationID;
	}

	public TextType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(TextType documentType) {
		this.documentType = documentType;
	}

	public CodeType getDocumentTypeCode() {
		return documentTypeCode;
	}

	public void setDocumentTypeCode(CodeType documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
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

	public IdentifierType getParentDocumentID() {
		return parentDocumentID;
	}

	public void setParentDocumentID(IdentifierType parentDocumentID) {
		this.parentDocumentID = parentDocumentID;
	}

	public CodeType getParentDocumentTypeCode() {
		return parentDocumentTypeCode;
	}

	public void setParentDocumentTypeCode(CodeType parentDocumentTypeCode) {
		this.parentDocumentTypeCode = parentDocumentTypeCode;
	}

	public IdentifierType getParentDocumentVersionID() {
		return parentDocumentVersionID;
	}

	public void setParentDocumentVersionID(IdentifierType parentDocumentVersionID) {
		this.parentDocumentVersionID = parentDocumentVersionID;
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

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
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
		this.signatures = signatures;
	}
}// end Attached Document