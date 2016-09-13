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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe an application-level response to a document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:32 a. m.
 */
@Entity
@Table(name = "RESPONSE")
public class ResponseEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;

	/**
	 * Text describing this response.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DESCRIPTION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DESCRIPTION_LANGUAGE")) })
	private TextType description;
	/**
	 * The date upon which this response is valid.
	 */
	@Type(type = "org.hibernate.type.LocalDateType")
	@Column(name = "EFFECTIVE_DATE")
	private LocalDate effectiveDate;
	/**
	 * The time at which this response is valid.
	 */
	@Type(type = "org.hibernate.type.LocalTimeType")
	@Column(name = "EFFECTIVE_TIME")
	private LocalTime effectiveTime;
	/**
	 * An identifier for the section (or line) of the document to which this
	 * response applies.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "REFERENCEID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "REFERENCEID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "REFERENCEID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "REFERENCEID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "REFERENCEID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "REFERENCEID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "REFERENCEID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "REFERENCEID_SCHEMEURI")) })
	private IdentifierType referenceID;
	/**
	 * A code signifying the type of response.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "RESPONSECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "RESPONSECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "RESPONSECODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "RESPONSECODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "RESPONSECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "RESPONSECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "RESPONSECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "RESPONSECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "RESPONSECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "RESPONSECODE_SCHEMEURI")) })
	private CodeType responseCode;

	@Transient
	private List<StatusEntity> statuses = new ArrayList<>();

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDIT_NOTE_ID")
	private CreditNoteEntity creditNote;

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
	 * @return the description
	 */
	public TextType getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(TextType description) {
		this.description = description;
	}

	/**
	 * @return the effectiveDate
	 */
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the effectiveTime
	 */
	public LocalTime getEffectiveTime() {
		return effectiveTime;
	}

	/**
	 * @param effectiveTime the effectiveTime to set
	 */
	public void setEffectiveTime(LocalTime effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	/**
	 * @return the referenceID
	 */
	public IdentifierType getReferenceID() {
		return referenceID;
	}

	/**
	 * @param referenceID the referenceID to set
	 */
	public void setReferenceID(IdentifierType referenceID) {
		this.referenceID = referenceID;
	}

	/**
	 * @return the responseCode
	 */
	public CodeType getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(CodeType responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the statuses
	 */
	public List<StatusEntity> getStatuses() {
		return statuses;
	}

	/**
	 * @param statuses the statuses to set
	 */
	public void setStatuses(List<StatusEntity> statuses) {
		this.statuses = statuses;
	}

	/**
	 * @return the creditNote
	 */
	public CreditNoteEntity getCreditNote() {
		return creditNote;
	}

	/**
	 * @param creditNote the creditNote to set
	 */
	public void setCreditNote(CreditNoteEntity creditNote) {
		this.creditNote = creditNote;
	}
	
		
}
