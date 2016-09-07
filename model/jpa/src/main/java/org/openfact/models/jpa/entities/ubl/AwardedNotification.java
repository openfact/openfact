package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The document used to communicate a contract award to the winner.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:10 a. m.
 */
public class AwardedNotification {

	/**
	 * An identifier, assigned by the sender, for the process file (i.e.,
	 * record) to which this document belongs.
	 */
	private String contractFolderID;
	/**
	 * The name, expressed as text, of this procurement project.
	 */
	private String contractName;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator;
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
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private DocumentReference minutesDocumentReference;
	private DocumentReference additionalDocumentReference;
	private FinancialGuarantee finalFinancialGuarantee;
	private Party receiverParty;
	private Party senderParty;
	private List<Signature> Signatures= new ArrayList<>();
	private List<TenderResult> TenderResults= new ArrayList<>();

	public AwardedNotification() {

	}

	public void finalize() throws Throwable {

	}

	public DocumentReference getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public String getContractFolderID() {
		return contractFolderID;
	}

	public String getContractName() {
		return contractName;
	}

	public boolean getCopyIndicator() {
		return copyIndicator;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public FinancialGuarantee getFinalFinancialGuarantee() {
		return finalFinancialGuarantee;
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

	public DocumentReference getMinutesDocumentReference() {
		return minutesDocumentReference;
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

	public Party getSenderParty() {
		return senderParty;
	}

	public boolean isCopyIndicator() {
		return copyIndicator;
	}

	public List<Signature> getSignatures() {
		return Signatures;
	}

	public List<TenderResult> getTenderResults() {
		return TenderResults;
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
	public void setAdditionalDocumentReference(DocumentReference newVal) {
		additionalDocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractFolderID(String newVal) {
		contractFolderID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractName(String newVal) {
		contractName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal) {
		copyIndicator = newVal;
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
	public void setFinalFinancialGuarantee(FinancialGuarantee newVal) {
		finalFinancialGuarantee = newVal;
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
	public void setMinutesDocumentReference(DocumentReference newVal) {
		minutesDocumentReference = newVal;
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
	public void setSenderParty(Party newVal) {
		senderParty = newVal;
	}

	public void setSignatures(List<Signature> signatures) {
		Signatures = signatures;
	}

	public void setTenderResults(List<TenderResult> tenderResults) {
		TenderResults = tenderResults;
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
}// end Awarded Notification