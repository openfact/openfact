package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used by a ContractingParty to define a procurement project to buy
 * goods, services, or works during a specified period.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTenders {

	/**
	 * The date, assigned by the contracting party, on which the Call For
	 * Tenders was approved.
	 */
	private DateType approvalDate;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e.,
	 * record) to which this document belongs.
	 */
	private IdentifierType contractFolderID;
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
	 * Identifies the previous version of the Call for Tenders which is
	 * superceded by this version.
	 */
	private IdentifierType previousVersionID;
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
	/**
	 * Indicates the current version of the Call for Tenders.
	 */
	private IdentifierType versionID;
	private List<ContractingParty> contractingPartys= new ArrayList<>();
	private CustomerParty originatorCustomerParty;
	private DocumentReference technicalDocumentReference;
	private DocumentReference additionalDocumentReference;
	private DocumentReference legalDocumentReference;
	private Party receiverParty;
	private List<ProcurementProject> procurementProjects= new ArrayList<>();
	private List<ProcurementProjectLot> procurementProjectLots= new ArrayList<>();
	private List<Signature> signatures= new ArrayList<>();
	private List<TenderingProcess> tenderingProcesss= new ArrayList<>();
	private List<TenderingTerms> tenderingTermss= new ArrayList<>();

	public CallForTenders() {

	}

	public void finalize() throws Throwable {

	}

	public DateType getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(DateType approvalDate) {
		this.approvalDate = approvalDate;
	}

	public IdentifierType getContractFolderID() {
		return contractFolderID;
	}

	public void setContractFolderID(IdentifierType contractFolderID) {
		this.contractFolderID = contractFolderID;
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

	public IdentifierType getPreviousVersionID() {
		return previousVersionID;
	}

	public void setPreviousVersionID(IdentifierType previousVersionID) {
		this.previousVersionID = previousVersionID;
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

	public IdentifierType getVersionID() {
		return versionID;
	}

	public void setVersionID(IdentifierType versionID) {
		this.versionID = versionID;
	}

	public List<ContractingParty> getContractingPartys() {
		return contractingPartys;
	}

	public void setContractingPartys(List<ContractingParty> contractingPartys) {
		this.contractingPartys = contractingPartys;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return originatorCustomerParty;
	}

	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		this.originatorCustomerParty = originatorCustomerParty;
	}

	public DocumentReference getTechnicalDocumentReference() {
		return technicalDocumentReference;
	}

	public void setTechnicalDocumentReference(DocumentReference technicalDocumentReference) {
		this.technicalDocumentReference = technicalDocumentReference;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public DocumentReference getLegalDocumentReference() {
		return legalDocumentReference;
	}

	public void setLegalDocumentReference(DocumentReference legalDocumentReference) {
		this.legalDocumentReference = legalDocumentReference;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public List<ProcurementProject> getProcurementProjects() {
		return procurementProjects;
	}

	public void setProcurementProjects(List<ProcurementProject> procurementProjects) {
		this.procurementProjects = procurementProjects;
	}

	public List<ProcurementProjectLot> getProcurementProjectLots() {
		return procurementProjectLots;
	}

	public void setProcurementProjectLots(List<ProcurementProjectLot> procurementProjectLots) {
		this.procurementProjectLots = procurementProjectLots;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}

	public List<TenderingProcess> getTenderingProcesss() {
		return tenderingProcesss;
	}

	public void setTenderingProcesss(List<TenderingProcess> tenderingProcesss) {
		this.tenderingProcesss = tenderingProcesss;
	}

	public List<TenderingTerms> getTenderingTermss() {
		return tenderingTermss;
	}

	public void setTenderingTermss(List<TenderingTerms> tenderingTermss) {
		this.tenderingTermss = tenderingTermss;
	}
}// end Call For Tenders