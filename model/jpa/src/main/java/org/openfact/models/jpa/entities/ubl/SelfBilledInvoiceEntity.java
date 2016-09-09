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
 * An InvoiceEntity document created by the Customer (rather than the Supplier)
 * in a Self Billing relationship.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:24 a. m.
 */
public class SelfBilledInvoiceEntity {

    /**
     * An accounting cost code, applied to the InvoiceEntity as a whole,
     * expressed as text.
     */
    private TextType AccountingCost;
    /**
     * An accounting cost code, applied to the InvoiceEntity as a whole.
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
     * A code signifying the type of invoice.
     */
    private CodeType InvoiceTypeCode;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private DateType IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private TimeType IssueTime;
    /**
     * The number of InvoiceLines in this document.
     */
    private NumericType LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Invoice.
     */
    private CurrencyCodeType CodeTypePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the Invoice.
     */
    private CurrencyCodeType CodeTypePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the Invoice.
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
     * A code signifying the currency used for tax amounts in the Invoice.
     */
    private CurrencyCodeType CodeTypeTaxCurrencyCode;
    /**
     * The date of the invoice for tax purposes, in accordance with the
     * applicable tax regulation.
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
    private CustomerPartyEntity AccountingCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> DeliveriesTerms = new ArrayList<>();
    private DocumentReferenceEntity StatementDocumentReference;
    private DocumentReferenceEntity ReceiptDocumentReference;
    private DocumentReferenceEntity DespatchDocumentReference;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private DocumentReferenceEntity ContractDocumentReference;
    private DocumentReferenceEntity OriginatorDocumentReference;
    private ExchangeRateEntity TaxExchangeRate;
    private ExchangeRateEntity PricingExchangeRate;
    private ExchangeRateEntity PaymentExchangeRate;
    private ExchangeRateEntity PaymentAlternativeExchangeRate;
    private List<InvoiceLineEntity> InvoiceLines = new ArrayList<>();
    private MonetaryTotalEntity LegalMonetaryTotal;
    private List<OrderReferenceEntity> OrderReferences = new ArrayList<>();
    private PartyEntity PayeeParty;
    private PartyEntity TaxRepresentativeParty;
    private PaymentEntity PrepaidPayment;
    private List<PaymentMeansEntity> PaymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity InvoicePeriod;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;
    private SupplierPartyEntity AccountingSupplierParty;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();

}
