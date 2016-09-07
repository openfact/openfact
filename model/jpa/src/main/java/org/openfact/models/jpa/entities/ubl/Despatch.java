package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe the despatching of goods (their pickup for delivery).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:28 a. m.
 */
public class Despatch {

	/**
	 * The actual despatch (pickup) date.
	 */
	private LocalDate actualDespatchDate;
	/**
	 * The actual despatch (pickup) time.
	 */
	private LocalTime actualDespatchTime;
	/**
	 * The estimated despatch (pickup) date.
	 */
	private LocalDate estimatedDespatchDate;
	/**
	 * The estimated despatch (pickup) time.
	 */
	private LocalTime estimatedDespatchTime;
	/**
	 * The date guaranteed for the despatch (pickup).
	 */
	private LocalDate guaranteedDespatchDate;
	/**
	 * The time guaranteed for the despatch (pickup).
	 */
	private LocalTime guaranteedDespatchTime;
	/**
	 * An identifier for this despatch event.
	 */
	private String id;
	/**
	 * Text describing any special instructions applying to the despatch
	 * (pickup).
	 */
	private String instructions;
	/**
	 * An identifier for the release of the despatch used as security control or
	 * cargo control (pick-up).
	 */
	private String releaseID;
	/**
	 * The despatch (pickup) date requested, normally by the buyer.
	 */
	private LocalDate requestedDespatchDate;
	/**
	 * The despatch (pickup) time requested, normally by the buyer.
	 */
	private LocalTime requestedDespatchTime;
	private Address despatchAddress;
	private List<Contact> contacts=new ArrayList<>();
	private Location despatchLocation;
	private Party notifyParty;
	private Party carrierParty;
	private Party despatchParty;
	private Period requestedDespatchPeriod;
	private Period estimatedDespatchPeriod;

	public Despatch() {

	}

	public void finalize() throws Throwable {

	}

	public LocalDate getActualDespatchDate() {
		return actualDespatchDate;
	}

	public void setActualDespatchDate(LocalDate actualDespatchDate) {
		this.actualDespatchDate = actualDespatchDate;
	}

	public LocalTime getActualDespatchTime() {
		return actualDespatchTime;
	}

	public void setActualDespatchTime(LocalTime actualDespatchTime) {
		this.actualDespatchTime = actualDespatchTime;
	}

	public LocalDate getEstimatedDespatchDate() {
		return estimatedDespatchDate;
	}

	public void setEstimatedDespatchDate(LocalDate estimatedDespatchDate) {
		this.estimatedDespatchDate = estimatedDespatchDate;
	}

	public LocalTime getEstimatedDespatchTime() {
		return estimatedDespatchTime;
	}

	public void setEstimatedDespatchTime(LocalTime estimatedDespatchTime) {
		this.estimatedDespatchTime = estimatedDespatchTime;
	}

	public LocalDate getGuaranteedDespatchDate() {
		return guaranteedDespatchDate;
	}

	public void setGuaranteedDespatchDate(LocalDate guaranteedDespatchDate) {
		this.guaranteedDespatchDate = guaranteedDespatchDate;
	}

	public LocalTime getGuaranteedDespatchTime() {
		return guaranteedDespatchTime;
	}

	public void setGuaranteedDespatchTime(LocalTime guaranteedDespatchTime) {
		this.guaranteedDespatchTime = guaranteedDespatchTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getReleaseID() {
		return releaseID;
	}

	public void setReleaseID(String releaseID) {
		this.releaseID = releaseID;
	}

	public LocalDate getRequestedDespatchDate() {
		return requestedDespatchDate;
	}

	public void setRequestedDespatchDate(LocalDate requestedDespatchDate) {
		this.requestedDespatchDate = requestedDespatchDate;
	}

	public LocalTime getRequestedDespatchTime() {
		return requestedDespatchTime;
	}

	public void setRequestedDespatchTime(LocalTime requestedDespatchTime) {
		this.requestedDespatchTime = requestedDespatchTime;
	}

	public Address getDespatchAddress() {
		return despatchAddress;
	}

	public void setDespatchAddress(Address despatchAddress) {
		this.despatchAddress = despatchAddress;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Location getDespatchLocation() {
		return despatchLocation;
	}

	public void setDespatchLocation(Location despatchLocation) {
		this.despatchLocation = despatchLocation;
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

	public Party getDespatchParty() {
		return despatchParty;
	}

	public void setDespatchParty(Party despatchParty) {
		this.despatchParty = despatchParty;
	}

	public Period getRequestedDespatchPeriod() {
		return requestedDespatchPeriod;
	}

	public void setRequestedDespatchPeriod(Period requestedDespatchPeriod) {
		this.requestedDespatchPeriod = requestedDespatchPeriod;
	}

	public Period getEstimatedDespatchPeriod() {
		return estimatedDespatchPeriod;
	}

	public void setEstimatedDespatchPeriod(Period estimatedDespatchPeriod) {
		this.estimatedDespatchPeriod = estimatedDespatchPeriod;
	}
}// end Despatch