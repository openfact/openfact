package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private String agencyID;
	/**
	 * The name of the agency that maintains the classification scheme.
	 */
	private String agencyName;
	/**
	 * Text describing this classification scheme.
	 */
	private String description;
	/**
	 * An identifier for this classification scheme.
	 */
	private String ID;
	/**
	 * An identifier for the language of this classification scheme.
	 */
	private String languageID;
	/**
	 * The date on which this classification scheme was last revised.
	 */
	private LocalDate lastRevisionDate;
	/**
	 * The time at which this classification scheme was last revised.
	 */
	private LocalTime lastRevisionTime;
	/**
	 * The name of this classification scheme.
	 */
	private String name;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * The Uniform Resource Identifier (URI) of this classification scheme.
	 */
	private String schemeURIID;
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
	private String versionID;
	private List<ClassificationCategory> classificationCategorys= new ArrayList<>();

	public ClassificationScheme() {

	}

	public void finalize() throws Throwable {

	}

	public String getAgencyID() {
		return agencyID;
	}

	public void setAgencyID(String agencyID) {
		this.agencyID = agencyID;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
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

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	public LocalDate getLastRevisionDate() {
		return lastRevisionDate;
	}

	public void setLastRevisionDate(LocalDate lastRevisionDate) {
		this.lastRevisionDate = lastRevisionDate;
	}

	public LocalTime getLastRevisionTime() {
		return lastRevisionTime;
	}

	public void setLastRevisionTime(LocalTime lastRevisionTime) {
		this.lastRevisionTime = lastRevisionTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getSchemeURIID() {
		return schemeURIID;
	}

	public void setSchemeURIID(String schemeURIID) {
		this.schemeURIID = schemeURIID;
	}

	public String getURIID() {
		return URIID;
	}

	public void setURIID(String URIID) {
		this.URIID = URIID;
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

	public List<ClassificationCategory> getClassificationCategorys() {
		return classificationCategorys;
	}

	public void setClassificationCategorys(List<ClassificationCategory> classificationCategorys) {
		this.classificationCategorys = classificationCategorys;
	}
}// end ClassificationScheme