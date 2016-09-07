package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Reminder document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:24 a. m.
 */
public class ReminderLine {

	/**
	 * The buyer's accounting cost centre for this reminder line, expressed as text.
	 */
	private Text. Type AccountingCost;
	/**
	 * The buyer's accounting cost centre for this reminder line, expressed as a code.
	 */
	private Code. Type AccountingCostCode;
	/**
	 * The amount on this reminder line.
	 */
	private Amount. Type Amount;
	/**
	 * An indication that this reminder line contains a balance brought forward (true)
	 * or does not (false).
	 */
	private Indicator. Type BalanceBroughtForwardIndicator;
	/**
	 * The amount credited on this reminder line.
	 */
	private Amount. Type CreditLineAmount;
	/**
	 * The amount debited on this reminder line.
	 */
	private Amount. Type DebitLineAmount;
	/**
	 * An identifier for this reminder line.
	 */
	private Identifier. Type ID;
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
	 * The penalty for late payment, expressed as a percentage.
	 */
	private Percent. Type PenaltySurchargePercent;
	/**
	 * A universally unique identifier for this reminder line.
	 */
	private Identifier. Type UUID;
	private Billing Reference m_Billing Reference;
	private Exchange Rate m_Exchange Rate;
	private Period Reminder Period;

	public Reminder Line(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getAccountingCost(){
		return AccountingCost;
	}

	public Code. Type getAccountingCostCode(){
		return AccountingCostCode;
	}

	public Amount. Type getAmount(){
		return Amount;
	}

	public Indicator. Type getBalanceBroughtForwardIndicator(){
		return BalanceBroughtForwardIndicator;
	}

	public Billing Reference getBilling Reference(){
		return m_Billing Reference;
	}

	public Amount. Type getCreditLineAmount(){
		return CreditLineAmount;
	}

	public Amount. Type getDebitLineAmount(){
		return DebitLineAmount;
	}

	public Exchange Rate getExchange Rate(){
		return m_Exchange Rate;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Code. Type getPaymentPurposeCode(){
		return PaymentPurposeCode;
	}

	public Percent. Type getPenaltySurchargePercent(){
		return PenaltySurchargePercent;
	}

	public Period getReminder Period(){
		return Reminder Period;
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
	public void setAmount(Amount. Type newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBalanceBroughtForwardIndicator(Indicator. Type newVal){
		BalanceBroughtForwardIndicator = newVal;
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
	public void setCreditLineAmount(Amount. Type newVal){
		CreditLineAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDebitLineAmount(Amount. Type newVal){
		DebitLineAmount = newVal;
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
	public void setPenaltySurchargePercent(Percent. Type newVal){
		PenaltySurchargePercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReminder Period(Period newVal){
		Reminder Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(Identifier. Type newVal){
		UUID = newVal;
	}
}//end Reminder Line