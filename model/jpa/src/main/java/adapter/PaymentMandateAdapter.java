package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a payment mandate.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
public class PaymentMandateAdapter{

	/**
	 * An identifier for this payment mandate.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying the type of this payment mandate.
	 */
	private CodeType mandateTypeCode;
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	private AmountType maximumPaidAmount;
	/**
	 * The number of maximum payment instructions allowed within the validity period.
	 */
	private NumericType maximumPaymentInstructionsNumeric;
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	private IdentifierType signatureID;
	private List<ClauseAdapter> clauses = new ArrayList<>();
	private FinancialAccountAdapter payerFinancialAccount;
	private PartyAdapter payerParty;
	private PeriodAdapter validityPeriod;
	private PeriodAdapter paymentReversalPeriod;

}
