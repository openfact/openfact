package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

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
	private String AccountingCost;
	/**
	 * The accounting cost centre used by the buyer to account for this allowance or
	 * charge, expressed as a code.
	 */
	private String AccountingCostCode;
	/**
	 * The reason for this allowance or charge.
	 */
	private String AllowanceChargeReason;
	/**
	 * A mutually agreed code signifying the reason for this allowance or charge.
	 */
	private AllowanceChargeReasonString AllowanceChargeReasonCode;
	/**
	 * The monetary amount of this allowance or charge to be applied.
	 */
	private BigDecimal Amount;
	/**
	 * The monetary amount to which the multiplier factor is applied in calculating
	 * the amount of this allowance or charge.
	 */
	private BigDecimal BaseAmount;
	/**
	 * An indicator that this AllowanceCharge describes a charge (true) or a discount
	 * (false).
	 */
	private boolean ChargeIndicator;
	/**
	 * An identifier for this allowance or charge.
	 */
	private String ID;
	/**
	 * A number by which the base amount is multiplied to calculate the actual amount
	 * of this allowance or charge.
	 */
	private BigDecimal MultiplierFactorNumeric;
	/**
	 * The allowance or charge per item; the total allowance or charge is calculated
	 * by multiplying the per unit amount by the quantity of items, either at the
	 * level of the individual transaction line or for the total number of items in
	 * the document, depending o
	 */
	private BigDecimal PerUnitAmount;
	/**
	 * An indicator that this allowance or charge is prepaid (true) or not (false).
	 */
	private boolean PrepaidIndicator;
	/**
	 * A number indicating the order of this allowance or charge in the sequence of
	 * calculations applied when there are multiple allowances or charges.
	 */
	private BigDecimal SequenceNumeric;
	private PaymentMeans m_PaymentMeans;
	private TaxCategory m_TaxCategory;
	private TaxTotal m_TaxTotal;

	public AllowanceCharge(){

	}

	public void finalize() throws Throwable {

	}
	public String getAccountingCost(){
		return AccountingCost;
	}

	public String getAccountingCostCode(){
		return AccountingCostCode;
	}

	public String getAllowanceChargeReason(){
		return AllowanceChargeReason;
	}

	public AllowanceChargeReason_String getAllowanceChargeReasonCode(){
		return AllowanceChargeReasonCode;
	}

	public BigDecimal getAmount(){
		return Amount;
	}

	public BigDecimal getBaseAmount(){
		return BaseAmount;
	}

	public boolean getChargeIndicator(){
		return ChargeIndicator;
	}

	public String getID(){
		return ID;
	}

	public BigDecimal getMultiplierFactorNumeric(){
		return MultiplierFactorNumeric;
	}

	public PaymentMeans getPaymentMeans(){
		return m_PaymentMeans;
	}

	public BigDecimal getPerUnitAmount(){
		return PerUnitAmount;
	}

	public boolean getPrepaidIndicator(){
		return PrepaidIndicator;
	}

	public BigDecimal getSequenceNumeric(){
		return SequenceNumeric;
	}

	public TaxCategory getTaxCategory(){
		return m_TaxCategory;
	}

	public TaxTotal getTaxTotal(){
		return m_TaxTotal;
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
	public void setAllowanceChargeReason(String newVal){
		AllowanceChargeReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowanceChargeReasonCode(AllowanceChargeReason_String newVal){
		AllowanceChargeReasonCode = newVal;
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
	public void setBaseAmount(BigDecimal newVal){
		BaseAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setChargeIndicator(boolean newVal){
		ChargeIndicator = newVal;
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
	public void setMultiplierFactorNumeric(BigDecimal newVal){
		MultiplierFactorNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPaymentMeans(PaymentMeans newVal){
		m_PaymentMeans = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPerUnitAmount(BigDecimal newVal){
		PerUnitAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrepaidIndicator(boolean newVal){
		PrepaidIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceNumeric(BigDecimal newVal){
		SequenceNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxCategory(TaxCategory newVal){
		m_TaxCategory = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxTotal(TaxTotal newVal){
		m_TaxTotal = newVal;
	}
}//end Allowance Charge