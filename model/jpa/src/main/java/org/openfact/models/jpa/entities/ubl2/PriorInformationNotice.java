

/**
 * A document used by a contracting party to declare the intention to buy goods,
 * services, or works during a specified period.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:07 a. m.
 */
public class PriorInformationNotice {

	/**
	 * An identifier, assigned by the sender, for the process file (i.e., record) to
	 * which this document belongs.
	 */
	private Identifier. Type ContractFolderID;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private Indicator. Type CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
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
	 * The date planned by the Contracting Party for publication of the contract
	 * notice.
	 */
	private Date. Type PlannedDate;
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
	private Contracting Party m_Contracting Party;
	private Customer Party Originator Customer Party;
	private Document Reference m_Document Reference;
	private Party Receiver Party;
	private Procurement Project m_Procurement Project;
	private Procurement Project Lot m_Procurement Project Lot;
	private Signature m_Signature;
	private Tendering Process m_Tendering Process;
	private Tendering Terms m_Tendering Terms;

	public Prior Information Notice(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getContractFolderID(){
		return ContractFolderID;
	}

	public Contracting Party getContracting Party(){
		return m_Contracting Party;
	}

	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
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

	public Customer Party getOriginator Customer Party(){
		return Originator Customer Party;
	}

	public Date. Type getPlannedDate(){
		return PlannedDate;
	}

	public Procurement Project getProcurement Project(){
		return m_Procurement Project;
	}

	public Procurement Project Lot getProcurement Project Lot(){
		return m_Procurement Project Lot;
	}

	public Identifier. Type getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public Identifier. Type getProfileID(){
		return ProfileID;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Tendering Process getTendering Process(){
		return m_Tendering Process;
	}

	public Tendering Terms getTendering Terms(){
		return m_Tendering Terms;
	}

	public Identifier. Type getUBLVersionID(){
		return UBLVersionID;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractFolderID(Identifier. Type newVal){
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
	public void setCopyIndicator(Indicator. Type newVal){
		CopyIndicator = newVal;
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
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
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
	public void setOriginator Customer Party(Customer Party newVal){
		Originator Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlannedDate(Date. Type newVal){
		PlannedDate = newVal;
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
}//end Prior Information Notice