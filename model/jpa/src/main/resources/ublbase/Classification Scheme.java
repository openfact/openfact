

/**
 * A class to define a classification scheme, such as a taxonomy for classifying
 * goods or services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:33 a. m.
 */
public class Classification Scheme {

	/**
	 * An identifier for the agency that maintains this classification scheme.
	 */
	private Identifier. Type AgencyID;
	/**
	 * The name of the agency that maintains the classification scheme.
	 */
	private Text. Type AgencyName;
	/**
	 * Text describing this classification scheme.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this classification scheme.
	 */
	private Identifier. Type ID;
	/**
	 * An identifier for the language of this classification scheme.
	 */
	private Identifier. Type LanguageID;
	/**
	 * The date on which this classification scheme was last revised.
	 */
	private Date. Type LastRevisionDate;
	/**
	 * The time at which this classification scheme was last revised.
	 */
	private Time. Type LastRevisionTime;
	/**
	 * The name of this classification scheme.
	 */
	private Name. Type Name;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The Uniform Resource Identifier (URI) of this classification scheme.
	 */
	private Identifier. Type SchemeURIID;
	/**
	 * The Uniform Resource Identifier (URI) of the documentation for this
	 * classification scheme.
	 */
	private Identifier. Type URIID;
	/**
	 * A universally unique identifier for this classification scheme.
	 */
	private Identifier. Type UUID;
	/**
	 * An identifier for the version of this classification scheme.
	 */
	private Identifier. Type VersionID;
	private Classification Category m_Classification Category;

	public Classification Scheme(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getAgencyID(){
		return AgencyID;
	}

	public Text. Type getAgencyName(){
		return AgencyName;
	}

	public Classification Category getClassification Category(){
		return m_Classification Category;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Identifier. Type getLanguageID(){
		return LanguageID;
	}

	public Date. Type getLastRevisionDate(){
		return LastRevisionDate;
	}

	public Time. Type getLastRevisionTime(){
		return LastRevisionTime;
	}

	public Name. Type getName(){
		return Name;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Identifier. Type getSchemeURIID(){
		return SchemeURIID;
	}

	public Identifier. Type getURIID(){
		return URIID;
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
	public void setAgencyID(Identifier. Type newVal){
		AgencyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAgencyName(Text. Type newVal){
		AgencyName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setClassification Category(Classification Category newVal){
		m_Classification Category = newVal;
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
	public void setLanguageID(Identifier. Type newVal){
		LanguageID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLastRevisionDate(Date. Type newVal){
		LastRevisionDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLastRevisionTime(Time. Type newVal){
		LastRevisionTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
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
	public void setSchemeURIID(Identifier. Type newVal){
		SchemeURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setURIID(Identifier. Type newVal){
		URIID = newVal;
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
}//end Classification Scheme