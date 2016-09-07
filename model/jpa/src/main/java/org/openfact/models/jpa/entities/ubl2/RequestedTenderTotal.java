

/**
 * A class defining budgeted monetary amounts.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:31 a. m.
 */
public class RequestedTenderTotal {

	/**
	 * The average monetary amount for the subsequent contracts following this budget
	 * amount.
	 */
	private Amount. Type AverageSubsequentContractAmount;
	/**
	 * The estimated overall monetary amount of a contract.
	 */
	private Amount. Type EstimatedOverallContractAmount;
	/**
	 * The maximum monetary amount of the budget.
	 */
	private Amount. Type MaximumAmount;
	/**
	 * The minimum monetary amount of the budget.
	 */
	private Amount. Type MinimumAmount;
	/**
	 * A description of the monetary scope of the budget.
	 */
	private Text. Type MonetaryScope;
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private Indicator. Type TaxIncludedIndicator;
	/**
	 * The monetary amount of the total budget including net amount, taxes, and
	 * material and instalment costs. 
	 */
	private Amount. Type TotalAmount;
	private Tax Category Applicable Tax Category;

	public Requested Tender Total(){

	}

	public void finalize() throws Throwable {

	}
	public Tax Category getApplicable Tax Category(){
		return Applicable Tax Category;
	}

	public Amount. Type getAverageSubsequentContractAmount(){
		return AverageSubsequentContractAmount;
	}

	public Amount. Type getEstimatedOverallContractAmount(){
		return EstimatedOverallContractAmount;
	}

	public Amount. Type getMaximumAmount(){
		return MaximumAmount;
	}

	public Amount. Type getMinimumAmount(){
		return MinimumAmount;
	}

	public Text. Type getMonetaryScope(){
		return MonetaryScope;
	}

	public Indicator. Type getTaxIncludedIndicator(){
		return TaxIncludedIndicator;
	}

	public Amount. Type getTotalAmount(){
		return TotalAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setApplicable Tax Category(Tax Category newVal){
		Applicable Tax Category = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAverageSubsequentContractAmount(Amount. Type newVal){
		AverageSubsequentContractAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimatedOverallContractAmount(Amount. Type newVal){
		EstimatedOverallContractAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumAmount(Amount. Type newVal){
		MaximumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumAmount(Amount. Type newVal){
		MinimumAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMonetaryScope(Text. Type newVal){
		MonetaryScope = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTaxIncludedIndicator(Indicator. Type newVal){
		TaxIncludedIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalAmount(Amount. Type newVal){
		TotalAmount = newVal;
	}
}//end Requested Tender Total