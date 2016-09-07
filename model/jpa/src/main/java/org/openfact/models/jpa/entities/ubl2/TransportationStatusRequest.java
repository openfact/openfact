

/**
 * A document requesting a Transportation Status report.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:47 a. m.
 */
public class TransportationStatusRequest {

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
	 * A textual description of the document instance.
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
	 * A code signifying the type of status requested in a Transportation Status
	 * document.
	 */
	private Code. Type TransportationStatusTypeCode;
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
	private Document Reference Transport Execution Plan Document Reference;
	private Location Requested Status Location;
	private Party Sender Party;
	private Party Receiver Party;
	private Period Requested Status Period;
	private Signature m_Signature;

	public Transportation Status Request(){

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

	public Location getRequested Status Location(){
		return Requested Status Location;
	}

	public Period getRequested Status Period(){
		return Requested Status Period;
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

	public Document Reference getTransport Execution Plan Document Reference(){
		return Transport Execution Plan Document Reference;
	}

	public Code. Type getTransportationStatusTypeCode(){
		return TransportationStatusTypeCode;
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
	public void setRequested Status Location(Location newVal){
		Requested Status Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Status Period(Period newVal){
		Requested Status Period = newVal;
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
	public void setTransport Execution Plan Document Reference(Document Reference newVal){
		Transport Execution Plan Document Reference = newVal;
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
}//end Transportation Status Request