package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A credit note created by the debtor in a self billing arrangement with a
 * creditor; SelfBilledCreditnoteAdapter replaces DebitnoteAdapter in such arrangements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:22 a. m.
 */
public class SelfBilledCreditnoteAdapter{

	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditnoteAdapter as a whole,
	 * expressed as text.
	 */
	private TextType accountingCost;
	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditnoteAdapter as a whole.
	 */
	private CodeType accountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType codeTypeDocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType issueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime;
	/**
	 * The number of SelfBilledCreditnoteAdapter Lines in this document.
	 */
	private NumericType lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * A code signifying the alternative currency used for payment in the Self Billed
	 * Creditnote.
	 */
	private CurrencyCodeType codeTypePaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the SelfBilledCreditnote.
	 */
	private CurrencyCodeType codeTypePaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the SelfBilledCreditnote.
	 */
	private CurrencyCodeType codeTypePricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType profileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType profileID;
	/**
	 * A code signifying the currency used for tax amounts in the Self Billed Credit
	 * note.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode;
	/**
	 * The date of the SelfBilledCreditnote, used to indicate the point at which
	 * tax becomes applicable.
	 */
	private DateType taxPointDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceAdapter> billingReferences = new ArrayList<>();
	private List<CreditnoteLineAdapter> CreditnoteLines = new ArrayList<>();
	private CustomerPartyAdapter accountingCustomerParty;
	private CustomerPartyAdapter buyerCustomerParty;
	private List<DeliveryAdapter> deliveries = new ArrayList<>();
	private List<DeliveryTermsAdapter> deliveriesTerms = new ArrayList<>();
	private DocumentReferenceAdapter contractDocumentReference;
	private DocumentReferenceAdapter originatorDocumentReference;
	private DocumentReferenceAdapter statementDocumentReference;
	private DocumentReferenceAdapter despatchDocumentReference;
	private DocumentReferenceAdapter receiptDocumentReference;
	private DocumentReferenceAdapter additionalDocumentReference;
	private ExchangeRateAdapter pricingExchangeRate;
	private ExchangeRateAdapter paymentAlternativeExchangeRate;
	private ExchangeRateAdapter paymentExchangeRate;
	private ExchangeRateAdapter taxExchangeRate;
	private MonetaryTotalAdapter legalMonetaryTotal;
	private List<OrderReferenceAdapter> orderReferences = new ArrayList<>();
	private PartyAdapter taxRepresentativeParty;
	private PartyAdapter payeeParty;
	private List<PaymentMeansAdapter> paymentMeanses = new ArrayList<>();
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>();
	private PeriodAdapter invoicePeriod;
	private ResponseAdapter discrepancyResponse;
	private List<SignatureAdapter> signatures = new ArrayList<>();
	private SupplierPartyAdapter sellerSupplierParty;
	private SupplierPartyAdapter accountingSupplierParty;
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>();

}
