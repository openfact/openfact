package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document to notify the deposit of a bid bond guarantee.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:45 a. m.
 */
public class GuaranteeCertificate {

	/**
	 * The code stating the constitution means of the guarantee.
	 */
	private String ConstitutionCode;
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
	 * A code signifying the type of the guarantee.
	 */
	private String GuaranteeTypeCode;
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
	 * The liability amount (a monetary value) in the bid bond guarantee.
	 */
	private BigDecimal LiabilityAmount;
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
	 * A textual description of the purpose of the bid bond guarantee.
	 */
	private String Purpose;
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
	private DocumentReference GuaranteeDocumentReference;
	private ImmobilizedSecurity m_ImmobilizedSecurity;
	private Party InterestedParty;
	private Party GuarantorParty;
	private Party BeneficiaryParty;
	private Period ApplicablePeriod;
	private Regulation ApplicableRegulation;
	private List<Signature> signatures = new ArrayList<>();

	/**
	 * @return the constitutionCode
	 */
	public String getConstitutionCode() {
		return ConstitutionCode;
	}

	/**
	 * @param constitutionCode
	 *            the constitutionCode to set
	 */
	public void setConstitutionCode(String constitutionCode) {
		ConstitutionCode = constitutionCode;
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
	 * @return the guaranteeTypeCode
	 */
	public String getGuaranteeTypeCode() {
		return GuaranteeTypeCode;
	}

	/**
	 * @param guaranteeTypeCode
	 *            the guaranteeTypeCode to set
	 */
	public void setGuaranteeTypeCode(String guaranteeTypeCode) {
		GuaranteeTypeCode = guaranteeTypeCode;
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
	 * @return the liabilityAmount
	 */
	public BigDecimal getLiabilityAmount() {
		return LiabilityAmount;
	}

	/**
	 * @param liabilityAmount
	 *            the liabilityAmount to set
	 */
	public void setLiabilityAmount(BigDecimal liabilityAmount) {
		LiabilityAmount = liabilityAmount;
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
	 * @return the purpose
	 */
	public String getPurpose() {
		return Purpose;
	}

	/**
	 * @param purpose
	 *            the purpose to set
	 */
	public void setPurpose(String purpose) {
		Purpose = purpose;
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
	 * @return the guaranteeDocumentReference
	 */
	public DocumentReference getGuaranteeDocumentReference() {
		return GuaranteeDocumentReference;
	}

	/**
	 * @param guaranteeDocumentReference
	 *            the guaranteeDocumentReference to set
	 */
	public void setGuaranteeDocumentReference(DocumentReference guaranteeDocumentReference) {
		GuaranteeDocumentReference = guaranteeDocumentReference;
	}

	/**
	 * @return the m_ImmobilizedSecurity
	 */
	public ImmobilizedSecurity getM_ImmobilizedSecurity() {
		return m_ImmobilizedSecurity;
	}

	/**
	 * @param m_ImmobilizedSecurity
	 *            the m_ImmobilizedSecurity to set
	 */
	public void setM_ImmobilizedSecurity(ImmobilizedSecurity m_ImmobilizedSecurity) {
		this.m_ImmobilizedSecurity = m_ImmobilizedSecurity;
	}

	/**
	 * @return the interestedParty
	 */
	public Party getInterestedParty() {
		return InterestedParty;
	}

	/**
	 * @param interestedParty
	 *            the interestedParty to set
	 */
	public void setInterestedParty(Party interestedParty) {
		InterestedParty = interestedParty;
	}

	/**
	 * @return the guarantorParty
	 */
	public Party getGuarantorParty() {
		return GuarantorParty;
	}

	/**
	 * @param guarantorParty
	 *            the guarantorParty to set
	 */
	public void setGuarantorParty(Party guarantorParty) {
		GuarantorParty = guarantorParty;
	}

	/**
	 * @return the beneficiaryParty
	 */
	public Party getBeneficiaryParty() {
		return BeneficiaryParty;
	}

	/**
	 * @param beneficiaryParty
	 *            the beneficiaryParty to set
	 */
	public void setBeneficiaryParty(Party beneficiaryParty) {
		BeneficiaryParty = beneficiaryParty;
	}

	/**
	 * @return the applicablePeriod
	 */
	public Period getApplicablePeriod() {
		return ApplicablePeriod;
	}

	/**
	 * @param applicablePeriod
	 *            the applicablePeriod to set
	 */
	public void setApplicablePeriod(Period applicablePeriod) {
		ApplicablePeriod = applicablePeriod;
	}

	/**
	 * @return the applicableRegulation
	 */
	public Regulation getApplicableRegulation() {
		return ApplicableRegulation;
	}

	/**
	 * @param applicableRegulation
	 *            the applicableRegulation to set
	 */
	public void setApplicableRegulation(Regulation applicableRegulation) {
		ApplicableRegulation = applicableRegulation;
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

}// end Guarantee Certificate