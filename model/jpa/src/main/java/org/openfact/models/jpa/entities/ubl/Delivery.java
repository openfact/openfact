package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a delivery.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class Delivery {

    /**
     * The actual date of delivery.
     */
    private LocalDate ActualDeliveryDate;
    /**
     * The actual time of delivery.
     */
    private LocalTime ActualDeliveryTime;
    /**
     * An identifier for this delivery.
     */
    private String ID;
    /**
     * The latest date of delivery allowed by the buyer.
     */
    private LocalDate LatestDeliveryDate;
    /**
     * The latest time of delivery allowed by the buyer.
     */
    private LocalTime LatestDeliveryTime;
    /**
     * The maximum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private BigDecimal MaximumQuantity;
    /**
     * The minimum quantity of items, child consignments, shipments in this
     * delivery.
     */
    private BigDecimal MinimumQuantity;
    /**
     * The quantity of items, child consignments, shipments in this delivery.
     */
    private BigDecimal Quantity;
    /**
     * An identifier used for approval of access to delivery locations (e.g.,
     * port terminals).
     */
    private String ReleaseID;
    /**
     * The delivery Tracking ID (for transport tracking).
     */
    private String trackingID;
    private Address deliveryAddress;
    private DeliveryUnit maximumDeliveryUnit;
    private DeliveryUnit minimumDeliveryUnit;
    private Despatch m_Despatch;
    private Period estimatedDeliveryPeriod;
    private Period promisedDeliveryPeriod;
    private Period requestedDeliveryPeriod;
    private Location deliveryLocation;
    private Location AlternativeDeliveryLocation;
    private Party NotifyParty;
    private Party CarrierParty;
    private Party DeliveryParty;
    private Shipment m_Shipment;
    private DeliveryTerms m_DeliveryTerms;

    public Delivery() {

    }

    public void finalize() throws Throwable {

    }

    public LocalDate getActualDeliveryDate() {
        return ActualDeliveryDate;
    }

    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        ActualDeliveryDate = actualDeliveryDate;
    }

    public LocalTime getActualDeliveryTime() {
        return ActualDeliveryTime;
    }

    public void setActualDeliveryTime(LocalTime actualDeliveryTime) {
        ActualDeliveryTime = actualDeliveryTime;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public LocalDate getLatestDeliveryDate() {
        return LatestDeliveryDate;
    }

    public void setLatestDeliveryDate(LocalDate latestDeliveryDate) {
        LatestDeliveryDate = latestDeliveryDate;
    }

    public LocalTime getLatestDeliveryTime() {
        return LatestDeliveryTime;
    }

    public void setLatestDeliveryTime(LocalTime latestDeliveryTime) {
        LatestDeliveryTime = latestDeliveryTime;
    }

    public BigDecimal getMaximumQuantity() {
        return MaximumQuantity;
    }

    public void setMaximumQuantity(BigDecimal maximumQuantity) {
        MaximumQuantity = maximumQuantity;
    }

    public BigDecimal getMinimumQuantity() {
        return MinimumQuantity;
    }

    public void setMinimumQuantity(BigDecimal minimumQuantity) {
        MinimumQuantity = minimumQuantity;
    }

    public BigDecimal getQuantity() {
        return Quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    public String getReleaseID() {
        return ReleaseID;
    }

    public void setReleaseID(String releaseID) {
        ReleaseID = releaseID;
    }

    public String getTrackingID() {
        return trackingID;
    }

    public void setTrackingID(String trackingID) {
        this.trackingID = trackingID;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public DeliveryUnit getMaximumDeliveryUnit() {
        return maximumDeliveryUnit;
    }

    public void setMaximumDeliveryUnit(DeliveryUnit maximumDeliveryUnit) {
        this.maximumDeliveryUnit = maximumDeliveryUnit;
    }

    public DeliveryUnit getMinimumDeliveryUnit() {
        return minimumDeliveryUnit;
    }

    public void setMinimumDeliveryUnit(DeliveryUnit minimumDeliveryUnit) {
        this.minimumDeliveryUnit = minimumDeliveryUnit;
    }

    public Despatch getM_Despatch() {
        return m_Despatch;
    }

    public void setM_Despatch(Despatch m_Despatch) {
        this.m_Despatch = m_Despatch;
    }

    public Period getEstimatedDeliveryPeriod() {
        return estimatedDeliveryPeriod;
    }

    public void setEstimatedDeliveryPeriod(Period estimatedDeliveryPeriod) {
        this.estimatedDeliveryPeriod = estimatedDeliveryPeriod;
    }

    public Period getPromisedDeliveryPeriod() {
        return promisedDeliveryPeriod;
    }

    public void setPromisedDeliveryPeriod(Period promisedDeliveryPeriod) {
        this.promisedDeliveryPeriod = promisedDeliveryPeriod;
    }

    public Period getRequestedDeliveryPeriod() {
        return requestedDeliveryPeriod;
    }

    public void setRequestedDeliveryPeriod(Period requestedDeliveryPeriod) {
        this.requestedDeliveryPeriod = requestedDeliveryPeriod;
    }

    public Location getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(Location deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Location getAlternativeDeliveryLocation() {
        return AlternativeDeliveryLocation;
    }

    public void setAlternativeDeliveryLocation(Location alternativeDeliveryLocation) {
        AlternativeDeliveryLocation = alternativeDeliveryLocation;
    }

    public Party getNotifyParty() {
        return NotifyParty;
    }

    public void setNotifyParty(Party notifyParty) {
        NotifyParty = notifyParty;
    }

    public Party getCarrierParty() {
        return CarrierParty;
    }

    public void setCarrierParty(Party carrierParty) {
        CarrierParty = carrierParty;
    }

    public Party getDeliveryParty() {
        return DeliveryParty;
    }

    public void setDeliveryParty(Party deliveryParty) {
        DeliveryParty = deliveryParty;
    }

    public Shipment getM_Shipment() {
        return m_Shipment;
    }

    public void setM_Shipment(Shipment m_Shipment) {
        this.m_Shipment = m_Shipment;
    }

    public DeliveryTerms getM_DeliveryTerms() {
        return m_DeliveryTerms;
    }

    public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
        this.m_DeliveryTerms = m_DeliveryTerms;
    }
}// end Delivery