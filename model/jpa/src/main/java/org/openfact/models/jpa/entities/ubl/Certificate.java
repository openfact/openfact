package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define a certificate applied to the item. Certificated can be a
 * requirement to sell goods or services in a jurisdiction.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:28 a. m.
 */
public class Certificate {

	/**
	 * The type of this certificate, expressed as a code. The type specifies
	 * what array it belongs to, e.g.. Environmental, security, health
	 * improvement etc.
	 */
	private String certificateType;
	/**
	 * The type of this certificate, expressed as a code. The type specifies
	 * what array it belongs to, e.g.. Environmental, security, health
	 * improvement etc.
	 */
	private String certificateTypeCode;
	/**
	 * An identifier for this certificate.
	 */
	private String ID;
	/**
	 * Remarks by the applicant for this certificate.
	 */
	private String remarks;
	private List<DocumentReference> documentReferences= new ArrayList<>();
	private Party issuerParty;
	private List<Signature> signatures= new ArrayList<>();

	public Certificate() {

	}

	public void finalize() throws Throwable {

	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateTypeCode() {
		return certificateTypeCode;
	}

	public void setCertificateTypeCode(String certificateTypeCode) {
		this.certificateTypeCode = certificateTypeCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public Party getIssuerParty() {
		return issuerParty;
	}

	public void setIssuerParty(Party issuerParty) {
		this.issuerParty = issuerParty;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}
}// end Certificate