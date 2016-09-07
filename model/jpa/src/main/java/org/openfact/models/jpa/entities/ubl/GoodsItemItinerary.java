package org.openfact.models.jpa.entities.ubl;


/**
 * A document providing details relating to a transport service, such as transport
 * movement, identification of equipment and goods, subcontracted service
 * providers, etc.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:43 a. m.
 */
public class GoodsItemItinerary {

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
	 * The Transport Execution Plan associated with this GoodsItem Itinerary.
	 */
	private String TransportExecutionPlanReferenceID;
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
	 * Identifies a version of a GoodsItem Itinerary in order to distinguish updates.
	 */
	private String VersionID;
	private Consignment Referenced Consignment;
	private GoodsItem Referenced GoodsItem;
	private Package Referenced Package;
	private Party Receiver Party;
	private Party Sender Party;
	private Signature m_Signature;
	private TransportEquipment Referenced TransportEquipment;
	private Transportation Segment m_Transportation Segment;

	public GoodsItem Itinerary(){

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

	public Consignment getReferenced Consignment(){
		return Referenced Consignment;
	}

	public GoodsItem getReferenced GoodsItem(){
		return Referenced GoodsItem;
	}

	public Package getReferenced Package(){
		return Referenced Package;
	}

	public TransportEquipment getReferenced TransportEquipment(){
		return Referenced TransportEquipment;
	}

	public Party getSender Party(){
		return Sender Party;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Transportation Segment getTransportation Segment(){
		return m_Transportation Segment;
	}

	public String getTransportExecutionPlanReferenceID(){
		return TransportExecutionPlanReferenceID;
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
	public void setReferenced Consignment(Consignment newVal){
		Referenced Consignment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenced GoodsItem(GoodsItem newVal){
		Referenced GoodsItem = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenced Package(Package newVal){
		Referenced Package = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenced TransportEquipment(TransportEquipment newVal){
		Referenced TransportEquipment = newVal;
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
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportation Segment(Transportation Segment newVal){
		m_Transportation Segment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportExecutionPlanReferenceID(String newVal){
		TransportExecutionPlanReferenceID = newVal;
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
}//end GoodsItem Itinerary