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
    private Indicator.Type CompletionIndicator;
    /**
     * Text describing this event.
     */
    private Text.Type Description;
    /**
     * An identifier for this event within an agreed event identification
     * scheme.
     */
    private Identifier.Type IdentificationID;
    /**
     * The date of this event.
     */
    private Date.Type OccurrenceDate;
    /**
     * The time of this event.
     */
    private Time.Type OccurrenceTime;
    /**
     * A code signifying the type of this event.
     */
    private Code.Type TypeCode;
    private Contact m_Contact;
    private Location Occurence Location;
    private Status Current Status;

    public Event() {

    }

    public void finalize() throws Throwable {

    }

    public Indicator.Type getCompletionIndicator() {
        return CompletionIndicator;
    }

    public Contact getContact() {
        return m_Contact;
    }

    public Status getCurrent

    Status(){
		return Current Status;
	}

    public Text.Type getDescription() {
        return Description;
    }

    public Identifier.Type getIdentificationID() {
        return IdentificationID;
    }

    public Location getOccurence

    Location(){
		return Occurence Location;
	}

    public Date.Type getOccurrenceDate() {
        return OccurrenceDate;
    }

    public Time.Type getOccurrenceTime() {
        return OccurrenceTime;
    }

    public Code.Type getTypeCode() {
        return TypeCode;
    }

    /**
     * 
     * @param newVal
     */
    public void setCompletionIndicator(Indicator.Type newVal) {
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
    public void setDescription(Text.Type newVal) {
        Description = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setIdentificationID(Identifier.Type newVal) {
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
    public void setOccurrenceDate(Date.Type newVal) {
        OccurrenceDate = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setOccurrenceTime(Time.Type newVal) {
        OccurrenceTime = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTypeCode(Code.Type newVal) {
        TypeCode = newVal;
    }
}// end Event