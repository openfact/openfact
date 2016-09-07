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
	private String CertificateType;
	/**
	 * The type of this certificate, expressed as a code. The type specifies
	 * what array it belongs to, e.g.. Environmental, security, health
	 * improvement etc.
	 */
	private String CertificateTypeCode;
	/**
	 * An identifier for this certificate.
	 */
	private String ID;
	/**
	 * Remarks by the applicant for this certificate.
	 */
	private String Remarks;
	private DocumentReference m_DocumentReference;
	private Party IssuerParty;
	private Signature m_Signature;

	public Certificate() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the certificateType
	 */
	public String getCertificateType() {
		return CertificateType;
	}

	/**
	 * @param certificateType
	 *            the certificateType to set
	 */
	public void setCertificateType(String certificateType) {
		CertificateType = certificateType;
	}

	/**
	 * @return the certificateTypeCode
	 */
	public String getCertificateTypeCode() {
		return CertificateTypeCode;
	}

	/**
	 * @param certificateTypeCode
	 *            the certificateTypeCode to set
	 */
	public void setCertificateTypeCode(String certificateTypeCode) {
		CertificateTypeCode = certificateTypeCode;
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
	 * @return the m_DocumentReference
	 */
	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	/**
	 * @param m_DocumentReference
	 *            the m_DocumentReference to set
	 */
	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
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

}// end Certificate