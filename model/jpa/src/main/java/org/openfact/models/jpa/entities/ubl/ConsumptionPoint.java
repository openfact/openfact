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
	private String Description;
	/**
	 * An identifier for this point of consumption.
	 */
	private String ID;
	/**
	 * An identifier for the subscriber responsible for the consumption at this
	 * consumption point.
	 */
	private String SubscriberID;
	/**
	 * The type of subscriber, expressed as text.
	 */
	private String SubscriberType;
	/**
	 * The type of subscriber, expressed as a code.
	 */
	private String SubscriberTypeCode;
	/**
	 * The total quantity delivered, calculated at this consumption point.
	 */
	private BigDecimal TotalDeliveredQuantity;
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

	public String getDescription(){
		return Description;
	}

	public String getID(){
		return ID;
	}

	public String getSubscriberID(){
		return SubscriberID;
	}

	public String getSubscriberType(){
		return SubscriberType;
	}

	public String getSubscriberTypeCode(){
		return SubscriberTypeCode;
	}

	public BigDecimal getTotalDeliveredQuantity(){
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
	public void setDescription(String newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberID(String newVal){
		SubscriberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberType(String newVal){
		SubscriberType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberTypeCode(String newVal){
		SubscriberTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalDeliveredQuantity(BigDecimal newVal){
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