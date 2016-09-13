package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

/**
 * A class to define a budget account.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:12 a. m.
 */
public class BudgetAccountRepresentation {

    /**
     * The number of the year for this budget account, e.g. 2012
     */
    private BigDecimal budgetYearNumeric;
    /**
     * An identifier for the budget account, typically an internal accounting
     * reference.
     */
    private IdentifierRepresentation ID;
    private ClassificationSchemeRepresentation requiredClassificationScheme;

}
