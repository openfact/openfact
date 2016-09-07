package org.openfact.models.jpa.entities.ubl;

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
    private Contact m_Contact;
    private Location m_Location;
    private Period m_Period;
    private Shipment ReportedShipment;
    private Status CurrentStatus;
    private Signature m_Signature;

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
     * @return the m_Contact
     */
    public Contact getM_Contact() {
        return m_Contact;
    }

    /**
     * @param m_Contact
     *            the m_Contact to set
     */
    public void setM_Contact(Contact m_Contact) {
        this.m_Contact = m_Contact;
    }

    /**
     * @return the m_Location
     */
    public Location getM_Location() {
        return m_Location;
    }

    /**
     * @param m_Location
     *            the m_Location to set
     */
    public void setM_Location(Location m_Location) {
        this.m_Location = m_Location;
    }

    /**
     * @return the m_Period
     */
    public Period getM_Period() {
        return m_Period;
    }

    /**
     * @param m_Period
     *            the m_Period to set
     */
    public void setM_Period(Period m_Period) {
        this.m_Period = m_Period;
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
     * @return the m_Signature
     */
    public Signature getM_Signature() {
        return m_Signature;
    }

    /**
     * @param m_Signature
     *            the m_Signature to set
     */
    public void setM_Signature(Signature m_Signature) {
        this.m_Signature = m_Signature;
    }

}// end TransportEvent