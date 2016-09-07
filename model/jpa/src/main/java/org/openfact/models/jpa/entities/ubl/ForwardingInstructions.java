package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document issued to a forwarder, giving instructions regarding the action to
 * be taken for the forwarding of goods described therein. Forwarding
 * Instructions is used by any party who gives instructions for the
 * transportation services required for a consig
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:38 a. m.
 */
public class ForwardingInstructions {

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on
	 * their value.
	 */
	private boolean adValoremIndicator;
	/**
	 * Reference number assigned by a carrier or its agent to identify a
	 * specific shipment, such as a booking reference number when cargo space is
	 * reserved prior to loading.
	 */
	private String carrierAssignedID;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String customizationID;
	/**
	 * Value declared by the shipper or his agent solely for the purpose of
	 * varying the carrier's level of liability from that provided in the
	 * contract of carriage in case of loss or damage to goods or delayed
	 * delivery.
	 */
	private BigDecimal declaredCarriageValueAmount;
	/**
	 * Textual description of the document instance.
	 */
	private String description;
	/**
	 * A code signifying the status of the Forwarding Instructions with respect
	 * to its original state. This code may be used if the document precedes the
	 * event and is subsequently found to be incorrect and in need of
	 * cancellation or revision.
	 */
	private String documentStatusCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private String ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private LocalDate issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime;
	/**
	 * Text, assigned by the sender, that identifies this document to business
	 * users.
	 */
	private String name;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String note;
	/**
	 * Contains other free-text instructions to the forwarders or carriers
	 * related to the shipment. This should only be used where such information
	 * cannot be represented in other structured information entities within the
	 * document.
	 */
	private String otherInstruction;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private String profileID;
	/**
	 * Reference number to identify a Shipping Order.
	 */
	private String shippingOrderID;
	/**
	 * Indicates whether the transport document is consigned to order.
	 */
	private boolean toOrderIndicator;
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
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private List<ExchangeRate> exchangeRates = new ArrayList<>();
	private Party freightForwarderParty;
	private Party consignorParty;
	private Party carrierParty;
	private Shipment m_Shipment;
	private List<Signature> signatures = new ArrayList<>();

	public ForwardingInstructions() {

	}

	public void finalize() throws Throwable {

	}

	public boolean isAdValoremIndicator() {
		return adValoremIndicator;
	}

	public void setAdValoremIndicator(boolean adValoremIndicator) {
		this.adValoremIndicator = adValoremIndicator;
	}

	public String getCarrierAssignedID() {
		return carrierAssignedID;
	}

	public void setCarrierAssignedID(String carrierAssignedID) {
		this.carrierAssignedID = carrierAssignedID;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public BigDecimal getDeclaredCarriageValueAmount() {
		return declaredCarriageValueAmount;
	}

	public void setDeclaredCarriageValueAmount(BigDecimal declaredCarriageValueAmount) {
		this.declaredCarriageValueAmount = declaredCarriageValueAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentStatusCode() {
		return documentStatusCode;
	}

	public void setDocumentStatusCode(String documentStatusCode) {
		this.documentStatusCode = documentStatusCode;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalTime getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(LocalTime issueTime) {
		this.issueTime = issueTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOtherInstruction() {
		return otherInstruction;
	}

	public void setOtherInstruction(String otherInstruction) {
		this.otherInstruction = otherInstruction;
	}

	public String getProfileExecutionID() {
		return profileExecutionID;
	}

	public void setProfileExecutionID(String profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getShippingOrderID() {
		return shippingOrderID;
	}

	public void setShippingOrderID(String shippingOrderID) {
		this.shippingOrderID = shippingOrderID;
	}

	public boolean isToOrderIndicator() {
		return toOrderIndicator;
	}

	public void setToOrderIndicator(boolean toOrderIndicator) {
		this.toOrderIndicator = toOrderIndicator;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
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

	public Party getFreightForwarderParty() {
		return freightForwarderParty;
	}

	public void setFreightForwarderParty(Party freightForwarderParty) {
		this.freightForwarderParty = freightForwarderParty;
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
}// end Forwarding Instructions