package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to remind a customer of payments past due.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:15 a. m.
 */
public class ReminderRepresentation{

	/**
	 * The buyer's accounting code, applied to the ReminderRepresentation as a whole, expressed as
	 * text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the ReminderRepresentation as a whole.
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
	 * The number of ReminderLines in this document.
	 */
	private NumericType LineCountNumeric;
	/**
	 * Free-form text pertinent to this document, conveying information that is not
	 * contained explicitly in other structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the alternative currency used for payment in the Reminder.
	 */
	private CurrencyCodeType CodeTypePaymentAlternativeCurrencyCode;
	/**
	 * A code signifying the currency used for payment in the Reminder.
	 */
	private CurrencyCodeType CodeTypePaymentCurrencyCode;
	/**
	 * A code signifying the currency used for prices in the Reminder.
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
	 * The number of the current ReminderRepresentation in the sequence of reminders relating to the
	 * specified payments; the number of reminders previously sent plus one.
	 */
	private NumericType ReminderSequenceNumeric;
	/**
	 * A code signifying the type of the Reminder.
	 */
	private CodeType ReminderTypeCode;
	/**
	 * A code signifying the currency used for tax amounts in the Reminder.
	 */
	private CurrencyCodeType CodeTypeTaxCurrencyCode;
	/**
	 * The date of the Reminder, used to indicate the point at which tax becomes
	 * applicable.
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
	private CustomerPartyRepresentation AccountingCustomerParty;
	private DocumentReferenceRepresentation AdditionalDocumentReference;
	private ExchangeRateRepresentation PaymentAlternativeExchangeRate;
	private ExchangeRateRepresentation PricingExchangeRate;
	private ExchangeRateRepresentation TaxExchangeRate;
	private ExchangeRateRepresentation PaymentExchangeRate;
	private MonetaryTotalRepresentation LegalMonetaryTotal;
	private PartyRepresentation TaxRepresentativeParty;
	private PartyRepresentation PayeeParty;
	private PaymentRepresentation PrepaidPayment;
	private List<PaymentMeansRepresentation> PaymentMeanses = new ArrayList<>();
	private List<PaymentTermsRepresentation> PaymentTermses = new ArrayList<>();
	private PeriodRepresentation ReminderPeriod;
	private List<ReminderLineRepresentation> ReminderLines = new ArrayList<>();
	private List<SignatureRepresentation> Signatures = new ArrayList<>();
	private SupplierPartyRepresentation AccountingSupplierParty;
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();

}
