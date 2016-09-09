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
	private TextType accountingCost;
	/**
	 * An accounting cost code applied to the order as a whole.
	 */
	private CodeType accountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
	/**
	 * A supplementary reference assigned by the buyer, e.g., the CRI in a purchasing
	 * card transaction.
	 */
	private TextType customerReference;
	/**
	 * Identifies a user-defined customization of UBL.
	 */
	private IdentifierType customizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType codeTypeDocumentCurrencyCode;
	/**
	 * The total volume of the goods in the OrderResponseModel including packaging.
	 */
	private MeasureType grossVolumeMeasure;
	/**
	 * The total gross weight for the OrderResponseModel (goods + packaging + transport
	 * equipment).
	 */
	private MeasureType grossWeightMeasure;
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
	 * The number of orderLines in this document.
	 */
	private NumericType lineCountNumeric;
	/**
	 * The total net weight of the goods in the OrderResponseModel excluding packaging.
	 */
	private MeasureType netnetWeightMeasure;
	/**
	 * The total volume of the goods in the OrderResponseModel excluding packaging.
	 */
	private MeasureType netVolumeMeasure;
	/**
	 * The total net weight for the OrderResponseModel (goods + packaging).
	 */
	private MeasureType netWeightMeasure;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * A code signifying the type of response for this Order.
	 */
	private CodeType orderResponseCode;
	/**
	 * A code signifying the currency that is used for all prices in the Order
	 * Response.
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
	 * An identifier for the Order, issued by the Seller.
	 */
	private IdentifierType salesOrderID;
	/**
	 * A code signifying the currency that is used for all tax amounts in the Order
	 * Response.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode;
	/**
	 * The total number of packages contained in the OrderResponse.
	 */
	private QuantityType totalPackagesQuantity;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document type that
	 * defines all of the elements that might be encountered in the current instance.
	 */
	private IdentifierType UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>();
	private List<ContractModel> contracts = new ArrayList<>();
	private CountryModel destinationCountry;
	private CustomerPartyModel originatorCustomerParty;
	private CustomerPartyModel accountingCustomerParty;
	private CustomerPartyModel buyerCustomerParty;
	private List<DeliveryModel> deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel additionalDocumentReference;
	private DocumentReferenceModel originatorDocumentReference;
	private DocumentReferenceModel orderDocumentReference;
	private ExchangeRateModel taxExchangeRate;
	private ExchangeRateModel pricingExchangeRate;
	private ExchangeRateModel paymentExchangeRate;
	private MonetaryTotalModel legalMonetaryTotal;
	private List<OrderLineModel> orderLines = new ArrayList<>();
	private List<OrderReferenceModel> orderReferences = new ArrayList<>();
	private PartyModel freightForwarderParty;
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
	private PeriodModel validityPeriod;
	private List<SignatureModel> signatures = new ArrayList<>();
	private SupplierPartyModel sellerSupplierParty;
	private SupplierPartyModel accountingSupplierParty;
	private List<TaxTotalModel> taxTotals = new ArrayList<>();
	private List<TransactionConditionsModel> transactionConditionses = new ArrayList<>();

}
