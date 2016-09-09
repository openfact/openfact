package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * An InvoiceModel document created by the Customer (rather than the Supplier) in a
 * Self Billing relationship.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:24 a. m.
 */
public class SelfBilledInvoiceModel{

	/**
	 * An accounting cost code, applied to the InvoiceModel as a whole, expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * An accounting cost code, applied to the InvoiceModel as a whole.
	 */
	private CodeType AccountingCostCode;
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
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying the type of invoice.
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
	 * The number of InvoiceLines in this document.
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
	 * The date of the invoice for tax purposes, in accordance with the applicable tax
	 * regulation.
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
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceModel> BillingReferences = new ArrayList<>();
	private CustomerPartyModel AccountingCustomerParty;
	private CustomerPartyModel BuyerCustomerParty;
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel StatementDocumentReference;
	private DocumentReferenceModel ReceiptDocumentReference;
	private DocumentReferenceModel DespatchDocumentReference;
	private DocumentReferenceModel AdditionalDocumentReference;
	private DocumentReferenceModel ContractDocumentReference;
	private DocumentReferenceModel OriginatorDocumentReference;
	private ExchangeRateModel TaxExchangeRate;
	private ExchangeRateModel PricingExchangeRate;
	private ExchangeRateModel PaymentExchangeRate;
	private ExchangeRateModel PaymentAlternativeExchangeRate;
	private List<InvoiceLineModel> InvoiceLines = new ArrayList<>();
	private MonetaryTotalModel LegalMonetaryTotal;
	private List<OrderReferenceModel> OrderReferences = new ArrayList<>();
	private PartyModel PayeeParty;
	private PartyModel TaxRepresentativeParty;
	private PaymentModel PrepaidPayment;
	private List<PaymentMeansModel> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel InvoicePeriod;
	private List<SignatureModel> Signatures = new ArrayList<>();
	private SupplierPartyModel SellerSupplierParty;
	private SupplierPartyModel AccountingSupplierParty;
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();

}
