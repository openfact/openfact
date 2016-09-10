package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to request payment.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */
public class InvoiceModel{

	/**
	 * The buyer's accounting code, applied to the InvoiceModel as a whole, expressed as
	 * text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting code, applied to the InvoiceModel as a whole.
	 */
	private CodeType accountingCostCode; 
	/**
	 * A reference provided by the buyer used for internal routing of the document.
	 */
	private TextType buyerReference; 
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean copyIndicator; 
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType customizationID; 
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType codeTypeDocumentCurrencyCode; 
	/**
	 * The date on which InvoiceModel is due.
	 */
	private LocalDate dueDate; 
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
	private LocalDate issueDate; 
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime issueTime; 
	/**
	 * The number of lines in the document.
	 */
	private BigDecimal lineCountNumeric; 
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
	private LocalDate taxPointDate; 
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
	private List<DeliveryModel> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>(); 
	private DocumentReferenceModel statementDocumentReference; 
	private DocumentReferenceModel receiptDocumentReference; 
	private DocumentReferenceModel despatchDocumentReference; 
	private DocumentReferenceModel originatorDocumentReference; 
	private DocumentReferenceModel contractDocumentReference; 
	private DocumentReferenceModel additionalDocumentReference; 
	private ExchangeRateModel taxExchangeRate; 
	private ExchangeRateModel pricingExchangeRate; 
	private ExchangeRateModel paymentExchangeRate; 
	private ExchangeRateModel paymentAlternativeExchangeRate; 
	private List<InvoiceLineModel> invoiceLines = new ArrayList<>(); 
	private MonetaryTotalModel legalMonetaryTotal; 
	private List<OrderReferenceModel> orderReferences = new ArrayList<>(); 
	private PartyModel taxRepresentativeParty; 
	private PartyModel payeeParty; 
	private PaymentModel prepaidPayment; 
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>(); 
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>(); 
	private PeriodModel invoicePeriod; 
	private List<ProjectReferenceModel> projectReferences = new ArrayList<>(); 
	private List<SignatureModel> signatures = new ArrayList<>(); 
	private SupplierPartyModel accountingSupplierParty; 
	private SupplierPartyModel sellerSupplierParty; 
	private List<TaxTotalModel> withholdingTaxTotal = new ArrayList<>(); 
	private List<TaxTotalModel> taxTotals = new ArrayList<>(); 

}
