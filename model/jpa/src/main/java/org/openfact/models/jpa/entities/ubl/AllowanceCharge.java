package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe information about a charge or discount as applied to a
 * price component.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:43 a. m.
 */
public class AllowanceCharge {

	/**
	 * The accounting cost centre used by the buyer to account for this
	 * allowance or charge, expressed as text.
	 */
	private String accountingCost;
	/**
	 * The accounting cost centre used by the buyer to account for this
	 * allowance or charge, expressed as a code.
	 */
	private String accountingCostCode;
	/**
	 * The reason for this allowance or charge.
	 */
	private String allowanceChargeReason;
	/**
	 * A mutually agreed code signifying the reason for this allowance or
	 * charge.
	 */
	private String allowanceChargeReasonCode;
	/**
	 * The monetary amount of this allowance or charge to be applied.
	 */
	private BigDecimal amount;
	/**
	 * The monetary amount to which the multiplier factor is applied in
	 * calculating the amount of this allowance or charge.
	 */
	private BigDecimal baseAmount;
	/**
	 * An indicator that this AllowanceCharge describes a charge (true) or a
	 * discount (false).
	 */
	private boolean chargeIndicator;
	/**
	 * An identifier for this allowance or charge.
	 */
	private String ID;
	/**
	 * A number by which the base amount is multiplied to calculate the actual
	 * amount of this allowance or charge.
	 */
	private BigDecimal multiplierFactorNumeric;
	/**
	 * The allowance or charge per item; the total allowance or charge is
	 * calculated by multiplying the per unit amount by the quantity of items,
	 * either at the level of the individual transaction line or for the total
	 * number of items in the document, depending o
	 */
	private BigDecimal perUnitAmount;
	/**
	 * An indicator that this allowance or charge is prepaid (true) or not
	 * (false).
	 */
	private boolean prepaidIndicator;
	/**
	 * A number indicating the order of this allowance or charge in the sequence
	 * of calculations applied when there are multiple allowances or charges.
	 */
	private BigDecimal sequenceNumeric;
	private PaymentMeans m_PaymentMeans;
	private TaxCategory m_TaxCategory;
	private TaxTotal m_TaxTotal;

	/**
	 * @return the accountingCost
	 */
	public String getAccountingCost() {
		return accountingCost;
	}

	/**
	 * @param accountingCost
	 *            the accountingCost to set
	 */
	public void setAccountingCost(String accountingCost) {
		this.accountingCost = accountingCost;
	}

	/**
	 * @return the accountingCostCode
	 */
	public String getAccountingCostCode() {
		return accountingCostCode;
	}

	/**
	 * @param accountingCostCode
	 *            the accountingCostCode to set
	 */
	public void setAccountingCostCode(String accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	/**
	 * @return the allowanceChargeReason
	 */
	public String getAllowanceChargeReason() {
		return allowanceChargeReason;
	}

	/**
	 * @param allowanceChargeReason
	 *            the allowanceChargeReason to set
	 */
	public void setAllowanceChargeReason(String allowanceChargeReason) {
		this.allowanceChargeReason = allowanceChargeReason;
	}

	/**
	 * @return the allowanceChargeReasonCode
	 */
	public String getAllowanceChargeReasonCode() {
		return allowanceChargeReasonCode;
	}

	/**
	 * @param allowanceChargeReasonCode
	 *            the allowanceChargeReasonCode to set
	 */
	public void setAllowanceChargeReasonCode(String allowanceChargeReasonCode) {
		this.allowanceChargeReasonCode = allowanceChargeReasonCode;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the baseAmount
	 */
	public BigDecimal getBaseAmount() {
		return baseAmount;
	}

	/**
	 * @param baseAmount
	 *            the baseAmount to set
	 */
	public void setBaseAmount(BigDecimal baseAmount) {
		this.baseAmount = baseAmount;
	}

	/**
	 * @return the chargeIndicator
	 */
	public boolean isChargeIndicator() {
		return chargeIndicator;
	}

	/**
	 * @param chargeIndicator
	 *            the chargeIndicator to set
	 */
	public void setChargeIndicator(boolean chargeIndicator) {
		this.chargeIndicator = chargeIndicator;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the multiplierFactorNumeric
	 */
	public BigDecimal getMultiplierFactorNumeric() {
		return multiplierFactorNumeric;
	}

	/**
	 * @param multiplierFactorNumeric
	 *            the multiplierFactorNumeric to set
	 */
	public void setMultiplierFactorNumeric(BigDecimal multiplierFactorNumeric) {
		this.multiplierFactorNumeric = multiplierFactorNumeric;
	}

	/**
	 * @return the perUnitAmount
	 */
	public BigDecimal getPerUnitAmount() {
		return perUnitAmount;
	}

	/**
	 * @param perUnitAmount
	 *            the perUnitAmount to set
	 */
	public void setPerUnitAmount(BigDecimal perUnitAmount) {
		this.perUnitAmount = perUnitAmount;
	}

	/**
	 * @return the prepaidIndicator
	 */
	public boolean isPrepaidIndicator() {
		return prepaidIndicator;
	}

	/**
	 * @param prepaidIndicator
	 *            the prepaidIndicator to set
	 */
	public void setPrepaidIndicator(boolean prepaidIndicator) {
		this.prepaidIndicator = prepaidIndicator;
	}

	/**
	 * @return the sequenceNumeric
	 */
	public BigDecimal getSequenceNumeric() {
		return sequenceNumeric;
	}

	/**
	 * @param sequenceNumeric
	 *            the sequenceNumeric to set
	 */
	public void setSequenceNumeric(BigDecimal sequenceNumeric) {
		this.sequenceNumeric = sequenceNumeric;
	}

	/**
	 * @return the m_PaymentMeans
	 */
	public PaymentMeans getM_PaymentMeans() {
		return m_PaymentMeans;
	}

	/**
	 * @param m_PaymentMeans
	 *            the m_PaymentMeans to set
	 */
	public void setM_PaymentMeans(PaymentMeans m_PaymentMeans) {
		this.m_PaymentMeans = m_PaymentMeans;
	}

	/**
	 * @return the m_TaxCategory
	 */
	public TaxCategory getM_TaxCategory() {
		return m_TaxCategory;
	}

	/**
	 * @param m_TaxCategory
	 *            the m_TaxCategory to set
	 */
	public void setM_TaxCategory(TaxCategory m_TaxCategory) {
		this.m_TaxCategory = m_TaxCategory;
	}

	/**
	 * @return the m_TaxTotal
	 */
	public TaxTotal getM_TaxTotal() {
		return m_TaxTotal;
	}

	/**
	 * @param m_TaxTotal
	 *            the m_TaxTotal to set
	 */
	public void setM_TaxTotal(TaxTotal m_TaxTotal) {
		this.m_TaxTotal = m_TaxTotal;
	}

}