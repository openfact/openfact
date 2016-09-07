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
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Attachment m_Attachment;
	private LineReference parentDocumentLineReference;
	private Party receiverParty;
	private Party senderParty;
	private List<Signature> signatures = new ArrayList<>();

	public AttachedDocument() {

	}

	public void finalize() throws Throwable {

	}

	public Attachment getAttachment() {
		return m_Attachment;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getDocumentTypeCode() {
		return documentTypeCode;
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

	public LineReference getParentDocumentLineReference() {
		return parentDocumentLineReference;
	}

	public String getParentDocumentID() {
		return parentDocumentID;
	}

	public String getParentDocumentTypeCode() {
		return parentDocumentTypeCode;
	}

	public String getParentDocumentVersionID() {
		return parentDocumentVersionID;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setAttachment(Attachment newVal) {
		m_Attachment = newVal;
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
	public void setDocumentType(String newVal) {
		documentType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentTypeCode(String newVal) {
		documentTypeCode = newVal;
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
	public void setParentDocumentLineReference(LineReference newVal) {
		parentDocumentLineReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentID(String newVal) {
		parentDocumentID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentTypeCode(String newVal) {
		parentDocumentTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentVersionID(String newVal) {
		parentDocumentVersionID = newVal;
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
}// end Attached Document