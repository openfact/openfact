

/**
 * A document sent by a transport user to request a transport service from a
 * transport service provider.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:38 a. m.
 */
public class Transport Execution Plan Request {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private Indicator. Type CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * A code signifying the status of the Transport Execution Plan Request.
	 */
	private Document Status_ Code. Type DocumentStatusCode;
	/**
	 * A code signifying a reason associated with the status of the Transport
	 * Execution Plan Request.
	 */
	private Code. Type DocumentStatusReasonCode;
	/**
	 * A reason associated with the status of the Transport Execution Plan Request.
	 */
	private Text. Type DocumentStatusReasonDescription;
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
	 * Remarks from the transport user regarding the transport operations referenced
	 * in the Transport Execution Plan Request.
	 */
	private Text. Type TransportUserRemarks;
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
	 * An identifier for the current version of the Transport Execution Plan Request.
	 */
	private Identifier. Type VersionID;
	private Consignment m_Consignment;
	private Contract Transport Contract;
	private Document Reference Transport Service Description Document Reference;
	private Document Reference Additional Document Reference;
	private Document Reference Transport Execution Plan Document Reference;
	private Location To Location;
	private Location From Location;
	private Location At Location;
	private Party Transport User Party;
	private Party Receiver Party;
	private Party Sender Party;
	private Party Transport Service Provider Party;
	private Party Payee Party;
	private Period Service End Time Period;
	private Period Service Start Time Period;
	private Period Transport Service Provider Response Deadline Period;
	private Signature m_Signature;
	private Transport Execution Terms m_Transport Execution Terms;
	private Transportation Service Main Transportation Service;
	private Transportation Service Additional Transportation Service;

	public Transport Execution Plan Request(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getAdditional Document Reference(){
		return Additional Document Reference;
	}

	public Transportation Service getAdditional Transportation Service(){
		return Additional Transportation Service;
	}

	public Location getAt Location(){
		return At Location;
	}

	public Consignment getConsignment(){
		return m_Consignment;
	}

	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Document Status_ Code. Type getDocumentStatusCode(){
		return DocumentStatusCode;
	}

	public Code. Type getDocumentStatusReasonCode(){
		return DocumentStatusReasonCode;
	}

	public Text. Type getDocumentStatusReasonDescription(){
		return DocumentStatusReasonDescription;
	}

	public Location getFrom Location(){
		return From Location;
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

	public Transportation Service getMain Transportation Service(){
		return Main Transportation Service;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Party getPayee Party(){
		return Payee Party;
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

	public Party getSender Party(){
		return Sender Party;
	}

	public Period getService End Time Period(){
		return Service End Time Period;
	}

	public Period getService Start Time Period(){
		return Service Start Time Period;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Location getTo Location(){
		return To Location;
	}

	public Contract getTransport Contract(){
		return Transport Contract;
	}

	public Document Reference getTransport Execution Plan Document Reference(){
		return Transport Execution Plan Document Reference;
	}

	public Transport Execution Terms getTransport Execution Terms(){
		return m_Transport Execution Terms;
	}

	public Document Reference getTransport Service Description Document Reference(){
		return Transport Service Description Document Reference;
	}

	public Party getTransport Service Provider Party(){
		return Transport Service Provider Party;
	}

	public Period getTransport Service Provider Response Deadline Period(){
		return Transport Service Provider Response Deadline Period;
	}

	public Party getTransport User Party(){
		return Transport User Party;
	}

	public Text. Type getTransportUserRemarks(){
		return TransportUserRemarks;
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
	public void setAdditional Document Reference(Document Reference newVal){
		Additional Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Transportation Service(Transportation Service newVal){
		Additional Transportation Service = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAt Location(Location newVal){
		At Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsignment(Consignment newVal){
		m_Consignment = newVal;
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
	public void setDocumentStatusCode(Document Status_ Code. Type newVal){
		DocumentStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentStatusReasonCode(Code. Type newVal){
		DocumentStatusReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentStatusReasonDescription(Text. Type newVal){
		DocumentStatusReasonDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFrom Location(Location newVal){
		From Location = newVal;
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
	public void setMain Transportation Service(Transportation Service newVal){
		Main Transportation Service = newVal;
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
	public void setPayee Party(Party newVal){
		Payee Party = newVal;
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
	public void setSender Party(Party newVal){
		Sender Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setService End Time Period(Period newVal){
		Service End Time Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setService Start Time Period(Period newVal){
		Service Start Time Period = newVal;
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
	public void setTo Location(Location newVal){
		To Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Contract(Contract newVal){
		Transport Contract = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Execution Plan Document Reference(Document Reference newVal){
		Transport Execution Plan Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Execution Terms(Transport Execution Terms newVal){
		m_Transport Execution Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Service Description Document Reference(Document Reference newVal){
		Transport Service Description Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Service Provider Party(Party newVal){
		Transport Service Provider Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Service Provider Response Deadline Period(Period newVal){
		Transport Service Provider Response Deadline Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport User Party(Party newVal){
		Transport User Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportUserRemarks(Text. Type newVal){
		TransportUserRemarks = newVal;
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
}//end Transport Execution Plan Request