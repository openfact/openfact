package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to indicate detailed acceptance or rejection of an OrderAdapter or to
 * make a counter-offer.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:59 a. m.
 */
public class OrderResponseAdapter{

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
	private boolean copyIndicator; 
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
	 * The total volume of the goods in the OrderResponseAdapter including packaging.
	 */
	private MeasureType grossVolumeMeasure; 
	/**
	 * The total gross weight for the OrderResponseAdapter (goods + packaging + transport
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
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * The number of orderLines in this document.
	 */
	private BigDecimal lineCountNumeric; 
	/**
	 * The total net weight of the goods in the OrderResponseAdapter excluding packaging.
	 */
	private MeasureType netNetWeightMeasure; 
	/**
	 * The total volume of the goods in the OrderResponseAdapter excluding packaging.
	 */
	private MeasureType netVolumeMeasure; 
	/**
	 * The total net weight for the OrderResponseAdapter (goods + packaging).
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
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<ContractAdapter> contracts = new ArrayList<>(); 
	private CountryAdapter destinationCountry; 
	private CustomerPartyAdapter originatorCustomerParty; 
	private CustomerPartyAdapter accountingCustomerParty; 
	private CustomerPartyAdapter buyerCustomerParty; 
	private List<DeliveryAdapter> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsAdapter> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceAdapter additionalDocumentReference; 
	private DocumentReferenceAdapter originatorDocumentReference; 
	private DocumentReferenceAdapter orderDocumentReference; 
	private ExchangeRateAdapter taxExchangeRate; 
	private ExchangeRateAdapter pricingExchangeRate; 
	private ExchangeRateAdapter paymentExchangeRate; 
	private MonetaryTotalAdapter legalMonetaryTotal; 
	private List<OrderLineAdapter> orderLines = new ArrayList<>(); 
	private List<OrderReferenceAdapter> orderReferences = new ArrayList<>(); 
	private PartyAdapter freightForwarderParty; 
	private List<PaymentMeansAdapter> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>(); 
	private PeriodAdapter validityPeriod; 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 
	private SupplierPartyAdapter sellerSupplierParty; 
	private SupplierPartyAdapter accountingSupplierParty; 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 
	private List<TransactionConditionsAdapter> transactionConditionses = new ArrayList<>(); 

}
