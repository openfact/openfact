package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe an external object, such as a document stored at a remote
 * location.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:10 a. m.
 */
@Entity
@Table(name = "EXTERNAL_REFERENCE")
public class ExternalReferenceEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * A code signifying the character set of an external document.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CHARACTERSETCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "CHARACTERSETCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "CHARACTERSETCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "CHARACTERSETCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "CHARACTERSETCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "CHARACTERSETCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "CHARACTERSETCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "CHARACTERSETCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "CHARACTERSETCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "CHARACTERSETCODE_LISTSCHEMEURI")) })
	private CodeType characterSetCode;
	/**
	 * Text describing the external object.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DESCRIPTION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DESCRIPTION_LANGUAGEID")) })
	private TextType description;
	/**
	 * A hash value for the externally stored object.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DOCUMENTHASH_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DOCUMENTHASH_LANGUAGEID")) })
	private TextType documentHash;
	/**
	 * A code signifying the encoding/decoding algorithm used with the external
	 * object.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ENCODINGCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ENCODINGCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ENCODINGCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ENCODINGCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ENCODINGCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ENCODINGCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ENCODINGCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ENCODINGCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ENCODINGCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ENCODINGCODE_LISTSCHEMEURI")) })
	private CodeType encodingCode;
	/**
	 * The date on which availability of the resource can no longer be relied
	 * upon.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "EXPIRY_DATE")
	private LocalDate expiryDate;
	/**
	 * The time after which availability of the resource can no longer be relied
	 * upon.
	 */
	@Type(type = "org.hibernate.type.LocalTimeType")
	@Column(name = "EXPIRY_TIME")
	private LocalTime expiryTime;
	/**
	 * The file name of the external object.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "FILENAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "FILENAME_LANGUAGEID")) })
	private NameType fileName;
	/**
	 * A code signifying the format of the external object.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "FORMATCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "FORMATCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "FORMATCODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "FORMATCODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "FORMATCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "FORMATCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "FORMATCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "FORMATCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "FORMATCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "FORMATCODE_LISTSCHEMEURI")) })
	private CodeType formatCode;
	/**
	 * A hash algorithm used to calculate the hash value of the externally
	 * stored object.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "HASHALGORITHMMETHOD_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "HASHALGORITHMMETHOD_LANGUAGEID")) })
	private TextType hashAlgorithmMethod;
	/**
	 * A code signifying the mime type of the external object.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "MIMECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "MIMECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "MIMECODE_LISTAGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "MIMECODE_LISTAGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "MIMECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "MIMECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "MIMECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "MIMECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "MIMECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "MIMECODE_LISTSCHEMEURI")) })
	private CodeType mimeCode;
	/**
	 * The Uniform Resource Identifier (URI) that identifies the external object
	 * as an Internet resource.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "URIID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "URIID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "URIID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "URIID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "URIID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "URIID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "URIID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "URIID_SCHEMEURI")) })
	private IdentifierType URIID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "SIGNATURE_ID")
	private AttachmentEntity attachment;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the characterSetCode
	 */
	public CodeType getCharacterSetCode() {
		return characterSetCode;
	}

	/**
	 * @param characterSetCode
	 *            the characterSetCode to set
	 */
	public void setCharacterSetCode(CodeType characterSetCode) {
		this.characterSetCode = characterSetCode;
	}

	/**
	 * @return the description
	 */
	public TextType getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(TextType description) {
		this.description = description;
	}

	/**
	 * @return the documentHash
	 */
	public TextType getDocumentHash() {
		return documentHash;
	}

	/**
	 * @param documentHash
	 *            the documentHash to set
	 */
	public void setDocumentHash(TextType documentHash) {
		this.documentHash = documentHash;
	}

	/**
	 * @return the encodingCode
	 */
	public CodeType getEncodingCode() {
		return encodingCode;
	}

	/**
	 * @param encodingCode
	 *            the encodingCode to set
	 */
	public void setEncodingCode(CodeType encodingCode) {
		this.encodingCode = encodingCode;
	}

	/**
	 * @return the expiryDate
	 */
	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the expiryTime
	 */
	public LocalTime getExpiryTime() {
		return expiryTime;
	}

	/**
	 * @param expiryTime
	 *            the expiryTime to set
	 */
	public void setExpiryTime(LocalTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	/**
	 * @return the fileName
	 */
	public NameType getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(NameType fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the formatCode
	 */
	public CodeType getFormatCode() {
		return formatCode;
	}

	/**
	 * @param formatCode
	 *            the formatCode to set
	 */
	public void setFormatCode(CodeType formatCode) {
		this.formatCode = formatCode;
	}

	/**
	 * @return the hashAlgorithmMethod
	 */
	public TextType getHashAlgorithmMethod() {
		return hashAlgorithmMethod;
	}

	/**
	 * @param hashAlgorithmMethod
	 *            the hashAlgorithmMethod to set
	 */
	public void setHashAlgorithmMethod(TextType hashAlgorithmMethod) {
		this.hashAlgorithmMethod = hashAlgorithmMethod;
	}

	/**
	 * @return the mimeCode
	 */
	public CodeType getMimeCode() {
		return mimeCode;
	}

	/**
	 * @param mimeCode
	 *            the mimeCode to set
	 */
	public void setMimeCode(CodeType mimeCode) {
		this.mimeCode = mimeCode;
	}

	/**
	 * @return the uRIID
	 */
	public IdentifierType getURIID() {
		return URIID;
	}

	/**
	 * @param uRIID
	 *            the uRIID to set
	 */
	public void setURIID(IdentifierType uRIID) {
		URIID = uRIID;
	}

	/**
	 * @return the attachment
	 */
	public AttachmentEntity getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment
	 *            the attachment to set
	 */
	public void setAttachment(AttachmentEntity attachment) {
		this.attachment = attachment;
	}

}
