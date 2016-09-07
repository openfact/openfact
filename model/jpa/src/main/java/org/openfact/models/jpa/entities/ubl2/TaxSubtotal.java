

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
	private Numeric. Type CalculationSequenceNumeric;
	/**
	 * The tax rate of the tax category applied to this tax subtotal, expressed as a
	 * percentage.
	 */
	private Percent. Type Percent;
	/**
	 * Where a tax is applied at a certain rate per unit, the rate per unit applied.
	 */
	private Amount. Type PerUnitAmount;
	/**
	 * The net amount to which the tax percent (rate) is applied to calculate the tax
	 * amount.
	 */
	private Amount. Type TaxableAmount;
	/**
	 * The amount of this tax subtotal.
	 */
	private Amount. Type TaxAmount;
	/**
	 * Where a tax is tiered, the range of taxable amounts that determines the rate of
	 * tax applicable to this tax subtotal.
	 */
	private Text. Type TierRange;
	/**
	 * Where a tax is tiered, the tax rate that applies within a specified range of
	 * taxable amounts for this tax subtotal.
	 */
	private Percent. Type TierRatePercent;
	/**
	 * The amount of this tax subtotal, expressed in the currency used for invoicing.
	 */
	private Amount. Type TransactionCurrencyTaxAmount;
	private Tax Category m_Tax Category;

	public Tax Subtotal(){

	}

	public void finalize() throws Throwable {

	}
	public Measure. Type getBaseUnitMeasure(){
		return BaseUnitMeasure;
	}

	public Numeric. Type getCalculationSequenceNumeric(){
		return CalculationSequenceNumeric;
	}

	public Percent. Type getPercent(){
		return Percent;
	}

	public Amount. Type getPerUnitAmount(){
		return PerUnitAmount;
	}

	public Tax Category getTax Category(){
		return m_Tax Category;
	}

	public Amount. Type getTaxableAmount(){
		return TaxableAmount;
	}

	public Amount. Type getTaxAmount(){
		return TaxAmount;
	}

	public Text. Type getTierRange(){
		return TierRange;
	}

	public Percent. Type getTierRatePercent(){
		return TierRatePercent;
	}

	public Amount. Type getTransactionCurrencyTaxAmount(){
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
	public void setCalculationSequenceNumeric(Numeric. Type newVal){
		CalculationSequenceNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPercent(Percent. Type newVal){
		Percent = newVal;
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
	public void setTax Category(Tax Category newVal){
		m_Tax Category = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxableAmount(Amount. Type newVal){
		TaxableAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxAmount(Amount. Type newVal){
		TaxAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTierRange(Text. Type newVal){
		TierRange = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTierRatePercent(Percent. Type newVal){
		TierRatePercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransactionCurrencyTaxAmount(Amount. Type newVal){
		TransactionCurrencyTaxAmount = newVal;
	}
}//end Tax Subtotal