package org.openfact.models.jpa.entities.ubl;

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
	private LocalDate approvalDate;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e.,
	 * record) to which this document belongs.
	 */
	private String contractFolderID;
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
	 * Identifies the previous version of the Call for Tenders which is
	 * superceded by this version.
	 */
	private String previousVersionID;
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
	/**
	 * Indicates the current version of the Call for Tenders.
	 */
	private String versionID;
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

	public LocalDate getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDate approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getContractFolderID() {
		return contractFolderID;
	}

	public void setContractFolderID(String contractFolderID) {
		this.contractFolderID = contractFolderID;
	}

	public boolean isCopyIndicator() {
		return copyIndicator;
	}

	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPreviousVersionID() {
		return previousVersionID;
	}

	public void setPreviousVersionID(String previousVersionID) {
		this.previousVersionID = previousVersionID;
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

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
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