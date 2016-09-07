package org.openfact.models.jpa.entities.ubl;


/**
 * A document sent by a transport service provider to announce the availability of
 * a transport service.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:43 a. m.
 */
public class TransportServiceDescription {

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
	 * A code signifying a response related to the Transport Service Description.
	 */
	private String ResponseCode;
	/**
	 * A name, assigned by the Transport Service Provider, for the service being
	 * announced.
	 */
	private String ServiceName;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private String UUID;
	private Document Reference Transport Service Description Request Document Reference;
	private Party Sender Party;
	private Party Receiver Party;
	private Party Transport Service Provider Party;
	private Payment Terms Service Charge Payment Terms;
	private Period Validity Period;
	private Signature m_Signature;
	private Transportation Service m_Transportation Service;

	public Transport Service Description(){

	}

	public void finalize() throws Throwable {

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

	public String getNote(){
		return Note;
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

	public String getResponseCode(){
		return ResponseCode;
	}

	public Party getSender Party(){
		return Sender Party;
	}

	public Payment Terms getService Charge Payment Terms(){
		return Service Charge Payment Terms;
	}

	public String getServiceName(){
		return ServiceName;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Document Reference getTransport Service Description Request Document Reference(){
		return Transport Service Description Request Document Reference;
	}

	public Party getTransport Service Provider Party(){
		return Transport Service Provider Party;
	}

	public Transportation Service getTransportation Service(){
		return m_Transportation Service;
	}

	public String getUBLVersionID(){
		return UBLVersionID;
	}

	public String getUUID(){
		return UUID;
	}

	public Period getValidity Period(){
		return Validity Period;
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
	public void setReceiver Party(Party newVal){
		Receiver Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponseCode(String newVal){
		ResponseCode = newVal;
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
	public void setService Charge Payment Terms(Payment Terms newVal){
		Service Charge Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setServiceName(String newVal){
		ServiceName = newVal;
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
	public void setTransport Service Description Request Document Reference(Document Reference newVal){
		Transport Service Description Request Document Reference = newVal;
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
	public void setTransportation Service(Transportation Service newVal){
		m_Transportation Service = newVal;
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
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Transport Service Description