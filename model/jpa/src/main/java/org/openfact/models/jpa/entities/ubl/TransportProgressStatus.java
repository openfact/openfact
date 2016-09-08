package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document sent from a Transportation Network Manager to a Transport Service
 * Provider giving the status of the whereabouts and schedule of the transport
 * means involved in a transport service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:40 a. m.
 */
public class TransportProgressStatus {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String customizationID;
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
     * Indicates whether transport progress information is available.
     */
    private boolean statusAvailableIndicator;
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
    private DocumentReference transportProgressStatusRequestDocumentReference;
    private Party senderParty;
    private Party receiverParty;
    private Party sourceIssuerParty;
    private List<Signature> signatures = new ArrayList<>();
    private List<TransportMeans> transportMeans = new ArrayList<>();
    private List<TransportSchedule> transportSchedules = new ArrayList<>();

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
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
     * @return the statusAvailableIndicator
     */
    public boolean isStatusAvailableIndicator() {
        return statusAvailableIndicator;
    }

    /**
     * @param statusAvailableIndicator
     *            the statusAvailableIndicator to set
     */
    public void setStatusAvailableIndicator(boolean statusAvailableIndicator) {
        this.statusAvailableIndicator = statusAvailableIndicator;
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
     * @return the transportProgressStatusRequestDocumentReference
     */
    public DocumentReference getTransportProgressStatusRequestDocumentReference() {
        return transportProgressStatusRequestDocumentReference;
    }

    /**
     * @param transportProgressStatusRequestDocumentReference
     *            the transportProgressStatusRequestDocumentReference to set
     */
    public void setTransportProgressStatusRequestDocumentReference(
            DocumentReference transportProgressStatusRequestDocumentReference) {
        this.transportProgressStatusRequestDocumentReference = transportProgressStatusRequestDocumentReference;
    }

    /**
     * @return the senderParty
     */
    public Party getSenderParty() {
        return senderParty;
    }

    /**
     * @param senderParty
     *            the senderParty to set
     */
    public void setSenderParty(Party senderParty) {
        this.senderParty = senderParty;
    }

    /**
     * @return the receiverParty
     */
    public Party getReceiverParty() {
        return receiverParty;
    }

    /**
     * @param receiverParty
     *            the receiverParty to set
     */
    public void setReceiverParty(Party receiverParty) {
        this.receiverParty = receiverParty;
    }

    /**
     * @return the sourceIssuerParty
     */
    public Party getSourceIssuerParty() {
        return sourceIssuerParty;
    }

    /**
     * @param sourceIssuerParty
     *            the sourceIssuerParty to set
     */
    public void setSourceIssuerParty(Party sourceIssuerParty) {
        this.sourceIssuerParty = sourceIssuerParty;
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
     * @return the transportMeans
     */
    public List<TransportMeans> getTransportMeans() {
        return transportMeans;
    }

    /**
     * @param transportMeans
     *            the transportMeans to set
     */
    public void setTransportMeans(List<TransportMeans> transportMeans) {
        this.transportMeans = transportMeans;
    }

    /**
     * @return the transportSchedules
     */
    public List<TransportSchedule> getTransportSchedules() {
        return transportSchedules;
    }

    /**
     * @param transportSchedules
     *            the transportSchedules to set
     */
    public void setTransportSchedules(List<TransportSchedule> transportSchedules) {
        this.transportSchedules = transportSchedules;
    }

}