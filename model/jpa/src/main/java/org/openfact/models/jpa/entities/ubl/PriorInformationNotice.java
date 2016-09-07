package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used by a contracting party to declare the intention to buy goods,
 * services, or works during a specified period.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:07 a. m.
 */
public class PriorInformationNotice {

	/**
	 * An identifier, assigned by the sender, for the process file (i.e.,
	 * record) to which this document belongs.
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
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * The date planned by the Contracting Party for publication of the contract
	 * notice.
	 */
	private LocalDate PlannedDate;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
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
	private ContractingParty m_ContractingParty;
	private CustomerParty OriginatorCustomerParty;
	private DocumentReference m_DocumentReference;
	private Party ReceiverParty;
	private ProcurementProject m_ProcurementProject;
	private ProcurementProjectLot m_ProcurementProjectLot;
	private Signature m_Signature;
	private TenderingProcess m_TenderingProcess;
	private TenderingTerms m_TenderingTerms;

	public PriorInformationNotice() {

	}

	public void finalize() throws Throwable {

	}

	public String getContractFolderID() {
		return ContractFolderID;
	}

	public ContractingParty getContractingParty() {
		return m_ContractingParty;
	}

	public boolean getCopyIndicator() {
		return CopyIndicator;
	}

	public String getCustomizationID() {
		return CustomizationID;
	}

	public DocumentReference getDocumentReference() {
		return m_DocumentReference;
	}

	public String getID() {
		return ID;
	}

	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public LocalTime getIssueTime() {
		return IssueTime;
	}

	public String getNote() {
		return Note;
	}

	public CustomerParty getOriginatorCustomerParty() {
		return OriginatorCustomerParty;
	}

	public LocalDate getPlannedDate() {
		return PlannedDate;
	}

	public ProcurementProject getProcurementProject() {
		return m_ProcurementProject;
	}

	public ProcurementProjectLot getProcurementProjectLot() {
		return m_ProcurementProjectLot;
	}

	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	public String getProfileID() {
		return ProfileID;
	}

	public Party getReceiverParty() {
		return ReceiverParty;
	}

	public Signature getSignature() {
		return m_Signature;
	}

	public TenderingProcess getTenderingProcess() {
		return m_TenderingProcess;
	}

	public TenderingTerms getTenderingTerms() {
		return m_TenderingTerms;
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
	public void setContractFolderID(String newVal) {
		ContractFolderID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractingParty(ContractingParty newVal) {
		m_ContractingParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal) {
		CopyIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(String newVal) {
		CustomizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal) {
		m_DocumentReference = newVal;
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
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal) {
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal) {
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginatorCustomerParty(CustomerParty newVal) {
		OriginatorCustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlannedDate(LocalDate newVal) {
		PlannedDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurementProject(ProcurementProject newVal) {
		m_ProcurementProject = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurementProjectLot(ProcurementProjectLot newVal) {
		m_ProcurementProjectLot = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileExecutionID(String newVal) {
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(String newVal) {
		ProfileID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceiverParty(Party newVal) {
		ReceiverParty = newVal;
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
	public void setTenderingProcess(TenderingProcess newVal) {
		m_TenderingProcess = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTenderingTerms(TenderingTerms newVal) {
		m_TenderingTerms = newVal;
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
}// end Prior Information Notice