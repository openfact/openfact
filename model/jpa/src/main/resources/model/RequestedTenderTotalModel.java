package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class defining budgeted monetary amounts.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:31 a. m.
 */
public class RequestedTenderTotalModel{

	/**
	 * The average monetary amount for the subsequent contracts following this budget
	 * amount.
	 */
	private AmountType averageSubsequentContractAmount; 
	/**
	 * The estimated overall monetary amount of a contract.
	 */
	private AmountType estimatedOverallContractAmount; 
	/**
	 * The maximum monetary amount of the budget.
	 */
	private AmountType maximumAmount; 
	/**
	 * The minimum monetary amount of the budget.
	 */
	private AmountType minimumAmount; 
	/**
	 * A description of the monetary scope of the budget.
	 */
	private TextType monetaryScope; 
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private IndicatorType taxIncludedIndicator; 
	/**
	 * The monetary amount of the total budget including net amount, taxes, and
	 * material and instalment costs. 
	 */
	private AmountType totalAmount; 
	private TaxCategoryModel applicableTaxCategory; 

}
