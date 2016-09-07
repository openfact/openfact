

/**
 * A class to define a line in a Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:15 a. m.
 */
public class Tender Line {

	/**
	 * The unit of measure and quantity of the orderable unit.
	 */
	private Quantity. Type ContentUnitQuantity;
	/**
	 * An identifier for this tender line.
	 */
	private Identifier. Type ID;
	/**
	 * The total amount for this tender line, including allowance charges but net of
	 * taxes.
	 */
	private Amount. Type LineExtensionAmount;
	/**
	 * The maximum number of items described in this tender line that can be ordered.
	 */
	private Quantity. Type MaximumOrderQuantity;
	/**
	 * The minimum number of items described in this tender line that can be ordered.
	 */
	private Quantity. Type MinimumOrderQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * Text describing a unit in which the item described in this tender line can be
	 * ordered.
	 */
	private Text. Type OrderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private Numeric. Type OrderQuantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this tender line.
	 */
	private Code. Type PackLevelCode;
	/**
	 * The quantity of the item quoted in this tender line.
	 */
	private Quantity. Type Quantity;
	/**
	 * The total tax amount for this tender line.
	 */
	private Amount. Type TotalTaxAmount;
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this tender line.
	 */
	private Text. Type WarrantyInformation;
	private Document Reference Call For Tenders Document Reference;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Item Location Quantity Offered Item Location Quantity;
	private Line Reference Call For Tenders Line Reference;
	private Party Warranty Party;
	private Period Warranty Validity Period;
	private Related Item Replacement Related Item;
	private Tender Line Sub Tender Line;

	public Tender Line(){

	}

	public void finalize() throws Throwable {

	}
	public Document Reference getCall For Tenders Document Reference(){
		return Call For Tenders Document Reference;
	}

	public Line Reference getCall For Tenders Line Reference(){
		return Call For Tenders Line Reference;
	}

	public Quantity. Type getContentUnitQuantity(){
		return ContentUnitQuantity;
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

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Quantity. Type getMaximumOrderQuantity(){
		return MaximumOrderQuantity;
	}

	public Quantity. Type getMinimumOrderQuantity(){
		return MinimumOrderQuantity;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Item Location Quantity getOffered Item Location Quantity(){
		return Offered Item Location Quantity;
	}

	public Text. Type getOrderableUnit(){
		return OrderableUnit;
	}

	public Numeric. Type getOrderQuantityIncrementNumeric(){
		return OrderQuantityIncrementNumeric;
	}

	public Code. Type getPackLevelCode(){
		return PackLevelCode;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Related Item getReplacement Related Item(){
		return Replacement Related Item;
	}

	public Tender Line getSub Tender Line(){
		return Sub Tender Line;
	}

	public Amount. Type getTotalTaxAmount(){
		return TotalTaxAmount;
	}

	public Party getWarranty Party(){
		return Warranty Party;
	}

	public Period getWarranty Validity Period(){
		return Warranty Validity Period;
	}

	public Text. Type getWarrantyInformation(){
		return WarrantyInformation;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCall For Tenders Document Reference(Document Reference newVal){
		Call For Tenders Document Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCall For Tenders Line Reference(Line Reference newVal){
		Call For Tenders Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContentUnitQuantity(Quantity. Type newVal){
		ContentUnitQuantity = newVal;
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
	public void setLineExtensionAmount(Amount. Type newVal){
		LineExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumOrderQuantity(Quantity. Type newVal){
		MaximumOrderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumOrderQuantity(Quantity. Type newVal){
		MinimumOrderQuantity = newVal;
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
	public void setOffered Item Location Quantity(Item Location Quantity newVal){
		Offered Item Location Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderableUnit(Text. Type newVal){
		OrderableUnit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderQuantityIncrementNumeric(Numeric. Type newVal){
		OrderQuantityIncrementNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackLevelCode(Code. Type newVal){
		PackLevelCode = newVal;
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
	public void setReplacement Related Item(Related Item newVal){
		Replacement Related Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSub Tender Line(Tender Line newVal){
		Sub Tender Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalTaxAmount(Amount. Type newVal){
		TotalTaxAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWarranty Party(Party newVal){
		Warranty Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWarranty Validity Period(Period newVal){
		Warranty Validity Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWarrantyInformation(Text. Type newVal){
		WarrantyInformation = newVal;
	}
}//end Tender Line