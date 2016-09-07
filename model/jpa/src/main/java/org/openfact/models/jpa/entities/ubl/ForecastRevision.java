package org.openfact.models.jpa.entities.ubl;


/**
 * A document used to revise a Forecast.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:37 a. m.
 */
public class ForecastRevision {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
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
	 * Indicates the purpose of the revision.
	 */
	private String PurposeCode;
	/**
	 * Indicates the revision status of this Forecast Revision.
	 */
	private String RevisionStatusCode;
	/**
	 * A sequence number, to ensure the proper sequencing of revisions.
	 */
	private String SequenceNumberID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private CustomerParty Buyer CustomerParty;
	private DocumentReference Original DocumentReference;
	private Forecast Revision Line m_Forecast Revision Line;
	private Party Sender Party;
	private Party Receiver Party;
	private Period Forecast Period;
	private Signature m_Signature;
	private Supplier Party Seller Supplier Party;

	public Forecast Revision(){

	}

	public void finalize() throws Throwable {

	}
	public CustomerParty getBuyer CustomerParty(){
		return Buyer CustomerParty;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public Period getForecast Period(){
		return Forecast Period;
	}

	public Forecast Revision Line getForecast Revision Line(){
		return m_Forecast Revision Line;
	}

	public String getID(){
		return ID;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	public String getNote(){
		return Note;
	}

	public DocumentReference getOriginal DocumentReference(){
		return Original DocumentReference;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public String getPurposeCode(){
		return PurposeCode;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public String getRevisionStatusCode(){
		return RevisionStatusCode;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	public Party getSender Party(){
		return Sender Party;
	}

	public String getSequenceNumberID(){
		return SequenceNumberID;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setBuyer CustomerParty(CustomerParty newVal){
		Buyer CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCopyIndicator(boolean newVal){
		CopyIndicator = newVal;
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
	public void setForecast Period(Period newVal){
		Forecast Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setForecast Revision Line(Forecast Revision Line newVal){
		m_Forecast Revision Line = newVal;
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
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
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
	public void setOriginal DocumentReference(DocumentReference newVal){
		Original DocumentReference = newVal;
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
	public void setPurposeCode(String newVal){
		PurposeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceiver Party(Party newVal){
		Receiver Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRevisionStatusCode(String newVal){
		RevisionStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSender Party(Party newVal){
		Sender Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceNumberID(String newVal){
		SequenceNumberID = newVal;
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
}//end Forecast Revision