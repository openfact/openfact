package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.CurrencyCodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document used to remind a customer of payments past due.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:15 a. m.
 */
public class ReminderEntity {

    /**
     * The buyer's accounting code, applied to the ReminderEntity as a whole,
     * expressed as text.
     */
    private TextType AccountingCost;
    /**
     * The buyer's accounting code, applied to the ReminderEntity as a whole.
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
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Reminder.
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
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType ProfileID;
    /**
     * The number of the current ReminderEntity in the sequence of reminders
     * relating to the specified payments; the number of reminders previously
     * sent plus one.
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
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private CustomerPartyEntity AccountingCustomerParty;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private ExchangeRateEntity PaymentAlternativeExchangeRate;
    private ExchangeRateEntity PricingExchangeRate;
    private ExchangeRateEntity TaxExchangeRate;
    private ExchangeRateEntity PaymentExchangeRate;
    private MonetaryTotalEntity LegalMonetaryTotal;
    private PartyEntity TaxRepresentativeParty;
    private PartyEntity PayeeParty;
    private PaymentEntity PrepaidPayment;
    private List<PaymentMeansEntity> PaymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity ReminderPeriod;
    private List<ReminderLineEntity> ReminderLines = new ArrayList<>();
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity AccountingSupplierParty;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();

}
