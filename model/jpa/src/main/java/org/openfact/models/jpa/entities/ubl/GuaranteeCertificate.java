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
	private String constitutionCode;
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
	 * A code signifying the type of the guarantee.
	 */
	private String guaranteeTypeCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String id;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime;
	/**
	 * The liability amount (a monetary value) in the bid bond guarantee.
	 */
	private BigDecimal liabilityAmount;
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
	 * A textual description of the purpose of the bid bond guarantee.
	 */
	private String purpose;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private DocumentReference guaranteeDocumentReference;
	private List<ImmobilizedSecurity> immobilizedSecurities=new ArrayList<>();
	private Party interestedParty;
	private Party guarantorParty;
	private Party beneficiaryParty;
	private Period applicablePeriod;
	private Regulation applicableRegulation;
	private List<Signature> signatures = new ArrayList<>();

	public String getConstitutionCode() {
		return constitutionCode;
	}

	public void setConstitutionCode(String constitutionCode) {
		this.constitutionCode = constitutionCode;
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

	public String getGuaranteeTypeCode() {
		return guaranteeTypeCode;
	}

	public void setGuaranteeTypeCode(String guaranteeTypeCode) {
		this.guaranteeTypeCode = guaranteeTypeCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public BigDecimal getLiabilityAmount() {
		return liabilityAmount;
	}

	public void setLiabilityAmount(BigDecimal liabilityAmount) {
		this.liabilityAmount = liabilityAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(String ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public DocumentReference getGuaranteeDocumentReference() {
		return guaranteeDocumentReference;
	}

	public void setGuaranteeDocumentReference(DocumentReference guaranteeDocumentReference) {
		this.guaranteeDocumentReference = guaranteeDocumentReference;
	}

	public List<ImmobilizedSecurity> getImmobilizedSecurities() {
		return immobilizedSecurities;
	}

	public void setImmobilizedSecurities(List<ImmobilizedSecurity> immobilizedSecurities) {
		this.immobilizedSecurities = immobilizedSecurities;
	}

	public Party getInterestedParty() {
		return interestedParty;
	}

	public void setInterestedParty(Party interestedParty) {
		this.interestedParty = interestedParty;
	}

	public Party getGuarantorParty() {
		return guarantorParty;
	}

	public void setGuarantorParty(Party guarantorParty) {
		this.guarantorParty = guarantorParty;
	}

	public Party getBeneficiaryParty() {
		return beneficiaryParty;
	}

	public void setBeneficiaryParty(Party beneficiaryParty) {
		this.beneficiaryParty = beneficiaryParty;
	}

	public Period getApplicablePeriod() {
		return applicablePeriod;
	}

	public void setApplicablePeriod(Period applicablePeriod) {
		this.applicablePeriod = applicablePeriod;
	}

	public Regulation getApplicableRegulation() {
		return applicableRegulation;
	}

	public void setApplicableRegulation(Regulation applicableRegulation) {
		this.applicableRegulation = applicableRegulation;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}
}// end Guarantee Certificate