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
    private String CarrierAssignedID;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * A textual description of transportation status.
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
     * An instruction regarding this message.
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
     * A reference number for a shipping order.
     */
    private String ShippingOrderID;
    /**
     * A code signifying the type of status provided in a Transportation Status
     * document.
     */
    private String TransportationStatusTypeCode;
    /**
     * A code signifying the overall status of transport service execution.
     */
    private String TransportExecutionStatusCode;
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
    private List<Consignment> consignments = new ArrayList<>();
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private DocumentReference TransportationStatusRequestDocumentReference;
    private DocumentReference TransportExecutionPlanDocumentReference;
    private Location StatusLocation;
    private Party ReceiverParty;
    private Party SenderParty;
    private Period StatusPeriod;
    private List<Signature> signatures = new ArrayList<>();
    private List<TransportEvent> transportEvents = new ArrayList<>();
    private TransportEvent UpdatedPickupTransportEvent;
    private TransportEvent UpdatedDeliveryTransportEvent;

    /**
     * @return the carrierAssignedID
     */
    public String getCarrierAssignedID() {
        return CarrierAssignedID;
    }

    /**
     * @param carrierAssignedID
     *            the carrierAssignedID to set
     */
    public void setCarrierAssignedID(String carrierAssignedID) {
        CarrierAssignedID = carrierAssignedID;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return CustomizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        CustomizationID = customizationID;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return IssueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        IssueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return IssueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        IssueTime = issueTime;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the otherInstruction
     */
    public String getOtherInstruction() {
        return OtherInstruction;
    }

    /**
     * @param otherInstruction
     *            the otherInstruction to set
     */
    public void setOtherInstruction(String otherInstruction) {
        OtherInstruction = otherInstruction;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return ProfileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        ProfileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return ProfileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        ProfileID = profileID;
    }

    /**
     * @return the shippingOrderID
     */
    public String getShippingOrderID() {
        return ShippingOrderID;
    }

    /**
     * @param shippingOrderID
     *            the shippingOrderID to set
     */
    public void setShippingOrderID(String shippingOrderID) {
        ShippingOrderID = shippingOrderID;
    }

    /**
     * @return the transportationStatusTypeCode
     */
    public String getTransportationStatusTypeCode() {
        return TransportationStatusTypeCode;
    }

    /**
     * @param transportationStatusTypeCode
     *            the transportationStatusTypeCode to set
     */
    public void setTransportationStatusTypeCode(String transportationStatusTypeCode) {
        TransportationStatusTypeCode = transportationStatusTypeCode;
    }

    /**
     * @return the transportExecutionStatusCode
     */
    public String getTransportExecutionStatusCode() {
        return TransportExecutionStatusCode;
    }

    /**
     * @param transportExecutionStatusCode
     *            the transportExecutionStatusCode to set
     */
    public void setTransportExecutionStatusCode(String transportExecutionStatusCode) {
        TransportExecutionStatusCode = transportExecutionStatusCode;
    }

    /**
     * @return the uBLVersionID
     */
    public String getUBLVersionID() {
        return UBLVersionID;
    }

    /**
     * @param uBLVersionID
     *            the uBLVersionID to set
     */
    public void setUBLVersionID(String uBLVersionID) {
        UBLVersionID = uBLVersionID;
    }

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
     * @return the consignments
     */
    public List<Consignment> getConsignments() {
        return consignments;
    }

    /**
     * @param consignments
     *            the consignments to set
     */
    public void setConsignments(List<Consignment> consignments) {
        this.consignments = consignments;
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
     * @return the transportationStatusRequestDocumentReference
     */
    public DocumentReference getTransportationStatusRequestDocumentReference() {
        return TransportationStatusRequestDocumentReference;
    }

    /**
     * @param transportationStatusRequestDocumentReference
     *            the transportationStatusRequestDocumentReference to set
     */
    public void setTransportationStatusRequestDocumentReference(
            DocumentReference transportationStatusRequestDocumentReference) {
        TransportationStatusRequestDocumentReference = transportationStatusRequestDocumentReference;
    }

    /**
     * @return the transportExecutionPlanDocumentReference
     */
    public DocumentReference getTransportExecutionPlanDocumentReference() {
        return TransportExecutionPlanDocumentReference;
    }

    /**
     * @param transportExecutionPlanDocumentReference
     *            the transportExecutionPlanDocumentReference to set
     */
    public void setTransportExecutionPlanDocumentReference(
            DocumentReference transportExecutionPlanDocumentReference) {
        TransportExecutionPlanDocumentReference = transportExecutionPlanDocumentReference;
    }

    /**
     * @return the statusLocation
     */
    public Location getStatusLocation() {
        return StatusLocation;
    }

    /**
     * @param statusLocation
     *            the statusLocation to set
     */
    public void setStatusLocation(Location statusLocation) {
        StatusLocation = statusLocation;
    }

    /**
     * @return the receiverParty
     */
    public Party getReceiverParty() {
        return ReceiverParty;
    }

    /**
     * @param receiverParty
     *            the receiverParty to set
     */
    public void setReceiverParty(Party receiverParty) {
        ReceiverParty = receiverParty;
    }

    /**
     * @return the senderParty
     */
    public Party getSenderParty() {
        return SenderParty;
    }

    /**
     * @param senderParty
     *            the senderParty to set
     */
    public void setSenderParty(Party senderParty) {
        SenderParty = senderParty;
    }

    /**
     * @return the statusPeriod
     */
    public Period getStatusPeriod() {
        return StatusPeriod;
    }

    /**
     * @param statusPeriod
     *            the statusPeriod to set
     */
    public void setStatusPeriod(Period statusPeriod) {
        StatusPeriod = statusPeriod;
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

    /**
     * @return the transportEvents
     */
    public List<TransportEvent> getTransportEvents() {
        return transportEvents;
    }

    /**
     * @param transportEvents
     *            the transportEvents to set
     */
    public void setTransportEvents(List<TransportEvent> transportEvents) {
        this.transportEvents = transportEvents;
    }

    /**
     * @return the updatedPickupTransportEvent
     */
    public TransportEvent getUpdatedPickupTransportEvent() {
        return UpdatedPickupTransportEvent;
    }

    /**
     * @param updatedPickupTransportEvent
     *            the updatedPickupTransportEvent to set
     */
    public void setUpdatedPickupTransportEvent(TransportEvent updatedPickupTransportEvent) {
        UpdatedPickupTransportEvent = updatedPickupTransportEvent;
    }

    /**
     * @return the updatedDeliveryTransportEvent
     */
    public TransportEvent getUpdatedDeliveryTransportEvent() {
        return UpdatedDeliveryTransportEvent;
    }

    /**
     * @param updatedDeliveryTransportEvent
     *            the updatedDeliveryTransportEvent to set
     */
    public void setUpdatedDeliveryTransportEvent(TransportEvent updatedDeliveryTransportEvent) {
        UpdatedDeliveryTransportEvent = updatedDeliveryTransportEvent;
    }

}// end Transportation Status