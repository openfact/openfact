package org.openfact.models.jpa.entities.ubl;


/**
 * A document published by a Contracting Party to announce the awarding of a
 * procurement project.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:21 a. m.
 */
public class ContractAwardNotice {

	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private String ContractFolderID;
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
	 * An indicator specifying if the notice is published for service contracts within
	 * certain service categories (true) or not (false).
	 */
	private boolean PublishAwardIndicator;
	/**
	 * Information about the law that defines the regulatory domain.
	 */
	private String RegulatoryDomain;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Contracting Party m_Contracting Party;
	private Customer Party Originator Customer Party;
	private Document Reference Previous Document Reference;
	private Document Reference Minutes Document Reference;
	private Party Receiver Party;
	private Procurement Project Lot m_Procurement Project Lot;
	private Procurement Project m_Procurement Project;
	private Signature m_Signature;
	private Tender Result m_Tender Result;
	private Tendering Process m_Tendering Process;
	private Tendering Terms m_Tendering Terms;

	public Contract Award Notice(){

	}

	public void finalize() throws Throwable {

	}
	public String getContractFolderID(){
		return ContractFolderID;
	}

	public Contracting Party getContracting Party(){
		return m_Contracting Party;
	}

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
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

	public Document Reference getMinutes Document Reference(){
		return Minutes Document Reference;
	}

	public String getNote(){
		return Note;
	}

	public Customer Party getOriginator Customer Party(){
		return Originator Customer Party;
	}

	public Document Reference getPrevious Document Reference(){
		return Previous Document Reference;
	}

	public Procurement Project getProcurement Project(){
		return m_Procurement Project;
	}

	public Procurement Project Lot getProcurement Project Lot(){
		return m_Procurement Project Lot;
	}

	public String getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public String getProfileID(){
		return ProfileID;
	}

	public boolean getPublishAwardIndicator(){
		return PublishAwardIndicator;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public String getRegulatoryDomain(){
		return RegulatoryDomain;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Tender Result getTender Result(){
		return m_Tender Result;
	}

	public Tendering Process getTendering Process(){
		return m_Tendering Process;
	}

	public Tendering Terms getTendering Terms(){
		return m_Tendering Terms;
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
	public void setContractFolderID(String newVal){
		ContractFolderID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContracting Party(Contracting Party newVal){
		m_Contracting Party = newVal;
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
	public void setMinutes Document Reference(Document Reference newVal){
		Minutes Document Reference = newVal;
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
	public void setOriginator Customer Party(Customer Party newVal){
		Originator Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrevious Document Reference(Document Reference newVal){
		Previous Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurement Project(Procurement Project newVal){
		m_Procurement Project = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProcurement Project Lot(Procurement Project Lot newVal){
		m_Procurement Project Lot = newVal;
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
	public void setPublishAwardIndicator(boolean newVal){
		PublishAwardIndicator = newVal;
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
	public void setRegulatoryDomain(String newVal){
		RegulatoryDomain = newVal;
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
	public void setTender Result(Tender Result newVal){
		m_Tender Result = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTendering Process(Tendering Process newVal){
		m_Tendering Process = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTendering Terms(Tendering Terms newVal){
		m_Tendering Terms = newVal;
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
}//end Contract Award Notice