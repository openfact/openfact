package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Describes the location and schedule relating to a transport means.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:49 a. m.
 */
public class TransportSchedule {

    /**
     * The reference date for the transport schedule status.
     */
    private LocalDate referenceDate;
    /**
     * The reference time for the transport schedule status.
     */
    private LocalTime referenceTime;
    /**
     * The reliability of the transport schedule status, expressed as a
     * percentage.
     */
    private BigDecimal reliabilityPercent;
    /**
     * Remarks related to the transport schedule status.
     */
    private String remarks;
    /**
     * A number indicating the order of this status in the sequence in which
     * statuses are to be presented.
     */
    private BigDecimal sequenceNumeric;
    private Location statusLocation;
    private TransportEvent actualDepartureTransportEvent;
    private TransportEvent estimatedDepartureTransportEvent;
    private TransportEvent estimatedArrivalTransportEvent;
    private TransportEvent plannedDepartureTransportEvent;
    private TransportEvent actualArrivalTransportEvent;
    private TransportEvent plannedArrivalTransportEvent;

    /**
     * @return the referenceDate
     */
    public LocalDate getReferenceDate() {
        return referenceDate;
    }

    /**
     * @param referenceDate
     *            the referenceDate to set
     */
    public void setReferenceDate(LocalDate referenceDate) {
        this.referenceDate = referenceDate;
    }

    /**
     * @return the referenceTime
     */
    public LocalTime getReferenceTime() {
        return referenceTime;
    }

    /**
     * @param referenceTime
     *            the referenceTime to set
     */
    public void setReferenceTime(LocalTime referenceTime) {
        this.referenceTime = referenceTime;
    }

    /**
     * @return the reliabilityPercent
     */
    public BigDecimal getReliabilityPercent() {
        return reliabilityPercent;
    }

    /**
     * @param reliabilityPercent
     *            the reliabilityPercent to set
     */
    public void setReliabilityPercent(BigDecimal reliabilityPercent) {
        this.reliabilityPercent = reliabilityPercent;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     *            the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * @return the sequenceNumeric
     */
    public BigDecimal getSequenceNumeric() {
        return sequenceNumeric;
    }

    /**
     * @param sequenceNumeric
     *            the sequenceNumeric to set
     */
    public void setSequenceNumeric(BigDecimal sequenceNumeric) {
        this.sequenceNumeric = sequenceNumeric;
    }

    /**
     * @return the statusLocation
     */
    public Location getStatusLocation() {
        return statusLocation;
    }

    /**
     * @param statusLocation
     *            the statusLocation to set
     */
    public void setStatusLocation(Location statusLocation) {
        this.statusLocation = statusLocation;
    }

    /**
     * @return the actualDepartureTransportEvent
     */
    public TransportEvent getActualDepartureTransportEvent() {
        return actualDepartureTransportEvent;
    }

    /**
     * @param actualDepartureTransportEvent
     *            the actualDepartureTransportEvent to set
     */
    public void setActualDepartureTransportEvent(TransportEvent actualDepartureTransportEvent) {
        this.actualDepartureTransportEvent = actualDepartureTransportEvent;
    }

    /**
     * @return the estimatedDepartureTransportEvent
     */
    public TransportEvent getEstimatedDepartureTransportEvent() {
        return estimatedDepartureTransportEvent;
    }

    /**
     * @param estimatedDepartureTransportEvent
     *            the estimatedDepartureTransportEvent to set
     */
    public void setEstimatedDepartureTransportEvent(TransportEvent estimatedDepartureTransportEvent) {
        this.estimatedDepartureTransportEvent = estimatedDepartureTransportEvent;
    }

    /**
     * @return the estimatedArrivalTransportEvent
     */
    public TransportEvent getEstimatedArrivalTransportEvent() {
        return estimatedArrivalTransportEvent;
    }

    /**
     * @param estimatedArrivalTransportEvent
     *            the estimatedArrivalTransportEvent to set
     */
    public void setEstimatedArrivalTransportEvent(TransportEvent estimatedArrivalTransportEvent) {
        this.estimatedArrivalTransportEvent = estimatedArrivalTransportEvent;
    }

    /**
     * @return the plannedDepartureTransportEvent
     */
    public TransportEvent getPlannedDepartureTransportEvent() {
        return plannedDepartureTransportEvent;
    }

    /**
     * @param plannedDepartureTransportEvent
     *            the plannedDepartureTransportEvent to set
     */
    public void setPlannedDepartureTransportEvent(TransportEvent plannedDepartureTransportEvent) {
        this.plannedDepartureTransportEvent = plannedDepartureTransportEvent;
    }

    /**
     * @return the actualArrivalTransportEvent
     */
    public TransportEvent getActualArrivalTransportEvent() {
        return actualArrivalTransportEvent;
    }

    /**
     * @param actualArrivalTransportEvent
     *            the actualArrivalTransportEvent to set
     */
    public void setActualArrivalTransportEvent(TransportEvent actualArrivalTransportEvent) {
        this.actualArrivalTransportEvent = actualArrivalTransportEvent;
    }

    /**
     * @return the plannedArrivalTransportEvent
     */
    public TransportEvent getPlannedArrivalTransportEvent() {
        return plannedArrivalTransportEvent;
    }

    /**
     * @param plannedArrivalTransportEvent
     *            the plannedArrivalTransportEvent to set
     */
    public void setPlannedArrivalTransportEvent(TransportEvent plannedArrivalTransportEvent) {
        this.plannedArrivalTransportEvent = plannedArrivalTransportEvent;
    }

}// end TransportSchedule