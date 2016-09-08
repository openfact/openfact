package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;

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
	private IdentifierType id;
	/**
	 * The total monetary amount for this budget account line.
	 */
	private AmountType totalAmount;
	private List<BudgetAccount> BudgetAccounts=new ArrayList<>();

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public AmountType getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(AmountType totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<BudgetAccount> getBudgetAccounts() {
		return BudgetAccounts;
	}

	public void setBudgetAccounts(List<BudgetAccount> budgetAccounts) {
		BudgetAccounts = budgetAccounts;
	}
}// end BudgetAccountLine