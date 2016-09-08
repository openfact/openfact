package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.*;

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
	private TextType accountingCost;
	/**
	 * The accounting cost centre used by the buyer to account for this
	 * allowance or charge, expressed as a code.
	 */
	private CodeType accountingCostCode;
	/**
	 * The reason for this allowance or charge.
	 */
	private TextType allowanceChargeReason;
	/**
	 * A mutually agreed code signifying the reason for this allowance or
	 * charge.
	 */
	private AllowanceChargeReasonCodeType allowanceChargeReasonCode;
	/**
	 * The monetary amount of this allowance or charge to be applied.
	 */
	private AmountType amount;
	/**
	 * The monetary amount to which the multiplier factor is applied in
	 * calculating the amount of this allowance or charge.
	 */
	private AmountType baseAmount;
	/**
	 * An indicator that this AllowanceCharge describes a charge (true) or a
	 * discount (false).
	 */
	private IndicatorType chargeIndicator;
	/**
	 * An identifier for this allowance or charge.
	 */
	private IdentifierType id;
	/**
	 * A number by which the base amount is multiplied to calculate the actual
	 * amount of this allowance or charge.
	 */
	private NumericType multiplierFactorNumeric;
	/**
	 * The allowance or charge per item; the total allowance or charge is
	 * calculated by multiplying the per unit amount by the quantity of items,
	 * either at the level of the individual transaction line or for the total
	 * number of items in the document, depending o
	 */
	private AmountType perUnitAmount;
	/**
	 * An indicator that this allowance or charge is prepaid (true) or not
	 * (false).
	 */
	private IndicatorType prepaidIndicator;
	/**
	 * A number indicating the order of this allowance or charge in the sequence
	 * of calculations applied when there are multiple allowances or charges.
	 */
	private NumericType sequenceNumeric;
	private List<PaymentMeans> paymentMeans= new ArrayList<>();
	private List<TaxCategory> taxCategories= new ArrayList<>();
	private List<TaxTotal> taxTotals= new ArrayList<>();

	public TextType getAccountingCost() {
		return accountingCost;
	}

	public void setAccountingCost(TextType accountingCost) {
		this.accountingCost = accountingCost;
	}

	public CodeType getAccountingCostCode() {
		return accountingCostCode;
	}

	public void setAccountingCostCode(CodeType accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	public TextType getAllowanceChargeReason() {
		return allowanceChargeReason;
	}

	public void setAllowanceChargeReason(TextType allowanceChargeReason) {
		this.allowanceChargeReason = allowanceChargeReason;
	}

	public AllowanceChargeReasonCodeType getAllowanceChargeReasonCode() {
		return allowanceChargeReasonCode;
	}

	public void setAllowanceChargeReasonCode(AllowanceChargeReasonCodeType allowanceChargeReasonCode) {
		this.allowanceChargeReasonCode = allowanceChargeReasonCode;
	}

	public AmountType getAmount() {
		return amount;
	}

	public void setAmount(AmountType amount) {
		this.amount = amount;
	}

	public AmountType getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(AmountType baseAmount) {
		this.baseAmount = baseAmount;
	}

	public IndicatorType getChargeIndicator() {
		return chargeIndicator;
	}

	public void setChargeIndicator(IndicatorType chargeIndicator) {
		this.chargeIndicator = chargeIndicator;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public NumericType getMultiplierFactorNumeric() {
		return multiplierFactorNumeric;
	}

	public void setMultiplierFactorNumeric(NumericType multiplierFactorNumeric) {
		this.multiplierFactorNumeric = multiplierFactorNumeric;
	}

	public AmountType getPerUnitAmount() {
		return perUnitAmount;
	}

	public void setPerUnitAmount(AmountType perUnitAmount) {
		this.perUnitAmount = perUnitAmount;
	}

	public IndicatorType getPrepaidIndicator() {
		return prepaidIndicator;
	}

	public void setPrepaidIndicator(IndicatorType prepaidIndicator) {
		this.prepaidIndicator = prepaidIndicator;
	}

	public NumericType getSequenceNumeric() {
		return sequenceNumeric;
	}

	public void setSequenceNumeric(NumericType sequenceNumeric) {
		this.sequenceNumeric = sequenceNumeric;
	}

	public List<PaymentMeans> getPaymentMeans() {
		return paymentMeans;
	}

	public void setPaymentMeans(List<PaymentMeans> paymentMeans) {
		this.paymentMeans = paymentMeans;
	}

	public List<TaxCategory> getTaxCategories() {
		return taxCategories;
	}

	public void setTaxCategories(List<TaxCategory> taxCategories) {
		this.taxCategories = taxCategories;
	}

	public List<TaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotal> taxTotals) {
		this.taxTotals = taxTotals;
	}
}