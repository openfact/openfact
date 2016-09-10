package org.openfact.models.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.*;

/**
 * A class defining budgeted monetary amounts.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:31 a. m.
 */
public class RequestedTenderTotalModel {

    /**
     * The average monetary amount for the subsequent contracts following this
     * budget amount.
     */
    private BigDecimal averageSubsequentContractAmount;
    /**
     * The estimated overall monetary amount of a contract.
     */
    private BigDecimal estimatedOverallContractAmount;
    /**
     * The maximum monetary amount of the budget.
     */
    private BigDecimal maximumAmount;
    /**
     * The minimum monetary amount of the budget.
     */
    private BigDecimal minimumAmount;
    /**
     * A description of the monetary scope of the budget.
     */
    private TextType monetaryScope;
    /**
     * Indicates whether the amounts are taxes included (true) or not (false).
     */
    private boolean taxIncludedIndicator;
    /**
     * The monetary amount of the total budget including net amount, taxes, and
     * material and instalment costs.
     */
    private BigDecimal totalAmount;
    private TaxCategoryModel applicableTaxCategory;

}
