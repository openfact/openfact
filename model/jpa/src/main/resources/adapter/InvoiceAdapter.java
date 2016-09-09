package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to request payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */
public class InvoiceAdapter{

	/**
	 * The buyer's accounting code, applied to the InvoiceAdapter as a whole, expressed as
	 * text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting code, applied to the InvoiceAdapter as a whole.
	 */
	private CodeType accountingCostCode; 
	/**
	 * A reference provided by the buyer used for internal routing of the document.
	 */
	private TextType buyerReference; 
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
	 * The date on which InvoiceAdapter is due.
	 */
	private DateType dueDate; 
	/**
	 * An identifier for this document, assigned by the sender.
	 */
	private IdentifierType ID; 
	/**
	 * A code signifying the type of the Invoice.
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
	 * The number of lines in the document.
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
	 * The date of the Invoice, used to indicate the point at which tax becomes
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
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<BillingReferenceAdapter> billingReferences = new ArrayList<>(); 
	private CustomerPartyAdapter accountingCustomerParty; 
	private CustomerPartyAdapter buyerCustomerParty; 
	private List<DeliveryAdapter> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsAdapter> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceAdapter statementDocumentReference; 
	private DocumentReferenceAdapter receiptDocumentReference; 
	private DocumentReferenceAdapter despatchDocumentReference; 
	private DocumentReferenceAdapter originatorDocumentReference; 
	private DocumentReferenceAdapter contractDocumentReference; 
	private DocumentReferenceAdapter additionalDocumentReference; 
	private ExchangeRateAdapter taxExchangeRate; 
	private ExchangeRateAdapter pricingExchangeRate; 
	private ExchangeRateAdapter paymentExchangeRate; 
	private ExchangeRateAdapter paymentAlternativeExchangeRate; 
	private List<InvoiceLineAdapter> invoiceLines = new ArrayList<>(); 
	private MonetaryTotalAdapter legalMonetaryTotal; 
	private List<OrderReferenceAdapter> orderReferences = new ArrayList<>(); 
	private PartyAdapter taxRepresentativeParty; 
	private PartyAdapter payeeParty; 
	private PaymentAdapter prepaidPayment; 
	private List<PaymentMeansAdapter> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>(); 
	private PeriodAdapter invoicePeriod; 
	private List<ProjectReferenceAdapter> projectReferences = new ArrayList<>(); 
	private List<SignatureAdapter> signatures = new ArrayList<>(); 
	private SupplierPartyAdapter accountingSupplierParty; 
	private SupplierPartyAdapter sellerSupplierParty; 
	private List<TaxTotalAdapter> withholdingTaxTotal = new ArrayList<>(); 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 

}
