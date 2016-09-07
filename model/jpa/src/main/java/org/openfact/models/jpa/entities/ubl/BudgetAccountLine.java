package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a budget account line.
 * 
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
	private BigDecimal totalAmount;
	private List<BudgetAccount> BudgetAccounts=new ArrayList<>();

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<BudgetAccount> getBudgetAccounts() {
		return BudgetAccounts;
	}

	public void setBudgetAccounts(List<BudgetAccount> budgetAccounts) {
		BudgetAccounts = budgetAccounts;
	}
}// end BudgetAccountLine