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
	private String applicationStatusCode;
	/**
	 * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
	 * Preferential, etc.).
	 */
	private String certificateType;
	/**
	 * The latest job number given to the CoO application. This is used by the
	 * system to keep track of amendments to or cancellation of any earlier
	 * applications.
	 */
	private String originalJobID;
	/**
	 * An identifier for the previous job used in case the application requires
	 * query or change.
	 */
	private String previousJobID;
	/**
	 * An identifier for a reference as part of the CoO application.
	 */
	private String referenceID;
	/**
	 * Remarks by the applicant for the CoO.
	 */
	private String remarks;
	private List<DocumentDistribution> documentDistributions= new ArrayList<>();
	private DocumentReference supportingDocumentReference;
	private List<EndorserParty> endorserPartys= new ArrayList<>();
	private Party preparationParty;
	private Party exporterParty;
	private Party issuerParty;
	private Party importerParty;
	private List<Shipment> shipments= new ArrayList<>();
	private List<Signature> signatures= new ArrayList<>();
	private Country issuingCountry;

	public CertificateOfOriginApplication() {

	}

	public void finalize() throws Throwable {

	}

	public String getApplicationStatusCode() {
		return applicationStatusCode;
	}

	public void setApplicationStatusCode(String applicationStatusCode) {
		this.applicationStatusCode = applicationStatusCode;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getOriginalJobID() {
		return originalJobID;
	}

	public void setOriginalJobID(String originalJobID) {
		this.originalJobID = originalJobID;
	}

	public String getPreviousJobID() {
		return previousJobID;
	}

	public void setPreviousJobID(String previousJobID) {
		this.previousJobID = previousJobID;
	}

	public String getReferenceID() {
		return referenceID;
	}

	public void setReferenceID(String referenceID) {
		this.referenceID = referenceID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<DocumentDistribution> getDocumentDistributions() {
		return documentDistributions;
	}

	public void setDocumentDistributions(List<DocumentDistribution> documentDistributions) {
		this.documentDistributions = documentDistributions;
	}

	public DocumentReference getSupportingDocumentReference() {
		return supportingDocumentReference;
	}

	public void setSupportingDocumentReference(DocumentReference supportingDocumentReference) {
		this.supportingDocumentReference = supportingDocumentReference;
	}

	public List<EndorserParty> getEndorserPartys() {
		return endorserPartys;
	}

	public void setEndorserPartys(List<EndorserParty> endorserPartys) {
		this.endorserPartys = endorserPartys;
	}

	public Party getPreparationParty() {
		return preparationParty;
	}

	public void setPreparationParty(Party preparationParty) {
		this.preparationParty = preparationParty;
	}

	public Party getExporterParty() {
		return exporterParty;
	}

	public void setExporterParty(Party exporterParty) {
		this.exporterParty = exporterParty;
	}

	public Party getIssuerParty() {
		return issuerParty;
	}

	public void setIssuerParty(Party issuerParty) {
		this.issuerParty = issuerParty;
	}

	public Party getImporterParty() {
		return importerParty;
	}

	public void setImporterParty(Party importerParty) {
		this.importerParty = importerParty;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}

	public Country getIssuingCountry() {
		return issuingCountry;
	}

	public void setIssuingCountry(Country issuingCountry) {
		this.issuingCountry = issuingCountry;
	}
}// end Certificate Of Origin Application