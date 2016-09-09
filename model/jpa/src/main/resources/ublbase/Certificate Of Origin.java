

/**
 * A document that describes the Certificate of Origin.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:56 a. m.
 */
public class Certificate Of Origin {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private Identifier. Type ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private Date. Type IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private Time. Type IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private Text. Type Note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private Identifier. Type ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private Identifier. Type ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private Identifier. Type UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private Identifier. Type UUID;
	/**
	 * Identifies the version of this Certificate of Origin.
	 */
	private Identifier. Type VersionID;
	private Certificate Of Origin Application m_Certificate Of Origin Application;
	private Endorsement Issuer Endorsement;
	private Endorsement Embassy Endorsement;
	private Endorsement Insurance Endorsement;
	private Endorser Party m_Endorser Party;
	private Party Importer Party;
	private Party Exporter Party;
	private Signature m_Signature;

	public Certificate Of Origin(){

	}

	public void finalize() throws Throwable {

	}
	public Certificate Of Origin Application getCertificate Of Origin Application(){
		return m_Certificate Of Origin Application;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Endorsement getEmbassy Endorsement(){
		return Embassy Endorsement;
	}

	public Endorser Party getEndorser Party(){
		return m_Endorser Party;
	}

	public Party getExporter Party(){
		return Exporter Party;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Party getImporter Party(){
		return Importer Party;
	}

	public Endorsement getInsurance Endorsement(){
		return Insurance Endorsement;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Endorsement getIssuer Endorsement(){
		return Issuer Endorsement;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Identifier. Type getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public Identifier. Type getProfileID(){
		return ProfileID;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Identifier. Type getUBLVersionID(){
		return UBLVersionID;
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
	public void setCertificate Of Origin Application(Certificate Of Origin Application newVal){
		m_Certificate Of Origin Application = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustomizationID(Identifier. Type newVal){
		CustomizationID = newVal;
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
	public void setEmbassy Endorsement(Endorsement newVal){
		Embassy Endorsement = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEndorser Party(Endorser Party newVal){
		m_Endorser Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExporter Party(Party newVal){
		Exporter Party = newVal;
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
	public void setImporter Party(Party newVal){
		Importer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInsurance Endorsement(Endorsement newVal){
		Insurance Endorsement = newVal;
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
	public void setIssuer Endorsement(Endorsement newVal){
		Issuer Endorsement = newVal;
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
	public void setProfileExecutionID(Identifier. Type newVal){
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(Identifier. Type newVal){
		ProfileID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUBLVersionID(Identifier. Type newVal){
		UBLVersionID = newVal;
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
}//end Certificate Of Origin