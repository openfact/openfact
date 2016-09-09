package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to request payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */
public class InvoiceModel{

	/**
	 * The buyer's accounting code, applied to the InvoiceModel as a whole, expressed as
	 * text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the InvoiceModel as a whole.
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
	 * The date on which InvoiceModel is due.
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
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceModel> BillingReferences = new ArrayList<>();
	private CustomerPartyModel AccountingCustomerParty;
	private CustomerPartyModel BuyerCustomerParty;
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel StatementDocumentReference;
	private DocumentReferenceModel ReceiptDocumentReference;
	private DocumentReferenceModel DespatchDocumentReference;
	private DocumentReferenceModel OriginatorDocumentReference;
	private DocumentReferenceModel ContractDocumentReference;
	private DocumentReferenceModel AdditionalDocumentReference;
	private ExchangeRateModel TaxExchangeRate;
	private ExchangeRateModel PricingExchangeRate;
	private ExchangeRateModel PaymentExchangeRate;
	private ExchangeRateModel PaymentAlternativeExchangeRate;
	private List<InvoiceLineModel> InvoiceLines = new ArrayList<>();
	private MonetaryTotalModel LegalMonetaryTotal;
	private List<OrderReferenceModel> OrderReferences = new ArrayList<>();
	private PartyModel TaxRepresentativeParty;
	private PartyModel PayeeParty;
	private PaymentModel PrepaidPayment;
	private List<PaymentMeansModel> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel InvoicePeriod;
	private List<ProjectReferenceModel> ProjectReferences = new ArrayList<>();
	private List<SignatureModel> Signatures = new ArrayList<>();
	private SupplierPartyModel AccountingSupplierParty;
	private SupplierPartyModel SellerSupplierParty;
	private List<TaxTotalModel> WithholdingTaxTotal = new ArrayList<>();
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();

}
