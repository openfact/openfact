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
	private Indicator. Type CompletionIndicator;
	/**
	 * Text describing this transport event.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this transport event within an agreed event identification
	 * scheme.
	 */
	private Identifier. Type IdentificationID;
	/**
	 * The date of this transport event.
	 */
	private Date. Type OccurrenceDate;
	/**
	 * The time of this transport event.
	 */
	private Time. Type OccurrenceTime;
	/**
	 * A code signifying the type of this transport event.
	 */
	private Code. Type TransportEventTypeCode;
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
	public Indicator. Type getCompletionIndicator(){
		return CompletionIndicator;
	}

	public Contact getContact(){
		return m_Contact;
	}

	public Status getCurrent Status(){
		return Current Status;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getIdentificationID(){
		return IdentificationID;
	}

	public Location getLocation(){
		return m_Location;
	}

	public Date. Type getOccurrenceDate(){
		return OccurrenceDate;
	}

	public Time. Type getOccurrenceTime(){
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

	public Code. Type getTransportEventTypeCode(){
		return TransportEventTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCompletionIndicator(Indicator. Type newVal){
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
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIdentificationID(Identifier. Type newVal){
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
	public void setOccurrenceDate(Date. Type newVal){
		OccurrenceDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOccurrenceTime(Time. Type newVal){
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
	public void setTransportEventTypeCode(Code. Type newVal){
		TransportEventTypeCode = newVal;
	}
}//end Transport Event