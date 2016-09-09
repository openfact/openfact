package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a payment mandate.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
public class PaymentMandateRepresentation{

	/**
	 * An identifier for this payment mandate.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying the type of this payment mandate.
	 */
	private CodeType MandateTypeCode;
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	private AmountType MaximumPaidAmount;
	/**
	 * The number of maximum payment instructions allowed within the validity period.
	 */
	private NumericType MaximumPaymentInstructionsNumeric;
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	private IdentifierType SignatureID;
	private List<ClauseRepresentation> Clauses = new ArrayList<>();
	private FinancialAccountRepresentation PayerFinancialAccount;
	private PartyRepresentation PayerParty;
	private PeriodRepresentation ValidityPeriod;
	private PeriodRepresentation PaymentReversalPeriod;

}
