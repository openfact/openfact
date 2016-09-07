

/**
 * A document providing details relating to a transport service, such as transport
 * movement, identification of equipment and goods, subcontracted service
 * providers, etc.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:43 a. m.
 */
public class Goods Item Itinerary {

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
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private Identifier. Type ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private Identifier. Type ProfileID;
	/**
	 * The Transport Execution Plan associated with this Goods Item Itinerary.
	 */
	private Identifier. Type TransportExecutionPlanReferenceID;
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
	 * Identifies a version of a Goods Item Itinerary in order to distinguish updates.
	 */
	private Identifier. Type VersionID;
	private Consignment Referenced Consignment;
	private Goods Item Referenced Goods Item;
	private Package Referenced Package;
	private Party Receiver Party;
	private Party Sender Party;
	private Signature m_Signature;
	private Transport Equipment Referenced Transport Equipment;
	private Transportation Segment m_Transportation Segment;

	public Goods Item Itinerary(){

	}

	public void finalize() throws Throwable {

	}
	public Indicator. Type getCopyIndicator(){
		return CopyIndicator;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
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

	public Identifier. Type getProfileExecutionID(){
		return ProfileExecutionID;
	}

	public Identifier. Type getProfileID(){
		return ProfileID;
	}

	public Party getReceiver Party(){
		return Receiver Party;
	}

	public Consignment getReferenced Consignment(){
		return Referenced Consignment;
	}

	public Goods Item getReferenced Goods Item(){
		return Referenced Goods Item;
	}

	public Package getReferenced Package(){
		return Referenced Package;
	}

	public Transport Equipment getReferenced Transport Equipment(){
		return Referenced Transport Equipment;
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

	public Identifier. Type getTransportExecutionPlanReferenceID(){
		return TransportExecutionPlanReferenceID;
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
	public void setReferenced Consignment(Consignment newVal){
		Referenced Consignment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenced Goods Item(Goods Item newVal){
		Referenced Goods Item = newVal;
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
	public void setReferenced Transport Equipment(Transport Equipment newVal){
		Referenced Transport Equipment = newVal;
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
	public void setTransportExecutionPlanReferenceID(Identifier. Type newVal){
		TransportExecutionPlanReferenceID = newVal;
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
}//end Goods Item Itinerary