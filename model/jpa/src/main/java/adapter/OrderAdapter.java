package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to order goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:53 a. m.
 */
public class OrderAdapter{

	/**
	 * The buyer's accounting cost centre, applied to the OrderAdapter as a whole, expressed
	 * as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the OrderAdapter as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * A supplementary reference for the Order.
	 */
	private TextType CustomerReference;
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
	 * The number of OrderLines in the document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the type of Order.
	 */
	private CodeType OrderTypeCode;
	/**
	 * A code signifying the currency used for all prices in the Order.
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
	 * A code signifying the currency requested for amount totals in Invoices related
	 * to this Order.
	 */
	private CurrencyCodeType CodeTypeRequestedInvoiceCurrencyCode;
	/**
	 * An identifier for the Order, assigned by the seller.
	 */
	private IdentifierType SalesOrderID;
	/**
	 * A code signifying the currency requested for tax amounts in Invoices related to
	 * this Order.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
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
	private List<CatalogueReferenceAdapter> CatalogueReferences = new ArrayList<>();
	private List<ContractAdapter> Contracts = new ArrayList<>();
	private CountryAdapter DestinationCountry;
	private CustomerPartyAdapter OriginatorCustomerParty;
	private CustomerPartyAdapter AccountingCustomerParty;
	private CustomerPartyAdapter BuyerCustomerParty;
	private List<DeliveryAdapter> Deliveries = new ArrayList<>();
	private List<DeliveryTermsAdapter> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceAdapter OrderDocumentReference;
	private DocumentReferenceAdapter AdditionalDocumentReference;
	private DocumentReferenceAdapter OriginatorDocumentReference;
	private DocumentReferenceAdapter QuotationDocumentReference;
	private ExchangeRateAdapter PaymentExchangeRate;
	private ExchangeRateAdapter PricingExchangeRate;
	private ExchangeRateAdapter TaxExchangeRate;
	private MonetaryTotalAdapter AnticipatedMonetaryTotal;
	private List<OrderLineAdapter> OrderLines = new ArrayList<>();
	private PartyAdapter FreightForwarderParty;
	private List<PaymentMeansAdapter> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsAdapter> PaymentTermses = new ArrayList<>();
	private PeriodAdapter ValidityPeriod;
	private List<ProjectReferenceAdapter> ProjectReferences = new ArrayList<>();
	private List<SignatureAdapter> Signatures = new ArrayList<>();
	private SupplierPartyAdapter SellerSupplierParty;
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();
	private List<TransactionConditionsAdapter> TransactionConditionses = new ArrayList<>();

}
