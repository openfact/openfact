package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private LocalDate actualDeliveryDate;
	/**
	 * The actual time of delivery.
	 */
	private LocalTime actualDeliveryTime;
	/**
	 * An identifier for this delivery.
	 */
	private String ID;
	/**
	 * The latest date of delivery allowed by the buyer.
	 */
	private LocalDate latestDeliveryDate;
	/**
	 * The latest time of delivery allowed by the buyer.
	 */
	private LocalTime latestDeliveryTime;
	/**
	 * The maximum quantity of items, child consignments, shipments in this
	 * delivery.
	 */
	private BigDecimal maximumQuantity;
	/**
	 * The minimum quantity of items, child consignments, shipments in this
	 * delivery.
	 */
	private BigDecimal minimumQuantity;
	/**
	 * The quantity of items, child consignments, shipments in this delivery.
	 */
	private BigDecimal quantity;
	/**
	 * An identifier used for approval of access to delivery locations (e.g.,
	 * port terminals).
	 */
	private String releaseID;
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
	private Party notifyParty;
	private Party carrierParty;
	private Party deliveryParty;
	private Shipment m_Shipment;
	private List<DeliveryTerms> deliveryTerms = new ArrayList<>(); 

	/**
	 * @return the actualDeliveryDate
	 */
	public LocalDate getActualDeliveryDate() {
		return actualDeliveryDate;
	}

	/**
	 * @param actualDeliveryDate
	 *            the actualDeliveryDate to set
	 */
	public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
		this.actualDeliveryDate = actualDeliveryDate;
	}

	/**
	 * @return the actualDeliveryTime
	 */
	public LocalTime getActualDeliveryTime() {
		return actualDeliveryTime;
	}

	/**
	 * @param actualDeliveryTime
	 *            the actualDeliveryTime to set
	 */
	public void setActualDeliveryTime(LocalTime actualDeliveryTime) {
		this.actualDeliveryTime = actualDeliveryTime;
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
	 * @return the latestDeliveryDate
	 */
	public LocalDate getLatestDeliveryDate() {
		return latestDeliveryDate;
	}

	/**
	 * @param latestDeliveryDate
	 *            the latestDeliveryDate to set
	 */
	public void setLatestDeliveryDate(LocalDate latestDeliveryDate) {
		this.latestDeliveryDate = latestDeliveryDate;
	}

	/**
	 * @return the latestDeliveryTime
	 */
	public LocalTime getLatestDeliveryTime() {
		return latestDeliveryTime;
	}

	/**
	 * @param latestDeliveryTime
	 *            the latestDeliveryTime to set
	 */
	public void setLatestDeliveryTime(LocalTime latestDeliveryTime) {
		this.latestDeliveryTime = latestDeliveryTime;
	}

	/**
	 * @return the maximumQuantity
	 */
	public BigDecimal getMaximumQuantity() {
		return maximumQuantity;
	}

	/**
	 * @param maximumQuantity
	 *            the maximumQuantity to set
	 */
	public void setMaximumQuantity(BigDecimal maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	/**
	 * @return the minimumQuantity
	 */
	public BigDecimal getMinimumQuantity() {
		return minimumQuantity;
	}

	/**
	 * @param minimumQuantity
	 *            the minimumQuantity to set
	 */
	public void setMinimumQuantity(BigDecimal minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	/**
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the releaseID
	 */
	public String getReleaseID() {
		return releaseID;
	}

	/**
	 * @param releaseID
	 *            the releaseID to set
	 */
	public void setReleaseID(String releaseID) {
		this.releaseID = releaseID;
	}

	/**
	 * @return the trackingID
	 */
	public String getTrackingID() {
		return trackingID;
	}

	/**
	 * @param trackingID
	 *            the trackingID to set
	 */
	public void setTrackingID(String trackingID) {
		this.trackingID = trackingID;
	}

	/**
	 * @return the deliveryAddress
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress
	 *            the deliveryAddress to set
	 */
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the maximumDeliveryUnit
	 */
	public DeliveryUnit getMaximumDeliveryUnit() {
		return maximumDeliveryUnit;
	}

	/**
	 * @param maximumDeliveryUnit
	 *            the maximumDeliveryUnit to set
	 */
	public void setMaximumDeliveryUnit(DeliveryUnit maximumDeliveryUnit) {
		this.maximumDeliveryUnit = maximumDeliveryUnit;
	}

	/**
	 * @return the minimumDeliveryUnit
	 */
	public DeliveryUnit getMinimumDeliveryUnit() {
		return minimumDeliveryUnit;
	}

	/**
	 * @param minimumDeliveryUnit
	 *            the minimumDeliveryUnit to set
	 */
	public void setMinimumDeliveryUnit(DeliveryUnit minimumDeliveryUnit) {
		this.minimumDeliveryUnit = minimumDeliveryUnit;
	}

	/**
	 * @return the m_Despatch
	 */
	public Despatch getM_Despatch() {
		return m_Despatch;
	}

	/**
	 * @param m_Despatch
	 *            the m_Despatch to set
	 */
	public void setM_Despatch(Despatch m_Despatch) {
		this.m_Despatch = m_Despatch;
	}

	/**
	 * @return the estimatedDeliveryPeriod
	 */
	public Period getEstimatedDeliveryPeriod() {
		return estimatedDeliveryPeriod;
	}

	/**
	 * @param estimatedDeliveryPeriod
	 *            the estimatedDeliveryPeriod to set
	 */
	public void setEstimatedDeliveryPeriod(Period estimatedDeliveryPeriod) {
		this.estimatedDeliveryPeriod = estimatedDeliveryPeriod;
	}

	/**
	 * @return the promisedDeliveryPeriod
	 */
	public Period getPromisedDeliveryPeriod() {
		return promisedDeliveryPeriod;
	}

	/**
	 * @param promisedDeliveryPeriod
	 *            the promisedDeliveryPeriod to set
	 */
	public void setPromisedDeliveryPeriod(Period promisedDeliveryPeriod) {
		this.promisedDeliveryPeriod = promisedDeliveryPeriod;
	}

	/**
	 * @return the requestedDeliveryPeriod
	 */
	public Period getRequestedDeliveryPeriod() {
		return requestedDeliveryPeriod;
	}

	/**
	 * @param requestedDeliveryPeriod
	 *            the requestedDeliveryPeriod to set
	 */
	public void setRequestedDeliveryPeriod(Period requestedDeliveryPeriod) {
		this.requestedDeliveryPeriod = requestedDeliveryPeriod;
	}

	/**
	 * @return the deliveryLocation
	 */
	public Location getDeliveryLocation() {
		return deliveryLocation;
	}

	/**
	 * @param deliveryLocation
	 *            the deliveryLocation to set
	 */
	public void setDeliveryLocation(Location deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	/**
	 * @return the alternativeDeliveryLocation
	 */
	public Location getAlternativeDeliveryLocation() {
		return AlternativeDeliveryLocation;
	}

	/**
	 * @param alternativeDeliveryLocation
	 *            the alternativeDeliveryLocation to set
	 */
	public void setAlternativeDeliveryLocation(Location alternativeDeliveryLocation) {
		AlternativeDeliveryLocation = alternativeDeliveryLocation;
	}

	/**
	 * @return the notifyParty
	 */
	public Party getNotifyParty() {
		return notifyParty;
	}

	/**
	 * @param notifyParty
	 *            the notifyParty to set
	 */
	public void setNotifyParty(Party notifyParty) {
		this.notifyParty = notifyParty;
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
	 * @return the deliveryParty
	 */
	public Party getDeliveryParty() {
		return deliveryParty;
	}

	/**
	 * @param deliveryParty
	 *            the deliveryParty to set
	 */
	public void setDeliveryParty(Party deliveryParty) {
		this.deliveryParty = deliveryParty;
	}

	/**
	 * @return the m_Shipment
	 */
	public Shipment getM_Shipment() {
		return m_Shipment;
	}

	/**
	 * @param m_Shipment
	 *            the m_Shipment to set
	 */
	public void setM_Shipment(Shipment m_Shipment) {
		this.m_Shipment = m_Shipment;
	}

	/**
	 * @return the m_DeliveryTerms
	 */
	public DeliveryTerms getM_DeliveryTerms() {
		return m_DeliveryTerms;
	}

	/**
	 * @param m_DeliveryTerms
	 *            the m_DeliveryTerms to set
	 */
	public void setM_DeliveryTerms(DeliveryTerms m_DeliveryTerms) {
		this.m_DeliveryTerms = m_DeliveryTerms;
	}

}