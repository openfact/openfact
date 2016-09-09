package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A document used to remind a customer of payments past due.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:15 a. m.
 */
public class Reminder{

	/**
	 * The buyer's accounting code, applied to the Reminder as a whole, expressed as
	 * text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting code, applied to the Reminder as a whole.
	 */
	private CodeType AccountingCostCode;
	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
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
	private LocalDate IssueDate;
	/**
	 * The time, assigned by the sender, at which this document was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * The number of ReminderLines in this document.
	 */
	private BigDecimal LineCountNumeric;
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
	 * The number of the current Reminder in the sequence of reminders relating to the
	 * specified payments; the number of reminders previously sent plus one.
	 */
	private BigDecimal ReminderSequenceNumeric;
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
	private LocalDate TaxPointDate;
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
	private CustomerParty AccountingCustomerParty;
	private DocumentReference AdditionalDocumentReference;
	private ExchangeRate PaymentAlternativeExchangeRate;
	private ExchangeRate PricingExchangeRate;
	private ExchangeRate TaxExchangeRate;
	private ExchangeRate PaymentExchangeRate;
	private MonetaryTotal LegalMonetaryTotal;
	private Party TaxRepresentativeParty;
	private Party PayeeParty;
	private Payment PrepaidPayment;
	private List<PaymentMeans> PaymentMeanses = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period ReminderPeriod;
	private List<ReminderLine> ReminderLines = new ArrayList<>();
	private List<Signature> Signatures = new ArrayList<>();
	private SupplierParty AccountingSupplierParty;
	private List<TaxTotal> TaxTotals = new ArrayList<>();

}
