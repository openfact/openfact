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
	private String AccountingCost;
	/**
	 * The buyer's accounting cost centre for this reminder line, expressed as a code.
	 */
	private String AccountingCostCode;
	/**
	 * The amount on this reminder line.
	 */
	private BigDecimal Amount;
	/**
	 * An indication that this reminder line contains a balance brought forward (true)
	 * or does not (false).
	 */
	private boolean BalanceBroughtForwardIndicator;
	/**
	 * The amount credited on this reminder line.
	 */
	private BigDecimal CreditLineAmount;
	/**
	 * The amount debited on this reminder line.
	 */
	private BigDecimal DebitLineAmount;
	/**
	 * An identifier for this reminder line.
	 */
	private String ID;
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
	 * The penalty for late payment, expressed as a percentage.
	 */
	private BigDecimal PenaltySurchargePercent;
	/**
	 * A universally unique identifier for this reminder line.
	 */
	private String UUID;
	private Billing Reference m_Billing Reference;
	private ExchangeRate m_ExchangeRate;
	private Period Reminder Period;

	public ReminderLine(){

	}

	public void finalize() throws Throwable {

	}
	public String getAccountingCost(){
		return AccountingCost;
	}

	public String getAccountingCostCode(){
		return AccountingCostCode;
	}

	public BigDecimal getAmount(){
		return Amount;
	}

	public boolean getBalanceBroughtForwardIndicator(){
		return BalanceBroughtForwardIndicator;
	}

	public Billing Reference getBilling Reference(){
		return m_Billing Reference;
	}

	public BigDecimal getCreditLineAmount(){
		return CreditLineAmount;
	}

	public BigDecimal getDebitLineAmount(){
		return DebitLineAmount;
	}

	public ExchangeRate getExchangeRate(){
		return m_ExchangeRate;
	}

	public String getID(){
		return ID;
	}

	public String getNote(){
		return Note;
	}

	public String getPaymentPurposeCode(){
		return PaymentPurposeCode;
	}

	public BigDecimal getPenaltySurchargePercent(){
		return PenaltySurchargePercent;
	}

	public Period getReminder Period(){
		return Reminder Period;
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
	public void setAmount(BigDecimal newVal){
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBalanceBroughtForwardIndicator(boolean newVal){
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
	public void setCreditLineAmount(BigDecimal newVal){
		CreditLineAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDebitLineAmount(BigDecimal newVal){
		DebitLineAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchangeRate(ExchangeRate newVal){
		m_ExchangeRate = newVal;
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
	public void setNote(String newVal){
		Note = newVal;
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
	public void setPenaltySurchargePercent(BigDecimal newVal){
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
	public void setUUID(String newVal){
		UUID = newVal;
	}
}//end ReminderLine