package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe information about a charge or discount as applied to a
 * price component.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:43 a. m.
 */
public class AllowanceCharge {

	/**
	 * The accounting cost centre used by the buyer to account for this allowance or
	 * charge, expressed as text.
	 */
	private Text. Type AccountingCost;
	/**
	 * The accounting cost centre used by the buyer to account for this allowance or
	 * charge, expressed as a code.
	 */
	private Code. Type AccountingCostCode;
	/**
	 * The reason for this allowance or charge.
	 */
	private Text. Type AllowanceChargeReason;
	/**
	 * A mutually agreed code signifying the reason for this allowance or charge.
	 */
	private Allowance Charge Reason_ Code. Type AllowanceChargeReasonCode;
	/**
	 * The monetary amount of this allowance or charge to be applied.
	 */
	private Amount. Type Amount;
	/**
	 * The monetary amount to which the multiplier factor is applied in calculating
	 * the amount of this allowance or charge.
	 */
	private Amount. Type BaseAmount;
	/**
	 * An indicator that this AllowanceCharge describes a charge (true) or a discount
	 * (false).
	 */
	private Indicator. Type ChargeIndicator;
	/**
	 * An identifier for this allowance or charge.
	 */
	private Identifier. Type ID;
	/**
	 * A number by which the base amount is multiplied to calculate the actual amount
	 * of this allowance or charge.
	 */
	private Numeric. Type MultiplierFactorNumeric;
	/**
	 * The allowance or charge per item; the total allowance or charge is calculated
	 * by multiplying the per unit amount by the quantity of items, either at the
	 * level of the individual transaction line or for the total number of items in
	 * the document, depending o
	 */
	private Amount. Type PerUnitAmount;
	/**
	 * An indicator that this allowance or charge is prepaid (true) or not (false).
	 */
	private Indicator. Type PrepaidIndicator;
	/**
	 * A number indicating the order of this allowance or charge in the sequence of
	 * calculations applied when there are multiple allowances or charges.
	 */
	private Numeric. Type SequenceNumeric;
	private Payment Means m_Payment Means;
	private Tax Category m_Tax Category;
	private Tax Total m_Tax Total;

	public Allowance Charge(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getAccountingCost(){
		return AccountingCost;
	}

	public Code. Type getAccountingCostCode(){
		return AccountingCostCode;
	}

	public Text. Type getAllowanceChargeReason(){
		return AllowanceChargeReason;
	}

	public Allowance Charge Reason_ Code. Type getAllowanceChargeReasonCode(){
		return AllowanceChargeReasonCode;
	}

	public Amount. Type getAmount(){
		return Amount;
	}

	public Amount. Type getBaseAmount(){
		return BaseAmount;
	}

	public Indicator. Type getChargeIndicator(){
		return ChargeIndicator;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Numeric. Type getMultiplierFactorNumeric(){
		return MultiplierFactorNumeric;
	}

	public Payment Means getPayment Means(){
		return m_Payment Means;
	}

	public Amount. Type getPerUnitAmount(){
		return PerUnitAmount;
	}

	public Indicator. Type getPrepaidIndicator(){
		return PrepaidIndicator;
	}

	public Numeric. Type getSequenceNumeric(){
		return SequenceNumeric;
	}

	public Tax Category getTax Category(){
		return m_Tax Category;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
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
	public void setAllowanceChargeReason(Text. Type newVal){
		AllowanceChargeReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowanceChargeReasonCode(Allowance Charge Reason_ Code. Type newVal){
		AllowanceChargeReasonCode = newVal;
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
	public void setBaseAmount(Amount. Type newVal){
		BaseAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChargeIndicator(Indicator. Type newVal){
		ChargeIndicator = newVal;
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
	public void setMultiplierFactorNumeric(Numeric. Type newVal){
		MultiplierFactorNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayment Means(Payment Means newVal){
		m_Payment Means = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPerUnitAmount(Amount. Type newVal){
		PerUnitAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrepaidIndicator(Indicator. Type newVal){
		PrepaidIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceNumeric(Numeric. Type newVal){
		SequenceNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Category(Tax Category newVal){
		m_Tax Category = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
	}
}//end Allowance Charge