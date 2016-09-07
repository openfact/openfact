

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
	private Identifier. Type ID;
	/**
	 * A code signifying the type of this payment mandate.
	 */
	private Code. Type MandateTypeCode;
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	private Amount. Type MaximumPaidAmount;
	/**
	 * The number of maximum payment instructions allowed within the validity period.
	 */
	private Numeric. Type MaximumPaymentInstructionsNumeric;
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	private Identifier. Type SignatureID;
	private Clause m_Clause;
	private Financial Account Payer Financial Account;
	private Party Payer Party;
	private Period Validity Period;
	private Period Payment Reversal Period;

	public Payment Mandate(){

	}

	public void finalize() throws Throwable {

	}
	public Clause getClause(){
		return m_Clause;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Code. Type getMandateTypeCode(){
		return MandateTypeCode;
	}

	public Amount. Type getMaximumPaidAmount(){
		return MaximumPaidAmount;
	}

	public Numeric. Type getMaximumPaymentInstructionsNumeric(){
		return MaximumPaymentInstructionsNumeric;
	}

	public Financial Account getPayer Financial Account(){
		return Payer Financial Account;
	}

	public Party getPayer Party(){
		return Payer Party;
	}

	public Period getPayment Reversal Period(){
		return Payment Reversal Period;
	}

	public Identifier. Type getSignatureID(){
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMandateTypeCode(Code. Type newVal){
		MandateTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumPaidAmount(Amount. Type newVal){
		MaximumPaidAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumPaymentInstructionsNumeric(Numeric. Type newVal){
		MaximumPaymentInstructionsNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayer Financial Account(Financial Account newVal){
		Payer Financial Account = newVal;
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
	public void setSignatureID(Identifier. Type newVal){
		SignatureID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Payment Mandate