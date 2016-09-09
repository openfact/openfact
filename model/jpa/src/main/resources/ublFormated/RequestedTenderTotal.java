package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class defining budgeted monetary amounts.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:31 a. m.
 */
public class RequestedTenderTotal{

	/**
	 * The average monetary amount for the subsequent contracts following this budget
	 * amount.
	 */
	private BigDecimal AverageSubsequentContractAmount;
	/**
	 * The estimated overall monetary amount of a contract.
	 */
	private BigDecimal EstimatedOverallContractAmount;
	/**
	 * The maximum monetary amount of the budget.
	 */
	private BigDecimal MaximumAmount;
	/**
	 * The minimum monetary amount of the budget.
	 */
	private BigDecimal MinimumAmount;
	/**
	 * A description of the monetary scope of the budget.
	 */
	private TextType MonetaryScope;
	/**
	 * Indicates whether the amounts are taxes included (true) or not (false).
	 */
	private boolean TaxIncludedIndicator;
	/**
	 * The monetary amount of the total budget including net amount, taxes, and
	 * material and instalment costs. 
	 */
	private BigDecimal TotalAmount;
	private TaxCategory ApplicableTaxCategory;

}
