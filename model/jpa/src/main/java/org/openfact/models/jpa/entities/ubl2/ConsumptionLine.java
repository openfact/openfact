

/**
 * A class to describe a line item for utility consumption. To specify more than
 * one utility item, use separate consumption lines.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:52 a. m.
 */
public class ConsumptionLine {

	/**
	 * An identifier for this consumption line.
	 */
	private Identifier. Type ID;
	/**
	 * The quantity invoiced.
	 */
	private Quantity. Type InvoicedQuantity;
	/**
	 * The monetary amount, including discount, to be charged for this consumption
	 * line.
	 */
	private Amount. Type LineExtensionAmount;
	/**
	 * An identifier for the transaction line on a related document (such as an
	 * invoice) that covers this consumption line.
	 */
	private Identifier. Type ParentDocumentLineReferenceID;
	private Allowance Charge m_Allowance Charge;
	private Delivery m_Delivery;
	private Period m_Period;
	private Price m_Price;
	private Tax Total m_Tax Total;
	private Unstructured Price m_Unstructured Price;
	private Utility Item m_Utility Item;

	public Consumption Line(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Quantity. Type getInvoicedQuantity(){
		return InvoicedQuantity;
	}

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Identifier. Type getParentDocumentLineReferenceID(){
		return ParentDocumentLineReferenceID;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public Price getPrice(){
		return m_Price;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Unstructured Price getUnstructured Price(){
		return m_Unstructured Price;
	}

	public Utility Item getUtility Item(){
		return m_Utility Item;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowance Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery(Delivery newVal){
		m_Delivery = newVal;
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
	public void setInvoicedQuantity(Quantity. Type newVal){
		InvoicedQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLineExtensionAmount(Amount. Type newVal){
		LineExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setParentDocumentLineReferenceID(Identifier. Type newVal){
		ParentDocumentLineReferenceID = newVal;
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
	public void setPrice(Price newVal){
		m_Price = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnstructured Price(Unstructured Price newVal){
		m_Unstructured Price = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUtility Item(Utility Item newVal){
		m_Utility Item = newVal;
	}
}//end Consumption Line