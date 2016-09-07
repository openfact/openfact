package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a significant occurrence relating to an object, process,
 * or person.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:53 a. m.
 */
public class Event {

	/**
	 * An indicator that this event has been completed (true) or not (false).
	 */
	private boolean completionIndicator;
	/**
	 * Text describing this event.
	 */
	private String description;
	/**
	 * An identifier for this event within an agreed event identification
	 * scheme.
	 */
	private String identificationID;
	/**
	 * The date of this event.
	 */
	private LocalDate occurrenceDate;
	/**
	 * The time of this event.
	 */
	private LocalTime occurrenceTime;
	/**
	 * A code signifying the type of this event.
	 */
	private String typeCode;
	private List<Contact> contacts=new ArrayList<>();
	private Location occurenceLocation;
	private Status currentStatus;

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

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Location getOccurenceLocation() {
		return occurenceLocation;
	}

	public void setOccurenceLocation(Location occurenceLocation) {
		this.occurenceLocation = occurenceLocation;
	}

	public Status getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}
}// end Event