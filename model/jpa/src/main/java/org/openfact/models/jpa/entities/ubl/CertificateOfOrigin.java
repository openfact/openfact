package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document that describes the Certificate of Origin.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:56 a. m.
 */
public class CertificateOfOrigin {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String Description;
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
	 * Identifies the version of this Certificate of Origin.
	 */
	private String VersionID;
	private CertificateOfOriginApplication m_CertificateOfOriginApplication;
	private Endorsement IssuerEndorsement;
	private Endorsement EmbassyEndorsement;
	private Endorsement InsuranceEndorsement;
	private EndorserParty m_EndorserParty;
	private Party ImporterParty;
	private Party ExporterParty;
	private List<Signature> signatures = new ArrayList<>();

	public CertificateOfOrigin() {

	}

	public void finalize() throws Throwable {

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
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		Description = description;
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
	 * @return the versionID
	 */
	public String getVersionID() {
		return VersionID;
	}

	/**
	 * @param versionID
	 *            the versionID to set
	 */
	public void setVersionID(String versionID) {
		VersionID = versionID;
	}

	/**
	 * @return the m_CertificateOfOriginApplication
	 */
	public CertificateOfOriginApplication getM_CertificateOfOriginApplication() {
		return m_CertificateOfOriginApplication;
	}

	/**
	 * @param m_CertificateOfOriginApplication
	 *            the m_CertificateOfOriginApplication to set
	 */
	public void setM_CertificateOfOriginApplication(CertificateOfOriginApplication m_CertificateOfOriginApplication) {
		this.m_CertificateOfOriginApplication = m_CertificateOfOriginApplication;
	}

	/**
	 * @return the issuerEndorsement
	 */
	public Endorsement getIssuerEndorsement() {
		return IssuerEndorsement;
	}

	/**
	 * @param issuerEndorsement
	 *            the issuerEndorsement to set
	 */
	public void setIssuerEndorsement(Endorsement issuerEndorsement) {
		IssuerEndorsement = issuerEndorsement;
	}

	/**
	 * @return the embassyEndorsement
	 */
	public Endorsement getEmbassyEndorsement() {
		return EmbassyEndorsement;
	}

	/**
	 * @param embassyEndorsement
	 *            the embassyEndorsement to set
	 */
	public void setEmbassyEndorsement(Endorsement embassyEndorsement) {
		EmbassyEndorsement = embassyEndorsement;
	}

	/**
	 * @return the insuranceEndorsement
	 */
	public Endorsement getInsuranceEndorsement() {
		return InsuranceEndorsement;
	}

	/**
	 * @param insuranceEndorsement
	 *            the insuranceEndorsement to set
	 */
	public void setInsuranceEndorsement(Endorsement insuranceEndorsement) {
		InsuranceEndorsement = insuranceEndorsement;
	}

	/**
	 * @return the m_EndorserParty
	 */
	public EndorserParty getM_EndorserParty() {
		return m_EndorserParty;
	}

	/**
	 * @param m_EndorserParty
	 *            the m_EndorserParty to set
	 */
	public void setM_EndorserParty(EndorserParty m_EndorserParty) {
		this.m_EndorserParty = m_EndorserParty;
	}

	/**
	 * @return the importerParty
	 */
	public Party getImporterParty() {
		return ImporterParty;
	}

	/**
	 * @param importerParty
	 *            the importerParty to set
	 */
	public void setImporterParty(Party importerParty) {
		ImporterParty = importerParty;
	}

	/**
	 * @return the exporterParty
	 */
	public Party getExporterParty() {
		return ExporterParty;
	}

	/**
	 * @param exporterParty
	 *            the exporterParty to set
	 */
	public void setExporterParty(Party exporterParty) {
		ExporterParty = exporterParty;
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

}// end Certificate Of Origin