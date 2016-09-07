package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define an application for a Certificate of Origin (CoO).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplication {

	/**
	 * A code signifying the status of the application (revision, replacement,
	 * etc.).
	 */
	private String ApplicationStatusCode;
	/**
	 * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
	 * Preferential, etc.).
	 */
	private String CertificateType;
	/**
	 * The latest job number given to the CoO application. This is used by the
	 * system to keep track of amendments to or cancellation of any earlier
	 * applications.
	 */
	private String OriginalJobID;
	/**
	 * An identifier for the previous job used in case the application requires
	 * query or change.
	 */
	private String PreviousJobID;
	/**
	 * An identifier for a reference as part of the CoO application.
	 */
	private String ReferenceID;
	/**
	 * Remarks by the applicant for the CoO.
	 */
	private String Remarks;
	private DocumentDistribution m_DocumentDistribution;
	private DocumentReference SupportingDocumentReference;
	private EndorserParty m_EndorserParty;
	private Party PreparationParty;
	private Party ExporterParty;
	private Party IssuerParty;
	private Party ImporterParty;
	private Shipment m_Shipment;
	private Signature m_Signature;
	private Country IssuingCountry;

	public CertificateOfOriginApplication() {

	}

	public void finalize() throws Throwable {

	}

	public String getApplicationStatusCode() {
		return ApplicationStatusCode;
	}

	public String getCertificateType() {
		return CertificateType;
	}

	/**
	 * @return the originalJobID
	 */
	public String getOriginalJobID() {
		return OriginalJobID;
	}

	/**
	 * @param originalJobID
	 *            the originalJobID to set
	 */
	public void setOriginalJobID(String originalJobID) {
		OriginalJobID = originalJobID;
	}

	/**
	 * @return the previousJobID
	 */
	public String getPreviousJobID() {
		return PreviousJobID;
	}

	/**
	 * @param previousJobID
	 *            the previousJobID to set
	 */
	public void setPreviousJobID(String previousJobID) {
		PreviousJobID = previousJobID;
	}

	/**
	 * @return the referenceID
	 */
	public String getReferenceID() {
		return ReferenceID;
	}

	/**
	 * @param referenceID
	 *            the referenceID to set
	 */
	public void setReferenceID(String referenceID) {
		ReferenceID = referenceID;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return Remarks;
	}

	/**
	 * @param remarks
	 *            the remarks to set
	 */
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	/**
	 * @return the m_DocumentDistribution
	 */
	public DocumentDistribution getM_DocumentDistribution() {
		return m_DocumentDistribution;
	}

	/**
	 * @param m_DocumentDistribution
	 *            the m_DocumentDistribution to set
	 */
	public void setM_DocumentDistribution(DocumentDistribution m_DocumentDistribution) {
		this.m_DocumentDistribution = m_DocumentDistribution;
	}

	/**
	 * @return the supportingDocumentReference
	 */
	public DocumentReference getSupportingDocumentReference() {
		return SupportingDocumentReference;
	}

	/**
	 * @param supportingDocumentReference
	 *            the supportingDocumentReference to set
	 */
	public void setSupportingDocumentReference(DocumentReference supportingDocumentReference) {
		SupportingDocumentReference = supportingDocumentReference;
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
	 * @return the preparationParty
	 */
	public Party getPreparationParty() {
		return PreparationParty;
	}

	/**
	 * @param preparationParty
	 *            the preparationParty to set
	 */
	public void setPreparationParty(Party preparationParty) {
		PreparationParty = preparationParty;
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
	 * @return the issuerParty
	 */
	public Party getIssuerParty() {
		return IssuerParty;
	}

	/**
	 * @param issuerParty
	 *            the issuerParty to set
	 */
	public void setIssuerParty(Party issuerParty) {
		IssuerParty = issuerParty;
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
	 * @return the m_Shipment
	 */
	public Shipment getM_Shipment() {
		return m_Shipment;
	}

	/**
	 * @param m_Shipment
	 *            the m_Shipment to set
	 */
	public void setM_Shipment(Shipment m_Shipment) {
		this.m_Shipment = m_Shipment;
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
	 * @return the issuingCountry
	 */
	public Country getIssuingCountry() {
		return IssuingCountry;
	}

	/**
	 * @param issuingCountry
	 *            the issuingCountry to set
	 */
	public void setIssuingCountry(Country issuingCountry) {
		IssuingCountry = issuingCountry;
	}

	/**
	 * @param applicationStatusCode
	 *            the applicationStatusCode to set
	 */
	public void setApplicationStatusCode(String applicationStatusCode) {
		ApplicationStatusCode = applicationStatusCode;
	}

	/**
	 * @param certificateType
	 *            the certificateType to set
	 */
	public void setCertificateType(String certificateType) {
		CertificateType = certificateType;
	}

}// end Certificate Of Origin Application