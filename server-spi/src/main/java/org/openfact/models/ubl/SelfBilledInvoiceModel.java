package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * An InvoiceModel document created by the Customer (rather than the Supplier)
 * in a Self Billing relationship.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:24 a. m.
 */
public class SelfBilledInvoiceModel {

    /**
     * An accounting cost code, applied to the InvoiceModel as a whole,
     * expressed as text.
     */
    private TextModel accountingCost;
    /**
     * An accounting cost code, applied to the InvoiceModel as a whole.
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
     * A code signifying the type of invoice.
     */
    private CodeModel invoiceTypeCode;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * The number of invoiceLines in this document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * A code signifying the alternative currency used for payment in the
     * Invoice.
     */
    private CurrencyCodeModel codeTypePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the Invoice.
     */
    private CurrencyCodeModel codeTypePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the Invoice.
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
     * A code signifying the currency used for tax amounts in the Invoice.
     */
    private CurrencyCodeModel codeTypeTaxCurrencyCode;
    /**
     * The date of the invoice for tax purposes, in accordance with the
     * applicable tax regulation.
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
    private List<BillingReferenceModel> billingReferences = new ArrayList<>();
    private CustomerPartyModel accountingCustomerParty;
    private CustomerPartyModel buyerCustomerParty;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceModel statementDocumentReference;
    private DocumentReferenceModel receiptDocumentReference;
    private DocumentReferenceModel despatchDocumentReference;
    private DocumentReferenceModel additionalDocumentReference;
    private DocumentReferenceModel contractDocumentReference;
    private DocumentReferenceModel originatorDocumentReference;
    private ExchangeRateModel taxExchangeRate;
    private ExchangeRateModel pricingExchangeRate;
    private ExchangeRateModel paymentExchangeRate;
    private ExchangeRateModel paymentAlternativeExchangeRate;
    private List<InvoiceLineModel> invoiceLines = new ArrayList<>();
    private MonetaryTotalModel legalMonetaryTotal;
    private List<OrderReferenceModel> orderReferences = new ArrayList<>();
    private PartyModel payeeParty;
    private PartyModel taxRepresentativeParty;
    private PaymentModel prepaidPayment;
    private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
    private PeriodModel invoicePeriod;
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;
    private SupplierPartyModel accountingSupplierParty;
    private List<TaxTotalModel> taxTotals = new ArrayList<>();

}
