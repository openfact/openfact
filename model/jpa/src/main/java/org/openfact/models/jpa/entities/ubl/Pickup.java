package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a pickup for delivery.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:49 a. m.
 */
public class Pickup {

	/**
	 * The actual pickup date.
	 */
	private LocalDate actualPickupDate;
	/**
	 * The actual pickup time.
	 */
	private LocalTime actualPickupTime;
	/**
	 * The earliest pickup date.
	 */
	private LocalDate earliestPickupDate;
	/**
	 * The earliest pickup time.
	 */
	private LocalTime earliestPickupTime;
	/**
	 * An identifier for this pickup.
	 */
	private String ID;
	/**
	 * The latest pickup date.
	 */
	private LocalDate latestPickupDate;
	/**
	 * The latest pickup time.
	 */
	private LocalTime latestPickupTime;
	private Location pickupLocation;
	private Party pickupParty;

	public Pickup() {

	}

	public void finalize() throws Throwable {

	}

	public LocalDate getActualPickupDate() {
		return actualPickupDate;
	}

	public void setActualPickupDate(LocalDate actualPickupDate) {
		this.actualPickupDate = actualPickupDate;
	}

	public LocalTime getActualPickupTime() {
		return actualPickupTime;
	}

	public void setActualPickupTime(LocalTime actualPickupTime) {
		this.actualPickupTime = actualPickupTime;
	}

	public LocalDate getEarliestPickupDate() {
		return earliestPickupDate;
	}

	public void setEarliestPickupDate(LocalDate earliestPickupDate) {
		this.earliestPickupDate = earliestPickupDate;
	}

	public LocalTime getEarliestPickupTime() {
		return earliestPickupTime;
	}

	public void setEarliestPickupTime(LocalTime earliestPickupTime) {
		this.earliestPickupTime = earliestPickupTime;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public LocalDate getLatestPickupDate() {
		return latestPickupDate;
	}

	public void setLatestPickupDate(LocalDate latestPickupDate) {
		this.latestPickupDate = latestPickupDate;
	}

	public LocalTime getLatestPickupTime() {
		return latestPickupTime;
	}

	public void setLatestPickupTime(LocalTime latestPickupTime) {
		this.latestPickupTime = latestPickupTime;
	}

	public Location getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(Location pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Party getPickupParty() {
		return pickupParty;
	}

	public void setPickupParty(Party pickupParty) {
		this.pickupParty = pickupParty;
	}
}// end Pickup