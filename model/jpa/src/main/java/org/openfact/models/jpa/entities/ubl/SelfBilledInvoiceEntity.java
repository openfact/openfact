package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * An InvoiceEntity document created by the Customer (rather than the Supplier) in a
 * Self Billing relationship.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:24 a. m.
 */
public class SelfBilledInvoiceEntity{

	/**
	 * An accounting cost code, applied to the InvoiceEntity as a whole, expressed as text.
	 */
	private TextType accountingCost; 
	/**
	 * An accounting cost code, applied to the InvoiceEntity as a whole.
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
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>(); 
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>(); 
	private CustomerPartyEntity accountingCustomerParty; 
	private CustomerPartyEntity buyerCustomerParty; 
	private List<DeliveryEntity> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceEntity statementDocumentReference; 
	private DocumentReferenceEntity receiptDocumentReference; 
	private DocumentReferenceEntity despatchDocumentReference; 
	private DocumentReferenceEntity additionalDocumentReference; 
	private DocumentReferenceEntity contractDocumentReference; 
	private DocumentReferenceEntity originatorDocumentReference; 
	private ExchangeRateEntity taxExchangeRate; 
	private ExchangeRateEntity pricingExchangeRate; 
	private ExchangeRateEntity paymentExchangeRate; 
	private ExchangeRateEntity paymentAlternativeExchangeRate; 
	private List<InvoiceLineEntity> invoiceLines = new ArrayList<>(); 
	private MonetaryTotalEntity legalMonetaryTotal; 
	private List<OrderReferenceEntity> orderReferences = new ArrayList<>(); 
	private PartyEntity payeeParty; 
	private PartyEntity taxRepresentativeParty; 
	private PaymentEntity prepaidPayment; 
	private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsEntity> paymentTermses = new ArrayList<>(); 
	private PeriodEntity invoicePeriod; 
	private List<SignatureEntity> signatures = new ArrayList<>(); 
	private SupplierPartyEntity sellerSupplierParty; 
	private SupplierPartyEntity accountingSupplierParty; 
	private List<TaxTotalEntity> taxTotals = new ArrayList<>(); 

}
