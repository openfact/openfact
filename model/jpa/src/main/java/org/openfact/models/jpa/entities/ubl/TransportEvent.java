package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a significant occurrence or happening related to the
 * transportation of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:42 a. m.
 */
public class TransportEvent {

    /**
     * An indicator that this transport event has been completed (true) or not
     * (false).
     */
    private boolean CompletionIndicator;
    /**
     * Text describing this transport event.
     */
    private String Description;
    /**
     * An identifier for this transport event within an agreed event
     * identification scheme.
     */
    private String IdentificationID;
    /**
     * The date of this transport event.
     */
    private LocalDate OccurrenceDate;
    /**
     * The time of this transport event.
     */
    private LocalTime OccurrenceTime;
    /**
     * A code signifying the type of this transport event.
     */
    private String TransportEventTypeCode;
    private List<Contact> contacts = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<Period> periods = new ArrayList<>();
    private Shipment ReportedShipment;
    private Status CurrentStatus;
    private List<Signature> signatures = new ArrayList<>();

    /**
     * @return the completionIndicator
     */
    public boolean isCompletionIndicator() {
        return CompletionIndicator;
    }

    /**
     * @param completionIndicator
     *            the completionIndicator to set
     */
    public void setCompletionIndicator(boolean completionIndicator) {
        CompletionIndicator = completionIndicator;
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
     * @return the identificationID
     */
    public String getIdentificationID() {
        return IdentificationID;
    }

    /**
     * @param identificationID
     *            the identificationID to set
     */
    public void setIdentificationID(String identificationID) {
        IdentificationID = identificationID;
    }

    /**
     * @return the occurrenceDate
     */
    public LocalDate getOccurrenceDate() {
        return OccurrenceDate;
    }

    /**
     * @param occurrenceDate
     *            the occurrenceDate to set
     */
    public void setOccurrenceDate(LocalDate occurrenceDate) {
        OccurrenceDate = occurrenceDate;
    }

    /**
     * @return the occurrenceTime
     */
    public LocalTime getOccurrenceTime() {
        return OccurrenceTime;
    }

    /**
     * @param occurrenceTime
     *            the occurrenceTime to set
     */
    public void setOccurrenceTime(LocalTime occurrenceTime) {
        OccurrenceTime = occurrenceTime;
    }

    /**
     * @return the transportEventTypeCode
     */
    public String getTransportEventTypeCode() {
        return TransportEventTypeCode;
    }

    /**
     * @param transportEventTypeCode
     *            the transportEventTypeCode to set
     */
    public void setTransportEventTypeCode(String transportEventTypeCode) {
        TransportEventTypeCode = transportEventTypeCode;
    }

    /**
     * @return the contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param contacts
     *            the contacts to set
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * @return the locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * @param locations
     *            the locations to set
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * @return the periods
     */
    public List<Period> getPeriods() {
        return periods;
    }

    /**
     * @param periods
     *            the periods to set
     */
    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    /**
     * @return the reportedShipment
     */
    public Shipment getReportedShipment() {
        return ReportedShipment;
    }

    /**
     * @param reportedShipment
     *            the reportedShipment to set
     */
    public void setReportedShipment(Shipment reportedShipment) {
        ReportedShipment = reportedShipment;
    }

    /**
     * @return the currentStatus
     */
    public Status getCurrentStatus() {
        return CurrentStatus;
    }

    /**
     * @param currentStatus
     *            the currentStatus to set
     */
    public void setCurrentStatus(Status currentStatus) {
        CurrentStatus = currentStatus;
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

}// end TransportEvent