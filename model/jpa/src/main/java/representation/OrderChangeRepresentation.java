package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to specify changes to an existing Order.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:57 a. m.
 */
public class OrderChangeRepresentation{

	/**
	 * The buyer's accounting code, applied to the OrderChangeRepresentation as a whole, expressed
	 * as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the OrderChangeRepresentation as a whole.
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
	 * The number of OrderChangeRepresentation lines in the document.
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
	 * The OrderChangeRepresentation Sequence Number assigned by the Buyer to ensure the proper
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
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<ContractRepresentation> Contracts = new ArrayList<>();
	private CountryRepresentation DestinationCountry;
	private CustomerPartyRepresentation AccountingCustomerParty;
	private CustomerPartyRepresentation OriginatorCustomerParty;
	private CustomerPartyRepresentation BuyerCustomerParty;
	private List<DeliveryRepresentation> Deliveries = new ArrayList<>();
	private List<DeliveryTermsRepresentation> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceRepresentation AdditionalDocumentReference;
	private DocumentReferenceRepresentation OriginatorDocumentReference;
	private DocumentReferenceRepresentation QuotationDocumentReference;
	private ExchangeRateRepresentation PricingExchangeRate;
	private ExchangeRateRepresentation PaymentExchangeRate;
	private ExchangeRateRepresentation TaxExchangeRate;
	private MonetaryTotalRepresentation AnticipatedMonetaryTotal;
	private List<OrderLineRepresentation> OrderLines = new ArrayList<>();
	private List<OrderReferenceRepresentation> OrderReferences = new ArrayList<>();
	private PartyRepresentation FreightForwarderParty;
	private List<PaymentMeansRepresentation> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsRepresentation> PaymentTermses = new ArrayList<>();
	private PeriodRepresentation ValidityPeriod;
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private SupplierPartyRepresentation SellerSupplierParty;
	private SupplierPartyRepresentation AccountingSupplierParty;
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();
	private List<TransactionConditionsRepresentation> TransactionConditionses = new ArrayList<>();

}
