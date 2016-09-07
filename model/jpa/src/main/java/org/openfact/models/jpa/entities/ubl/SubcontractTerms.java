package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe subcontract terms for a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:55 a. m.
 */
public class SubcontractTerms {

	/**
	 * The monetary amount assigned to the subcontracted task.
	 */
	private Amount. Type Amount;
	/**
	 * Text describing the subcontract terms.
	 */
	private Text. Type Description;
	/**
	 * The maximum percentage allowed to be subcontracted.
	 */
	private Percent. Type MaximumPercent;
	/**
	 * The minimum percentage allowed to be subcontracted.
	 */
	private Percent. Type MinimumPercent;
	/**
	 * MF: I agree with the query. Rate?
	 */
	private Rate. Type Rate;
	/**
	 * A code specifying the conditions for subcontracting.
	 */
	private Code. Type SubcontractingConditionsCode;
	/**
	 * An indicator that the subcontract price is known (true) or not (false).
	 */
	private Indicator. Type UnknownPriceIndicator;

	public Subcontract Terms(){

	}

	public void finalize() throws Throwable {

	}
	public Amount. Type getAmount(){
		return Amount;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Percent. Type getMaximumPercent(){
		return MaximumPercent;
	}

	public Percent. Type getMinimumPercent(){
		return MinimumPercent;
	}

	public Rate. Type getRate(){
		return Rate;
	}

	public Code. Type getSubcontractingConditionsCode(){
		return SubcontractingConditionsCode;
	}

	public Indicator. Type getUnknownPriceIndicator(){
		return UnknownPriceIndicator;
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
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumPercent(Percent. Type newVal){
		MaximumPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumPercent(Percent. Type newVal){
		MinimumPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRate(Rate. Type newVal){
		Rate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubcontractingConditionsCode(Code. Type newVal){
		SubcontractingConditionsCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnknownPriceIndicator(Indicator. Type newVal){
		UnknownPriceIndicator = newVal;
	}
}//end Subcontract Terms