package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A credit note created by the debtor in a self billing arrangement with a
 * creditor; SelfBilledCreditNote replaces DebitNote in such arrangements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:22 a. m.
 */
public class SelfBilledCreditNote{

	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNote as a whole,
	 * expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNote as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private IndicatorType CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private IdentifierType CustomizationID;
	/**
	 * A code signifying the default currency for this document.
	 */
	private CurrencyCodeType CodeTypeDocumentCurrencyCode;
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
	 * The number of SelfBilledCreditNote Lines in this document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the alternative currency used for payment in the Self Billed
	 * CreditNote.
	 */
	private CurrencyCodeType CodeTypePaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the SelfBilledCreditNote.
	 */
	private CurrencyCodeType CodeTypePaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the SelfBilledCreditNote.
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
	 * A code signifying the currency used for tax amounts in the Self Billed Credit
	 * Note.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
	/**
	 * The date of the SelfBilledCreditNote, used to indicate the point at which
	 * tax becomes applicable.
	 */
	private DateType TaxPointDate;
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
	private List<BillingReference> BillingReferences = new ArrayList<>();
	private List<CreditNoteLine> CreditNoteLines = new ArrayList<>();
	private CustomerParty AccountingCustomerParty;
	private CustomerParty BuyerCustomerParty;
	private List<Delivery> Deliveries = new ArrayList<>();
	private List<DeliveryTerms> DeliveriesTerms = new ArrayList<>();
	private DocumentReference ContractDocumentReference;
	private DocumentReference OriginatorDocumentReference;
	private DocumentReference StatementDocumentReference;
	private DocumentReference DespatchDocumentReference;
	private DocumentReference ReceiptDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private ExchangeRate PricingExchangeRate;
	private ExchangeRate PaymentAlternativeExchangeRate;
	private ExchangeRate PaymentExchangeRate;
	private ExchangeRate TaxExchangeRate;
	private MonetaryTotal LegalMonetaryTotal;
	private List<OrderReference> OrderReferences = new ArrayList<>();
	private Party TaxRepresentativeParty;
	private Party PayeeParty;
	private List<PaymentMeans> PaymentMeanses = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period InvoicePeriod;
	private Response DiscrepancyResponse;
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty SellerSupplierParty;
	private SupplierParty AccountingSupplierParty;
	private List<TaxTotal> TaxTotals = new ArrayList<>();

}
