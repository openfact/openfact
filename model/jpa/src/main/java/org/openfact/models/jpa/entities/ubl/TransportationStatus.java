package org.openfact.models.jpa.entities.ubl;


/**
 * A document to circulate reports of transportation status or changes in status
 * (events) among a group of participants.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:46 a. m.
 */
public class TransportationStatus {

	/**
	 * A reference number assigned by a carrier or its agent to identify a specific
	 * shipment, such as a booking reference number when cargo space is reserved prior
	 * to loading.
	 */
	private String CarrierAssignedID;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * A textual description of transportation status.
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
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private String Name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * An instruction regarding this message.
	 */
	private String OtherInstruction;
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
	 * A reference number for a shipping order.
	 */
	private String ShippingOrderID;
	/**
	 * A code signifying the type of status provided in a Transportation Status
	 * document.
	 */
	private String TransportationStatusTypeCode;
	/**
	 * A code signifying the overall status of transport service execution.
	 */
	private String TransportExecutionStatusCode;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
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
	public String getCarrierAssignedID(){
		return CarrierAssignedID;
	}

	public Consignment getConsignment(){
		return m_Consignment;
	}

	public String getCustomizationID(){
		return CustomizationID;
	}

	public String getDescription(){
		return Description;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
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

	public String getName(){
		return Name;
	}

	public String getNote(){
		return Note;
	}

	public String getOtherInstruction(){
		return OtherInstruction;
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

	public String getShippingOrderID(){
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

	public String getTransportationStatusTypeCode(){
		return TransportationStatusTypeCode;
	}

	public String getTransportExecutionStatusCode(){
		return TransportExecutionStatusCode;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
	}

	public Transport Event getUpdated Delivery Transport Event(){
		return Updated Delivery Transport Event;
	}

	public Transport Event getUpdated Pickup Transport Event(){
		return Updated Pickup Transport Event;
	}

	public String getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCarrierAssignedID(String newVal){
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
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
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
	public void setName(String newVal){
		Name = newVal;
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
	public void setOtherInstruction(String newVal){
		OtherInstruction = newVal;
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
	public void setShippingOrderID(String newVal){
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
	public void setTransportationStatusTypeCode(String newVal){
		TransportationStatusTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportExecutionStatusCode(String newVal){
		TransportExecutionStatusCode = newVal;
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
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Transportation Status