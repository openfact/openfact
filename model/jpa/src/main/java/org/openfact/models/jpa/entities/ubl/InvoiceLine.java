package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in an Invoice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLine {

	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as text.
	 */
	private Text. Type AccountingCost;
	/**
	 * The buyer's accounting cost centre for this invoice line, expressed as a code.
	 */
	private Code. Type AccountingCostCode;
	/**
	 * An indicator that this invoice line is free of charge (true) or not (false).
	 * The default is false.
	 */
	private Indicator. Type FreeOfChargeIndicator;
	/**
	 * An identifier for this invoice line.
	 */
	private Identifier. Type ID;
	/**
	 * The quantity (of items) on this invoice line.
	 */
	private Quantity. Type InvoicedQuantity;
	/**
	 * The total amount for this invoice line, including allowance charges but net of
	 * taxes.
	 */
	private Amount. Type LineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private Code. Type PaymentPurposeCode;
	/**
	 * The date of this invoice line, used to indicate the point at which tax becomes
	 * applicable.
	 */
	private Date. Type TaxPointDate;
	/**
	 * A universally unique identifier for this invoice line.
	 */
	private Identifier. Type UUID;
	private Allowance Charge m_Allowance Charge;
	private Billing Reference m_Billing Reference;
	private Delivery m_Delivery;
	private Delivery Terms m_Delivery Terms;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Line Reference Despatch Line Reference;
	private Line Reference Receipt Line Reference;
	private Order Line Reference m_Order Line Reference;
	private Party Originator Party;
	private Payment Terms m_Payment Terms;
	private Period Invoice Period;
	private Invoice Line Sub Invoice Line;
	private Price m_Price;
	private Price Extension Item Price Extension;
	private Pricing Reference m_Pricing Reference;
	private Tax Total Withholding Tax Total;
	private Tax Total m_Tax Total;

	public Invoice Line(){

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

	public Billing Reference getBilling Reference(){
		return m_Billing Reference;
	}

	public Delivery getDelivery(){
		return m_Delivery;
	}

	public Delivery Terms getDelivery Terms(){
		return m_Delivery Terms;
	}

	public Line Reference getDespatch Line Reference(){
		return Despatch Line Reference;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public Indicator. Type getFreeOfChargeIndicator(){
		return FreeOfChargeIndicator;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Period getInvoice Period(){
		return Invoice Period;
	}

	public Quantity. Type getInvoicedQuantity(){
		return InvoicedQuantity;
	}

	public Item getItem(){
		return m_Item;
	}

	public Price Extension getItem Price Extension(){
		return Item Price Extension;
	}

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Order Line Reference getOrder Line Reference(){
		return m_Order Line Reference;
	}

	public Party getOriginator Party(){
		return Originator Party;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	public Code. Type getPaymentPurposeCode(){
		return PaymentPurposeCode;
	}

	public Price getPrice(){
		return m_Price;
	}

	public Pricing Reference getPricing Reference(){
		return m_Pricing Reference;
	}

	public Line Reference getReceipt Line Reference(){
		return Receipt Line Reference;
	}

	public Invoice Line getSub Invoice Line(){
		return Sub Invoice Line;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Date. Type getTaxPointDate(){
		return TaxPointDate;
	}

	public Identifier. Type getUUID(){
		return UUID;
	}

	public Tax Total getWithholding Tax Total(){
		return Withholding Tax Total;
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
	public void setBilling Reference(Billing Reference newVal){
		m_Billing Reference = newVal;
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
	public void setDespatch Line Reference(Line Reference newVal){
		Despatch Line Reference = newVal;
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
	public void setFreeOfChargeIndicator(Indicator. Type newVal){
		FreeOfChargeIndicator = newVal;
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
	public void setInvoice Period(Period newVal){
		Invoice Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoicedQuantity(Quantity. Type newVal){
		InvoicedQuantity = newVal;
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
	public void setLineExtensionAmount(Amount. Type newVal){
		LineExtensionAmount = newVal;
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
	public void setOriginator Party(Party newVal){
		Originator Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Terms(Payment Terms newVal){
		m_Payment Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentPurposeCode(Code. Type newVal){
		PaymentPurposeCode = newVal;
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
	public void setReceipt Line Reference(Line Reference newVal){
		Receipt Line Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSub Invoice Line(Invoice Line newVal){
		Sub Invoice Line = newVal;
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
	public void setTaxPointDate(Date. Type newVal){
		TaxPointDate = newVal;
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
	public void setWithholding Tax Total(Tax Total newVal){
		Withholding Tax Total = newVal;
	}
}//end Invoice Line