

/**
 * A document issued to a forwarder, giving instructions regarding the action to
 * be taken for the forwarding of goods described therein. Forwarding Instructions
 * is used by any party who gives instructions for the transportation services
 * required for a consig
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:38 a. m.
 */
public class Forwarding Instructions {

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on their
	 * value.
	 */
	private Indicator. Type AdValoremIndicator;
	/**
	 * Reference number assigned by a carrier or its agent to identify a specific
	 * shipment, such as a booking reference number when cargo space is reserved prior
	 * to loading.
	 */
	private Identifier. Type CarrierAssignedID;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private Identifier. Type CustomizationID;
	/**
	 * Value declared by the shipper or his agent solely for the purpose of varying
	 * the carrier's level of liability from that provided in the contract of carriage
	 * in case of loss or damage to goods or delayed delivery.
	 */
	private Amount. Type DeclaredCarriageValueAmount;
	/**
	 * Textual description of the document instance.
	 */
	private Text. Type Description;
	/**
	 * A code signifying the status of the Forwarding Instructions with respect to its
	 * original state. This code may be used if the document precedes the event and is
	 * subsequently found to be incorrect and in need of cancellation or revision.
	 */
	private Document Status_ Code. Type DocumentStatusCode;
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
	 * Contains other free-text instructions to the forwarders or carriers related to
	 * the shipment. This should only be used where such information cannot be
	 * represented in other structured information entities within the document.
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
	 * Reference number to identify a Shipping Order.
	 */
	private Identifier. Type ShippingOrderID;
	/**
	 * Indicates whether the transport document is consigned to order.
	 */
	private Indicator. Type ToOrderIndicator;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private Identifier. Type UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private Identifier. Type UUID;
	private Document Reference m_Document Reference;
	private Exchange Rate m_Exchange Rate;
	private Party Freight Forwarder Party;
	private Party Consignor Party;
	private Party Carrier Party;
	private Shipment m_Shipment;
	private Signature m_Signature;

	public Forwarding Instructions(){

	}

	public void finalize() throws Throwable {

	}
	public Indicator. Type getAdValoremIndicator(){
		return AdValoremIndicator;
	}

	public Party getCarrier Party(){
		return Carrier Party;
	}

	public Identifier. Type getCarrierAssignedID(){
		return CarrierAssignedID;
	}

	public Party getConsignor Party(){
		return Consignor Party;
	}

	public Identifier. Type getCustomizationID(){
		return CustomizationID;
	}

	public Amount. Type getDeclaredCarriageValueAmount(){
		return DeclaredCarriageValueAmount;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Document Status_ Code. Type getDocumentStatusCode(){
		return DocumentStatusCode;
	}

	public Exchange Rate getExchange Rate(){
		return m_Exchange Rate;
	}

	public Party getFreight Forwarder Party(){
		return Freight Forwarder Party;
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

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Identifier. Type getShippingOrderID(){
		return ShippingOrderID;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public Indicator. Type getToOrderIndicator(){
		return ToOrderIndicator;
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
	public void setAdValoremIndicator(Indicator. Type newVal){
		AdValoremIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCarrier Party(Party newVal){
		Carrier Party = newVal;
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
	public void setConsignor Party(Party newVal){
		Consignor Party = newVal;
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
	public void setDeclaredCarriageValueAmount(Amount. Type newVal){
		DeclaredCarriageValueAmount = newVal;
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
	public void setDocumentStatusCode(Document Status_ Code. Type newVal){
		DocumentStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchange Rate(Exchange Rate newVal){
		m_Exchange Rate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight Forwarder Party(Party newVal){
		Freight Forwarder Party = newVal;
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
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
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
	public void setToOrderIndicator(Indicator. Type newVal){
		ToOrderIndicator = newVal;
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
}//end Forwarding Instructions