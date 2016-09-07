package org.openfact.models.jpa.entities.ubl;


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
	private String ActionCode;
	/**
	 * The numeric quantity of the ordering unit (and units of measure) of the
	 * catalogue line.
	 */
	private BigDecimal ContentUnitQuantity;
	/**
	 * A subdivision of a contract or tender covering this catalogue line.
	 */
	private String ContractSubdivision;
	/**
	 * An identifier for the line in the catalogue.
	 */
	private String ID;
	/**
	 * A code signifying the life cycle status of this catalogue line. Examples are
	 * pre-order, end of production
	 */
	private String LifeCycleStatusCode;
	/**
	 * The maximum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private BigDecimal MaximumOrderQuantity;
	/**
	 * The minimum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private BigDecimal MinimumOrderQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * An indicator that this catalogue line describes an orderable item (true) or is
	 * included for reference purposes only (false).
	 */
	private boolean OrderableIndicator;
	/**
	 * A textual description of the units in which the item described in this
	 * catalogue line can be ordered.
	 */
	private String OrderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private BigDecimal OrderQuantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this catalogue line.
	 */
	private String PackLevelCode;
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this catalogue line.
	 */
	private String WarrantyInformation;
	private Customer Party Contractor Customer Party;
	private DocumentReference Call For Tenders DocumentReference;
	private DocumentReference m_DocumentReference;
	private Item m_Item;
	private Item Comparison m_Item Comparison;
	private Item Location Quantity Required Item Location Quantity;
	private Item Property Keyword Item Property;
	private LineReference Call For Tenders LineReference;
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

	public String getActionCode(){
		return ActionCode;
	}

	public DocumentReference getCall For Tenders DocumentReference(){
		return Call For Tenders DocumentReference;
	}

	public LineReference getCall For Tenders LineReference(){
		return Call For Tenders LineReference;
	}

	public Related Item getComplementary Related Item(){
		return Complementary Related Item;
	}

	public Related Item getComponent Related Item(){
		return Component Related Item;
	}

	public BigDecimal getContentUnitQuantity(){
		return ContentUnitQuantity;
	}

	public Customer Party getContractor Customer Party(){
		return Contractor Customer Party;
	}

	public String getContractSubdivision(){
		return ContractSubdivision;
	}

	public DocumentReference getDocumentReference(){
		return m_DocumentReference;
	}

	public String getID(){
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

	public String getLifeCycleStatusCode(){
		return LifeCycleStatusCode;
	}

	public Period getLine Validity Period(){
		return Line Validity Period;
	}

	public BigDecimal getMaximumOrderQuantity(){
		return MaximumOrderQuantity;
	}

	public BigDecimal getMinimumOrderQuantity(){
		return MinimumOrderQuantity;
	}

	public String getNote(){
		return Note;
	}

	public boolean getOrderableIndicator(){
		return OrderableIndicator;
	}

	public String getOrderableUnit(){
		return OrderableUnit;
	}

	public BigDecimal getOrderQuantityIncrementNumeric(){
		return OrderQuantityIncrementNumeric;
	}

	public String getPackLevelCode(){
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

	public String getWarrantyInformation(){
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
	public void setActionCode(String newVal){
		ActionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCall For Tenders DocumentReference(DocumentReference newVal){
		Call For Tenders DocumentReference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCall For Tenders LineReference(LineReference newVal){
		Call For Tenders LineReference = newVal;
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
	public void setContentUnitQuantity(BigDecimal newVal){
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
	public void setContractSubdivision(String newVal){
		ContractSubdivision = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDocumentReference(DocumentReference newVal){
		m_DocumentReference = newVal;
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
	public void setLifeCycleStatusCode(String newVal){
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
	public void setMaximumOrderQuantity(BigDecimal newVal){
		MaximumOrderQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumOrderQuantity(BigDecimal newVal){
		MinimumOrderQuantity = newVal;
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
	public void setOrderableIndicator(boolean newVal){
		OrderableIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderableUnit(String newVal){
		OrderableUnit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOrderQuantityIncrementNumeric(BigDecimal newVal){
		OrderQuantityIncrementNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackLevelCode(String newVal){
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
	public void setWarrantyInformation(String newVal){
		WarrantyInformation = newVal;
	}
}//end Catalogue Line