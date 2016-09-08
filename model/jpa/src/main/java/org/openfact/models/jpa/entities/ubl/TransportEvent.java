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
    private boolean completionIndicator;
    /**
     * Text describing this transport event.
     */
    private String description;
    /**
     * An identifier for this transport event within an agreed event
     * identification scheme.
     */
    private String identificationID;
    /**
     * The date of this transport event.
     */
    private LocalDate occurrenceDate;
    /**
     * The time of this transport event.
     */
    private LocalTime occurrenceTime;
    /**
     * A code signifying the type of this transport event.
     */
    private String transportEventTypeCode;
    private List<Contact> contacts = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<Period> periods = new ArrayList<>();
    private Shipment reportedShipment;
    private Status currentStatus;
    private List<Signature> signatures = new ArrayList<>();

    public boolean isCompletionIndicator() {
        return completionIndicator;
    }

    public void setCompletionIndicator(boolean completionIndicator) {
        this.completionIndicator = completionIndicator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentificationID() {
        return identificationID;
    }

    public void setIdentificationID(String identificationID) {
        this.identificationID = identificationID;
    }

    public LocalDate getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(LocalDate occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public LocalTime getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(LocalTime occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getTransportEventTypeCode() {
        return transportEventTypeCode;
    }

    public void setTransportEventTypeCode(String transportEventTypeCode) {
        this.transportEventTypeCode = transportEventTypeCode;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    public Shipment getReportedShipment() {
        return reportedShipment;
    }

    public void setReportedShipment(Shipment reportedShipment) {
        this.reportedShipment = reportedShipment;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }
}// end TransportEvent