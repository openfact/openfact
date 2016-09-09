package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a StatementAdapter of account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLineAdapter{

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
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceAdapter> BillingReferences = new ArrayList<>();
	private CustomerPartyAdapter BuyerCustomerParty;
	private CustomerPartyAdapter OriginatorCustomerParty;
	private CustomerPartyAdapter AccountingCustomerParty;
	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private List<ExchangeRateAdapter> ExchangeRates = new ArrayList<>();
	private PartyAdapter PayeeParty;
	private PaymentAdapter CollectedPayment;
	private List<PaymentMeansAdapter> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsAdapter> PaymentTermses = new ArrayList<>();
	private PeriodAdapter InvoicePeriod;
	private SupplierPartyAdapter AccountingSupplierParty;
	private SupplierPartyAdapter SellerSupplierParty;

}
