package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a set of payment terms.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:41 a. m.
 */
public class PaymentTerms {

	/**
	 * The monetary amount covered by these payment terms.
	 */
	private Amount. Type Amount;
	/**
	 * An identifier for this set of payment terms.
	 */
	private Identifier. Type ID;
	/**
	 * The due date for an installment payment for these payment terms.
	 */
	private Date. Type InstallmentDueDate;
	/**
	 * A reference to the payment terms used by the invoicing party. This may have
	 * been requested of the payer by the payee to accompany its remittance.
	 */
	private Text. Type InvoicingPartyReference;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The due date for these payment terms.
	 */
	private Date. Type PaymentDueDate;
	/**
	 * An identifier for a means of payment associated with these payment terms.
	 */
	private Identifier. Type PaymentMeansID;
	/**
	 * The part of a payment, expressed as a percent, relevant for these payment terms.
	 */
	private Percent. Type PaymentPercent;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing additional
	 * details regarding these payment terms.
	 */
	private Identifier. Type PaymentTermsDetailsURIID;
	/**
	 * The monetary amount of the penalty for payment after the settlement period.
	 */
	private Amount. Type PenaltyAmount;
	/**
	 * The penalty for payment after the settlement period, expressed as a percentage
	 * of the payment.
	 */
	private Percent. Type PenaltySurchargePercent;
	/**
	 * An identifier for a reference to a prepaid payment.
	 */
	private Identifier. Type PrepaidPaymentReferenceID;
	/**
	 * A code signifying the event during which these terms are offered.
	 */
	private Code. Type ReferenceEventCode;
	/**
	 * The amount of a settlement discount offered for payment under these payment
	 * terms.
	 */
	private Amount. Type SettlementDiscountAmount;
	/**
	 * The percentage for the settlement discount that is offered for payment under
	 * these payment terms.
	 */
	private Percent. Type SettlementDiscountPercent;
	private Exchange Rate m_Exchange Rate;
	private Period Settlement Period;
	private Period Penalty Period;
	private Period Validity Period;

	public Payment Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAmount(){
		return Amount;
	}

	public Exchange Rate getExchange Rate(){
		return m_Exchange Rate;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getInstallmentDueDate(){
		return InstallmentDueDate;
	}

	public Text. Type getInvoicingPartyReference(){
		return InvoicingPartyReference;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Date. Type getPaymentDueDate(){
		return PaymentDueDate;
	}

	public Identifier. Type getPaymentMeansID(){
		return PaymentMeansID;
	}

	public Percent. Type getPaymentPercent(){
		return PaymentPercent;
	}

	public Identifier. Type getPaymentTermsDetailsURIID(){
		return PaymentTermsDetailsURIID;
	}

	public Period getPenalty Period(){
		return Penalty Period;
	}

	public Amount. Type getPenaltyAmount(){
		return PenaltyAmount;
	}

	public Percent. Type getPenaltySurchargePercent(){
		return PenaltySurchargePercent;
	}

	public Identifier. Type getPrepaidPaymentReferenceID(){
		return PrepaidPaymentReferenceID;
	}

	public Code. Type getReferenceEventCode(){
		return ReferenceEventCode;
	}

	public Period getSettlement Period(){
		return Settlement Period;
	}

	public Amount. Type getSettlementDiscountAmount(){
		return SettlementDiscountAmount;
	}

	public Percent. Type getSettlementDiscountPercent(){
		return SettlementDiscountPercent;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(Amount. Type newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchange Rate(Exchange Rate newVal){
		m_Exchange Rate = newVal;
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
	public void setInstallmentDueDate(Date. Type newVal){
		InstallmentDueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInvoicingPartyReference(Text. Type newVal){
		InvoicingPartyReference = newVal;
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
	public void setPaymentDueDate(Date. Type newVal){
		PaymentDueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentMeansID(Identifier. Type newVal){
		PaymentMeansID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentPercent(Percent. Type newVal){
		PaymentPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentTermsDetailsURIID(Identifier. Type newVal){
		PaymentTermsDetailsURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenalty Period(Period newVal){
		Penalty Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenaltyAmount(Amount. Type newVal){
		PenaltyAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPenaltySurchargePercent(Percent. Type newVal){
		PenaltySurchargePercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrepaidPaymentReferenceID(Identifier. Type newVal){
		PrepaidPaymentReferenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenceEventCode(Code. Type newVal){
		ReferenceEventCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSettlement Period(Period newVal){
		Settlement Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSettlementDiscountAmount(Amount. Type newVal){
		SettlementDiscountAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSettlementDiscountPercent(Percent. Type newVal){
		SettlementDiscountPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Payment Terms