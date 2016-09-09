package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a monetary total.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:12 a. m.
 */
public class MonetaryTotal{

	/**
	 * The total monetary amount of all allowances.
	 */
	private BigDecimal AllowanceTotalAmount;
	/**
	 * The total monetary amount of all charges.
	 */
	private BigDecimal ChargeTotalAmount;
	/**
	 * The monetary amount of an extended transaction line, net of tax and settlement
	 * discounts, but inclusive of any applicable rounding amount.
	 */
	private BigDecimal LineExtensionAmount;
	/**
	 * The amount of the monetary total to be paid, expressed in an alternative
	 * currency.
	 */
	private BigDecimal PayableAlternativeAmount;
	/**
	 * The amount of the monetary total to be paid.
	 */
	private BigDecimal PayableAmount;
	/**
	 * The rounding amount (positive or negative) added to produce the line extension
	 * amount.
	 */
	private BigDecimal PayableRoundingAmount;
	/**
	 * The total prepaid monetary amount.
	 */
	private BigDecimal PrepaidAmount;
	/**
	 * The monetary amount of an extended transaction line, exclusive of taxes.
	 */
	private BigDecimal TaxExclusiveAmount;
	/**
	 * The monetary amount including taxes; the sum of payable amount and prepaid
	 * amount.
	 */
	private BigDecimal TaxInclusiveAmount;

}
