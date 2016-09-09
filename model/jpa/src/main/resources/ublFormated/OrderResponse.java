package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to indicate detailed acceptance or rejection of an Order or to
 * make a counter-offer.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:59 a. m.
 */
public class OrderResponse{

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
	 * The total volume of the goods in the OrderResponse including packaging.
	 */
	private MeasureType GrossVolumeMeasure;
	/**
	 * The total gross weight for the OrderResponse (goods + packaging + transport
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
	 * The total net weight of the goods in the OrderResponse excluding packaging.
	 */
	private MeasureType NetNetWeightMeasure;
	/**
	 * The total volume of the goods in the OrderResponse excluding packaging.
	 */
	private MeasureType NetVolumeMeasure;
	/**
	 * The total net weight for the OrderResponse (goods + packaging).
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
	private List<AllowanceCharge> AllowanceCharges = new ArrayList<>();
	private List<Contract> Contracts = new ArrayList<>();
	private Country DestinationCountry;
	private CustomerParty OriginatorCustomerParty;
	private CustomerParty AccountingCustomerParty;
	private CustomerParty BuyerCustomerParty;
	private List<Delivery> Deliveries = new ArrayList<>();
	private List<DeliveryTerms> DeliveriesTerms = new ArrayList<>();
	private DocumentReference AdditionalDocumentReference;
	private DocumentReference OriginatorDocumentReference;
	private DocumentReference OrderDocumentReference;
	private ExchangeRate TaxExchangeRate;
	private ExchangeRate PricingExchangeRate;
	private ExchangeRate PaymentExchangeRate;
	private MonetaryTotal LegalMonetaryTotal;
	private List<OrderLine> OrderLines = new ArrayList<>();
	private List<OrderReference> OrderReferences = new ArrayList<>();
	private Party FreightForwarderParty;
	private List<PaymentMeans> PaymentMeanses = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period ValidityPeriod;
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty SellerSupplierParty;
	private SupplierParty AccountingSupplierParty;
	private List<TaxTotal> TaxTotals = new ArrayList<>();
	private List<TransactionConditions> TransactionConditionses = new ArrayList<>();

}
