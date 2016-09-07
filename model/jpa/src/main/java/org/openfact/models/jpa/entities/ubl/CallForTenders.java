package org.openfact.models.jpa.entities.ubl;


/**
 * A document used by a Contracting Party to define a procurement project to buy
 * goods, services, or works during a specified period.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:19:15 a. m.
 */
public class CallForTenders {

	/**
	 * The date, assigned by the contracting party, on which the Call For Tenders was
	 * approved.
	 */
	private LocalDate ApprovalDate;
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
	 * Identifies the previous version of the Call for Tenders which is superceded by
	 * this version.
	 */
	private String PreviousVersionID;
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
	 * Indicates the current version of the Call for Tenders.
	 */
	private String VersionID;
	private Contracting Party m_Contracting Party;
	private CustomerParty Originator CustomerParty;
	private DocumentReference Technical DocumentReference;
	private DocumentReference Additional DocumentReference;
	private DocumentReference Legal DocumentReference;
	private Party Receiver Party;
	private Procurement Project m_Procurement Project;
	private Procurement Project Lot m_Procurement Project Lot;
	private Signature m_Signature;
	private Tendering Process m_Tendering Process;
	private Tendering Terms m_Tendering Terms;

	public Call For Tenders(){

	}

	public void finalize() throws Throwable {

	}
	public DocumentReference getAdditional DocumentReference(){
		return Additional DocumentReference;
	}

	public LocalDate getApprovalDate(){
		return ApprovalDate;
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

	public DocumentReference getLegal DocumentReference(){
		return Legal DocumentReference;
	}

	public String getNote(){
		return Note;
	}

	public CustomerParty getOriginator CustomerParty(){
		return Originator CustomerParty;
	}

	public String getPreviousVersionID(){
		return PreviousVersionID;
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

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public DocumentReference getTechnical DocumentReference(){
		return Technical DocumentReference;
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

	public String getVersionID(){
		return VersionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional DocumentReference(DocumentReference newVal){
		Additional DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApprovalDate(LocalDate newVal){
		ApprovalDate = newVal;
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
	public void setLegal DocumentReference(DocumentReference newVal){
		Legal DocumentReference = newVal;
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
	public void setOriginator CustomerParty(CustomerParty newVal){
		Originator CustomerParty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousVersionID(String newVal){
		PreviousVersionID = newVal;
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
	public void setReceiver Party(Party newVal){
		Receiver Party = newVal;
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
	public void setTechnical DocumentReference(DocumentReference newVal){
		Technical DocumentReference = newVal;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setVersionID(String newVal){
		VersionID = newVal;
	}
}//end Call For Tenders