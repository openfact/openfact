package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used by a Contracting party to announce a project to buy goods,
 * services, or works.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:23 a. m.
 */
public class ContractNotice {

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
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
	/**
	 * Information about the law that defines the regulatory domain.
	 */
	private String RegulatoryDomain;
	/**
	 * The requested publication date for this Contract Notice.
	 */
	private LocalDate RequestedPublicationDate;
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
	private Party ReceiverParty;
	private Period FrequencyPeriod;
	private ProcurementProjectLot m_ProcurementProjectLot;
	private ProcurementProject m_ProcurementProject;
	private Signature m_Signature;
	private TenderingProcess m_TenderingProcess;
	private TenderingTerms m_TenderingTerms;

	public ContractNotice() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the contractFolderID
	 */
	public String getContractFolderID() {
		return ContractFolderID;
	}

	/**
	 * @param contractFolderID
	 *            the contractFolderID to set
	 */
	public void setContractFolderID(String contractFolderID) {
		ContractFolderID = contractFolderID;
	}

	/**
	 * @return the copyIndicator
	 */
	public boolean isCopyIndicator() {
		return CopyIndicator;
	}

	/**
	 * @param copyIndicator
	 *            the copyIndicator to set
	 */
	public void setCopyIndicator(boolean copyIndicator) {
		CopyIndicator = copyIndicator;
	}

	/**
	 * @return the customizationID
	 */
	public String getCustomizationID() {
		return CustomizationID;
	}

	/**
	 * @param customizationID
	 *            the customizationID to set
	 */
	public void setCustomizationID(String customizationID) {
		CustomizationID = customizationID;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the issueDate
	 */
	public LocalDate getIssueDate() {
		return IssueDate;
	}

	/**
	 * @param issueDate
	 *            the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}

	/**
	 * @return the issueTime
	 */
	public LocalTime getIssueTime() {
		return IssueTime;
	}

	/**
	 * @param issueTime
	 *            the issueTime to set
	 */
	public void setIssueTime(LocalTime issueTime) {
		IssueTime = issueTime;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return Note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		Note = note;
	}

	/**
	 * @return the profileExecutionID
	 */
	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	/**
	 * @param profileExecutionID
	 *            the profileExecutionID to set
	 */
	public void setProfileExecutionID(String profileExecutionID) {
		ProfileExecutionID = profileExecutionID;
	}

	/**
	 * @return the profileID
	 */
	public String getProfileID() {
		return ProfileID;
	}

	/**
	 * @param profileID
	 *            the profileID to set
	 */
	public void setProfileID(String profileID) {
		ProfileID = profileID;
	}

	/**
	 * @return the regulatoryDomain
	 */
	public String getRegulatoryDomain() {
		return RegulatoryDomain;
	}

	/**
	 * @param regulatoryDomain
	 *            the regulatoryDomain to set
	 */
	public void setRegulatoryDomain(String regulatoryDomain) {
		RegulatoryDomain = regulatoryDomain;
	}

	/**
	 * @return the requestedPublicationDate
	 */
	public LocalDate getRequestedPublicationDate() {
		return RequestedPublicationDate;
	}

	/**
	 * @param requestedPublicationDate
	 *            the requestedPublicationDate to set
	 */
	public void setRequestedPublicationDate(LocalDate requestedPublicationDate) {
		RequestedPublicationDate = requestedPublicationDate;
	}

	/**
	 * @return the uBLVersionID
	 */
	public String getUBLVersionID() {
		return UBLVersionID;
	}

	/**
	 * @param uBLVersionID
	 *            the uBLVersionID to set
	 */
	public void setUBLVersionID(String uBLVersionID) {
		UBLVersionID = uBLVersionID;
	}

	/**
	 * @return the uUID
	 */
	public String getUUID() {
		return UUID;
	}

	/**
	 * @param uUID
	 *            the uUID to set
	 */
	public void setUUID(String uUID) {
		UUID = uUID;
	}

	/**
	 * @return the m_ContractingParty
	 */
	public ContractingParty getM_ContractingParty() {
		return m_ContractingParty;
	}

	/**
	 * @param m_ContractingParty
	 *            the m_ContractingParty to set
	 */
	public void setM_ContractingParty(ContractingParty m_ContractingParty) {
		this.m_ContractingParty = m_ContractingParty;
	}

	/**
	 * @return the originatorCustomerParty
	 */
	public CustomerParty getOriginatorCustomerParty() {
		return OriginatorCustomerParty;
	}

	/**
	 * @param originatorCustomerParty
	 *            the originatorCustomerParty to set
	 */
	public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
		OriginatorCustomerParty = originatorCustomerParty;
	}

	/**
	 * @return the receiverParty
	 */
	public Party getReceiverParty() {
		return ReceiverParty;
	}

	/**
	 * @param receiverParty
	 *            the receiverParty to set
	 */
	public void setReceiverParty(Party receiverParty) {
		ReceiverParty = receiverParty;
	}

	/**
	 * @return the frequencyPeriod
	 */
	public Period getFrequencyPeriod() {
		return FrequencyPeriod;
	}

	/**
	 * @param frequencyPeriod
	 *            the frequencyPeriod to set
	 */
	public void setFrequencyPeriod(Period frequencyPeriod) {
		FrequencyPeriod = frequencyPeriod;
	}

	/**
	 * @return the m_ProcurementProjectLot
	 */
	public ProcurementProjectLot getM_ProcurementProjectLot() {
		return m_ProcurementProjectLot;
	}

	/**
	 * @param m_ProcurementProjectLot
	 *            the m_ProcurementProjectLot to set
	 */
	public void setM_ProcurementProjectLot(ProcurementProjectLot m_ProcurementProjectLot) {
		this.m_ProcurementProjectLot = m_ProcurementProjectLot;
	}

	/**
	 * @return the m_ProcurementProject
	 */
	public ProcurementProject getM_ProcurementProject() {
		return m_ProcurementProject;
	}

	/**
	 * @param m_ProcurementProject
	 *            the m_ProcurementProject to set
	 */
	public void setM_ProcurementProject(ProcurementProject m_ProcurementProject) {
		this.m_ProcurementProject = m_ProcurementProject;
	}

	/**
	 * @return the m_Signature
	 */
	public Signature getM_Signature() {
		return m_Signature;
	}

	/**
	 * @param m_Signature
	 *            the m_Signature to set
	 */
	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	/**
	 * @return the m_TenderingProcess
	 */
	public TenderingProcess getM_TenderingProcess() {
		return m_TenderingProcess;
	}

	/**
	 * @param m_TenderingProcess
	 *            the m_TenderingProcess to set
	 */
	public void setM_TenderingProcess(TenderingProcess m_TenderingProcess) {
		this.m_TenderingProcess = m_TenderingProcess;
	}

	/**
	 * @return the m_TenderingTerms
	 */
	public TenderingTerms getM_TenderingTerms() {
		return m_TenderingTerms;
	}

	/**
	 * @param m_TenderingTerms
	 *            the m_TenderingTerms to set
	 */
	public void setM_TenderingTerms(TenderingTerms m_TenderingTerms) {
		this.m_TenderingTerms = m_TenderingTerms;
	}

}// end Contract Notice