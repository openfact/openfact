

/**
 * A class to define a line in a Catalogue describing a purchasable item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:19 a. m.
 */
public class CatalogueLine {

	/**
	 * A code signifying the action required to synchronize this catalogue line.
	 * Recommend codes (delete, update, add)
	 */
	private Code. Type ActionCode;
	/**
	 * The numeric quantity of the ordering unit (and units of measure) of the
	 * catalogue line.
	 */
	private Quantity. Type ContentUnitQuantity;
	/**
	 * A subdivision of a contract or tender covering this catalogue line.
	 */
	private Text. Type ContractSubdivision;
	/**
	 * An identifier for the line in the catalogue.
	 */
	private Identifier. Type ID;
	/**
	 * A code signifying the life cycle status of this catalogue line. Examples are
	 * pre-order, end of production
	 */
	private Code. Type LifeCycleStatusCode;
	/**
	 * The maximum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private Quantity. Type MaximumOrderQuantity;
	/**
	 * The minimum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private Quantity. Type MinimumOrderQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * An indicator that this catalogue line describes an orderable item (true) or is
	 * included for reference purposes only (false).
	 */
	private Indicator. Type OrderableIndicator;
	/**
	 * A textual description of the units in which the item described in this
	 * catalogue line can be ordered.
	 */
	private Text. Type OrderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private Numeric. Type OrderQuantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this catalogue line.
	 */
	private Code. Type PackLevelCode;
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this catalogue line.
	 */
	private Text. Type WarrantyInformation;
	private Customer Party Contractor Customer Party;
	private Document Reference Call For Tenders Document Reference;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Item Comparison m_Item Comparison;
	private Item Location Quantity Required Item Location Quantity;
	private Item Property Keyword Item Property;
	private Line Reference Call For Tenders Line Reference;
	private Party Warranty Party;
	private Period Warranty Validity Period;
	private Period Line Validity Period;
	private Related Item Component Related Item;
	private Related Item Replaced Related Item;
	private Related Item Complementary Related Item;
	private Related Item Replacement Related Item;
	private Related Item Accessory Related Item;
	private Related Item Required Related Item;
	private Supplier Party Seller Supplier Party;

	public Catalogue Line(){

	}

	public void finalize() throws Throwable {

	}
	public Related Item getAccessory Related Item(){
		return Accessory Related Item;
	}

	public Code. Type getActionCode(){
		return ActionCode;
	}

	public Document Reference getCall For Tenders Document Reference(){
		return Call For Tenders Document Reference;
	}

	public Line Reference getCall For Tenders Line Reference(){
		return Call For Tenders Line Reference;
	}

	public Related Item getComplementary Related Item(){
		return Complementary Related Item;
	}

	public Related Item getComponent Related Item(){
		return Component Related Item;
	}

	public Quantity. Type getContentUnitQuantity(){
		return ContentUnitQuantity;
	}

	public Customer Party getContractor Customer Party(){
		return Contractor Customer Party;
	}

	public Text. Type getContractSubdivision(){
		return ContractSubdivision;
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

	public Item Comparison getItem Comparison(){
		return m_Item Comparison;
	}

	public Item Property getKeyword Item Property(){
		return Keyword Item Property;
	}

	public Code. Type getLifeCycleStatusCode(){
		return LifeCycleStatusCode;
	}

	public Period getLine Validity Period(){
		return Line Validity Period;
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

	public Indicator. Type getOrderableIndicator(){
		return OrderableIndicator;
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

	public Related Item getReplaced Related Item(){
		return Replaced Related Item;
	}

	public Related Item getReplacement Related Item(){
		return Replacement Related Item;
	}

	public Item Location Quantity getRequired Item Location Quantity(){
		return Required Item Location Quantity;
	}

	public Related Item getRequired Related Item(){
		return Required Related Item;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
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
	public void setAccessory Related Item(Related Item newVal){
		Accessory Related Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActionCode(Code. Type newVal){
		ActionCode = newVal;
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
	public void setComplementary Related Item(Related Item newVal){
		Complementary Related Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComponent Related Item(Related Item newVal){
		Component Related Item = newVal;
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
	public void setContractor Customer Party(Customer Party newVal){
		Contractor Customer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractSubdivision(Text. Type newVal){
		ContractSubdivision = newVal;
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
	public void setItem Comparison(Item Comparison newVal){
		m_Item Comparison = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setKeyword Item Property(Item Property newVal){
		Keyword Item Property = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLifeCycleStatusCode(Code. Type newVal){
		LifeCycleStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLine Validity Period(Period newVal){
		Line Validity Period = newVal;
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
	public void setOrderableIndicator(Indicator. Type newVal){
		OrderableIndicator = newVal;
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
	public void setReplaced Related Item(Related Item newVal){
		Replaced Related Item = newVal;
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
	public void setRequired Item Location Quantity(Item Location Quantity newVal){
		Required Item Location Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequired Related Item(Related Item newVal){
		Required Related Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
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
}//end Catalogue Line