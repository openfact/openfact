package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a budget account line.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:13 a. m.
 */
public class BudgetAccountLine {

	/**
	 * An identifier for this budget account line.
	 */
	private String ID;
	/**
	 * The total monetary amount for this budget account line.
	 */
	private BigDecimal TotalAmount;
	private Budget Account m_Budget Account;

	public Budget Account Line(){

	}

	public void finalize() throws Throwable {

	}
	public Budget Account getBudget Account(){
		return m_Budget Account;
	}

	public String getID(){
		return ID;
	}

	public BigDecimal getTotalAmount(){
		return TotalAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBudget Account(Budget Account newVal){
		m_Budget Account = newVal;
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
	public void setTotalAmount(BigDecimal newVal){
		TotalAmount = newVal;
	}
}//end Budget Account Line