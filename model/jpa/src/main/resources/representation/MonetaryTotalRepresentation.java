package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a monetary total.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:12 a. m.
 */
public class MonetaryTotalRepresentation{

	/**
	 * The total monetary amount of all allowances.
	 */
	private AmountType allowanceTotalAmount;
	/**
	 * The total monetary amount of all charges.
	 */
	private AmountType chargeTotalAmount;
	/**
	 * The monetary amount of an extended transaction line, net of tax and settlement
	 * discounts, but inclusive of any applicable rounding amount.
	 */
	private AmountType lineExtensionAmount;
	/**
	 * The amount of the monetary total to be paid, expressed in an alternative
	 * currency.
	 */
	private AmountType payableAlternativeAmount;
	/**
	 * The amount of the monetary total to be paid.
	 */
	private AmountType payableAmount;
	/**
	 * The rounding amount (positive or negative) added to produce the line extension
	 * amount.
	 */
	private AmountType payableRoundingAmount;
	/**
	 * The total prepaid monetary amount.
	 */
	private AmountType prepaidAmount;
	/**
	 * The monetary amount of an extended transaction line, exclusive of taxes.
	 */
	private AmountType taxExclusiveAmount;
	/**
	 * The monetary amount including taxes; the sum of payable amount and prepaid
	 * amount.
	 */
	private AmountType taxInclusiveAmount;

}
