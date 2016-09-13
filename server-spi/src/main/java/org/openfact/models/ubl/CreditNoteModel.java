package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to specify credits due to the Debtor from the Creditor.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:25 a. m.
 */
public class CreditNoteModel {

    /**
     * The buyer's accounting code, applied to the CreditNoteModel as a whole,
     * expressed as text.
     */
    private TextModel accountingCost;
    /**
     * The buyer's accounting code, applied to the CreditNoteModel as a whole.
     */
    private CodeModel accountingCostCode;
    /**
     * A reference provided by the buyer used for internal routing of the
     * document.
     */
    private TextModel buyerReference;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A code signifying the type of the CreditNote.
     */
    private CodeModel creditNoteTypeCode;
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
     * The number of creditNoteLines in the document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * A code signifying the alternative currency used for payment in the
     * CreditNote.
     */
    private CurrencyCodeModel codeTypePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the CreditNote.
     */
    private CurrencyCodeModel codeTypePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the CreditNote.
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
     * A code signifying the currency used for tax amounts in the CreditNote.
     */
    private CurrencyCodeModel codeTypeTaxCurrencyCode;
    /**
     * The date of the CreditNote, used to indicate the point at which tax
     * becomes applicable.
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
    private List<CreditNoteLineModel> creditNoteLines = new ArrayList<>();
    private CustomerPartyModel accountingCustomerParty;
    private CustomerPartyModel buyerCustomerParty;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceModel statementDocumentReference;
    private DocumentReferenceModel originatorDocumentReference;
    private DocumentReferenceModel contractDocumentReference;
    private DocumentReferenceModel receiptDocumentReference;
    private DocumentReferenceModel additionalDocumentReference;
    private DocumentReferenceModel despatchDocumentReference;
    private ExchangeRateModel paymentAlternativeExchangeRate;
    private ExchangeRateModel paymentExchangeRate;
    private ExchangeRateModel taxExchangeRate;
    private ExchangeRateModel pricingExchangeRate;
    private MonetaryTotalModel legalMonetaryTotal;
    private List<OrderReferenceModel> orderReferences = new ArrayList<>();
    private PartyModel taxRepresentativeParty;
    private PartyModel payeeParty;
    private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
    private PeriodModel invoicePeriod;
    private ResponseModel discrepancyResponse;
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;
    private SupplierPartyModel accountingSupplierParty;
    private List<TaxTotalModel> taxTotals = new ArrayList<>();

}
