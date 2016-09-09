package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A credit note created by the debtor in a self billing arrangement with a
 * creditor; SelfBilledCreditNoteModel replaces DebitNoteModel in such arrangements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:22 a. m.
 */
public class SelfBilledCreditNoteModel{

	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNoteModel as a whole,
	 * expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNoteModel as a whole.
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
	 * The number of SelfBilledCreditNoteModel Lines in this document.
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
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceModel> BillingReferences = new ArrayList<>();
	private List<CreditNoteLineModel> CreditNoteLines = new ArrayList<>();
	private CustomerPartyModel AccountingCustomerParty;
	private CustomerPartyModel BuyerCustomerParty;
	private List<DeliveryModel> Deliveries = new ArrayList<>();
	private List<DeliveryTermsModel> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceModel ContractDocumentReference;
	private DocumentReferenceModel OriginatorDocumentReference;
	private DocumentReferenceModel StatementDocumentReference;
	private DocumentReferenceModel DespatchDocumentReference;
	private DocumentReferenceModel ReceiptDocumentReference;
	private DocumentReferenceModel AdditionalDocumentReference;
	private ExchangeRateModel PricingExchangeRate;
	private ExchangeRateModel PaymentAlternativeExchangeRate;
	private ExchangeRateModel PaymentExchangeRate;
	private ExchangeRateModel TaxExchangeRate;
	private MonetaryTotalModel LegalMonetaryTotal;
	private List<OrderReferenceModel> OrderReferences = new ArrayList<>();
	private PartyModel TaxRepresentativeParty;
	private PartyModel PayeeParty;
	private List<PaymentMeansModel> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel InvoicePeriod;
	private ResponseModel DiscrepancyResponse;
	private List<SignatureModel> Signatures = new ArrayList<>();
	private SupplierPartyModel SellerSupplierParty;
	private SupplierPartyModel AccountingSupplierParty;
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();

}
