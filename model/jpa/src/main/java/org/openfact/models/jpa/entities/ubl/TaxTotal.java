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
	private BigDecimal RoundingAmount;
	/**
	 * The total tax amount for a particular taxation scheme, e.g., VAT; the sum of
	 * the tax subtotals for each tax category within the taxation scheme.
	 */
	private BigDecimal TaxAmount;
	/**
	 * An indicator that this total is recognized as legal evidence for taxation
	 * purposes (true) or not (false).
	 */
	private boolean TaxEvidenceIndicator;
	/**
	 * An indicator that tax is included in the calculation (true) or not (false).
	 */
	private boolean TaxIncludedIndicator;
	private Tax Subtotal m_Tax Subtotal;

	public Tax Total(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getRoundingAmount(){
		return RoundingAmount;
	}

	public Tax Subtotal getTax Subtotal(){
		return m_Tax Subtotal;
	}

	public BigDecimal getTaxAmount(){
		return TaxAmount;
	}

	public boolean getTaxEvidenceIndicator(){
		return TaxEvidenceIndicator;
	}

	public boolean getTaxIncludedIndicator(){
		return TaxIncludedIndicator;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoundingAmount(BigDecimal newVal){
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
	public void setTaxAmount(BigDecimal newVal){
		TaxAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxEvidenceIndicator(boolean newVal){
		TaxEvidenceIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxIncludedIndicator(boolean newVal){
		TaxIncludedIndicator = newVal;
	}
}//end Tax Total