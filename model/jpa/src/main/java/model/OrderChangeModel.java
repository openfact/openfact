package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to specify changes to an existing Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:57 a. m.
 */
public class OrderChangeModel{

	/**
	 * The buyer's accounting code, applied to the OrderChangeModel as a whole, expressed
	 * as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the OrderChangeModel as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * A supplementary reference for the transaction (e.g., CRI when using purchasing
	 * card).
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
	 * The number of OrderChangeModel lines in the document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the currency that is used for all prices in the OrderChange.
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
	 * A code signifying he currency requested for amount totals in Invoices related
	 * to this OrderChange.
	 */
	private CurrencyCodeType CodeTypeRequestedInvoiceCurrencyCode;
	/**
	 * An identifier for the OrderChange, assigned by the seller.
	 */
	private IdentifierType SalesOrderID;
	/**
	 * The OrderChangeModel Sequence Number assigned by the Buyer to ensure the proper
	 * sequencing of changes.
	 */
	private IdentifierType SequenceNumberID;
	/**
	 * A code signifying the currency requested for tax amounts in Invoices related to
	 * this OrderChange.
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
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<ContractModel> Contracts = new ArrayList<>();
	private CountryModel DestinationCountry;
	private CustomerPartyModel AccountingCustomerParty;
	private CustomerPartyModel OriginatorCustomerParty;
	private CustomerPartyModel BuyerCustomerParty;
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel AdditionalDocumentReference;
	private DocumentReferenceModel OriginatorDocumentReference;
	private DocumentReferenceModel QuotationDocumentReference;
	private ExchangeRateModel PricingExchangeRate;
	private ExchangeRateModel PaymentExchangeRate;
	private ExchangeRateModel TaxExchangeRate;
	private MonetaryTotalModel AnticipatedMonetaryTotal;
	private List<OrderLineModel> OrderLines = new ArrayList<>();
	private List<OrderReferenceModel> OrderReferences = new ArrayList<>();
	private PartyModel FreightForwarderParty;
	private List<PaymentMeansModel> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel ValidityPeriod;
	private List<SignatureModel> Signatures = new ArrayList<>();
	private SupplierPartyModel SellerSupplierParty;
	private SupplierPartyModel AccountingSupplierParty;
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();
	private List<TransactionConditionsModel> TransactionConditionses = new ArrayList<>();

}
