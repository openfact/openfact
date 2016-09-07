package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define the point of consumption for a utility, such as a meter.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:53 a. m.
 */
public class ConsumptionPoint {

	/**
	 * Text describing this consumption point.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this point of consumption.
	 */
	private Identifier. Type ID;
	/**
	 * An identifier for the subscriber responsible for the consumption at this
	 * consumption point.
	 */
	private Identifier. Type SubscriberID;
	/**
	 * The type of subscriber, expressed as text.
	 */
	private Text. Type SubscriberType;
	/**
	 * The type of subscriber, expressed as a code.
	 */
	private Code. Type SubscriberTypeCode;
	/**
	 * The total quantity delivered, calculated at this consumption point.
	 */
	private Quantity. Type TotalDeliveredQuantity;
	private Address m_Address;
	private Meter Utility Meter;
	private Web Site Access m_Web Site Access;

	public Consumption Point(){

	}

	public void finalize() throws Throwable {

	}
	public Address getAddress(){
		return m_Address;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Identifier. Type getSubscriberID(){
		return SubscriberID;
	}

	public Text. Type getSubscriberType(){
		return SubscriberType;
	}

	public Code. Type getSubscriberTypeCode(){
		return SubscriberTypeCode;
	}

	public Quantity. Type getTotalDeliveredQuantity(){
		return TotalDeliveredQuantity;
	}

	public Meter getUtility Meter(){
		return Utility Meter;
	}

	public Web Site Access getWeb Site Access(){
		return m_Web Site Access;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddress(Address newVal){
		m_Address = newVal;
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberID(Identifier. Type newVal){
		SubscriberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberType(Text. Type newVal){
		SubscriberType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberTypeCode(Code. Type newVal){
		SubscriberTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalDeliveredQuantity(Quantity. Type newVal){
		TotalDeliveredQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUtility Meter(Meter newVal){
		Utility Meter = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeb Site Access(Web Site Access newVal){
		m_Web Site Access = newVal;
	}
}//end Consumption Point