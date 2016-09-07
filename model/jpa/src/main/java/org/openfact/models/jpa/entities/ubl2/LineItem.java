

/**
 * A class to describe a line item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:55 a. m.
 */
public class LineItem {

	/**
	 * The buyer's accounting cost centre for this line item, expressed as text.
	 */
	private Text. Type AccountingCost;
	/**
	 * The buyer's accounting cost centre for this line item, expressed as a code.
	 */
	private Code. Type AccountingCostCode;
	/**
	 * An indicator that back order is allowed (true) or not (false).
	 */
	private Indicator. Type BackOrderAllowedIndicator;
	/**
	 * An identifier for this line item, assigned by the buyer.
	 */
	private Identifier. Type ID;
	/**
	 * A code signifying the inspection requirements for the item associated with this
	 * line item.
	 */
	private Code. Type InspectionMethodCode;
	/**
	 * The total amount for this line item, including allowance charges but net of
	 * taxes.
	 */
	private Amount. Type LineExtensionAmount;
	/**
	 * A code signifying the status of this line item with respect to its original
	 * state.
	 */
	private Line Status_ Code. Type LineStatusCode;
	/**
	 * The maximum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private Quantity. Type MaximumBackorderQuantity;
	/**
	 * The maximum quantity of the item associated with this line.
	 */
	private Quantity. Type MaximumQuantity;
	/**
	 * The minimum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private Quantity. Type MinimumBackorderQuantity;
	/**
	 * The minimum quantity of the item associated with this line.
	 */
	private Quantity. Type MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * An indicator that a partial delivery is allowed (true) or not (false).
	 */
	private Indicator. Type PartialDeliveryIndicator;
	/**
	 * The quantity of items associated with this line item.
	 */
	private Quantity. Type Quantity;
	/**
	 * An identifier for this line item, assigned by the seller.
	 */
	private Identifier. Type SalesOrderID;
	/**
	 * The total tax amount for this line item.
	 */
	private Amount. Type TotalTaxAmount;
	/**
	 * A universally unique identifier for this line item.
	 */
	private Identifier. Type UUID;
	/**
	 * Text describing a warranty (provided by WarrantyParty) for the good or service
	 * described in this line item.
	 */
	private Text. Type WarrantyInformation;
	private Allowance Charge m_Allowance Charge;
	private Delivery m_Delivery;
	private Delivery Terms m_Delivery Terms;
	private Item m_Item;
	private Line Item Sub Line Item;
	private Line Reference m_Line Reference;
	private Party Originator Party;
	private Party Warranty Party;
	private Period Warranty Validity Period;
	private Ordered Shipment m_Ordered Shipment;
	private Price m_Price;
	private Price Extension Item Price Extension;
	private Pricing Reference m_Pricing Reference;
	private Tax Total m_Tax Total;

	public Line Item(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getAccountingCost(){
		return AccountingCost;
	}

	public Code. Type getAccountingCostCode(){
		return AccountingCostCode;
	}

	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Indicator. Type getBackOrderAllowedIndicator(){
		return BackOrderAllowedIndicator;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public Delivery Terms getDelivery Terms(){
		return m_Delivery Terms;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Code. Type getInspectionMethodCode(){
		return InspectionMethodCode;
	}

	public Item getItem(){
		return m_Item;
	}

	public Price Extension getItem Price Extension(){
		return Item Price Extension;
	}

	public Line Reference getLine Reference(){
		return m_Line Reference;
	}

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Line Status_ Code. Type getLineStatusCode(){
		return LineStatusCode;
	}

	public Quantity. Type getMaximumBackorderQuantity(){
		return MaximumBackorderQuantity;
	}

	public Quantity. Type getMaximumQuantity(){
		return MaximumQuantity;
	}

	public Quantity. Type getMinimumBackorderQuantity(){
		return MinimumBackorderQuantity;
	}

	public Quantity. Type getMinimumQuantity(){
		return MinimumQuantity;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Ordered Shipment getOrdered Shipment(){
		return m_Ordered Shipment;
	}

	public Party getOriginator Party(){
		return Originator Party;
	}

	public Indicator. Type getPartialDeliveryIndicator(){
		return PartialDeliveryIndicator;
	}

	public Price getPrice(){
		return m_Price;
	}

	public Pricing Reference getPricing Reference(){
		return m_Pricing Reference;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Identifier. Type getSalesOrderID(){
		return SalesOrderID;
	}

	public Line Item getSub Line Item(){
		return Sub Line Item;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Amount. Type getTotalTaxAmount(){
		return TotalTaxAmount;
	}

	public Identifier. Type getUUID(){
		return UUID;
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
	public void setAccountingCost(Text. Type newVal){
		AccountingCost = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountingCostCode(Code. Type newVal){
		AccountingCostCode = newVal;
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
	public void setBackOrderAllowedIndicator(Indicator. Type newVal){
		BackOrderAllowedIndicator = newVal;
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
	public void setDelivery Terms(Delivery Terms newVal){
		m_Delivery Terms = newVal;
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
	public void setInspectionMethodCode(Code. Type newVal){
		InspectionMethodCode = newVal;
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
	public void setItem Price Extension(Price Extension newVal){
		Item Price Extension = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLine Reference(Line Reference newVal){
		m_Line Reference = newVal;
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
	public void setLineStatusCode(Line Status_ Code. Type newVal){
		LineStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumBackorderQuantity(Quantity. Type newVal){
		MaximumBackorderQuantity = newVal;
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
	public void setMinimumBackorderQuantity(Quantity. Type newVal){
		MinimumBackorderQuantity = newVal;
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
	public void setOrdered Shipment(Ordered Shipment newVal){
		m_Ordered Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOriginator Party(Party newVal){
		Originator Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPartialDeliveryIndicator(Indicator. Type newVal){
		PartialDeliveryIndicator = newVal;
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
	public void setPricing Reference(Pricing Reference newVal){
		m_Pricing Reference = newVal;
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
	public void setSalesOrderID(Identifier. Type newVal){
		SalesOrderID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSub Line Item(Line Item newVal){
		Sub Line Item = newVal;
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
	public void setTotalTaxAmount(Amount. Type newVal){
		TotalTaxAmount = newVal;
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
}//end Line Item