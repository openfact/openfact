package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Request for Tender describing an item of goods or
 * a service solicited in the Request for Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLine {

	/**
	 * The estimated total amount of the deliverable.
	 */
	private BigDecimal EstimatedAmount;
	/**
	 * An identifier for this request for tender line.
	 */
	private String ID;
	/**
	 * The maximum amount allowed for this deliverable.
	 */
	private BigDecimal MaximumAmount;
	/**
	 * The maximum quantity of the item associated with this request for tender line.
	 */
	private BigDecimal MaximumQuantity;
	/**
	 * The minimum amount allowed for this deliverable.
	 */
	private BigDecimal MinimumAmount;
	/**
	 * The minimum quantity of the item associated with this request for tender line.
	 */
	private BigDecimal MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * The quantity of the item for which a tender is requested in this line.
	 */
	private BigDecimal Quantity;
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private boolean TaxIncludedIndicator;
	/**
	 * A universally unique identifier for this request for tender line.
	 */
	private String UUID;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Item Location Quantity Required Item Location Quantity;
	private Period Delivery Period;
	private Period Warranty Validity Period;
	private Request For Tender Line Sub Request For Tender Line;

	public Request For Tender Line(){

	}

	public void finalize() throws Throwable {

	}
	public Period getDelivery Period(){
		return Delivery Period;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public BigDecimal getEstimatedAmount(){
		return EstimatedAmount;
	}

	public String getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public BigDecimal getMaximumAmount(){
		return MaximumAmount;
	}

	public BigDecimal getMaximumQuantity(){
		return MaximumQuantity;
	}

	public BigDecimal getMinimumAmount(){
		return MinimumAmount;
	}

	public BigDecimal getMinimumQuantity(){
		return MinimumQuantity;
	}

	public String getNote(){
		return Note;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public Item Location Quantity getRequired Item Location Quantity(){
		return Required Item Location Quantity;
	}

	public Request For Tender Line getSub Request For Tender Line(){
		return Sub Request For Tender Line;
	}

	public boolean getTaxIncludedIndicator(){
		return TaxIncludedIndicator;
	}

	public String getUUID(){
		return UUID;
	}

	public Period getWarranty Validity Period(){
		return Warranty Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Period(Period newVal){
		Delivery Period = newVal;
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
	public void setEstimatedAmount(BigDecimal newVal){
		EstimatedAmount = newVal;
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
	public void setMaximumAmount(BigDecimal newVal){
		MaximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(BigDecimal newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(BigDecimal newVal){
		MinimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(BigDecimal newVal){
		MinimumQuantity = newVal;
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
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequired Item Location Quantity(Item Location Quantity newVal){
		Required Item Location Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSub Request For Tender Line(Request For Tender Line newVal){
		Sub Request For Tender Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxIncludedIndicator(boolean newVal){
		TaxIncludedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWarranty Validity Period(Period newVal){
		Warranty Validity Period = newVal;
	}
}//end Request For Tender Line