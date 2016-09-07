

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
	private Date. Type BestBeforeDate;
	/**
	 * The date on which this item instance was manufactured.
	 */
	private Date. Type ManufactureDate;
	/**
	 * The time at which this item instance was manufactured.
	 */
	private Time. Type ManufactureTime;
	/**
	 * An identifier used for tracing this item instance, such as the EPC number used
	 * in RFID.
	 */
	private Identifier. Type ProductTraceID;
	/**
	 * The registration identifier of this item instance.
	 */
	private Identifier. Type RegistrationID;
	/**
	 * The serial number of this item instance.
	 */
	private Identifier. Type SerialID;
	private Item Property Additional Item Property;
	private Lot Identification m_Lot Identification;

	public Item Instance(){

	}

	public void finalize() throws Throwable {

	}
	public Item Property getAdditional Item Property(){
		return Additional Item Property;
	}

	public Date. Type getBestBeforeDate(){
		return BestBeforeDate;
	}

	public Lot Identification getLot Identification(){
		return m_Lot Identification;
	}

	public Date. Type getManufactureDate(){
		return ManufactureDate;
	}

	public Time. Type getManufactureTime(){
		return ManufactureTime;
	}

	public Identifier. Type getProductTraceID(){
		return ProductTraceID;
	}

	public Identifier. Type getRegistrationID(){
		return RegistrationID;
	}

	public Identifier. Type getSerialID(){
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
	public void setBestBeforeDate(Date. Type newVal){
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
	public void setManufactureDate(Date. Type newVal){
		ManufactureDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setManufactureTime(Time. Type newVal){
		ManufactureTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setProductTraceID(Identifier. Type newVal){
		ProductTraceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationID(Identifier. Type newVal){
		RegistrationID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSerialID(Identifier. Type newVal){
		SerialID = newVal;
	}
}//end Item Instance