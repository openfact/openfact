package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a reference to an order line.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:17 a. m.
 */
public class OrderLineReference {

	/**
	 * An identifier for the referenced order line, assigned by the buyer.
	 */
	private String LineID;
	/**
	 * A code signifying the status of the referenced order line with respect to its
	 * original state.
	 */
	private Line Status_ String LineStatusCode;
	/**
	 * An identifier for the referenced order line, assigned by the seller.
	 */
	private String SalesOrderLineID;
	/**
	 * A universally unique identifier for this order line reference.
	 */
	private String UUID;
	private Order Reference m_Order Reference;

	public OrderLineReference(){

	}

	public void finalize() throws Throwable {

	}
	public String getLineID(){
		return LineID;
	}

	public Line Status_ String getLineStatusCode(){
		return LineStatusCode;
	}

	public Order Reference getOrder Reference(){
		return m_Order Reference;
	}

	public String getSalesOrderLineID(){
		return SalesOrderLineID;
	}

	public String getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineID(String newVal){
		LineID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineStatusCode(Line Status_ String newVal){
		LineStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrder Reference(Order Reference newVal){
		m_Order Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSalesOrderLineID(String newVal){
		SalesOrderLineID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end OrderLineReference