package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NumericType;

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
	private NumericType budgetYearNumeric;
	/**
	 * An identifier for the budget account, typically an internal accounting
	 * reference.
	 */
	private IdentifierType id;
	private ClassificationScheme requiredClassificationScheme;

	public NumericType getBudgetYearNumeric() {
		return budgetYearNumeric;
	}

	public void setBudgetYearNumeric(NumericType budgetYearNumeric) {
		this.budgetYearNumeric = budgetYearNumeric;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public ClassificationScheme getRequiredClassificationScheme() {
		return requiredClassificationScheme;
	}

	public void setRequiredClassificationScheme(ClassificationScheme requiredClassificationScheme) {
		this.requiredClassificationScheme = requiredClassificationScheme;
	}
}// end Budget Account