

/**
 * A class to define a reference to an order line.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:17 a. m.
 */
public class Order Line Reference {

	/**
	 * An identifier for the referenced order line, assigned by the buyer.
	 */
	private Identifier. Type LineID;
	/**
	 * A code signifying the status of the referenced order line with respect to its
	 * original state.
	 */
	private Line Status_ Code. Type LineStatusCode;
	/**
	 * An identifier for the referenced order line, assigned by the seller.
	 */
	private Identifier. Type SalesOrderLineID;
	/**
	 * A universally unique identifier for this order line reference.
	 */
	private Identifier. Type UUID;
	private Order Reference m_Order Reference;

	public Order Line Reference(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getLineID(){
		return LineID;
	}

	public Line Status_ Code. Type getLineStatusCode(){
		return LineStatusCode;
	}

	public Order Reference getOrder Reference(){
		return m_Order Reference;
	}

	public Identifier. Type getSalesOrderLineID(){
		return SalesOrderLineID;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineID(Identifier. Type newVal){
		LineID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineStatusCode(Line Status_ Code. Type newVal){
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
	public void setSalesOrderLineID(Identifier. Type newVal){
		SalesOrderLineID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Order Line Reference