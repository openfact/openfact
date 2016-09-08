package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document to circulate reports of transportation status or changes in status
 * (events) among a group of participants.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:46 a. m.
 */
public class TransportationStatus {

    /**
     * A reference number assigned by a carrier or its agent to identify a
     * specific shipment, such as a booking reference number when cargo space is
     * reserved prior to loading.
     */
    private String carrierAssignedID;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String customizationID;
    /**
     * A textual description of transportation status.
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
     * An instruction regarding this message.
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
     * A reference number for a shipping order.
     */
    private String shippingOrderID;
    /**
     * A code signifying the type of status provided in a Transportation Status
     * document.
     */
    private String transportationStatusTypeCode;
    /**
     * A code signifying the overall status of transport service execution.
     */
    private String transportExecutionStatusCode;
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
    private List<Consignment> consignments = new ArrayList<>();
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private DocumentReference transportationStatusRequestDocumentReference;
    private DocumentReference transportExecutionPlanDocumentReference;
    private Location statusLocation;
    private Party receiverParty;
    private Party senderParty;
    private Period statusPeriod;
    private List<Signature> signatures = new ArrayList<>();
    private List<TransportEvent> transportEvents = new ArrayList<>();
    private TransportEvent updatedPickupTransportEvent;
    private TransportEvent updatedDeliveryTransportEvent;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTransportationStatusTypeCode() {
        return transportationStatusTypeCode;
    }

    public void setTransportationStatusTypeCode(String transportationStatusTypeCode) {
        this.transportationStatusTypeCode = transportationStatusTypeCode;
    }

    public String getTransportExecutionStatusCode() {
        return transportExecutionStatusCode;
    }

    public void setTransportExecutionStatusCode(String transportExecutionStatusCode) {
        this.transportExecutionStatusCode = transportExecutionStatusCode;
    }

    public String getUblVersionID() {
        return ublVersionID;
    }

    public void setUblVersionID(String ublVersionID) {
        this.ublVersionID = ublVersionID;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public List<Consignment> getConsignments() {
        return consignments;
    }

    public void setConsignments(List<Consignment> consignments) {
        this.consignments = consignments;
    }

    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    public DocumentReference getTransportationStatusRequestDocumentReference() {
        return transportationStatusRequestDocumentReference;
    }

    public void setTransportationStatusRequestDocumentReference(DocumentReference transportationStatusRequestDocumentReference) {
        this.transportationStatusRequestDocumentReference = transportationStatusRequestDocumentReference;
    }

    public DocumentReference getTransportExecutionPlanDocumentReference() {
        return transportExecutionPlanDocumentReference;
    }

    public void setTransportExecutionPlanDocumentReference(DocumentReference transportExecutionPlanDocumentReference) {
        this.transportExecutionPlanDocumentReference = transportExecutionPlanDocumentReference;
    }

    public Location getStatusLocation() {
        return statusLocation;
    }

    public void setStatusLocation(Location statusLocation) {
        this.statusLocation = statusLocation;
    }

    public Party getReceiverParty() {
        return receiverParty;
    }

    public void setReceiverParty(Party receiverParty) {
        this.receiverParty = receiverParty;
    }

    public Party getSenderParty() {
        return senderParty;
    }

    public void setSenderParty(Party senderParty) {
        this.senderParty = senderParty;
    }

    public Period getStatusPeriod() {
        return statusPeriod;
    }

    public void setStatusPeriod(Period statusPeriod) {
        this.statusPeriod = statusPeriod;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public List<TransportEvent> getTransportEvents() {
        return transportEvents;
    }

    public void setTransportEvents(List<TransportEvent> transportEvents) {
        this.transportEvents = transportEvents;
    }

    public TransportEvent getUpdatedPickupTransportEvent() {
        return updatedPickupTransportEvent;
    }

    public void setUpdatedPickupTransportEvent(TransportEvent updatedPickupTransportEvent) {
        this.updatedPickupTransportEvent = updatedPickupTransportEvent;
    }

    public TransportEvent getUpdatedDeliveryTransportEvent() {
        return updatedDeliveryTransportEvent;
    }

    public void setUpdatedDeliveryTransportEvent(TransportEvent updatedDeliveryTransportEvent) {
        this.updatedDeliveryTransportEvent = updatedDeliveryTransportEvent;
    }
}// end Transportation Status