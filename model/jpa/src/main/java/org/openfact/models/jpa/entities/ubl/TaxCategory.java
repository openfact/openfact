package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe one of the tax categories within a taxation scheme (e.g.,
 * High Rate VAT, Low Rate VAT).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:02 a. m.
 */
public class TaxCategory {

	/**
	 * A Unit of Measures used as the basic for the tax calculation applied at a
	 * certain rate per unit.
	 */
	private Measure. Type BaseUnitMeasure;
	/**
	 * An identifier for this tax category.
	 */
	private String ID;
	/**
	 * The name of this tax category.
	 */
	private String Name;
	/**
	 * The tax rate for this category, expressed as a percentage.
	 */
	private BigDecimal Percent;
	/**
	 * Where a tax is applied at a certain rate per unit, the rate per unit applied.
	 */
	private BigDecimal PerUnitAmount;
	/**
	 * The reason for tax being exempted, expressed as text.
	 */
	private String TaxExemptionReason;
	/**
	 * The reason for tax being exempted, expressed as a code.
	 */
	private String TaxExemptionReasonCode;
	/**
	 * Where a tax is tiered, the range of taxable amounts that determines the rate of
	 * tax applicable to this tax category.
	 */
	private String TierRange;
	/**
	 * Where a tax is tiered, the tax rate that applies within the specified range of
	 * taxable amounts for this tax category.
	 */
	private BigDecimal TierRatePercent;
	private Tax Scheme m_Tax Scheme;

	public TaxCategory(){

	}

	public void finalize() throws Throwable {

	}
	public Measure. Type getBaseUnitMeasure(){
		return BaseUnitMeasure;
	}

	public String getID(){
		return ID;
	}

	public String getName(){
		return Name;
	}

	public BigDecimal getPercent(){
		return Percent;
	}

	public BigDecimal getPerUnitAmount(){
		return PerUnitAmount;
	}

	public Tax Scheme getTax Scheme(){
		return m_Tax Scheme;
	}

	public String getTaxExemptionReason(){
		return TaxExemptionReason;
	}

	public String getTaxExemptionReasonCode(){
		return TaxExemptionReasonCode;
	}

	public String getTierRange(){
		return TierRange;
	}

	public BigDecimal getTierRatePercent(){
		return TierRatePercent;
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
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
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
	public void setTax Scheme(Tax Scheme newVal){
		m_Tax Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxExemptionReason(String newVal){
		TaxExemptionReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxExemptionReasonCode(String newVal){
		TaxExemptionReasonCode = newVal;
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
}//end TaxCategory