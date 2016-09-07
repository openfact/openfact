package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to a catalogue.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:23 a. m.
 */
public class CatalogueReference {

	/**
	 * Text describing the catalogue.
	 */
	private Text. Type Description;
	/**
	 * An identifier for a specific catalogue.
	 */
	private Identifier. Type ID;
	/**
	 * The date on which the catalogue was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time at which the catalogue was issued.
	 */
	private Time. Type IssueTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * An identifier for the previous version of the catalogue that is superseded by
	 * this version.
	 */
	private Identifier. Type PreviousVersionID;
	/**
	 * The date on which the information in the catalogue was last revised.
	 */
	private Date. Type RevisionDate;
	/**
	 * The time at which the information in the catalogue was last revised.
	 */
	private Time. Type RevisionTime;
	/**
	 * A universally unique identifier for a specific catalogue.
	 */
	private Identifier. Type UUID;
	/**
	 * An identifier for the current version of the catalogue.
	 */
	private Identifier. Type VersionID;

	public Catalogue Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Identifier. Type getPreviousVersionID(){
		return PreviousVersionID;
	}

	public Date. Type getRevisionDate(){
		return RevisionDate;
	}

	public Time. Type getRevisionTime(){
		return RevisionTime;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	public Identifier. Type getVersionID(){
		return VersionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(Date. Type newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(Time. Type newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousVersionID(Identifier. Type newVal){
		PreviousVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRevisionDate(Date. Type newVal){
		RevisionDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRevisionTime(Time. Type newVal){
		RevisionTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(Identifier. Type newVal){
		VersionID = newVal;
	}
}//end Catalogue Reference