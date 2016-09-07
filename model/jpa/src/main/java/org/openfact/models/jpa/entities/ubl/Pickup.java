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
	private LocalDate ActualPickupDate;
	/**
	 * The actual pickup time.
	 */
	private LocalTime ActualPickupTime;
	/**
	 * The earliest pickup date.
	 */
	private LocalDate EarliestPickupDate;
	/**
	 * The earliest pickup time.
	 */
	private LocalTime EarliestPickupTime;
	/**
	 * An identifier for this pickup.
	 */
	private String ID;
	/**
	 * The latest pickup date.
	 */
	private LocalDate LatestPickupDate;
	/**
	 * The latest pickup time.
	 */
	private LocalTime LatestPickupTime;
	private Location PickupLocation;
	private Party PickupParty;

	public Pickup() {

	}

	public void finalize() throws Throwable {

	}

	public LocalDate getActualPickupDate() {
		return ActualPickupDate;
	}

	public LocalTime getActualPickupTime() {
		return ActualPickupTime;
	}

	public LocalDate getEarliestPickupDate() {
		return EarliestPickupDate;
	}

	public LocalTime getEarliestPickupTime() {
		return EarliestPickupTime;
	}

	public String getID() {
		return ID;
	}

	public LocalDate getLatestPickupDate() {
		return LatestPickupDate;
	}

	public LocalTime getLatestPickupTime() {
		return LatestPickupTime;
	}

	public Location getPickupLocation() {
		return PickupLocation;
	}

	public Party getPickupParty() {
		return PickupParty;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualPickupDate(LocalDate newVal) {
		ActualPickupDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualPickupTime(LocalTime newVal) {
		ActualPickupTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEarliestPickupDate(LocalDate newVal) {
		EarliestPickupDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEarliestPickupTime(LocalTime newVal) {
		EarliestPickupTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestPickupDate(LocalDate newVal) {
		LatestPickupDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestPickupTime(LocalTime newVal) {
		LatestPickupTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPickupLocation(Location newVal) {
		PickupLocation = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPickupParty(Party newVal) {
		PickupParty = newVal;
	}
}// end Pickup