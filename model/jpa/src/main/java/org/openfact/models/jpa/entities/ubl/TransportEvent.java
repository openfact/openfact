package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a significant occurrence or happening related to the
 * transportation of goods.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:42 a. m.
 */
public class TransportEvent {

	/**
	 * An indicator that this transport event has been completed (true) or not (false).
	 */
	private boolean CompletionIndicator;
	/**
	 * Text describing this transport event.
	 */
	private String Description;
	/**
	 * An identifier for this transport event within an agreed event identification
	 * scheme.
	 */
	private String IdentificationID;
	/**
	 * The date of this transport event.
	 */
	private LocalDate OccurrenceDate;
	/**
	 * The time of this transport event.
	 */
	private LocalTime OccurrenceTime;
	/**
	 * A code signifying the type of this transport event.
	 */
	private String TransportEventTypeCode;
	private Contact m_Contact;
	private Location m_Location;
	private Period m_Period;
	private Shipment Reported Shipment;
	private Status Current Status;
	private Signature m_Signature;

	public Transport Event(){

	}

	public void finalize() throws Throwable {

	}
	public boolean getCompletionIndicator(){
		return CompletionIndicator;
	}

	public Contact getContact(){
		return m_Contact;
	}

	public Status getCurrent Status(){
		return Current Status;
	}

	public String getDescription(){
		return Description;
	}

	public String getIdentificationID(){
		return IdentificationID;
	}

	public Location getLocation(){
		return m_Location;
	}

	public LocalDate getOccurrenceDate(){
		return OccurrenceDate;
	}

	public LocalTime getOccurrenceTime(){
		return OccurrenceTime;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Shipment getReported Shipment(){
		return Reported Shipment;
	}

	public Signature getSignature(){
		return m_Signature;
	}

	public String getTransportEventTypeCode(){
		return TransportEventTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompletionIndicator(boolean newVal){
		CompletionIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContact(Contact newVal){
		m_Contact = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCurrent Status(Status newVal){
		Current Status = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIdentificationID(String newVal){
		IdentificationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocation(Location newVal){
		m_Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOccurrenceDate(LocalDate newVal){
		OccurrenceDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOccurrenceTime(LocalTime newVal){
		OccurrenceTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReported Shipment(Shipment newVal){
		Reported Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignature(Signature newVal){
		m_Signature = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportEventTypeCode(String newVal){
		TransportEventTypeCode = newVal;
	}
}//end Transport Event