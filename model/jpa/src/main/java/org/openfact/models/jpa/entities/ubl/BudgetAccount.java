package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a budget account.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:12 a. m.
 */
public class BudgetAccount {

	/**
	 * The number of the year for this budget account, e.g. 2012
	 */
	private BigDecimal budgetYearNumeric;
	/**
	 * An identifier for the budget account, typically an internal accounting
	 * reference.
	 */
	private String id;
	private ClassificationScheme requiredClassificationScheme;

	public BigDecimal getBudgetYearNumeric() {
		return budgetYearNumeric;
	}

	public void setBudgetYearNumeric(BigDecimal budgetYearNumeric) {
		this.budgetYearNumeric = budgetYearNumeric;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClassificationScheme getRequiredClassificationScheme() {
		return requiredClassificationScheme;
	}

	public void setRequiredClassificationScheme(ClassificationScheme requiredClassificationScheme) {
		this.requiredClassificationScheme = requiredClassificationScheme;
	}
}// end Budget Account