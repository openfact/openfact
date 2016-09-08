package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to define a reference to a catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:23 a. m.
 */
public class CatalogueReference {

	/**
	 * Text describing the catalogue.
	 */
	private TextType description;
	/**
	 * An identifier for a specific catalogue.
	 */
	private IdentifierType id;
	/**
	 * The date on which the catalogue was issued.
	 */
	private DateType issueDate;
	/**
	 * The time at which the catalogue was issued.
	 */
	private TimeType issueTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private TextType note;
	/**
	 * An identifier for the previous version of the catalogue that is
	 * superseded by this version.
	 */
	private IdentifierType previousVersionID;
	/**
	 * The date on which the information in the catalogue was last revised.
	 */
	private DateType revisionDate;
	/**
	 * The time at which the information in the catalogue was last revised.
	 */
	private TimeType revisionTime;
	/**
	 * A universally unique identifier for a specific catalogue.
	 */
	private IdentifierType UUID;
	/**
	 * An identifier for the current version of the catalogue.
	 */
	private IdentifierType versionID;

	public CatalogueReference() {

	}

	public void finalize() throws Throwable {

	}

	public TextType getDescription() {
		return description;
	}

	public void setDescription(TextType description) {
		this.description = description;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public DateType getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(DateType issueDate) {
		this.issueDate = issueDate;
	}

	public TimeType getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(TimeType issueTime) {
		this.issueTime = issueTime;
	}

	public TextType getNote() {
		return note;
	}

	public void setNote(TextType note) {
		this.note = note;
	}

	public IdentifierType getPreviousVersionID() {
		return previousVersionID;
	}

	public void setPreviousVersionID(IdentifierType previousVersionID) {
		this.previousVersionID = previousVersionID;
	}

	public DateType getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(DateType revisionDate) {
		this.revisionDate = revisionDate;
	}

	public TimeType getRevisionTime() {
		return revisionTime;
	}

	public void setRevisionTime(TimeType revisionTime) {
		this.revisionTime = revisionTime;
	}

	public IdentifierType getUUID() {
		return UUID;
	}

	public void setUUID(IdentifierType UUID) {
		this.UUID = UUID;
	}

	public IdentifierType getVersionID() {
		return versionID;
	}

	public void setVersionID(IdentifierType versionID) {
		this.versionID = versionID;
	}
}// end Catalogue Reference