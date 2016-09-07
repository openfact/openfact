package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the total tax for a particular taxation scheme.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:07 a. m.
 */
public class TaxTotal {

	/**
	 * The rounding amount (positive or negative) added to the calculated tax total to
	 * produce the rounded TaxAmount.
	 */
	private Amount. Type RoundingAmount;
	/**
	 * The total tax amount for a particular taxation scheme, e.g., VAT; the sum of
	 * the tax subtotals for each tax category within the taxation scheme.
	 */
	private Amount. Type TaxAmount;
	/**
	 * An indicator that this total is recognized as legal evidence for taxation
	 * purposes (true) or not (false).
	 */
	private Indicator. Type TaxEvidenceIndicator;
	/**
	 * An indicator that tax is included in the calculation (true) or not (false).
	 */
	private Indicator. Type TaxIncludedIndicator;
	private Tax Subtotal m_Tax Subtotal;

	public Tax Total(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getRoundingAmount(){
		return RoundingAmount;
	}

	public Tax Subtotal getTax Subtotal(){
		return m_Tax Subtotal;
	}

	public Amount. Type getTaxAmount(){
		return TaxAmount;
	}

	public Indicator. Type getTaxEvidenceIndicator(){
		return TaxEvidenceIndicator;
	}

	public Indicator. Type getTaxIncludedIndicator(){
		return TaxIncludedIndicator;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoundingAmount(Amount. Type newVal){
		RoundingAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Subtotal(Tax Subtotal newVal){
		m_Tax Subtotal = newVal;
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
	public void setTaxEvidenceIndicator(Indicator. Type newVal){
		TaxEvidenceIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxIncludedIndicator(Indicator. Type newVal){
		TaxIncludedIndicator = newVal;
	}
}//end Tax Total