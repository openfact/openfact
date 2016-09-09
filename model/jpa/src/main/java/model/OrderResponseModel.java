package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to indicate detailed acceptance or rejection of an OrderModel or to
 * make a counter-offer.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:59 a. m.
 */
public class OrderResponseModel{

	/**
	 * An accounting cost code applied to the order as a whole, expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * An accounting cost code applied to the order as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * A supplementary reference assigned by the buyer, e.g., the CRI in a purchasing
	 * card transaction.
	 */
	private TextType CustomerReference;
	/**
	 * Identifies a user-defined customization of UBL.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
	/**
	 * The total volume of the goods in the OrderResponseModel including packaging.
	 */
	private MeasureType GrossVolumeMeasure;
	/**
	 * The total gross weight for the OrderResponseModel (goods + packaging + transport
	 * equipment).
	 */
	private MeasureType GrossWeightMeasure;
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
	 * The number of OrderLines in this document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * The total net weight of the goods in the OrderResponseModel excluding packaging.
	 */
	private MeasureType NetNetWeightMeasure;
	/**
	 * The total volume of the goods in the OrderResponseModel excluding packaging.
	 */
	private MeasureType NetVolumeMeasure;
	/**
	 * The total net weight for the OrderResponseModel (goods + packaging).
	 */
	private MeasureType NetWeightMeasure;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the type of response for this Order.
	 */
	private CodeType OrderResponseCode;
	/**
	 * A code signifying the currency that is used for all prices in the Order
	 * Response.
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
	 * An identifier for the Order, issued by the Seller.
	 */
	private IdentifierType SalesOrderID;
	/**
	 * A code signifying the currency that is used for all tax amounts in the Order
	 * Response.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
	/**
	 * The total number of packages contained in the OrderResponse.
	 */
	private QuantityType TotalPackagesQuantity;
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
	private CustomerPartyModel OriginatorCustomerParty;
	private CustomerPartyModel AccountingCustomerParty;
	private CustomerPartyModel BuyerCustomerParty;
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel AdditionalDocumentReference;
	private DocumentReferenceModel OriginatorDocumentReference;
	private DocumentReferenceModel OrderDocumentReference;
	private ExchangeRateModel TaxExchangeRate;
	private ExchangeRateModel PricingExchangeRate;
	private ExchangeRateModel PaymentExchangeRate;
	private MonetaryTotalModel LegalMonetaryTotal;
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
