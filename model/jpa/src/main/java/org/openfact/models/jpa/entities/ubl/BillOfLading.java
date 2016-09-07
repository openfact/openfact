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

	private boolean adValoremIndicator;
	private String carrierAssignedID;
	private String customizationID;
	private BigDecimal declaredCarriageValueAmount;
	private String description;
	private DocumentStatus documentStatusCode;
	private String ID;
	private LocalDate issueDate;
	private LocalTime issueTime;
	private String name;
	private String note;
	private String otherInstruction;
	private String profileExecutionID;
	private String profileID;
	private String shippingOrderID;
	private boolean toOrderIndicator;
	private String UBLVersionID;
	private String UUID;
	private List<DocumentDistribution> documentDistributions=new ArrayList<>();
	private List<DocumentReference> documentReferences=new ArrayList<>();
	private List<ExchangeRate> exchangeRates=new ArrayList<>();
	private Party consignorParty;
	private Party carrierParty;
	private Party freightForwarderParty;
	private List<Shipment> shipments=new ArrayList<>();
	private List<Signature> signatures=new ArrayList<>();

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

	public DocumentStatus getDocumentStatusCode() {
		return documentStatusCode;
	}

	public void setDocumentStatusCode(DocumentStatus documentStatusCode) {
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