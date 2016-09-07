package org.openfact.models.jpa.entities.ubl;


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
	private String AccountingCost;
	/**
	 * The buyer's accounting cost centre for this line item, expressed as a code.
	 */
	private String AccountingCostCode;
	/**
	 * An indicator that back order is allowed (true) or not (false).
	 */
	private boolean BackOrderAllowedIndicator;
	/**
	 * An identifier for this line item, assigned by the buyer.
	 */
	private String ID;
	/**
	 * A code signifying the inspection requirements for the item associated with this
	 * line item.
	 */
	private String InspectionMethodCode;
	/**
	 * The total amount for this line item, including allowance charges but net of
	 * taxes.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * A code signifying the status of this line item with respect to its original
	 * state.
	 */
	private Line Status_ String LineStatusCode;
	/**
	 * The maximum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private BigDecimal MaximumBackorderQuantity;
	/**
	 * The maximum quantity of the item associated with this line.
	 */
	private BigDecimal MaximumQuantity;
	/**
	 * The minimum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private BigDecimal MinimumBackorderQuantity;
	/**
	 * The minimum quantity of the item associated with this line.
	 */
	private BigDecimal MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * An indicator that a partial delivery is allowed (true) or not (false).
	 */
	private boolean PartialDeliveryIndicator;
	/**
	 * The quantity of items associated with this line item.
	 */
	private BigDecimal Quantity;
	/**
	 * An identifier for this line item, assigned by the seller.
	 */
	private String SalesOrderID;
	/**
	 * The total tax amount for this line item.
	 */
	private BigDecimal TotalTaxAmount;
	/**
	 * A universally unique identifier for this line item.
	 */
	private String UUID;
	/**
	 * Text describing a warranty (provided by WarrantyParty) for the good or service
	 * described in this line item.
	 */
	private String WarrantyInformation;
	private Allowance Charge m_Allowance Charge;
	private Delivery m_Delivery;
	private DeliveryTerms m_DeliveryTerms;
	private Item m_Item;
	private Line Item Sub Line Item;
	private LineReference m_LineReference;
	private Party Originator Party;
	private Party Warranty Party;
	private Period Warranty Validity Period;
	private Ordered Shipment m_Ordered Shipment;
	private Price m_Price;
	private Price Extension Item Price Extension;
	private Pricing Reference m_Pricing Reference;
	private TaxTotal m_TaxTotal;

	public Line Item(){

	}

	public void finalize() throws Throwable {

	}
	public String getAccountingCost(){
		return AccountingCost;
	}

	public String getAccountingCostCode(){
		return AccountingCostCode;
	}

	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public boolean getBackOrderAllowedIndicator(){
		return BackOrderAllowedIndicator;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public DeliveryTerms getDeliveryTerms(){
		return m_DeliveryTerms;
	}

	public String getID(){
		return ID;
	}

	public String getInspectionMethodCode(){
		return InspectionMethodCode;
	}

	public Item getItem(){
		return m_Item;
	}

	public Price Extension getItem Price Extension(){
		return Item Price Extension;
	}

	public LineReference getLineReference(){
		return m_LineReference;
	}

	public BigDecimal getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Line Status_ String getLineStatusCode(){
		return LineStatusCode;
	}

	public BigDecimal getMaximumBackorderQuantity(){
		return MaximumBackorderQuantity;
	}

	public BigDecimal getMaximumQuantity(){
		return MaximumQuantity;
	}

	public BigDecimal getMinimumBackorderQuantity(){
		return MinimumBackorderQuantity;
	}

	public BigDecimal getMinimumQuantity(){
		return MinimumQuantity;
	}

	public String getNote(){
		return Note;
	}

	public Ordered Shipment getOrdered Shipment(){
		return m_Ordered Shipment;
	}

	public Party getOriginator Party(){
		return Originator Party;
	}

	public boolean getPartialDeliveryIndicator(){
		return PartialDeliveryIndicator;
	}

	public Price getPrice(){
		return m_Price;
	}

	public Pricing Reference getPricing Reference(){
		return m_Pricing Reference;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public String getSalesOrderID(){
		return SalesOrderID;
	}

	public Line Item getSub Line Item(){
		return Sub Line Item;
	}

	public TaxTotal getTaxTotal(){
		return m_TaxTotal;
	}

	public BigDecimal getTotalTaxAmount(){
		return TotalTaxAmount;
	}

	public String getUUID(){
		return UUID;
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
	public void setAccountingCost(String newVal){
		AccountingCost = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAccountingCostCode(String newVal){
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
	public void setBackOrderAllowedIndicator(boolean newVal){
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
	public void setDeliveryTerms(DeliveryTerms newVal){
		m_DeliveryTerms = newVal;
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
	public void setInspectionMethodCode(String newVal){
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
	public void setLineReference(LineReference newVal){
		m_LineReference = newVal;
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
	public void setLineStatusCode(Line Status_ String newVal){
		LineStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumBackorderQuantity(BigDecimal newVal){
		MaximumBackorderQuantity = newVal;
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
	public void setMinimumBackorderQuantity(BigDecimal newVal){
		MinimumBackorderQuantity = newVal;
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
	public void setPartialDeliveryIndicator(boolean newVal){
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
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSalesOrderID(String newVal){
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
	public void setTaxTotal(TaxTotal newVal){
		m_TaxTotal = newVal;
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
	public void setUUID(String newVal){
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
	public void setWarrantyInformation(String newVal){
		WarrantyInformation = newVal;
	}
}//end Line Item