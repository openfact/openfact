package org.openfact.models.jpa.entities.ubl;


/**
 * A document sent by a transport user to request a transport service from a
 * transport service provider.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:38 a. m.
 */
public class TransportExecutionPlanRequest {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * A code signifying the status of the Transport Execution Plan Request.
	 */
	private Document Status_ String DocumentStatusCode;
	/**
	 * A code signifying a reason associated with the status of the Transport
	 * Execution Plan Request.
	 */
	private String DocumentStatusReasonCode;
	/**
	 * A reason associated with the status of the Transport Execution Plan Request.
	 */
	private String DocumentStatusReasonDescription;
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
	 * Remarks from the transport user regarding the transport operations referenced
	 * in the Transport Execution Plan Request.
	 */
	private String TransportUserRemarks;
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
	 * An identifier for the current version of the Transport Execution Plan Request.
	 */
	private String VersionID;
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

	public boolean getCopyIndicator(){
		return CopyIndicator;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public Document Status_ String getDocumentStatusCode(){
		return DocumentStatusCode;
	}

	public String getDocumentStatusReasonCode(){
		return DocumentStatusReasonCode;
	}

	public String getDocumentStatusReasonDescription(){
		return DocumentStatusReasonDescription;
	}

	public Location getFrom Location(){
		return From Location;
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

	public Transportation Service getMain Transportation Service(){
		return Main Transportation Service;
	}

	public String getNote(){
		return Note;
	}

	public Party getPayee Party(){
		return Payee Party;
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

	public String getTransportUserRemarks(){
		return TransportUserRemarks;
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
	public void setDocumentStatusCode(Document Status_ String newVal){
		DocumentStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentStatusReasonCode(String newVal){
		DocumentStatusReasonCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentStatusReasonDescription(String newVal){
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
	public void setMain Transportation Service(Transportation Service newVal){
		Main Transportation Service = newVal;
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
	public void setPayee Party(Party newVal){
		Payee Party = newVal;
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
	public void setTransportUserRemarks(String newVal){
		TransportUserRemarks = newVal;
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
}//end Transport Execution Plan Request