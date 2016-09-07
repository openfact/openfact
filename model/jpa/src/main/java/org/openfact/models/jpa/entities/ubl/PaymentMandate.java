package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a payment mandate.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
public class PaymentMandate {

	/**
	 * An identifier for this payment mandate.
	 */
	private String ID;
	/**
	 * A code signifying the type of this payment mandate.
	 */
	private String MandateTypeCode;
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	private BigDecimal MaximumPaidAmount;
	/**
	 * The number of maximum payment instructions allowed within the validity period.
	 */
	private BigDecimal MaximumPaymentInstructionsNumeric;
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	private String SignatureID;
	private Clause m_Clause;
	private FinancialAccount Payer FinancialAccount;
	private Party Payer Party;
	private Period Validity Period;
	private Period Payment Reversal Period;

	public PaymentMandate(){

	}

	public void finalize() throws Throwable {

	}
	public Clause getClause(){
		return m_Clause;
	}

	public String getID(){
		return ID;
	}

	public String getMandateTypeCode(){
		return MandateTypeCode;
	}

	public BigDecimal getMaximumPaidAmount(){
		return MaximumPaidAmount;
	}

	public BigDecimal getMaximumPaymentInstructionsNumeric(){
		return MaximumPaymentInstructionsNumeric;
	}

	public FinancialAccount getPayer FinancialAccount(){
		return Payer FinancialAccount;
	}

	public Party getPayer Party(){
		return Payer Party;
	}

	public Period getPayment Reversal Period(){
		return Payment Reversal Period;
	}

	public String getSignatureID(){
		return SignatureID;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setClause(Clause newVal){
		m_Clause = newVal;
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
	public void setMandateTypeCode(String newVal){
		MandateTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumPaidAmount(BigDecimal newVal){
		MaximumPaidAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumPaymentInstructionsNumeric(BigDecimal newVal){
		MaximumPaymentInstructionsNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayer FinancialAccount(FinancialAccount newVal){
		Payer FinancialAccount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayer Party(Party newVal){
		Payer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Reversal Period(Period newVal){
		Payment Reversal Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSignatureID(String newVal){
		SignatureID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end PaymentMandate