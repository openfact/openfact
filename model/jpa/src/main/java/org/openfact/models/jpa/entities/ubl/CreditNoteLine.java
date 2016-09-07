package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Credit Note or Self Billed Credit Note.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLine {

	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as text.
	 */
	private String AccountingCost;
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as a
	 * code.
	 */
	private String AccountingCostCode;
	/**
	 * The quantity of items credited in this credit note line.
	 */
	private BigDecimal CreditedQuantity;
	/**
	 * An indicator that this credit note line is free of charge (true) or not (false).
	 * The default is false.
	 */
	private boolean FreeOfChargeIndicator;
	/**
	 * An identifier for this credit note line.
	 */
	private String ID;
	/**
	 * The total amount for this credit note line, including allowance charges but
	 * exclusive of taxes.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private String PaymentPurposeCode;
	/**
	 * The date of this credit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private LocalDate TaxPointDate;
	/**
	 * A universally unique identifier for this credit note line.
	 */
	private String UUID;
	private Allowance Charge m_Allowance Charge;
	private Billing Reference m_Billing Reference;
	private Credit Note Line Sub Credit Note Line;
	private Delivery m_Delivery;
	private Delivery Terms m_Delivery Terms;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Line Reference Receipt Line Reference;
	private Line Reference Despatch Line Reference;
	private Order Line Reference m_Order Line Reference;
	private Party Originator Party;
	private Payment Terms m_Payment Terms;
	private Period Invoice Period;
	private Price m_Price;
	private Price Extension Item Price Extension;
	private Pricing Reference m_Pricing Reference;
	private Response Discrepancy Response;
	private Tax Total m_Tax Total;

	public Credit Note Line(){

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

	public Billing Reference getBilling Reference(){
		return m_Billing Reference;
	}

	public BigDecimal getCreditedQuantity(){
		return CreditedQuantity;
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

	public Response getDiscrepancy Response(){
		return Discrepancy Response;
	}

	public Document Reference getDocument Reference(){
		return m_Document Reference;
	}

	public boolean getFreeOfChargeIndicator(){
		return FreeOfChargeIndicator;
	}

	public String getID(){
		return ID;
	}

	public Period getInvoice Period(){
		return Invoice Period;
	}

	public Item getItem(){
		return m_Item;
	}

	public Price Extension getItem Price Extension(){
		return Item Price Extension;
	}

	public BigDecimal getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public String getNote(){
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

	public String getPaymentPurposeCode(){
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

	public Credit Note Line getSub Credit Note Line(){
		return Sub Credit Note Line;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public LocalDate getTaxPointDate(){
		return TaxPointDate;
	}

	public String getUUID(){
		return UUID;
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
	public void setBilling Reference(Billing Reference newVal){
		m_Billing Reference = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCreditedQuantity(BigDecimal newVal){
		CreditedQuantity = newVal;
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
	public void setDiscrepancy Response(Response newVal){
		Discrepancy Response = newVal;
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
	public void setFreeOfChargeIndicator(boolean newVal){
		FreeOfChargeIndicator = newVal;
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
	public void setInvoice Period(Period newVal){
		Invoice Period = newVal;
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
	public void setLineExtensionAmount(BigDecimal newVal){
		LineExtensionAmount = newVal;
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
	public void setPaymentPurposeCode(String newVal){
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
	public void setSub Credit Note Line(Credit Note Line newVal){
		Sub Credit Note Line = newVal;
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
	public void setTaxPointDate(LocalDate newVal){
		TaxPointDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end Credit Note Line