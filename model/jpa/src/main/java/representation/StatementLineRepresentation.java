package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a StatementRepresentation of account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLineRepresentation{

	/**
	 * The balance amount on this statement line.
	 */
	private AmountType BalanceAmount;
	/**
	 * An indication that this statement line contains an outstanding balance from the
	 * previous bill(s) (true) or does not (false).
	 */
	private IndicatorType BalanceBroughtForwardIndicator;
	/**
	 * The amount credited on this statement line.
	 */
	private AmountType CreditLineAmount;
	/**
	 * The amount debited on this statement line.
	 */
	private AmountType DebitLineAmount;
	/**
	 * An identifier for this statement line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private CodeType PaymentPurposeCode;
	/**
	 * A universally unique identifier for this statement line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceRepresentation> BillingReferences = new ArrayList<>();
	private CustomerPartyRepresentation BuyerCustomerParty;
	private CustomerPartyRepresentation OriginatorCustomerParty;
	private CustomerPartyRepresentation AccountingCustomerParty;
	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<ExchangeRateRepresentation> ExchangeRates = new ArrayList<>();
	private PartyRepresentation PayeeParty;
	private PaymentRepresentation CollectedPayment;
	private List<PaymentMeansRepresentation> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsRepresentation> PaymentTermses = new ArrayList<>();
	private PeriodRepresentation InvoicePeriod;
	private SupplierPartyRepresentation AccountingSupplierParty;
	private SupplierPartyRepresentation SellerSupplierParty;

}
