

/**
 * A class to define a budget account.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:12 a. m.
 */
public class BudgetAccount {

	/**
	 * The number of the year for this budget account, e.g. 2012
	 */
	private Numeric. Type BudgetYearNumeric;
	/**
	 * An identifier for the budget account, typically an internal accounting
	 * reference.
	 */
	private Identifier. Type ID;
	private Classification Scheme Required Classification Scheme;

	public Budget Account(){

	}

	public void finalize() throws Throwable {

	}
	public Numeric. Type getBudgetYearNumeric(){
		return BudgetYearNumeric;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Classification Scheme getRequired Classification Scheme(){
		return Required Classification Scheme;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBudgetYearNumeric(Numeric. Type newVal){
		BudgetYearNumeric = newVal;
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
	public void setRequired Classification Scheme(Classification Scheme newVal){
		Required Classification Scheme = newVal;
	}
}//end Budget Account