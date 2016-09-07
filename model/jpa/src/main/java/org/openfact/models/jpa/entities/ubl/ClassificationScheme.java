package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to define a classification scheme, such as a taxonomy for classifying
 * goods or services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:33 a. m.
 */
public class ClassificationScheme {

	/**
	 * An identifier for the agency that maintains this classification scheme.
	 */
	private String AgencyID;
	/**
	 * The name of the agency that maintains the classification scheme.
	 */
	private String AgencyName;
	/**
	 * Text describing this classification scheme.
	 */
	private String Description;
	/**
	 * An identifier for this classification scheme.
	 */
	private String ID;
	/**
	 * An identifier for the language of this classification scheme.
	 */
	private String LanguageID;
	/**
	 * The date on which this classification scheme was last revised.
	 */
	private LocalDate LastRevisionDate;
	/**
	 * The time at which this classification scheme was last revised.
	 */
	private LocalTime LastRevisionTime;
	/**
	 * The name of this classification scheme.
	 */
	private String Name;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * The Uniform Resource Identifier (URI) of this classification scheme.
	 */
	private String SchemeURIID;
	/**
	 * The Uniform Resource Identifier (URI) of the documentation for this
	 * classification scheme.
	 */
	private String URIID;
	/**
	 * A universally unique identifier for this classification scheme.
	 */
	private String UUID;
	/**
	 * An identifier for the version of this classification scheme.
	 */
	private String VersionID;
	private ClassificationCategory m_ClassificationCategory;

	public ClassificationScheme() {

	}

	public void finalize() throws Throwable {

	}

	public String getAgencyID() {
		return AgencyID;
	}

	public String getAgencyName() {
		return AgencyName;
	}

	public ClassificationCategory getClassificationCategory() {
		return m_ClassificationCategory;
	}

	public String getDescription() {
		return Description;
	}

	public String getID() {
		return ID;
	}

	public String getLanguageID() {
		return LanguageID;
	}

	public LocalDate getLastRevisionDate() {
		return LastRevisionDate;
	}

	public LocalTime getLastRevisionTime() {
		return LastRevisionTime;
	}

	public String getName() {
		return Name;
	}

	public String getNote() {
		return Note;
	}

	public String getSchemeURIID() {
		return SchemeURIID;
	}

	public String getURIID() {
		return URIID;
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
	public void setAgencyID(String newVal) {
		AgencyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAgencyName(String newVal) {
		AgencyName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setClassificationCategory(ClassificationCategory newVal) {
		m_ClassificationCategory = newVal;
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
	public void setLanguageID(String newVal) {
		LanguageID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLastRevisionDate(LocalDate newVal) {
		LastRevisionDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLastRevisionTime(LocalTime newVal) {
		LastRevisionTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		Name = newVal;
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
	public void setSchemeURIID(String newVal) {
		SchemeURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setURIID(String newVal) {
		URIID = newVal;
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
}// end Classification Scheme