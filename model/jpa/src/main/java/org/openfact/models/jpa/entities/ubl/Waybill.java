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
    private Indicator.Type AdValoremIndicator;
    /**
     * An identifier (in the form of a reference number) assigned by a carrier
     * or its agent to identify a specific shipment.
     */
    private Identifier.Type CarrierAssignedID;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private Identifier.Type CustomizationID;
    /**
     * Value declared by the shipper or his agent solely for the purpose of
     * varying the carrier's level of liability from that provided in the
     * contract of carriage in case of loss or damage to goods or delayed
     * delivery.
     */
    private Amount.Type DeclaredCarriageValueAmount;
    /**
     * Text describing the contents of the Waybill.
     */
    private Text.Type Description;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private Identifier.Type ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private Date.Type IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private Time.Type IssueTime;
    /**
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private Name.Type Name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private Text.Type Note;
    /**
     * Other free-text instructions related to the shipment to the forwarders or
     * carriers. This should only be used where such information cannot be
     * represented in other structured information entities within the document.
     */
    private Text.Type OtherInstruction;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private Identifier.Type ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private Identifier.Type ProfileID;
    /**
     * An identifier (in the form of a reference number) of the Shipping Order
     * or Forwarding Instruction associated with this shipment.
     */
    private Identifier.Type ShippingOrderID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private Identifier.Type UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private Identifier.Type UUID;
    private Document Distribution
    m_Document Distribution;
    private Document Reference
    m_Document Reference;
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

    public Indicator.Type getAdValoremIndicator() {
        return AdValoremIndicator;
    }

    public Party getCarrier

    Party(){
		return Carrier Party;
	}

    public Identifier.Type getCarrierAssignedID() {
        return CarrierAssignedID;
    }

    public Party getConsignor

    Party(){
		return Consignor Party;
	}

    public Identifier.Type getCustomizationID() {
        return CustomizationID;
    }

    public Amount.Type getDeclaredCarriageValueAmount() {
        return DeclaredCarriageValueAmount;
    }

    public Text.Type getDescription() {
        return Description;
    }

    public Document Distribution

    getDocument Distribution(){
		return m_Document Distribution;
	}

    public Document Reference

    getDocument Reference(){
		return m_Document Reference;
	}

    public Exchange Rate

    getExchange Rate(){
		return m_Exchange Rate;
	}

    public Party getFreight

    Forwarder Party(){
		return Freight Forwarder Party;
	}

    public Identifier.Type getID() {
        return ID;
    }

    public Date.Type getIssueDate() {
        return IssueDate;
    }

    public Time.Type getIssueTime() {
        return IssueTime;
    }

    public Name.Type getName() {
        return Name;
    }

    public Text.Type getNote() {
        return Note;
    }

    public Text.Type getOtherInstruction() {
        return OtherInstruction;
    }

    public Identifier.Type getProfileExecutionID() {
        return ProfileExecutionID;
    }

    public Identifier.Type getProfileID() {
        return ProfileID;
    }

    public Shipment getShipment() {
        return m_Shipment;
    }

    public Identifier.Type getShippingOrderID() {
        return ShippingOrderID;
    }

    public Signature getSignature() {
        return m_Signature;
    }

    public Identifier.Type getUBLVersionID() {
        return UBLVersionID;
    }

    public Identifier.Type getUUID() {
        return UUID;
    }

    /**
     * 
     * @param newVal
     */
    public void setAdValoremIndicator(Indicator.Type newVal) {
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
    public void setCarrierAssignedID(Identifier.Type newVal) {
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
    public void setCustomizationID(Identifier.Type newVal) {
        CustomizationID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDeclaredCarriageValueAmount(Amount.Type newVal) {
        DeclaredCarriageValueAmount = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDescription(Text.Type newVal) {
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

    Reference(Document Reference newVal){
		m_Document Reference = newVal;
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
    public void setID(Identifier.Type newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueDate(Date.Type newVal) {
        IssueDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIssueTime(Time.Type newVal) {
        IssueTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setName(Name.Type newVal) {
        Name = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setNote(Text.Type newVal) {
        Note = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOtherInstruction(Text.Type newVal) {
        OtherInstruction = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileExecutionID(Identifier.Type newVal) {
        ProfileExecutionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setProfileID(Identifier.Type newVal) {
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
    public void setShippingOrderID(Identifier.Type newVal) {
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
    public void setUBLVersionID(Identifier.Type newVal) {
        UBLVersionID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setUUID(Identifier.Type newVal) {
        UUID = newVal;
    }
}// end Waybill