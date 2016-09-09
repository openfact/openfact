package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * An InvoiceAdapter document created by the Customer (rather than the Supplier) in a
 * Self Billing relationship.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:24 a. m.
 */
public class SelfBilledInvoiceAdapter{

	/**
	 * An accounting cost code, applied to the InvoiceAdapter as a whole, expressed as text.
	 */
	private TextType accountingCost; 
	/**
	 * An accounting cost code, applied to the InvoiceAdapter as a whole.
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
	 * A code signifying the type of invoice.
	 */
	private CodeType invoiceTypeCode; 
	/**
	 * The date, assigned by the sender, on which this document was issued.
	 */
	private DateType issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private TimeType issueTime; 
	/**
	 * The number of invoiceLines in this document.
	 */
	private NumericType lineCountNumeric; 
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the alternative currency used for payment in the Invoice.
	 */
	private CurrencyCodeType codeTypePaymentAlternativeCurrencyCode; 
	/**
	 * A code signifying the currency used for payment in the Invoice.
	 */
	private CurrencyCodeType codeTypePaymentCurrencyCode; 
	/**
	 * A code signifying the currency used for prices in the Invoice.
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
	 * A code signifying the currency used for tax amounts in the Invoice.
	 */
	private CurrencyCodeType codeTypeTaxCurrencyCode; 
	/**
	 * The date of the invoice for tax purposes, in accordance with the applicable tax
	 * regulation.
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
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<BillingReferenceAdapter> billingReferences = new ArrayList<>(); 
	private CustomerPartyAdapter accountingCustomerParty; 
	private CustomerPartyAdapter buyerCustomerParty; 
	private List<DeliveryAdapter> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsAdapter> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceAdapter statementDocumentReference; 
	private DocumentReferenceAdapter receiptDocumentReference; 
	private DocumentReferenceAdapter despatchDocumentReference; 
	private DocumentReferenceAdapter additionalDocumentReference; 
	private DocumentReferenceAdapter contractDocumentReference; 
	private DocumentReferenceAdapter originatorDocumentReference; 
	private ExchangeRateAdapter taxExchangeRate; 
	private ExchangeRateAdapter pricingExchangeRate; 
	private ExchangeRateAdapter paymentExchangeRate; 
	private ExchangeRateAdapter paymentAlternativeExchangeRate; 
	private List<InvoiceLineAdapter> invoiceLines = new ArrayList<>(); 
	private MonetaryTotalAdapter legalMonetaryTotal; 
	private List<OrderReferenceAdapter> orderReferences = new ArrayList<>(); 
	private PartyAdapter payeeParty; 
	private PartyAdapter taxRepresentativeParty; 
	private PaymentAdapter prepaidPayment; 
	private List<PaymentMeansAdapter> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>(); 
	private PeriodAdapter invoicePeriod; 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 
	private SupplierPartyAdapter sellerSupplierParty; 
	private SupplierPartyAdapter accountingSupplierParty; 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 

}
