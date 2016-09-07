package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define the subtotal for a particular tax category within a
 * particular taxation scheme, such as standard rate within VAT.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:05 a. m.
 */
public class TaxSubtotal {

	/**
	 * The unit of measure on which the tax calculation is based
	 */
	private Measure. Type BaseUnitMeasure;
	/**
	 * The number of this tax subtotal in the sequence of subtotals corresponding to
	 * the order in which multiple taxes are applied. If all taxes are applied to the
	 * same taxable amount (i.e., their order of application is inconsequential), then
	 * CalculationSequenc
	 */
	private BigDecimal CalculationSequenceNumeric;
	/**
	 * The tax rate of the tax category applied to this tax subtotal, expressed as a
	 * percentage.
	 */
	private BigDecimal Percent;
	/**
	 * Where a tax is applied at a certain rate per unit, the rate per unit applied.
	 */
	private BigDecimal PerUnitAmount;
	/**
	 * The net amount to which the tax percent (rate) is applied to calculate the tax
	 * amount.
	 */
	private BigDecimal TaxableAmount;
	/**
	 * The amount of this tax subtotal.
	 */
	private BigDecimal TaxAmount;
	/**
	 * Where a tax is tiered, the range of taxable amounts that determines the rate of
	 * tax applicable to this tax subtotal.
	 */
	private String TierRange;
	/**
	 * Where a tax is tiered, the tax rate that applies within a specified range of
	 * taxable amounts for this tax subtotal.
	 */
	private BigDecimal TierRatePercent;
	/**
	 * The amount of this tax subtotal, expressed in the currency used for invoicing.
	 */
	private BigDecimal TransactionCurrencyTaxAmount;
	private TaxCategory m_TaxCategory;

	public Tax Subtotal(){

	}

	public void finalize() throws Throwable {

	}
	public Measure. Type getBaseUnitMeasure(){
		return BaseUnitMeasure;
	}

	public BigDecimal getCalculationSequenceNumeric(){
		return CalculationSequenceNumeric;
	}

	public BigDecimal getPercent(){
		return Percent;
	}

	public BigDecimal getPerUnitAmount(){
		return PerUnitAmount;
	}

	public TaxCategory getTaxCategory(){
		return m_TaxCategory;
	}

	public BigDecimal getTaxableAmount(){
		return TaxableAmount;
	}

	public BigDecimal getTaxAmount(){
		return TaxAmount;
	}

	public String getTierRange(){
		return TierRange;
	}

	public BigDecimal getTierRatePercent(){
		return TierRatePercent;
	}

	public BigDecimal getTransactionCurrencyTaxAmount(){
		return TransactionCurrencyTaxAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBaseUnitMeasure(Measure. Type newVal){
		BaseUnitMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationSequenceNumeric(BigDecimal newVal){
		CalculationSequenceNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPercent(BigDecimal newVal){
		Percent = newVal;
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
	public void setTaxCategory(TaxCategory newVal){
		m_TaxCategory = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxableAmount(BigDecimal newVal){
		TaxableAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxAmount(BigDecimal newVal){
		TaxAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTierRange(String newVal){
		TierRange = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTierRatePercent(BigDecimal newVal){
		TierRatePercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransactionCurrencyTaxAmount(BigDecimal newVal){
		TransactionCurrencyTaxAmount = newVal;
	}
}//end Tax Subtotal