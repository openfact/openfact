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
 * A document used to specify credits due to the Debtor from the Creditor.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:25 a. m.
 */
public class CreditNoteEntity {

    /**
     * The buyer's accounting code, applied to the CreditNoteEntity as a whole,
     * expressed as text.
     */
    private TextType AccountingCost;
    /**
     * The buyer's accounting code, applied to the CreditNoteEntity as a whole.
     */
    private CodeType AccountingCostCode;
    /**
     * A reference provided by the buyer used for internal routing of the
     * document.
     */
    private TextType BuyerReference;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * A code signifying the type of the CreditNote.
     */
    private CodeType CreditNoteTypeCode;
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
     * The number of CreditNoteLines in the document.
     */
    private NumericType LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * A code signifying the alternative currency used for payment in the
     * CreditNote.
     */
    private CurrencyCodeType CodeTypePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the CreditNote.
     */
    private CurrencyCodeType CodeTypePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the CreditNote.
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
     * A code signifying the currency used for tax amounts in the CreditNote.
     */
    private CurrencyCodeType CodeTypeTaxCurrencyCode;
    /**
     * The date of the CreditNote, used to indicate the point at which tax
     * becomes applicable.
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
    private List<BillingReferenceEntity> BillingReferences = new ArrayList<>();
    private List<CreditNoteLineEntity> CreditNoteLines = new ArrayList<>();
    private CustomerPartyEntity AccountingCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> DeliveriesTerms = new ArrayList<>();
    private DocumentReferenceEntity StatementDocumentReference;
    private DocumentReferenceEntity OriginatorDocumentReference;
    private DocumentReferenceEntity ContractDocumentReference;
    private DocumentReferenceEntity ReceiptDocumentReference;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private DocumentReferenceEntity DespatchDocumentReference;
    private ExchangeRateEntity PaymentAlternativeExchangeRate;
    private ExchangeRateEntity PaymentExchangeRate;
    private ExchangeRateEntity TaxExchangeRate;
    private ExchangeRateEntity PricingExchangeRate;
    private MonetaryTotalEntity LegalMonetaryTotal;
    private List<OrderReferenceEntity> OrderReferences = new ArrayList<>();
    private PartyEntity TaxRepresentativeParty;
    private PartyEntity PayeeParty;
    private List<PaymentMeansEntity> PaymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity InvoicePeriod;
    private ResponseEntity DiscrepancyResponse;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;
    private SupplierPartyEntity AccountingSupplierParty;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();

}
