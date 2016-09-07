package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to define a reference to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
public class DocumentReference {

	/**
	 * An indicator that the referenced document is a copy (true) or the
	 * original (false).
	 */
	private boolean copyIndicator;
	/**
	 * Text describing the referenced document.
	 */
	private String documentDescription;
	/**
	 * A code signifying the status of the reference document with respect to
	 * its original state.
	 */
	private String documentStatusCode;
	/**
	 * The type of document being referenced, expressed as text.
	 */
	private String documentType;
	/**
	 * The type of document being referenced, expressed as a code.
	 */
	private String documentTypeCode;
	/**
	 * An identifier for the referenced document.
	 */
	private String id;
	/**
	 * The date, assigned by the sender of the referenced document, on which the
	 * document was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender of the referenced document, at which the
	 * document was issued.
	 */
	private LocalTime issueTime;
	/**
	 * An identifier for the language used in the referenced document.
	 */
	private String languageID;
	/**
	 * A code signifying the locale in which the language in the referenced
	 * document is used.
	 */
	private String localeCode;
	/**
	 * A universally unique identifier for this document reference.
	 */
	private String UUID;
	/**
	 * An identifier for the current version of the referenced document.
	 */
	private String versionID;
	/**
	 * A reference to another place in the same XML document instance in which
	 * DocumentReference appears.
	 */
	private String xPath;
	private List<Attachment> attachments=new ArrayList<>();
	private Party issuerParty;
	private Period validityPeriod;
	private List<ResultOfVerification> resultOfVerifications=new ArrayList<>();

	public boolean isCopyIndicator() {
		return copyIndicator;
	}

	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}

	public String getDocumentDescription() {
		return documentDescription;
	}

	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}

	public String getDocumentStatusCode() {
		return documentStatusCode;
	}

	public void setDocumentStatusCode(String documentStatusCode) {
		this.documentStatusCode = documentStatusCode;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentTypeCode() {
		return documentTypeCode;
	}

	public void setDocumentTypeCode(String documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
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

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
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

	public String getxPath() {
		return xPath;
	}

	public void setxPath(String xPath) {
		this.xPath = xPath;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Party getIssuerParty() {
		return issuerParty;
	}

	public void setIssuerParty(Party issuerParty) {
		this.issuerParty = issuerParty;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public List<ResultOfVerification> getResultOfVerifications() {
		return resultOfVerifications;
	}

	public void setResultOfVerifications(List<ResultOfVerification> resultOfVerifications) {
		this.resultOfVerifications = resultOfVerifications;
	}
}// end DocumentReference