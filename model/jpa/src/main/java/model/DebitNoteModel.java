package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to specify debts incurred by the Debtor.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:27 a. m.
 */
public class DebitnoteModel{

	/**
	 * The Buyer's accounting code, applied to the CreditnoteModel as a whole, expressed
	 * as text.
	 */
	private TextType accountingCost;
	/**
	 * The Buyer's accounting code, applied to the CreditnoteModel as a whole.
	 */
	private CodeType accountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType copyIndicator;
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
	 * The number of DebitnoteModel Lines in this document.
	 */
	private NumericType lineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note;
	/**
	 * A code signifying the alternative currency used for payment in the Debitnote.
	 */
	private CurrencyCodeType codeTypePaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Debitnote.
	 */
	private CurrencyCodeType codeTypePaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Debitnote.
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
	 * A code signifying the currency used for tax amounts in the Debitnote.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode;
	/**
	 * The date of the Debitnote, used to indicate the point at which tax becomes
	 * applicable.
	 */
	private DateType taxPointDate;
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
	private List<BillingReferenceModel> billingReferences = new ArrayList<>();
	private CustomerPartyModel accountingCustomerParty;
	private CustomerPartyModel buyerCustomerParty;
	private List<DebitnoteModel> LineDebitnoteLines = new ArrayList<>();
	private List<DeliveryModel> deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel additionalDocumentReference;
	private DocumentReferenceModel contractDocumentReference;
	private DocumentReferenceModel despatchDocumentReference;
	private DocumentReferenceModel receiptDocumentReference;
	private DocumentReferenceModel statementDocumentReference;
	private ExchangeRateModel paymentAlternativeExchangeRate;
	private ExchangeRateModel paymentExchangeRate;
	private ExchangeRateModel pricingExchangeRate;
	private ExchangeRateModel taxExchangeRate;
	private MonetaryTotalModel requestedMonetaryTotal;
	private List<OrderReferenceModel> orderReferences = new ArrayList<>();
	private PartyModel taxRepresentativeParty;
	private PartyModel payeeParty;
	private PaymentModel prepaidPayment;
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
	private PeriodModel invoicePeriod;
	private ResponseModel discrepancyResponse;
	private List<SignatureModel> signatures = new ArrayList<>();
	private SupplierPartyModel accountingSupplierParty;
	private SupplierPartyModel sellerSupplierParty;
	private List<TaxTotalModel> taxTotals = new ArrayList<>();

}
