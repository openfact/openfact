package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a budget account line.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:13 a. m.
 */
public class BudgetAccountLineModel {

    /**
     * An identifier for this budget account line.
     */
    private IdentifierType ID;
    /**
     * The total monetary amount for this budget account line.
     */
    private BigDecimal totalAmount;
    private List<BudgetAccountModel> budgetAccounts = new ArrayList<>();

}
