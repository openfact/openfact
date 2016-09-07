

/**
 * A class to define a line in a Debit Note.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLine {

	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as text.
	 */
	private Text. Type AccountingCost;
	/**
	 * The buyer's accounting cost centre for this debit note line, expressed as a
	 * code.
	 */
	private Code. Type AccountingCostCode;
	/**
	 * The quantity of Items debited in this debit note line.
	 */
	private Quantity. Type DebitedQuantity;
	/**
	 * An identifier for this debit note line.
	 */
	private Identifier. Type ID;
	/**
	 * The total amount for this debit note line, including allowance charges but net
	 * of taxes.
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
	 * The date of this debit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private Date. Type TaxPointDate;
	/**
	 * A universally unique identifier for this debit note line.
	 */
	private Identifier. Type UUID;
	private Allowance Charge m_Allowance Charge;
	private Billing Reference m_Billing Reference;
	private Debit Note Line Sub Debit Note Line;
	private Delivery m_Delivery;
	private Document Reference m_Document Reference;
	private Item m_Item;
	private Line Reference Despatch Line Reference;
	private Line Reference Receipt Line Reference;
	private Price m_Price;
	private Pricing Reference m_Pricing Reference;
	private Response Discrepancy Response;
	private Tax Total m_Tax Total;

	public Debit Note Line(){

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

	public Quantity. Type getDebitedQuantity(){
		return DebitedQuantity;
	}

	public Delivery getDelivery(){
		return m_Delivery;
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

	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Amount. Type getLineExtensionAmount(){
		return LineExtensionAmount;
	}

	public Text. Type getNote(){
		return Note;
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

	public Debit Note Line getSub Debit Note Line(){
		return Sub Debit Note Line;
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
	public void setDebitedQuantity(Quantity. Type newVal){
		DebitedQuantity = newVal;
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
	public void setNote(Text. Type newVal){
		Note = newVal;
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
	public void setSub Debit Note Line(Debit Note Line newVal){
		Sub Debit Note Line = newVal;
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
}//end Debit Note Line