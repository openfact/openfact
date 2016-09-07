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
	private String Description;
	/**
	 * An identifier for a specific catalogue.
	 */
	private String ID;
	/**
	 * The date on which the catalogue was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time at which the catalogue was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * An identifier for the previous version of the catalogue that is
	 * superseded by this version.
	 */
	private String PreviousVersionID;
	/**
	 * The date on which the information in the catalogue was last revised.
	 */
	private LocalDate RevisionDate;
	/**
	 * The time at which the information in the catalogue was last revised.
	 */
	private LocalTime RevisionTime;
	/**
	 * A universally unique identifier for a specific catalogue.
	 */
	private String UUID;
	/**
	 * An identifier for the current version of the catalogue.
	 */
	private String VersionID;

	public CatalogueReference() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return Description;
	}

	public String getID() {
		return ID;
	}

	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public LocalTime getIssueTime() {
		return IssueTime;
	}

	public String getNote() {
		return Note;
	}

	public String getPreviousVersionID() {
		return PreviousVersionID;
	}

	public LocalDate getRevisionDate() {
		return RevisionDate;
	}

	public LocalTime getRevisionTime() {
		return RevisionTime;
	}

	public String getUUID() {
		return UUID;
	}

	public String getVersionID() {
		return VersionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal) {
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal) {
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal) {
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousVersionID(String newVal) {
		PreviousVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRevisionDate(LocalDate newVal) {
		RevisionDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRevisionTime(LocalTime newVal) {
		RevisionTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal) {
		UUID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(String newVal) {
		VersionID = newVal;
	}
}// end Catalogue Reference