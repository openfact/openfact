package org.openfact.models.jpa.entities.ubl;

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
    private boolean CompletionIndicator;
    /**
     * Text describing this event.
     */
    private String Description;
    /**
     * An identifier for this event within an agreed event identification
     * scheme.
     */
    private String IdentificationID;
    /**
     * The date of this event.
     */
    private LocalDate OccurrenceDate;
    /**
     * The time of this event.
     */
    private LocalTime OccurrenceTime;
    /**
     * A code signifying the type of this event.
     */
    private String TypeCode;
    private Contact m_Contact;
    private Location Occurence Location;
    private Status Current Status;

    public Event() {

    }

    public void finalize() throws Throwable {

    }

    public boolean getCompletionIndicator() {
        return CompletionIndicator;
    }

    public Contact getContact() {
        return m_Contact;
    }

    public Status getCurrent

    Status(){
		return Current Status;
	}

    public String getDescription() {
        return Description;
    }

    public String getIdentificationID() {
        return IdentificationID;
    }

    public Location getOccurence

    Location(){
		return Occurence Location;
	}

    public LocalDate getOccurrenceDate() {
        return OccurrenceDate;
    }

    public LocalTime getOccurrenceTime() {
        return OccurrenceTime;
    }

    public String getTypeCode() {
        return TypeCode;
    }

    /**
     * 
     * @param newVal
     */
    public void setCompletionIndicator(boolean newVal) {
        CompletionIndicator = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setContact(Contact newVal) {
        m_Contact = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setCurrent

    Status(Status newVal){
		Current Status = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setDescription(String newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIdentificationID(String newVal) {
        IdentificationID = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setOccurence

    Location(Location newVal){
		Occurence Location = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setOccurrenceDate(LocalDate newVal) {
        OccurrenceDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOccurrenceTime(LocalTime newVal) {
        OccurrenceTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTypeCode(String newVal) {
        TypeCode = newVal;
    }
}// end Event