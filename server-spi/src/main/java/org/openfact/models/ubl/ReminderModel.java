package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to remind a customer of payments past due.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:15 a. m.
 */
public class ReminderModel {

    /**
     * The buyer's accounting code, applied to the ReminderModel as a whole,
     * expressed as text.
     */
    private TextModel accountingCost;
    /**
     * The buyer's accounting code, applied to the ReminderModel as a whole.
     */
    private CodeModel accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierModel customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeModel codeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierModel ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * The number of reminderLines in this document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Reminder.
     */
    private CurrencyCodeModel codeTypePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the Reminder.
     */
    private CurrencyCodeModel codeTypePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the Reminder.
     */
    private CurrencyCodeModel codeTypePricingCurrencyCode;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierModel profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierModel profileID;
    /**
     * The number of the current ReminderModel in the sequence of reminders
     * relating to the specified payments; the number of reminders previously
     * sent plus one.
     */
    private BigDecimal reminderSequenceNumeric;
    /**
     * A code signifying the type of the Reminder.
     */
    private CodeModel reminderTypeCode;
    /**
     * A code signifying the currency used for tax amounts in the Reminder.
     */
    private CurrencyCodeModel codeTypeTaxCurrencyCode;
    /**
     * The date of the Reminder, used to indicate the point at which tax becomes
     * applicable.
     */
    private LocalDate taxPointDate;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierModel UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierModel UUID;
    private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>();
    private CustomerPartyModel accountingCustomerParty;
    private DocumentReferenceModel additionalDocumentReference;
    private ExchangeRateModel paymentAlternativeExchangeRate;
    private ExchangeRateModel pricingExchangeRate;
    private ExchangeRateModel taxExchangeRate;
    private ExchangeRateModel paymentExchangeRate;
    private MonetaryTotalModel legalMonetaryTotal;
    private PartyModel taxRepresentativeParty;
    private PartyModel payeeParty;
    private PaymentModel prepaidPayment;
    private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
    private PeriodModel reminderPeriod;
    private List<ReminderLineModel> reminderLines = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel accountingSupplierParty;
    private List<TaxTotalModel> taxTotals = new ArrayList<>();

}
