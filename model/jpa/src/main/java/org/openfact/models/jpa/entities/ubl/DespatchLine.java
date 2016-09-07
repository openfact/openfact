package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Despatch Advice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:29 a. m.
 */
public class DespatchLine {

	/**
	 * The quantity on back order at the supplier.
	 */
	private Quantity. Type BackorderQuantity;
	/**
	 * The reason for the back order.
	 */
	private Text. Type BackorderReason;
	/**
	 * The quantity despatched (picked up).
	 */
	private Quantity. Type DeliveredQuantity;
	/**
	 * An identifier for this despatch line.
	 */
	private Identifier. Type ID;
	/**
	 * A code signifying the status of this despatch line with respect to its original
	 * state.
	 */
	private Line Status_ Code. Type LineStatusCode;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The quantity outstanding (which will follow in a later despatch).
	 */
	private Quantity. Type OutstandingQuantity;
	/**
	 * The reason for the outstanding quantity.
	 */
	private Text. Type OutstandingReason;
	/**
	 * The quantity over-supplied, i.e., the quantity over and above that ordered.
	 */
	private Quantity. Type OversupplyQuantity;
	/**
	 * A universally unique identifier for this despatch line.
	 */
	private Identifier. Type UUID;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Order Line Reference m_Order Line Reference;
	private Shipment m_Shipment;

	public Despatch Line(){

	}

	public void finalize() throws Throwable {

	}
	public Quantity. Type getBackorderQuantity(){
		return BackorderQuantity;
	}

	public Text. Type getBackorderReason(){
		return BackorderReason;
	}

	public Quantity. Type getDeliveredQuantity(){
		return DeliveredQuantity;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Line Status_ Code. Type getLineStatusCode(){
		return LineStatusCode;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Order Line Reference getOrder Line Reference(){
		return m_Order Line Reference;
	}

	public Quantity. Type getOutstandingQuantity(){
		return OutstandingQuantity;
	}

	public Text. Type getOutstandingReason(){
		return OutstandingReason;
	}

	public Quantity. Type getOversupplyQuantity(){
		return OversupplyQuantity;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBackorderQuantity(Quantity. Type newVal){
		BackorderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBackorderReason(Text. Type newVal){
		BackorderReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeliveredQuantity(Quantity. Type newVal){
		DeliveredQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocument Reference(Document Reference newVal){
		m_Document Reference = newVal;
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
	public void setItem(Item newVal){
		m_Item = newVal;
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
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrder Line Reference(Order Line Reference newVal){
		m_Order Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOutstandingQuantity(Quantity. Type newVal){
		OutstandingQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOutstandingReason(Text. Type newVal){
		OutstandingReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOversupplyQuantity(Quantity. Type newVal){
		OversupplyQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Despatch Line