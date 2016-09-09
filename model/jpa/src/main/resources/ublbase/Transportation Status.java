

/**
 * A document to circulate reports of transportation status or changes in status
 * (events) among a group of participants.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:46 a. m.
 */
public class Transportation Status {

	/**
	 * A reference number assigned by a carrier or its agent to identify a specific
	 * shipment, such as a booking reference number when cargo space is reserved prior
	 * to loading.
	 */
	private Identifier. Type CarrierAssignedID;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * A textual description of transportation status.
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private Name. Type Name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private Text. Type Note;
	/**
	 * An instruction regarding this message.
	 */
	private Text. Type OtherInstruction;
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
	 * A reference number for a shipping order.
	 */
	private Identifier. Type ShippingOrderID;
	/**
	 * A code signifying the type of status provided in a Transportation Status
	 * document.
	 */
	private Code. Type TransportationStatusTypeCode;
	/**
	 * A code signifying the overall status of transport service execution.
	 */
	private Code. Type TransportExecutionStatusCode;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private Identifier. Type UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private Identifier. Type UUID;
	private Consignment m_Consignment;
	private Document Reference m_Document Reference;
	private Document Reference Transportation Status Request Document Reference;
	private Document Reference Transport Execution Plan Document Reference;
	private Location Status Location;
	private Party Receiver Party;
	private Party Sender Party;
	private Period Status Period;
	private Signature m_Signature;
	private Transport Event m_Transport Event;
	private Transport Event Updated Pickup Transport Event;
	private Transport Event Updated Delivery Transport Event;

	public Transportation Status(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getCarrierAssignedID(){
		return CarrierAssignedID;
	}

	public Consignment getConsignment(){
		return m_Consignment;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Text. Type getDescription(){
		return Description;
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

	public Name. Type getName(){
		return Name;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Text. Type getOtherInstruction(){
		return OtherInstruction;
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

	public Identifier. Type getShippingOrderID(){
		return ShippingOrderID;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Location getStatus Location(){
		return Status Location;
	}

	public Period getStatus Period(){
		return Status Period;
	}

	public Transport Event getTransport Event(){
		return m_Transport Event;
	}

	public Document Reference getTransport Execution Plan Document Reference(){
		return Transport Execution Plan Document Reference;
	}

	public Document Reference getTransportation Status Request Document Reference(){
		return Transportation Status Request Document Reference;
	}

	public Code. Type getTransportationStatusTypeCode(){
		return TransportationStatusTypeCode;
	}

	public Code. Type getTransportExecutionStatusCode(){
		return TransportExecutionStatusCode;
	}

	public Identifier. Type getUBLVersionID(){
		return UBLVersionID;
	}

	public Transport Event getUpdated Delivery Transport Event(){
		return Updated Delivery Transport Event;
	}

	public Transport Event getUpdated Pickup Transport Event(){
		return Updated Pickup Transport Event;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCarrierAssignedID(Identifier. Type newVal){
		CarrierAssignedID = newVal;
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
	public void setOtherInstruction(Text. Type newVal){
		OtherInstruction = newVal;
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
	public void setShippingOrderID(Identifier. Type newVal){
		ShippingOrderID = newVal;
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
	public void setStatus Location(Location newVal){
		Status Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatus Period(Period newVal){
		Status Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Event(Transport Event newVal){
		m_Transport Event = newVal;
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
	public void setTransportation Status Request Document Reference(Document Reference newVal){
		Transportation Status Request Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportationStatusTypeCode(Code. Type newVal){
		TransportationStatusTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportExecutionStatusCode(Code. Type newVal){
		TransportExecutionStatusCode = newVal;
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
	public void setUpdated Delivery Transport Event(Transport Event newVal){
		Updated Delivery Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUpdated Pickup Transport Event(Transport Event newVal){
		Updated Pickup Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Transportation Status