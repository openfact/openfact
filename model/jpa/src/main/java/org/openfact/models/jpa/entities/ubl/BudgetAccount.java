package org.openfact.models.jpa.entities.ubl;


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
	private BigDecimal BudgetYearNumeric;
	/**
	 * An identifier for the budget account, typically an internal accounting
	 * reference.
	 */
	private String ID;
	private Classification Scheme Required Classification Scheme;

	public Budget Account(){

	}

	public void finalize() throws Throwable {

	}
	public BigDecimal getBudgetYearNumeric(){
		return BudgetYearNumeric;
	}

	public String getID(){
		return ID;
	}

	public Classification Scheme getRequired Classification Scheme(){
		return Required Classification Scheme;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBudgetYearNumeric(BigDecimal newVal){
		BudgetYearNumeric = newVal;
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
	public void setRequired Classification Scheme(Classification Scheme newVal){
		Required Classification Scheme = newVal;
	}
}//end Budget Account