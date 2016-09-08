package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

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
	private IdentifierType contractFolderID;
	/**
	 * The name, expressed as text, of this procurement project.
	 */
	private TextType contractName;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
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
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private IdentifierType ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private DocumentReference minutesDocumentReference;
	private DocumentReference additionalDocumentReference;
	private FinancialGuarantee finalFinancialGuarantee;
	private Party receiverParty;
	private Party senderParty;
	private List<Signature> signatures= new ArrayList<>();
	private List<TenderResult> tenderResults= new ArrayList<>();

	public AwardedNotification() {

	}

	public void finalize() throws Throwable {

	}

	public IdentifierType getContractFolderID() {
		return contractFolderID;
	}

	public void setContractFolderID(IdentifierType contractFolderID) {
		this.contractFolderID = contractFolderID;
	}

	public TextType getContractName() {
		return contractName;
	}

	public void setContractName(TextType contractName) {
		this.contractName = contractName;
	}

	public IndicatorType getCopyIndicator() {
		return copyIndicator;
	}

	public void setCopyIndicator(IndicatorType copyIndicator) {
		this.copyIndicator = copyIndicator;
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

	public DocumentReference getMinutesDocumentReference() {
		return minutesDocumentReference;
	}

	public void setMinutesDocumentReference(DocumentReference minutesDocumentReference) {
		this.minutesDocumentReference = minutesDocumentReference;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public FinancialGuarantee getFinalFinancialGuarantee() {
		return finalFinancialGuarantee;
	}

	public void setFinalFinancialGuarantee(FinancialGuarantee finalFinancialGuarantee) {
		this.finalFinancialGuarantee = finalFinancialGuarantee;
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

	public List<TenderResult> getTenderResults() {
		return tenderResults;
	}

	public void setTenderResults(List<TenderResult> tenderResults) {
		this.tenderResults = tenderResults;
	}
}// end Awarded Notification