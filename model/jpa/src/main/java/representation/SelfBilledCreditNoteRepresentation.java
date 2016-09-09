package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A credit note created by the debtor in a self billing arrangement with a
 * creditor; SelfBilledCreditNoteRepresentation replaces DebitNoteRepresentation in such arrangements.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:22 a. m.
 */
public class SelfBilledCreditNoteRepresentation{

	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNoteRepresentation as a whole,
	 * expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the SelfBilledCreditNoteRepresentation as a whole.
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
	 * The number of SelfBilledCreditNoteRepresentation Lines in this document.
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
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<BillingReferenceRepresentation> BillingReferences = new ArrayList<>();
	private List<CreditNoteLineRepresentation> CreditNoteLines = new ArrayList<>();
	private CustomerPartyRepresentation AccountingCustomerParty;
	private CustomerPartyRepresentation BuyerCustomerParty;
	private List<DeliveryRepresentation> Deliveries = new ArrayList<>();
	private List<DeliveryTermsRepresentation> DeliveriesTerms = new ArrayList<>();
	private DocumentReferenceRepresentation ContractDocumentReference;
	private DocumentReferenceRepresentation OriginatorDocumentReference;
	private DocumentReferenceRepresentation StatementDocumentReference;
	private DocumentReferenceRepresentation DespatchDocumentReference;
	private DocumentReferenceRepresentation ReceiptDocumentReference;
	private DocumentReferenceRepresentation AdditionalDocumentReference;
	private ExchangeRateRepresentation PricingExchangeRate;
	private ExchangeRateRepresentation PaymentAlternativeExchangeRate;
	private ExchangeRateRepresentation PaymentExchangeRate;
	private ExchangeRateRepresentation TaxExchangeRate;
	private MonetaryTotalRepresentation LegalMonetaryTotal;
	private List<OrderReferenceRepresentation> OrderReferences = new ArrayList<>();
	private PartyRepresentation TaxRepresentativeParty;
	private PartyRepresentation PayeeParty;
	private List<PaymentMeansRepresentation> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsRepresentation> PaymentTermses = new ArrayList<>();
	private PeriodRepresentation InvoicePeriod;
	private ResponseRepresentation DiscrepancyResponse;
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private SupplierPartyRepresentation SellerSupplierParty;
	private SupplierPartyRepresentation AccountingSupplierParty;
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();

}
