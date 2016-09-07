

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
	private Identifier. Type ID;
	/**
	 * The name of this tax category.
	 */
	private Name. Type Name;
	/**
	 * The tax rate for this category, expressed as a percentage.
	 */
	private Percent. Type Percent;
	/**
	 * Where a tax is applied at a certain rate per unit, the rate per unit applied.
	 */
	private Amount. Type PerUnitAmount;
	/**
	 * The reason for tax being exempted, expressed as text.
	 */
	private Text. Type TaxExemptionReason;
	/**
	 * The reason for tax being exempted, expressed as a code.
	 */
	private Code. Type TaxExemptionReasonCode;
	/**
	 * Where a tax is tiered, the range of taxable amounts that determines the rate of
	 * tax applicable to this tax category.
	 */
	private Text. Type TierRange;
	/**
	 * Where a tax is tiered, the tax rate that applies within the specified range of
	 * taxable amounts for this tax category.
	 */
	private Percent. Type TierRatePercent;
	private Tax Scheme m_Tax Scheme;

	public Tax Category(){

	}

	public void finalize() throws Throwable {

	}
	public Measure. Type getBaseUnitMeasure(){
		return BaseUnitMeasure;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Name. Type getName(){
		return Name;
	}

	public Percent. Type getPercent(){
		return Percent;
	}

	public Amount. Type getPerUnitAmount(){
		return PerUnitAmount;
	}

	public Tax Scheme getTax Scheme(){
		return m_Tax Scheme;
	}

	public Text. Type getTaxExemptionReason(){
		return TaxExemptionReason;
	}

	public Code. Type getTaxExemptionReasonCode(){
		return TaxExemptionReasonCode;
	}

	public Text. Type getTierRange(){
		return TierRange;
	}

	public Percent. Type getTierRatePercent(){
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
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
	public void setTax Scheme(Tax Scheme newVal){
		m_Tax Scheme = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxExemptionReason(Text. Type newVal){
		TaxExemptionReason = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxExemptionReasonCode(Code. Type newVal){
		TaxExemptionReasonCode = newVal;
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
}//end Tax Category