package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a specific, trackable instance of an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:45 a. m.
 */
public class ItemInstance {

	/**
	 * The date before which it is best to use this item instance.
	 */
	private LocalDate BestBeforeDate;
	/**
	 * The date on which this item instance was manufactured.
	 */
	private LocalDate ManufactureDate;
	/**
	 * The time at which this item instance was manufactured.
	 */
	private LocalTime ManufactureTime;
	/**
	 * An identifier used for tracing this item instance, such as the EPC number used
	 * in RFID.
	 */
	private String ProductTraceID;
	/**
	 * The registration identifier of this item instance.
	 */
	private String RegistrationID;
	/**
	 * The serial number of this item instance.
	 */
	private String SerialID;
	private Item Property Additional Item Property;
	private Lot Identification m_Lot Identification;

	public Item Instance(){

	}

	public void finalize() throws Throwable {

	}
	public Item Property getAdditional Item Property(){
		return Additional Item Property;
	}

	public LocalDate getBestBeforeDate(){
		return BestBeforeDate;
	}

	public Lot Identification getLot Identification(){
		return m_Lot Identification;
	}

	public LocalDate getManufactureDate(){
		return ManufactureDate;
	}

	public LocalTime getManufactureTime(){
		return ManufactureTime;
	}

	public String getProductTraceID(){
		return ProductTraceID;
	}

	public String getRegistrationID(){
		return RegistrationID;
	}

	public String getSerialID(){
		return SerialID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditional Item Property(Item Property newVal){
		Additional Item Property = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBestBeforeDate(LocalDate newVal){
		BestBeforeDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLot Identification(Lot Identification newVal){
		m_Lot Identification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setManufactureDate(LocalDate newVal){
		ManufactureDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setManufactureTime(LocalTime newVal){
		ManufactureTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProductTraceID(String newVal){
		ProductTraceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationID(String newVal){
		RegistrationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSerialID(String newVal){
		SerialID = newVal;
	}
}//end Item Instance