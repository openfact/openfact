package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document issued by the party who acts as an agent for a transportation
 * carrier or other agents to the party who gives instructions for the
 * transportation services (shipper, consignor, etc.) stating the details of the
 * transportation, charges, and terms a
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:12 a. m.
 */
public class BillOfLading {

	private boolean AdValoremIndicator;
	private String CarrierAssignedID;
	private String CustomizationID;
	private BigDecimal DeclaredCarriageValueAmount;
	private String Description;
	private DocumentStatus _StringDocumentStatusCode;
	private String ID;
	private LocalDate IssueDate;
	private LocalTime IssueTime;
	private String Name;
	private String Note;
	private String OtherInstruction;
	private String ProfileExecutionID;
	private String ProfileID;
	private String ShippingOrderID;
	private boolean ToOrderIndicator;
	private String UBLVersionID;
	private String UUID;
	private DocumentDistribution m_DocumentDistribution;
	private DocumentReference m_DocumentReference;
	private ExchangeRate m_ExchangeRate;
	private Party consignorParty;
	private Party carrierParty;
	private Party freightForwarderParty;
	private Shipment m_Shipment;
	private List<Signature> signatures = new ArrayList<>();

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on
	 * their value.
	 */
	public boolean isAdValoremIndicator() {
		return AdValoremIndicator;
	}

	public void setAdValoremIndicator(boolean adValoremIndicator) {
		AdValoremIndicator = adValoremIndicator;
	}

	/**
	 * Reference number (such as a booking reference number) assigned by a
	 * carrier or its agent to identify a specific shipment when cargo space is
	 * reserved prior to loading.
	 */
	public String getCarrierAssignedID() {
		return CarrierAssignedID;
	}

	public void setCarrierAssignedID(String carrierAssignedID) {
		CarrierAssignedID = carrierAssignedID;
	}

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	public String getCustomizationID() {
		return CustomizationID;
	}

	public void setCustomizationID(String customizationID) {
		CustomizationID = customizationID;
	}

	/**
	 * Value declared by the shipper or his agent solely for the purpose of
	 * varying the carrier's level of liability from that provided in the
	 * contract of carriage in case of loss or damage to goods or delayed
	 * delivery.
	 */
	public BigDecimal getDeclaredCarriageValueAmount() {
		return DeclaredCarriageValueAmount;
	}

	public void setDeclaredCarriageValueAmount(BigDecimal declaredCarriageValueAmount) {
		DeclaredCarriageValueAmount = declaredCarriageValueAmount;
	}

	/**
	 * Textual description of the document instance.
	 */
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	/**
	 * A code signifying the status of the Bill Of Lading (revision,
	 * replacement, etc. ).
	 */
	public DocumentStatus get_StringDocumentStatusCode() {
		return _StringDocumentStatusCode;
	}

	public void set_StringDocumentStatusCode(DocumentStatus _StringDocumentStatusCode) {
		this._StringDocumentStatusCode = _StringDocumentStatusCode;
	}

	/**
	 * An identifier for this document, assigned by the sender.
	 */
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	public LocalDate getIssueDate() {
		return IssueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		IssueDate = issueDate;
	}

	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	public LocalTime getIssueTime() {
		return IssueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		IssueTime = issueTime;
	}

	/**
	 * Text, assigned by the sender, that identifies this document to business
	 * users.
	 */
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	/**
	 * Other free-text instructions to the forwarders or carriers related to the
	 * shipment. This element should only be used where such information cannot
	 * be represented in other structured information entities within the
	 * document.
	 */
	public String getOtherInstruction() {
		return OtherInstruction;
	}

	public void setOtherInstruction(String otherInstruction) {
		OtherInstruction = otherInstruction;
	}

	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	public String getProfileExecutionID() {
		return ProfileExecutionID;
	}

	public void setProfileExecutionID(String profileExecutionID) {
		ProfileExecutionID = profileExecutionID;
	}

	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	public String getProfileID() {
		return ProfileID;
	}

	public void setProfileID(String profileID) {
		ProfileID = profileID;
	}

	/**
	 * Reference number to identify a Shipping Order or Forwarding Instruction.
	 */
	public String getShippingOrderID() {
		return ShippingOrderID;
	}

	public void setShippingOrderID(String shippingOrderID) {
		ShippingOrderID = shippingOrderID;
	}

	/**
	 * Indicates whether the transport document is consigned to order.
	 */
	public boolean isToOrderIndicator() {
		return ToOrderIndicator;
	}

	public void setToOrderIndicator(boolean toOrderIndicator) {
		ToOrderIndicator = toOrderIndicator;
	}

	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	/**
	 * A universally unique identifier for an instance of this document.
	 */
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public DocumentDistribution getM_DocumentDistribution() {
		return m_DocumentDistribution;
	}

	public void setM_DocumentDistribution(DocumentDistribution m_DocumentDistribution) {
		this.m_DocumentDistribution = m_DocumentDistribution;
	}

	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	public ExchangeRate getM_ExchangeRate() {
		return m_ExchangeRate;
	}

	public void setM_ExchangeRate(ExchangeRate m_ExchangeRate) {
		this.m_ExchangeRate = m_ExchangeRate;
	}

	public Party getConsignorParty() {
		return consignorParty;
	}

	public void setConsignorParty(Party consignorParty) {
		this.consignorParty = consignorParty;
	}

	public Party getCarrierParty() {
		return carrierParty;
	}

	public void setCarrierParty(Party carrierParty) {
		this.carrierParty = carrierParty;
	}

	public Party getFreightForwarderParty() {
		return freightForwarderParty;
	}

	public void setFreightForwarderParty(Party freightForwarderParty) {
		this.freightForwarderParty = freightForwarderParty;
	}

	public Shipment getM_Shipment() {
		return m_Shipment;
	}

	public void setM_Shipment(Shipment m_Shipment) {
		this.m_Shipment = m_Shipment;
	}

	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}
}// end Bill Of Lading