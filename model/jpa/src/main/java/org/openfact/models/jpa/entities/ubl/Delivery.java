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
	private String id;
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
	private List<Despatch> despatchs=new ArrayList<>();
	private Period estimatedDeliveryPeriod;
	private Period promisedDeliveryPeriod;
	private Period requestedDeliveryPeriod;
	private Location deliveryLocation;
	private Location alternativeDeliveryLocation;
	private Party notifyParty;
	private Party carrierParty;
	private Party deliveryParty;
	private List<Shipment> shipments=new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms=new ArrayList<>();

	public LocalDate getActualDeliveryDate() {
		return actualDeliveryDate;
	}

	public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
		this.actualDeliveryDate = actualDeliveryDate;
	}

	public LocalTime getActualDeliveryTime() {
		return actualDeliveryTime;
	}

	public void setActualDeliveryTime(LocalTime actualDeliveryTime) {
		this.actualDeliveryTime = actualDeliveryTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getLatestDeliveryDate() {
		return latestDeliveryDate;
	}

	public void setLatestDeliveryDate(LocalDate latestDeliveryDate) {
		this.latestDeliveryDate = latestDeliveryDate;
	}

	public LocalTime getLatestDeliveryTime() {
		return latestDeliveryTime;
	}

	public void setLatestDeliveryTime(LocalTime latestDeliveryTime) {
		this.latestDeliveryTime = latestDeliveryTime;
	}

	public BigDecimal getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(BigDecimal maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public BigDecimal getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(BigDecimal minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getReleaseID() {
		return releaseID;
	}

	public void setReleaseID(String releaseID) {
		this.releaseID = releaseID;
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

	public List<Despatch> getDespatchs() {
		return despatchs;
	}

	public void setDespatchs(List<Despatch> despatchs) {
		this.despatchs = despatchs;
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
		return alternativeDeliveryLocation;
	}

	public void setAlternativeDeliveryLocation(Location alternativeDeliveryLocation) {
		this.alternativeDeliveryLocation = alternativeDeliveryLocation;
	}

	public Party getNotifyParty() {
		return notifyParty;
	}

	public void setNotifyParty(Party notifyParty) {
		this.notifyParty = notifyParty;
	}

	public Party getCarrierParty() {
		return carrierParty;
	}

	public void setCarrierParty(Party carrierParty) {
		this.carrierParty = carrierParty;
	}

	public Party getDeliveryParty() {
		return deliveryParty;
	}

	public void setDeliveryParty(Party deliveryParty) {
		this.deliveryParty = deliveryParty;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}

	public List<DeliveryTerms> getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}
}