package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

/**
 * A class to define a budget account line.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:13 a. m.
 */
public class BudgetAccountLineRepresentation {

    /**
     * An identifier for this budget account line.
     */
    private IdentifierRepresentation ID;
    /**
     * The total monetary amount for this budget account line.
     */
    private BigDecimal totalAmount;
    private List<BudgetAccountRepresentation> budgetAccounts = new ArrayList<>();

}
