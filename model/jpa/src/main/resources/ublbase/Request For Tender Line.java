

/**
 * A class to define a line in a Request for Tender describing an item of goods or
 * a service solicited in the Request for Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class Request For Tender Line {

	/**
	 * The estimated total amount of the deliverable.
	 */
	private Amount. Type EstimatedAmount;
	/**
	 * An identifier for this request for tender line.
	 */
	private Identifier. Type ID;
	/**
	 * The maximum amount allowed for this deliverable.
	 */
	private Amount. Type MaximumAmount;
	/**
	 * The maximum quantity of the item associated with this request for tender line.
	 */
	private Quantity. Type MaximumQuantity;
	/**
	 * The minimum amount allowed for this deliverable.
	 */
	private Amount. Type MinimumAmount;
	/**
	 * The minimum quantity of the item associated with this request for tender line.
	 */
	private Quantity. Type MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The quantity of the item for which a tender is requested in this line.
	 */
	private Quantity. Type Quantity;
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private Indicator. Type TaxIncludedIndicator;
	/**
	 * A universally unique identifier for this request for tender line.
	 */
	private Identifier. Type UUID;
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

	public Amount. Type getEstimatedAmount(){
		return EstimatedAmount;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Amount. Type getMaximumAmount(){
		return MaximumAmount;
	}

	public Quantity. Type getMaximumQuantity(){
		return MaximumQuantity;
	}

	public Amount. Type getMinimumAmount(){
		return MinimumAmount;
	}

	public Quantity. Type getMinimumQuantity(){
		return MinimumQuantity;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Item Location Quantity getRequired Item Location Quantity(){
		return Required Item Location Quantity;
	}

	public Request For Tender Line getSub Request For Tender Line(){
		return Sub Request For Tender Line;
	}

	public Indicator. Type getTaxIncludedIndicator(){
		return TaxIncludedIndicator;
	}

	public Identifier. Type getUUID(){
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
	public void setEstimatedAmount(Amount. Type newVal){
		EstimatedAmount = newVal;
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
	public void setMaximumAmount(Amount. Type newVal){
		MaximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(Quantity. Type newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(Amount. Type newVal){
		MinimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(Quantity. Type newVal){
		MinimumQuantity = newVal;
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
	public void setQuantity(Quantity. Type newVal){
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
	public void setTaxIncludedIndicator(Indicator. Type newVal){
		TaxIncludedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
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