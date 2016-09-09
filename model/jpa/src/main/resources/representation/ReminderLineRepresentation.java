package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a ReminderRepresentation document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:24 a. m.
 */
public class ReminderLineRepresentation{

	/**
	 * The buyer's accounting cost centre for this reminder line, expressed as text.
	 */
	private TextType accountingCost;
	/**
	 * The buyer's accounting cost centre for this reminder line, expressed as a code.
	 */
	private CodeType accountingCostCode;
	/**
	 * The amount on this reminder line.
	 */
	private amountType amount;
	/**
	 * An indication that this reminder line contains a balance brought forward (true)
	 * or does not (false).
	 */
	private IndicatorType balanceBroughtForwardIndicator;
	/**
	 * The amount credited on this reminder line.
	 */
	private amountType CreditLineamount;
	/**
	 * The amount debited on this reminder line.
	 */
	private amountType DebitLineamount;
	/**
	 * An identifier for this reminder line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private CodeType paymentPurposeCode;
	/**
	 * The penalty for late payment, expressed as a percentage.
	 */
	private PercentType penaltySurchargePercent;
	/**
	 * A universally unique identifier for this reminder line.
	 */
	private IdentifierType UUID;
	private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
	private List<ExchangeRateRepresentation> exchangeRates = new ArrayList<>();
	private PeriodRepresentation reminderPeriod;

}
