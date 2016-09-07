package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used by a Contracting Party to define a procurement project to buy
 * goods, services, or works during a specified period.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTenders {

	/**
	 * The date, assigned by the contracting party, on which the Call For Tenders was
	 * approved.
	 */
	private LocalDate ApprovalDate;
	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private String ContractFolderID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * Identifies the previous version of the Call for Tenders which is superceded by
	 * this version.
	 */
	private String PreviousVersionID;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	/**
	 * Indicates the current version of the Call for Tenders.
	 */
	private String VersionID;
	private ContractingParty m_ContractingParty;
	private CustomerParty OriginatorCustomerParty;
	private DocumentReference TechnicalDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private DocumentReference LegalDocumentReference;
	private Party ReceiverParty;
	private ProcurementProject m_ProcurementProject;
	private ProcurementProjectLot m_ProcurementProjectLot;
	private Signature m_Signature;
	private TenderingProcess m_TenderingProcess;
	private TenderingTerms m_TenderingTerms;

	public CallForTenders(){

	}

	public void finalize() throws Throwable {

	}
	
	public LocalDate getApprovalDate() {
		return ApprovalDate;
	}

	public void setApprovalDate(LocalDate approvalDate) {
		ApprovalDate = approvalDate;
	}

	public String getContractFolderID() {
		return ContractFolderID;
	}

	public void setContractFolderID(String contractFolderID) {
		ContractFolderID = contractFolderID;
	}

	public boolean isCopyIndicator() {
		return CopyIndicator;
	}

	public void setCopyIndicator(boolean copyIndicator) {
		CopyIndicator = copyIndicator;
	}

	public String getCustomizationID() {
		return CustomizationID;
	}

	public void setCustomizationID(String customizationID) {
		CustomizationID = customizationID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}

	public LocalTime getIssueTime() {
		return IssueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		IssueTime = issueTime;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getPreviousVersionID() {
		return PreviousVersionID;
	}

	public void setPreviousVersionID(String previousVersionID) {
		PreviousVersionID = previousVersionID;
	}

	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	public void setProfileExecutionID(String profileExecutionID) {
		ProfileExecutionID = profileExecutionID;
	}

	public String getProfileID() {
		return ProfileID;
	}

	public void setProfileID(String profileID) {
		ProfileID = profileID;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String uBLVersionID) {
		UBLVersionID = uBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public String getVersionID() {
		return VersionID;
	}

	public void setVersionID(String versionID) {
		VersionID = versionID;
	}

	public ContractingParty getM_ContractingParty() {
		return m_ContractingParty;
	}

	public void setM_ContractingParty(ContractingParty m_ContractingParty) {
		this.m_ContractingParty = m_ContractingParty;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return OriginatorCustomerParty;
	}

	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		OriginatorCustomerParty = originatorCustomerParty;
	}

	public DocumentReference getTechnicalDocumentReference() {
		return TechnicalDocumentReference;
	}

	public void setTechnicalDocumentReference(DocumentReference technicalDocumentReference) {
		TechnicalDocumentReference = technicalDocumentReference;
	}

	public DocumentReference getAdditionalDocumentReference() {
		return AdditionalDocumentReference;
	}

	public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
		AdditionalDocumentReference = additionalDocumentReference;
	}

	public DocumentReference getLegalDocumentReference() {
		return LegalDocumentReference;
	}

	public void setLegalDocumentReference(DocumentReference legalDocumentReference) {
		LegalDocumentReference = legalDocumentReference;
	}

	public Party getReceiverParty() {
		return ReceiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		ReceiverParty = receiverParty;
	}

	public ProcurementProject getM_ProcurementProject() {
		return m_ProcurementProject;
	}

	public void setM_ProcurementProject(ProcurementProject m_ProcurementProject) {
		this.m_ProcurementProject = m_ProcurementProject;
	}

	public ProcurementProjectLot getM_ProcurementProjectLot() {
		return m_ProcurementProjectLot;
	}

	public void setM_ProcurementProjectLot(ProcurementProjectLot m_ProcurementProjectLot) {
		this.m_ProcurementProjectLot = m_ProcurementProjectLot;
	}

	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	public TenderingProcess getM_TenderingProcess() {
		return m_TenderingProcess;
	}

	public void setM_TenderingProcess(TenderingProcess m_TenderingProcess) {
		this.m_TenderingProcess = m_TenderingProcess;
	}

	public TenderingTerms getM_TenderingTerms() {
		return m_TenderingTerms;
	}

	public void setM_TenderingTerms(TenderingTerms m_TenderingTerms) {
		this.m_TenderingTerms = m_TenderingTerms;
	}
	
	
}//end Call For Tenders