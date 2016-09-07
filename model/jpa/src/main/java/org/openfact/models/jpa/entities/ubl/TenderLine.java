package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Tender.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:15 a. m.
 */
public class TenderLine {

	/**
	 * The unit of measure and quantity of the orderable unit.
	 */
	private BigDecimal ContentUnitQuantity;
	/**
	 * An identifier for this tender line.
	 */
	private String ID;
	/**
	 * The total amount for this tender line, including allowance charges but net of
	 * taxes.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * The maximum number of items described in this tender line that can be ordered.
	 */
	private BigDecimal MaximumOrderQuantity;
	/**
	 * The minimum number of items described in this tender line that can be ordered.
	 */
	private BigDecimal MinimumOrderQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * Text describing a unit in which the item described in this tender line can be
	 * ordered.
	 */
	private String OrderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private BigDecimal OrderQuantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this tender line.
	 */
	private String PackLevelCode;
	/**
	 * The quantity of the item quoted in this tender line.
	 */
	private BigDecimal Quantity;
	/**
	 * The total tax amount for this tender line.
	 */
	private BigDecimal TotalTaxAmount;
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this tender line.
	 */
	private String WarrantyInformation;
	private DocumentReference Call For Tenders DocumentReference;
	private DocumentReference m_DocumentReference;
	private Item m_Item;
	private Item Location Quantity Offered Item Location Quantity;
	private LineReference Call For Tenders LineReference;
	private Party Warranty Party;
	private Period Warranty Validity Period;
	private Related Item Replacement Related Item;
	private Tender Line Sub Tender Line;

	public Tender Line(){

	}

	public void finalize() throws Throwable {

	}
	public DocumentReference getCall For Tenders DocumentReference(){
		return Call For Tenders DocumentReference;
	}

	public LineReference getCall For Tenders LineReference(){
		return Call For Tenders LineReference;
	}

	public BigDecimal getContentUnitQuantity(){
		return ContentUnitQuantity;
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

	public BigDecimal getLineExtensionAmount(){
		return LineExtensionAmount;
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

	public Item Location Quantity getOffered Item Location Quantity(){
		return Offered Item Location Quantity;
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

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public Related Item getReplacement Related Item(){
		return Replacement Related Item;
	}

	public Tender Line getSub Tender Line(){
		return Sub Tender Line;
	}

	public BigDecimal getTotalTaxAmount(){
		return TotalTaxAmount;
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
	public void setContentUnitQuantity(BigDecimal newVal){
		ContentUnitQuantity = newVal;
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
	public void setLineExtensionAmount(BigDecimal newVal){
		LineExtensionAmount = newVal;
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
	public void setOffered Item Location Quantity(Item Location Quantity newVal){
		Offered Item Location Quantity = newVal;
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
	public void setQuantity(BigDecimal newVal){
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
	public void setTotalTaxAmount(BigDecimal newVal){
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
	public void setWarrantyInformation(String newVal){
		WarrantyInformation = newVal;
	}
}//end Tender Line