package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to order goods and services.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:53 a. m.
 */
public class OrderModel{

	/**
	 * The buyer's accounting cost centre, applied to the OrderModel as a whole, expressed
	 * as text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting code, applied to the OrderModel as a whole.
	 */
	private CodeType accountingCostCode; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator; 
	/**
	 * A supplementary reference for the Order.
	 */
	private TextType customerReference; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType codeTypeDocumentCurrencyCode; 
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
	 * The number of orderLines in the document.
	 */
	private NumericType lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the type of Order.
	 */
	private CodeType orderTypeCode; 
	/**
	 * A code signifying the currency used for all prices in the Order.
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
	 * A code signifying the currency requested for amount totals in Invoices related
	 * to this Order.
	 */
	private CurrencyCodeType codeTypeRequestedInvoiceCurrencyCode; 
	/**
	 * An identifier for the Order, assigned by the seller.
	 */
	private IdentifierType salesOrderID; 
	/**
	 * A code signifying the currency requested for tax amounts in Invoices related to
	 * this Order.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode; 
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
	private List<CatalogueReferenceModel> catalogueReferences = new ArrayList<>(); 
	private List<ContractModel> contracts = new ArrayList<>(); 
	private CountryModel destinationCountry; 
	private CustomerPartyModel originatorCustomerParty; 
	private CustomerPartyModel accountingCustomerParty; 
	private CustomerPartyModel buyerCustomerParty; 
	private List<DeliveryModel> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceModel orderDocumentReference; 
	private DocumentReferenceModel additionalDocumentReference; 
	private DocumentReferenceModel originatorDocumentReference; 
	private DocumentReferenceModel quotationDocumentReference; 
	private ExchangeRateModel paymentExchangeRate; 
	private ExchangeRateModel pricingExchangeRate; 
	private ExchangeRateModel taxExchangeRate; 
	private MonetaryTotalModel anticipatedMonetaryTotal; 
	private List<OrderLineModel> orderLines = new ArrayList<>(); 
	private PartyModel freightForwarderParty; 
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>(); 
	private PeriodModel validityPeriod; 
	private List<ProjectReferenceModel> projectReferences = new ArrayList<>(); 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private SupplierPartyModel sellerSupplierParty; 
	private List<TaxTotalModel> taxTotals = new ArrayList<>(); 
	private List<TransactionConditionsModel> transactionConditionses = new ArrayList<>(); 

}
