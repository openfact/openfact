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
	private BigDecimal BackorderQuantity;
	/**
	 * The reason for the back order.
	 */
	private String BackorderReason;
	/**
	 * The quantity despatched (picked up).
	 */
	private BigDecimal DeliveredQuantity;
	/**
	 * An identifier for this despatch line.
	 */
	private String ID;
	/**
	 * A code signifying the status of this despatch line with respect to its original
	 * state.
	 */
	private Line Status_ String LineStatusCode;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * The quantity outstanding (which will follow in a later despatch).
	 */
	private BigDecimal OutstandingQuantity;
	/**
	 * The reason for the outstanding quantity.
	 */
	private String OutstandingReason;
	/**
	 * The quantity over-supplied, i.e., the quantity over and above that ordered.
	 */
	private BigDecimal OversupplyQuantity;
	/**
	 * A universally unique identifier for this despatch line.
	 */
	private String UUID;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Order Line Reference m_Order Line Reference;
	private Shipment m_Shipment;

	public Despatch Line(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getBackorderQuantity(){
		return BackorderQuantity;
	}

	public String getBackorderReason(){
		return BackorderReason;
	}

	public BigDecimal getDeliveredQuantity(){
		return DeliveredQuantity;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public String getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Line Status_ String getLineStatusCode(){
		return LineStatusCode;
	}

	public String getNote(){
		return Note;
	}

	public Order Line Reference getOrder Line Reference(){
		return m_Order Line Reference;
	}

	public BigDecimal getOutstandingQuantity(){
		return OutstandingQuantity;
	}

	public String getOutstandingReason(){
		return OutstandingReason;
	}

	public BigDecimal getOversupplyQuantity(){
		return OversupplyQuantity;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public String getUUID(){
		return UUID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBackorderQuantity(BigDecimal newVal){
		BackorderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBackorderReason(String newVal){
		BackorderReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeliveredQuantity(BigDecimal newVal){
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
	public void setID(String newVal){
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
	public void setLineStatusCode(Line Status_ String newVal){
		LineStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(String newVal){
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
	public void setOutstandingQuantity(BigDecimal newVal){
		OutstandingQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOutstandingReason(String newVal){
		OutstandingReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOversupplyQuantity(BigDecimal newVal){
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
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Despatch Line