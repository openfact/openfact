package org.openfact.models.jpa.entities.ubl;

/**
 * A transport document describing a shipment It is issued by the party who
 * undertakes to provide transportation services, or undertakes to arrange for
 * their provision, to the party who gives instructions for the transportation
 * services (shipper, consignor,
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:52 a. m.
 */
public class Waybill {

    /**
     * A term used in commerce in reference to certain duties, called ad valorem
     * duties, which are levied on commodities at certain rates per centum on
     * their value.
     */
    private boolean AdValoremIndicator;
    /**
     * An identifier (in the form of a reference number) assigned by a carrier
     * or its agent to identify a specific shipment.
     */
    private String CarrierAssignedID;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * Value declared by the shipper or his agent solely for the purpose of
     * varying the carrier's level of liability from that provided in the
     * contract of carriage in case of loss or damage to goods or delayed
     * delivery.
     */
    private BigDecimal DeclaredCarriageValueAmount;
    /**
     * Text describing the contents of the Waybill.
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
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private String Name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
    /**
     * Other free-text instructions related to the shipment to the forwarders or
     * carriers. This should only be used where such information cannot be
     * represented in other structured information entities within the document.
     */
    private String OtherInstruction;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String ProfileID;
    /**
     * An identifier (in the form of a reference number) of the Shipping Order
     * or Forwarding Instruction associated with this shipment.
     */
    private String ShippingOrderID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    private Document Distribution
    m_Document Distribution;
    private DocumentReference
    m_DocumentReference;
    private Exchange Rate
    m_Exchange Rate;
    private Party Freight
    Forwarder Party;
    private Party Carrier Party;
    private Party Consignor Party;
    private Shipment m_Shipment;
    private Signature m_Signature;

    public Waybill() {

    }

    public void finalize() throws Throwable {

    }

    public boolean getAdValoremIndicator() {
        return AdValoremIndicator;
    }

    public Party getCarrier

    Party(){
		return Carrier Party;
	}

    public String getCarrierAssignedID() {
        return CarrierAssignedID;
    }

    public Party getConsignor

    Party(){
		return Consignor Party;
	}

    public String getCustomizationID() {
        return CustomizationID;
    }

    public BigDecimal getDeclaredCarriageValueAmount() {
        return DeclaredCarriageValueAmount;
    }

    public String getDescription() {
        return Description;
    }

    public Document Distribution

    getDocument Distribution(){
		return m_Document Distribution;
	}

    public DocumentReference

    getDocumentReference(){
		return m_DocumentReference;
	}

    public Exchange Rate

    getExchange Rate(){
		return m_Exchange Rate;
	}

    public Party getFreight

    Forwarder Party(){
		return Freight Forwarder Party;
	}

    public String getID() {
        return ID;
    }

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public LocalTime getIssueTime() {
        return IssueTime;
    }

    public String getName() {
        return Name;
    }

    public String getNote() {
        return Note;
    }

    public String getOtherInstruction() {
        return OtherInstruction;
    }

    public String getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public String getProfileID() {
        return ProfileID;
    }

    public Shipment getShipment() {
        return m_Shipment;
    }

    public String getShippingOrderID() {
        return ShippingOrderID;
    }

    public Signature getSignature() {
        return m_Signature;
    }

    public String getUBLVersionID() {
        return UBLVersionID;
    }

    public String getUUID() {
        return UUID;
    }

    /**
     * 
     * @param newVal
     */
    public void setAdValoremIndicator(boolean newVal) {
        AdValoremIndicator = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setCarrier

    Party(Party newVal){
		Carrier Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setCarrierAssignedID(String newVal) {
        CarrierAssignedID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setConsignor

    Party(Party newVal){
		Consignor Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setCustomizationID(String newVal) {
        CustomizationID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDeclaredCarriageValueAmount(BigDecimal newVal) {
        DeclaredCarriageValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setDocument

    Distribution(Document Distribution newVal){
		m_Document Distribution = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setDocument

    Reference(DocumentReference newVal){
		m_DocumentReference = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setExchange

    Rate(Exchange Rate newVal){
		m_Exchange Rate = newVal;
	}

    /**
	 * 
	 * @param newVal
	 */
	public void setFreight

    Forwarder Party(Party newVal){
		Freight Forwarder Party = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueDate(LocalDate newVal) {
        IssueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueTime(LocalTime newVal) {
        IssueTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setName(String newVal) {
        Name = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(String newVal) {
        Note = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOtherInstruction(String newVal) {
        OtherInstruction = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileExecutionID(String newVal) {
        ProfileExecutionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileID(String newVal) {
        ProfileID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setShipment(Shipment newVal) {
        m_Shipment = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setShippingOrderID(String newVal) {
        ShippingOrderID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setSignature(Signature newVal) {
        m_Signature = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUBLVersionID(String newVal) {
        UBLVersionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUUID(String newVal) {
        UUID = newVal;
    }
}// end Waybill