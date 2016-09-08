package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

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

	/**
	 * A term used in commerce in reference to certain duties, called ad valorem
	 * duties, which are levied on commodities at certain rates per centum on their
	 * value.
	 */
	private IndicatorType adValoremIndicator;
	/**
	 * Reference number (such as a booking reference number) assigned by a carrier or
	 * its agent to identify a specific shipment when cargo space is reserved prior to
	 * loading.
	 */
	private IdentifierType carrierAssignedID;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
	/**
	 * Value declared by the shipper or his agent solely for the purpose of varying
	 * the carrier's level of liability from that provided in the contract of carriage
	 * in case of loss or damage to goods or delayed delivery.
	 */
	private AmountType declaredCarriageValueAmount;
	/**
	 * Textual description of the document instance.
	 */
	private TextType description;
	/**
	 * A code signifying the status of the Bill Of Lading (revision, replacement, etc.
	 * ).
	 */
	private DocumentStatusCodeType documentStatusCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType id;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime;
	/**
	 * Text, assigned by the sender, that identifies this document to business users.
	 */
	private NameType name;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * Other free-text instructions to the forwarders or carriers related to the
	 * shipment. This element should only be used where such information cannot be
	 * represented in other structured information entities within the document.
	 */
	private TextType otherInstruction;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * Reference number to identify a Shipping Order or Forwarding Instruction.
	 */
	private IdentifierType shippingOrderID;
	/**
	 * Indicates whether the transport document is consigned to order.
	 */
	private IndicatorType toOrderIndicator;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType ublVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<DocumentDistribution> documentDistributions=new ArrayList<>();
	private List<DocumentReference> documentReferences=new ArrayList<>();
	private List<ExchangeRate> exchangeRates=new ArrayList<>();
	private Party consignorParty;
	private Party carrierParty;
	private Party freightForwarderParty;
	private List<Shipment> shipments=new ArrayList<>();
	private List<Signature> signatures=new ArrayList<>();

	public IndicatorType getAdValoremIndicator() {
		return adValoremIndicator;
	}

	public void setAdValoremIndicator(IndicatorType adValoremIndicator) {
		this.adValoremIndicator = adValoremIndicator;
	}

	public IdentifierType getCarrierAssignedID() {
		return carrierAssignedID;
	}

	public void setCarrierAssignedID(IdentifierType carrierAssignedID) {
		this.carrierAssignedID = carrierAssignedID;
	}

	public IdentifierType getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(IdentifierType customizationID) {
		this.customizationID = customizationID;
	}

	public AmountType getDeclaredCarriageValueAmount() {
		return declaredCarriageValueAmount;
	}

	public void setDeclaredCarriageValueAmount(AmountType declaredCarriageValueAmount) {
		this.declaredCarriageValueAmount = declaredCarriageValueAmount;
	}

	public TextType getDescription() {
		return description;
	}

	public void setDescription(TextType description) {
		this.description = description;
	}

	public DocumentStatusCodeType getDocumentStatusCode() {
		return documentStatusCode;
	}

	public void setDocumentStatusCode(DocumentStatusCodeType documentStatusCode) {
		this.documentStatusCode = documentStatusCode;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public DateType getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(DateType issueDate) {
		this.issueDate = issueDate;
	}

	public TimeType getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(TimeType issueTime) {
		this.issueTime = issueTime;
	}

	public NameType getName() {
		return name;
	}

	public void setName(NameType name) {
		this.name = name;
	}

	public TextType getNote() {
		return note;
	}

	public void setNote(TextType note) {
		this.note = note;
	}

	public TextType getOtherInstruction() {
		return otherInstruction;
	}

	public void setOtherInstruction(TextType otherInstruction) {
		this.otherInstruction = otherInstruction;
	}

	public IdentifierType getProfileExecutionID() {
		return profileExecutionID;
	}

	public void setProfileExecutionID(IdentifierType profileExecutionID) {
		this.profileExecutionID = profileExecutionID;
	}

	public IdentifierType getProfileID() {
		return profileID;
	}

	public void setProfileID(IdentifierType profileID) {
		this.profileID = profileID;
	}

	public IdentifierType getShippingOrderID() {
		return shippingOrderID;
	}

	public void setShippingOrderID(IdentifierType shippingOrderID) {
		this.shippingOrderID = shippingOrderID;
	}

	public IndicatorType getToOrderIndicator() {
		return toOrderIndicator;
	}

	public void setToOrderIndicator(IndicatorType toOrderIndicator) {
		this.toOrderIndicator = toOrderIndicator;
	}

	public IdentifierType getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(IdentifierType ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public IdentifierType getUUID() {
		return UUID;
	}

	public void setUUID(IdentifierType UUID) {
		this.UUID = UUID;
	}

	public List<DocumentDistribution> getDocumentDistributions() {
		return documentDistributions;
	}

	public void setDocumentDistributions(List<DocumentDistribution> documentDistributions) {
		this.documentDistributions = documentDistributions;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<ExchangeRate> getExchangeRates() {
		return exchangeRates;
	}

	public void setExchangeRates(List<ExchangeRate> exchangeRates) {
		this.exchangeRates = exchangeRates;
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

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public List<Signature> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<Signature> signatures) {
		this.signatures = signatures;
	}
}// end Bill Of Lading