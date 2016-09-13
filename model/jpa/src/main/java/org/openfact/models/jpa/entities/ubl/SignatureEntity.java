package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a signature.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:47 a. m.
 */
@Entity
@Table(name = "SIGNATURE")
public class SignatureEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * The method used to perform XML canonicalization of this signature.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CANONICALIZATIONMETHOD_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "CANONICALIZATIONMETHOD_LANGUAGEID")) })
	private TextType canonicalizationMethod;
	/**
	 * An identifier for this signature.
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
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures; in particular, information regarding the circumstances
	 * in which the signature is being used.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "NOTE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "NOTE_LANGUAGEID")) })
	private TextType note;
	/**
	 * Text describing the method of signature.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "SIGNATUREMETHOD_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "SIGNATUREMETHOD_LANGUAGEID")) })
	private TextType signatureMethod;
	/**
	 * The date upon which this signature was verified.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "VALIDATION_DATE")
	private LocalDate validationDate;
	/**
	 * The time at which this signature was verified.
	 */
	@Type(type = "org.hibernate.type.LocalTimeType")
	@Column(name = "VALIDATION_TIME")
	private LocalTime validationTime;
	/**
	 * An identifier for the organization, person, service, or server that
	 * verified this signature.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "VALIDATORID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "VALIDATORID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "VALIDATORID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "VALIDATORID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "VALIDATORID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "VALIDATORID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "VALIDATORID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "VALIDATORID_SCHEMEURI")) })
	private IdentifierType validatorID;

	@OneToOne(mappedBy = "signature", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private AttachmentEntity digitalSignatureAttachment;

	@Transient
	private DocumentReferenceEntity originalDocumentReference;

	@OneToOne(mappedBy = "signature", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private SignaturePartyMappingEntity signatoryParty;

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
	 * @return the canonicalizationMethod
	 */
	public TextType getCanonicalizationMethod() {
		return canonicalizationMethod;
	}

	/**
	 * @param canonicalizationMethod
	 *            the canonicalizationMethod to set
	 */
	public void setCanonicalizationMethod(TextType canonicalizationMethod) {
		this.canonicalizationMethod = canonicalizationMethod;
	}

	/**
	 * @return the iD
	 */
	public IdentifierType getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(IdentifierType iD) {
		ID = iD;
	}

	/**
	 * @return the note
	 */
	public TextType getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(TextType note) {
		this.note = note;
	}

	/**
	 * @return the signatureMethod
	 */
	public TextType getSignatureMethod() {
		return signatureMethod;
	}

	/**
	 * @param signatureMethod
	 *            the signatureMethod to set
	 */
	public void setSignatureMethod(TextType signatureMethod) {
		this.signatureMethod = signatureMethod;
	}

	/**
	 * @return the validationDate
	 */
	public LocalDate getValidationDate() {
		return validationDate;
	}

	/**
	 * @param validationDate
	 *            the validationDate to set
	 */
	public void setValidationDate(LocalDate validationDate) {
		this.validationDate = validationDate;
	}

	/**
	 * @return the validationTime
	 */
	public LocalTime getValidationTime() {
		return validationTime;
	}

	/**
	 * @param validationTime
	 *            the validationTime to set
	 */
	public void setValidationTime(LocalTime validationTime) {
		this.validationTime = validationTime;
	}

	/**
	 * @return the validatorID
	 */
	public IdentifierType getValidatorID() {
		return validatorID;
	}

	/**
	 * @param validatorID
	 *            the validatorID to set
	 */
	public void setValidatorID(IdentifierType validatorID) {
		this.validatorID = validatorID;
	}

	/**
	 * @return the digitalSignatureAttachment
	 */
	public AttachmentEntity getDigitalSignatureAttachment() {
		return digitalSignatureAttachment;
	}

	/**
	 * @param digitalSignatureAttachment
	 *            the digitalSignatureAttachment to set
	 */
	public void setDigitalSignatureAttachment(AttachmentEntity digitalSignatureAttachment) {
		this.digitalSignatureAttachment = digitalSignatureAttachment;
	}

	/**
	 * @return the originalDocumentReference
	 */
	public DocumentReferenceEntity getOriginalDocumentReference() {
		return originalDocumentReference;
	}

	/**
	 * @param originalDocumentReference
	 *            the originalDocumentReference to set
	 */
	public void setOriginalDocumentReference(DocumentReferenceEntity originalDocumentReference) {
		this.originalDocumentReference = originalDocumentReference;
	}

	/**
	 * @return the signatoryParty
	 */
	public SignaturePartyMappingEntity getSignatoryParty() {
		return signatoryParty;
	}

	/**
	 * @param signatoryParty
	 *            the signatoryParty to set
	 */
	public void setSignatoryParty(SignaturePartyMappingEntity signatoryParty) {
		this.signatoryParty = signatoryParty;
	}

}
