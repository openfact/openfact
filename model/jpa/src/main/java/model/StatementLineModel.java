package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a StatementModel of account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLineModel{

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
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceModel> BillingReferences = new ArrayList<>();
	private CustomerPartyModel BuyerCustomerParty;
	private CustomerPartyModel OriginatorCustomerParty;
	private CustomerPartyModel AccountingCustomerParty;
	private List<DocumentReferenceModel> DocumentReferences = new ArrayList<>();
	private List<ExchangeRateModel> ExchangeRates = new ArrayList<>();
	private PartyModel PayeeParty;
	private PaymentModel CollectedPayment;
	private List<PaymentMeansModel> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel InvoicePeriod;
	private SupplierPartyModel AccountingSupplierParty;
	private SupplierPartyModel SellerSupplierParty;

}
