package org.openfact.models.jpa.entities.ubl;


/**
 * A document that describes the Certificate of Origin.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:56 a. m.
 */
public class CertificateOfOrigin {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String Description;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	/**
	 * Identifies the version of this Certificate of Origin.
	 */
	private String VersionID;
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

	public String getCustomizationID(){
		return CustomizationID;
	}

	public String getDescription(){
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

	public String getID(){
		return ID;
	}

	public Party getImporter Party(){
		return Importer Party;
	}

	public Endorsement getInsurance Endorsement(){
		return Insurance Endorsement;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public Endorsement getIssuer Endorsement(){
		return Issuer Endorsement;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public String getNote(){
		return Note;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
	}

	public String getUUID(){
		return UUID;
	}

	public String getVersionID(){
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
	public void setCustomizationID(String newVal){
		CustomizationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
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
	public void setID(String newVal){
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
	public void setIssueDate(LocalDate newVal){
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
	public void setIssueTime(LocalTime newVal){
		IssueTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileExecutionID(String newVal){
		ProfileExecutionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProfileID(String newVal){
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
	public void setUBLVersionID(String newVal){
		UBLVersionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(String newVal){
		VersionID = newVal;
	}
}//end Certificate Of Origin