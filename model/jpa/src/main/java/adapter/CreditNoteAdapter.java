package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to specify credits due to the Debtor from the Creditor.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:25 a. m.
 */
public class CreditNoteAdapter{

	/**
	 * The buyer's accounting code, applied to the CreditNoteAdapter as a whole, expressed
	 * as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the CreditNoteAdapter as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * A reference provided by the buyer used for internal routing of the document.
	 */
	private TextType BuyerReference;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * A code signifying the type of the CreditNote.
	 */
	private CodeType CreditNoteTypeCode;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType IssueTime;
	/**
	 * The number of CreditNoteLines in the document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the alternative currency used for payment in the CreditNote.
	 */
	private CurrencyCodeType CodeTypePaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the CreditNote.
	 */
	private CurrencyCodeType CodeTypePaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the CreditNote.
	 */
	private CurrencyCodeType CodeTypePricingCurrencyCode;
	/**
	 * Identifies an instance of executing a profile, to associate all transactions in
	 * a collaboration.
	 */
	private IdentifierType ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the customization of UBL being used.
	 */
	private IdentifierType ProfileID;
	/**
	 * A code signifying the currency used for tax amounts in the CreditNote.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
	/**
	 * The date of the CreditNote, used to indicate the point at which tax becomes
	 * applicable.
	 */
	private DateType TaxPointDate;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceAdapter> BillingReferences = new ArrayList<>();
	private List<CreditNoteLineAdapter> CreditNoteLines = new ArrayList<>();
	private CustomerPartyAdapter AccountingCustomerParty;
	private CustomerPartyAdapter BuyerCustomerParty;
	private List<DeliveryAdapter> Deliveries = new ArrayList<>();
	private List<DeliveryTermsAdapter> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceAdapter StatementDocumentReference;
	private DocumentReferenceAdapter OriginatorDocumentReference;
	private DocumentReferenceAdapter ContractDocumentReference;
	private DocumentReferenceAdapter ReceiptDocumentReference;
	private DocumentReferenceAdapter AdditionalDocumentReference;
	private DocumentReferenceAdapter DespatchDocumentReference;
	private ExchangeRateAdapter PaymentAlternativeExchangeRate;
	private ExchangeRateAdapter PaymentExchangeRate;
	private ExchangeRateAdapter TaxExchangeRate;
	private ExchangeRateAdapter PricingExchangeRate;
	private MonetaryTotalAdapter LegalMonetaryTotal;
	private List<OrderReferenceAdapter> OrderReferences = new ArrayList<>();
	private PartyAdapter TaxRepresentativeParty;
	private PartyAdapter PayeeParty;
	private List<PaymentMeansAdapter> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsAdapter> PaymentTermses = new ArrayList<>();
	private PeriodAdapter InvoicePeriod;
	private ResponseAdapter DiscrepancyResponse;
	private List<SignatureAdapter> Signatures = new ArrayList<>();
	private SupplierPartyAdapter SellerSupplierParty;
	private SupplierPartyAdapter AccountingSupplierParty;
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();

}
