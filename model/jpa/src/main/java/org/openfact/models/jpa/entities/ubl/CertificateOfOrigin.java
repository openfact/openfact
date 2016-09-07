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
	private String customizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String description;
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
	/**
	 * Identifies the version of this Certificate of Origin.
	 */
	private String versionID;
	private List<CertificateOfOriginApplication> certificateOfOriginApplications= new ArrayList<>();
	private Endorsement issuerEndorsement;
	private Endorsement embassyEndorsement;
	private Endorsement insuranceEndorsement;
	private List<EndorserParty> endorserPartys= new ArrayList<>();
	private Party importerParty;
	private Party exporterParty;
	private List<Signature> signatures= new ArrayList<>();

	public CertificateOfOrigin() {

	}

	public void finalize() throws Throwable {

	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<CertificateOfOriginApplication> getCertificateOfOriginApplications() {
		return certificateOfOriginApplications;
	}

	public void setCertificateOfOriginApplications(List<CertificateOfOriginApplication> certificateOfOriginApplications) {
		this.certificateOfOriginApplications = certificateOfOriginApplications;
	}

	public Endorsement getIssuerEndorsement() {
		return issuerEndorsement;
	}

	public void setIssuerEndorsement(Endorsement issuerEndorsement) {
		this.issuerEndorsement = issuerEndorsement;
	}

	public Endorsement getEmbassyEndorsement() {
		return embassyEndorsement;
	}

	public void setEmbassyEndorsement(Endorsement embassyEndorsement) {
		this.embassyEndorsement = embassyEndorsement;
	}

	public Endorsement getInsuranceEndorsement() {
		return insuranceEndorsement;
	}

	public void setInsuranceEndorsement(Endorsement insuranceEndorsement) {
		this.insuranceEndorsement = insuranceEndorsement;
	}

	public List<EndorserParty> getEndorserPartys() {
		return endorserPartys;
	}

	public void setEndorserPartys(List<EndorserParty> endorserPartys) {
		this.endorserPartys = endorserPartys;
	}

	public Party getImporterParty() {
		return importerParty;
	}

	public void setImporterParty(Party importerParty) {
		this.importerParty = importerParty;
	}

	public Party getExporterParty() {
		return exporterParty;
	}

	public void setExporterParty(Party exporterParty) {
		this.exporterParty = exporterParty;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}
}// end Certificate Of Origin