package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private boolean adValoremIndicator;
    /**
     * An identifier (in the form of a reference number) assigned by a carrier
     * or its agent to identify a specific shipment.
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
     * Text describing the contents of the Waybill.
     */
    private String description;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String id;
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
     * Other free-text instructions related to the shipment to the forwarders or
     * carriers. This should only be used where such information cannot be
     * represented in other structured information entities within the document.
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
     * An identifier (in the form of a reference number) of the Shipping Order
     * or Forwarding Instruction associated with this shipment.
     */
    private String shippingOrderID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String ublVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    private List<DocumentDistribution> documentDistributions = new ArrayList<>();
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
    private Party freightForwarderParty;
    private Party carrierParty;
    private Party consignorParty;
    private List<Shipment> shipments = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();

    /**
     * @return the adValoremIndicator
     */
    public boolean isAdValoremIndicator() {
        return adValoremIndicator;
    }

    /**
     * @param adValoremIndicator
     *            the adValoremIndicator to set
     */
    public void setAdValoremIndicator(boolean adValoremIndicator) {
        this.adValoremIndicator = adValoremIndicator;
    }

    /**
     * @return the carrierAssignedID
     */
    public String getCarrierAssignedID() {
        return carrierAssignedID;
    }

    /**
     * @param carrierAssignedID
     *            the carrierAssignedID to set
     */
    public void setCarrierAssignedID(String carrierAssignedID) {
        this.carrierAssignedID = carrierAssignedID;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the declaredCarriageValueAmount
     */
    public BigDecimal getDeclaredCarriageValueAmount() {
        return declaredCarriageValueAmount;
    }

    /**
     * @param declaredCarriageValueAmount
     *            the declaredCarriageValueAmount to set
     */
    public void setDeclaredCarriageValueAmount(BigDecimal declaredCarriageValueAmount) {
        this.declaredCarriageValueAmount = declaredCarriageValueAmount;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the otherInstruction
     */
    public String getOtherInstruction() {
        return otherInstruction;
    }

    /**
     * @param otherInstruction
     *            the otherInstruction to set
     */
    public void setOtherInstruction(String otherInstruction) {
        this.otherInstruction = otherInstruction;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return profileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return profileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the shippingOrderID
     */
    public String getShippingOrderID() {
        return shippingOrderID;
    }

    /**
     * @param shippingOrderID
     *            the shippingOrderID to set
     */
    public void setShippingOrderID(String shippingOrderID) {
        this.shippingOrderID = shippingOrderID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUblVersionID() {
        return ublVersionID;
    }

    public void setUblVersionID(String ublVersionID) {
        this.ublVersionID = ublVersionID;
    }

    /**

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the documentDistributions
     */
    public List<DocumentDistribution> getDocumentDistributions() {
        return documentDistributions;
    }

    /**
     * @param documentDistributions
     *            the documentDistributions to set
     */
    public void setDocumentDistributions(List<DocumentDistribution> documentDistributions) {
        this.documentDistributions = documentDistributions;
    }

    /**
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the exchangeRates
     */
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    /**
     * @param exchangeRates
     *            the exchangeRates to set
     */
    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    /**
     * @return the freightForwarderParty
     */
    public Party getFreightForwarderParty() {
        return freightForwarderParty;
    }

    /**
     * @param freightForwarderParty
     *            the freightForwarderParty to set
     */
    public void setFreightForwarderParty(Party freightForwarderParty) {
        this.freightForwarderParty = freightForwarderParty;
    }

    /**
     * @return the carrierParty
     */
    public Party getCarrierParty() {
        return carrierParty;
    }

    /**
     * @param carrierParty
     *            the carrierParty to set
     */
    public void setCarrierParty(Party carrierParty) {
        this.carrierParty = carrierParty;
    }

    /**
     * @return the consignorParty
     */
    public Party getConsignorParty() {
        return consignorParty;
    }

    /**
     * @param consignorParty
     *            the consignorParty to set
     */
    public void setConsignorParty(Party consignorParty) {
        this.consignorParty = consignorParty;
    }

    /**
     * @return the shipments
     */
    public List<Shipment> getShipments() {
        return shipments;
    }

    /**
     * @param shipments
     *            the shipments to set
     */
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    /**
     * @return the signatures
     */
    public List<Signature> getSignatures() {
        return signatures;
    }

    /**
     * @param signatures
     *            the signatures to set
     */
    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

}