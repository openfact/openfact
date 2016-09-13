package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.DocumentStatusCodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a reference to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:35 a. m.
 */
@Entity
@Table(name = "DOCUMENT_REFERENCE")
public class DocumentReferenceEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An indicator that the referenced document is a copy (true) or the
	 * original (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "COPY_INDICATOR")
	private boolean copyIndicator;
	/**
	 * Text describing the referenced document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DOCUMENTDESCRIPTION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DOCUMENTDESCRIPTION_ID")) })
	private TextType documentDescription;
	/**
	 * A code signifying the status of the reference document with respect to
	 * its original state.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DOCUMENTSTATUSCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "DOCUMENTSTATUSCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "DOCUMENTSTATUSCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "DOCUMENTSTATUSCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "DOCUMENTSTATUSCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "DOCUMENTSTATUSCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "DOCUMENTSTATUSCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DOCUMENTSTATUSCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "DOCUMENTSTATUSCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "DOCUMENTSTATUSCODE_SCHEMEURI")) })
	private DocumentStatusCodeType documentStatusCode;
	/**
	 * The type of document being referenced, expressed as text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DOCUMENTTYPE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DOCUMENTTYPE_ID")) })
	private TextType documentType;
	/**
	 * The type of document being referenced, expressed as a code.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DOCUMENTTYPECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "DOCUMENTTYPECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "DOCUMENTTYPECODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "DOCUMENTTYPECODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "DOCUMENTTYPECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "DOCUMENTTYPECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "DOCUMENTTYPECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DOCUMENTTYPECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "DOCUMENTTYPECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "DOCUMENTTYPECODE_SCHEMEURI")) })
	private CodeType documentTypeCode;
	/**
	 * An identifier for the referenced document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender of the referenced document, on which the
	 * document was issued.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "ISSUE_DATE")
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender of the referenced document, at which the
	 * document was issued.
	 */
	@Type(type = "org.hibernate.type.LocalTimeType")
	@Column(name = "ISSUE_TIME")
	private LocalTime issueTime;
	/**
	 * An identifier for the language used in the referenced document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "LANGUAGEID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "LANGUAGEID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "LANGUAGEID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "LANGUAGEID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "LANGUAGEID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "LANGUAGEID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "LANGUAGEID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "LANGUAGEID_SCHEMEURI")) })
	private IdentifierType languageID;
	/**
	 * A code signifying the locale in which the language in the referenced
	 * document is used.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "LOCALECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "LOCALECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "LOCALECODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "LOCALECODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "LOCALECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "LOCALECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "LOCALECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "LOCALECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "LOCALECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "LOCALECODE_SCHEMEURI")) })
	private CodeType localeCode;
	/**
	 * A universally unique identifier for this document reference.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "UUID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "UUID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "UUID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "UUID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "UUID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "UUID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "UUID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "UUID_SCHEMEURI")) })
	private IdentifierType UUID;
	/**
	 * An identifier for the current version of the referenced document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "VERSIONID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "VERSIONID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "VERSIONID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "VERSIONID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "VERSIONID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "VERSIONID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "VERSIONID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "VERSIONID_SCHEMEURI")) })
	private IdentifierType versionID;
	/**
	 * A reference to another place in the same XML document instance in which
	 * DocumentReferenceEntity appears.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "XPATH_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "XPATH_ID")) })
	private TextType XPath;
	@Transient
	private List<AttachmentEntity> attachments = new ArrayList<>();
	@Transient
	private PartyEntity issuerParty;
	@Transient
	private PeriodEntity validityPeriod;
	@Transient
	private List<ResultOfVerificationEntity> resultOfVerifications = new ArrayList<>();
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the copyIndicator
	 */
	public boolean isCopyIndicator() {
		return copyIndicator;
	}
	/**
	 * @param copyIndicator the copyIndicator to set
	 */
	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}
	/**
	 * @return the documentDescription
	 */
	public TextType getDocumentDescription() {
		return documentDescription;
	}
	/**
	 * @param documentDescription the documentDescription to set
	 */
	public void setDocumentDescription(TextType documentDescription) {
		this.documentDescription = documentDescription;
	}
	/**
	 * @return the documentStatusCode
	 */
	public DocumentStatusCodeType getDocumentStatusCode() {
		return documentStatusCode;
	}
	/**
	 * @param documentStatusCode the documentStatusCode to set
	 */
	public void setDocumentStatusCode(DocumentStatusCodeType documentStatusCode) {
		this.documentStatusCode = documentStatusCode;
	}
	/**
	 * @return the documentType
	 */
	public TextType getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(TextType documentType) {
		this.documentType = documentType;
	}
	/**
	 * @return the documentTypeCode
	 */
	public CodeType getDocumentTypeCode() {
		return documentTypeCode;
	}
	/**
	 * @param documentTypeCode the documentTypeCode to set
	 */
	public void setDocumentTypeCode(CodeType documentTypeCode) {
		this.documentTypeCode = documentTypeCode;
	}
	/**
	 * @return the iD
	 */
	public IdentifierType getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(IdentifierType iD) {
		ID = iD;
	}
	/**
	 * @return the issueDate
	 */
	public LocalDate getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * @return the issueTime
	 */
	public LocalTime getIssueTime() {
		return issueTime;
	}
	/**
	 * @param issueTime the issueTime to set
	 */
	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}
	/**
	 * @return the languageID
	 */
	public IdentifierType getLanguageID() {
		return languageID;
	}
	/**
	 * @param languageID the languageID to set
	 */
	public void setLanguageID(IdentifierType languageID) {
		this.languageID = languageID;
	}
	/**
	 * @return the localeCode
	 */
	public CodeType getLocaleCode() {
		return localeCode;
	}
	/**
	 * @param localeCode the localeCode to set
	 */
	public void setLocaleCode(CodeType localeCode) {
		this.localeCode = localeCode;
	}
	/**
	 * @return the uUID
	 */
	public IdentifierType getUUID() {
		return UUID;
	}
	/**
	 * @param uUID the uUID to set
	 */
	public void setUUID(IdentifierType uUID) {
		UUID = uUID;
	}
	/**
	 * @return the versionID
	 */
	public IdentifierType getVersionID() {
		return versionID;
	}
	/**
	 * @param versionID the versionID to set
	 */
	public void setVersionID(IdentifierType versionID) {
		this.versionID = versionID;
	}
	/**
	 * @return the xPath
	 */
	public TextType getXPath() {
		return XPath;
	}
	/**
	 * @param xPath the xPath to set
	 */
	public void setXPath(TextType xPath) {
		XPath = xPath;
	}
	/**
	 * @return the attachments
	 */
	public List<AttachmentEntity> getAttachments() {
		return attachments;
	}
	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List<AttachmentEntity> attachments) {
		this.attachments = attachments;
	}
	/**
	 * @return the issuerParty
	 */
	public PartyEntity getIssuerParty() {
		return issuerParty;
	}
	/**
	 * @param issuerParty the issuerParty to set
	 */
	public void setIssuerParty(PartyEntity issuerParty) {
		this.issuerParty = issuerParty;
	}
	/**
	 * @return the validityPeriod
	 */
	public PeriodEntity getValidityPeriod() {
		return validityPeriod;
	}
	/**
	 * @param validityPeriod the validityPeriod to set
	 */
	public void setValidityPeriod(PeriodEntity validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	/**
	 * @return the resultOfVerifications
	 */
	public List<ResultOfVerificationEntity> getResultOfVerifications() {
		return resultOfVerifications;
	}
	/**
	 * @param resultOfVerifications the resultOfVerifications to set
	 */
	public void setResultOfVerifications(List<ResultOfVerificationEntity> resultOfVerifications) {
		this.resultOfVerifications = resultOfVerifications;
	}
	

}
