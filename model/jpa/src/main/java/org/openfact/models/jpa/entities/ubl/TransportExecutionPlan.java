package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used in the negotiation of a transport service between a transport
 * user and a transport service provider.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:37 a. m.
 */
public class TransportExecutionPlan {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String customizationID;
    /**
     * A code signifying the status of the Transport Execution Plan (updated,
     * cancelled, confirmed, etc.)
     */
    private String documentStatusCode;
    /**
     * A code signifying a reason associated with the status of a Transport
     * Execution Plan.
     */
    private String documentStatusReasonCode;
    /**
     * A reason for the status assigned to the Transport Execution Plan,
     * expressed in text.
     */
    private String documentStatusReasonDescription;
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
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
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
     * Remarks from the transport service provider regarding the transport
     * operations referred to in the Transport Execution Plan.
     */
    private String transportServiceProviderRemarks;
    /**
     * Remarks from the transport user regarding the transport operations
     * referred to in the Transport Execution Plan.
     */
    private String transportUserRemarks;
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
    /**
     * Indicates the current version of the Transport Execution Plan.
     */
    private String versionID;
    private List<Consignment> consignments = new ArrayList<>();
    private Contract transportContract;
    private DocumentReference transportExecutionPlanDocumentReference;
    private DocumentReference transportExecutionPlanRequestDocumentReference;
    private DocumentReference transportServiceDescriptionDocumentReference;
    private DocumentReference additionalDocumentReference;
    private Location toLocation;
    private Location fromLocation;
    private Location atLocation;
    private Party senderParty;
    private Party transportUserParty;
    private Party receiverParty;
    private Party billToParty;
    private Party transportServiceProviderParty;
    private Period serviceStartTimePeriod;
    private Period serviceEndTimePeriod;
    private Period validityPeriod;
    private Period transportUserResponseRequiredPeriod;
    private Period transportServiceProviderResponseRequiredPeriod;
    private List<Signature> signatures = new ArrayList<>();
    private List<TransportExecutionTerms> transportExecutionTerms = new ArrayList<>();
    private TransportationService additionalTransportationService;
    private TransportationService mainTransportationService;

    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    public String getCustomizationID() {
        return customizationID;
    }

    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    public String getDocumentStatusCode() {
        return documentStatusCode;
    }

    public void setDocumentStatusCode(String documentStatusCode) {
        this.documentStatusCode = documentStatusCode;
    }

    public String getDocumentStatusReasonCode() {
        return documentStatusReasonCode;
    }

    public void setDocumentStatusReasonCode(String documentStatusReasonCode) {
        this.documentStatusReasonCode = documentStatusReasonCode;
    }

    public String getDocumentStatusReasonDescription() {
        return documentStatusReasonDescription;
    }

    public void setDocumentStatusReasonDescription(String documentStatusReasonDescription) {
        this.documentStatusReasonDescription = documentStatusReasonDescription;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public String getTransportServiceProviderRemarks() {
        return transportServiceProviderRemarks;
    }

    public void setTransportServiceProviderRemarks(String transportServiceProviderRemarks) {
        this.transportServiceProviderRemarks = transportServiceProviderRemarks;
    }

    public String getTransportUserRemarks() {
        return transportUserRemarks;
    }

    public void setTransportUserRemarks(String transportUserRemarks) {
        this.transportUserRemarks = transportUserRemarks;
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

    public String getVersionID() {
        return versionID;
    }

    public void setVersionID(String versionID) {
        this.versionID = versionID;
    }

    public List<Consignment> getConsignments() {
        return consignments;
    }

    public void setConsignments(List<Consignment> consignments) {
        this.consignments = consignments;
    }

    public Contract getTransportContract() {
        return transportContract;
    }

    public void setTransportContract(Contract transportContract) {
        this.transportContract = transportContract;
    }

    public DocumentReference getTransportExecutionPlanDocumentReference() {
        return transportExecutionPlanDocumentReference;
    }

    public void setTransportExecutionPlanDocumentReference(DocumentReference transportExecutionPlanDocumentReference) {
        this.transportExecutionPlanDocumentReference = transportExecutionPlanDocumentReference;
    }

    public DocumentReference getTransportExecutionPlanRequestDocumentReference() {
        return transportExecutionPlanRequestDocumentReference;
    }

    public void setTransportExecutionPlanRequestDocumentReference(DocumentReference transportExecutionPlanRequestDocumentReference) {
        this.transportExecutionPlanRequestDocumentReference = transportExecutionPlanRequestDocumentReference;
    }

    public DocumentReference getTransportServiceDescriptionDocumentReference() {
        return transportServiceDescriptionDocumentReference;
    }

    public void setTransportServiceDescriptionDocumentReference(DocumentReference transportServiceDescriptionDocumentReference) {
        this.transportServiceDescriptionDocumentReference = transportServiceDescriptionDocumentReference;
    }

    public DocumentReference getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getAtLocation() {
        return atLocation;
    }

    public void setAtLocation(Location atLocation) {
        this.atLocation = atLocation;
    }

    public Party getSenderParty() {
        return senderParty;
    }

    public void setSenderParty(Party senderParty) {
        this.senderParty = senderParty;
    }

    public Party getTransportUserParty() {
        return transportUserParty;
    }

    public void setTransportUserParty(Party transportUserParty) {
        this.transportUserParty = transportUserParty;
    }

    public Party getReceiverParty() {
        return receiverParty;
    }

    public void setReceiverParty(Party receiverParty) {
        this.receiverParty = receiverParty;
    }

    public Party getBillToParty() {
        return billToParty;
    }

    public void setBillToParty(Party billToParty) {
        this.billToParty = billToParty;
    }

    public Party getTransportServiceProviderParty() {
        return transportServiceProviderParty;
    }

    public void setTransportServiceProviderParty(Party transportServiceProviderParty) {
        this.transportServiceProviderParty = transportServiceProviderParty;
    }

    public Period getServiceStartTimePeriod() {
        return serviceStartTimePeriod;
    }

    public void setServiceStartTimePeriod(Period serviceStartTimePeriod) {
        this.serviceStartTimePeriod = serviceStartTimePeriod;
    }

    public Period getServiceEndTimePeriod() {
        return serviceEndTimePeriod;
    }

    public void setServiceEndTimePeriod(Period serviceEndTimePeriod) {
        this.serviceEndTimePeriod = serviceEndTimePeriod;
    }

    public Period getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Period validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public Period getTransportUserResponseRequiredPeriod() {
        return transportUserResponseRequiredPeriod;
    }

    public void setTransportUserResponseRequiredPeriod(Period transportUserResponseRequiredPeriod) {
        this.transportUserResponseRequiredPeriod = transportUserResponseRequiredPeriod;
    }

    public Period getTransportServiceProviderResponseRequiredPeriod() {
        return transportServiceProviderResponseRequiredPeriod;
    }

    public void setTransportServiceProviderResponseRequiredPeriod(Period transportServiceProviderResponseRequiredPeriod) {
        this.transportServiceProviderResponseRequiredPeriod = transportServiceProviderResponseRequiredPeriod;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public List<TransportExecutionTerms> getTransportExecutionTerms() {
        return transportExecutionTerms;
    }

    public void setTransportExecutionTerms(List<TransportExecutionTerms> transportExecutionTerms) {
        this.transportExecutionTerms = transportExecutionTerms;
    }

    public TransportationService getAdditionalTransportationService() {
        return additionalTransportationService;
    }

    public void setAdditionalTransportationService(TransportationService additionalTransportationService) {
        this.additionalTransportationService = additionalTransportationService;
    }

    public TransportationService getMainTransportationService() {
        return mainTransportationService;
    }

    public void setMainTransportationService(TransportationService mainTransportationService) {
        this.mainTransportationService = mainTransportationService;
    }
}// end Transport Execution Plan