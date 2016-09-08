package org.openfact.models.jpa.entities.ubl;

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
	private String description;
	/**
	 * An identifier for a specific catalogue.
	 */
	private String ID;
	/**
	 * The date on which the catalogue was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time at which the catalogue was issued.
	 */
	private LocalTime issueTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * An identifier for the previous version of the catalogue that is
	 * superseded by this version.
	 */
	private String previousVersionID;
	/**
	 * The date on which the information in the catalogue was last revised.
	 */
	private LocalDate revisionDate;
	/**
	 * The time at which the information in the catalogue was last revised.
	 */
	private LocalTime revisionTime;
	/**
	 * A universally unique identifier for a specific catalogue.
	 */
	private String UUID;
	/**
	 * An identifier for the current version of the catalogue.
	 */
	private String versionID;

	public CatalogueReference() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPreviousVersionID() {
		return previousVersionID;
	}

	public void setPreviousVersionID(String previousVersionID) {
		this.previousVersionID = previousVersionID;
	}

	public LocalDate getRevisionDate() {
		return revisionDate;
	}

	public void setRevisionDate(LocalDate revisionDate) {
		this.revisionDate = revisionDate;
	}

	public LocalTime getRevisionTime() {
		return revisionTime;
	}

	public void setRevisionTime(LocalTime revisionTime) {
		this.revisionTime = revisionTime;
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
}// end Catalogue Reference