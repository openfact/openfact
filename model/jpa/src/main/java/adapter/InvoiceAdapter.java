package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to request payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */
public class InvoiceAdapter{

	/**
	 * The buyer's accounting code, applied to the InvoiceAdapter as a whole, expressed as
	 * text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the InvoiceAdapter as a whole.
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
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
	/**
	 * The date on which InvoiceAdapter is due.
	 */
	private DateType DueDate;
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying the type of the Invoice.
	 */
	private CodeType InvoiceTypeCode;
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType IssueTime;
	/**
	 * The number of lines in the document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the alternative currency used for payment in the Invoice.
	 */
	private CurrencyCodeType CodeTypePaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Invoice.
	 */
	private CurrencyCodeType CodeTypePaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Invoice.
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
	 * A code signifying the currency used for tax amounts in the Invoice.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
	/**
	 * The date of the Invoice, used to indicate the point at which tax becomes
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
	private CustomerPartyAdapter AccountingCustomerParty;
	private CustomerPartyAdapter BuyerCustomerParty;
	private List<DeliveryAdapter> Deliveries = new ArrayList<>();
	private List<DeliveryTermsAdapter> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceAdapter StatementDocumentReference;
	private DocumentReferenceAdapter ReceiptDocumentReference;
	private DocumentReferenceAdapter DespatchDocumentReference;
	private DocumentReferenceAdapter OriginatorDocumentReference;
	private DocumentReferenceAdapter ContractDocumentReference;
	private DocumentReferenceAdapter AdditionalDocumentReference;
	private ExchangeRateAdapter TaxExchangeRate;
	private ExchangeRateAdapter PricingExchangeRate;
	private ExchangeRateAdapter PaymentExchangeRate;
	private ExchangeRateAdapter PaymentAlternativeExchangeRate;
	private List<InvoiceLineAdapter> InvoiceLines = new ArrayList<>();
	private MonetaryTotalAdapter LegalMonetaryTotal;
	private List<OrderReferenceAdapter> OrderReferences = new ArrayList<>();
	private PartyAdapter TaxRepresentativeParty;
	private PartyAdapter PayeeParty;
	private PaymentAdapter PrepaidPayment;
	private List<PaymentMeansAdapter> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsAdapter> PaymentTermses = new ArrayList<>();
	private PeriodAdapter InvoicePeriod;
	private List<ProjectReferenceAdapter> ProjectReferences = new ArrayList<>();
	private List<SignatureAdapter> Signatures = new ArrayList<>();
	private SupplierPartyAdapter AccountingSupplierParty;
	private SupplierPartyAdapter SellerSupplierParty;
	private List<TaxTotalAdapter> WithholdingTaxTotal = new ArrayList<>();
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();

}
