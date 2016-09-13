package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.CurrencyCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document used to specify credits due to the Debtor from the Creditor.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:25 a. m.
 */
public class CreditNoteRepresentation {

    /**
     * The buyer's accounting code, applied to the CreditNoteRepresentation as a
     * whole, expressed as text.
     */
    private TextRepresentation accountingCost;
    /**
     * The buyer's accounting code, applied to the CreditNoteRepresentation as a
     * whole.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * A reference provided by the buyer used for internal routing of the
     * document.
     */
    private TextRepresentation buyerReference;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A code signifying the type of the CreditNote.
     */
    private CodeRepresentation creditNoteTypeCode;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeRepresentation codeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierRepresentation ID;
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
    private TextRepresentation note;
    /**
     * A code signifying the alternative currency used for payment in the
     * CreditNote.
     */
    private CurrencyCodeRepresentation codeTypePaymentAlternativeCurrencyCode;
    /**
     * A code signifying the currency used for payment in the CreditNote.
     */
    private CurrencyCodeRepresentation codeTypePaymentCurrencyCode;
    /**
     * A code signifying the currency used for prices in the CreditNote.
     */
    private CurrencyCodeRepresentation codeTypePricingCurrencyCode;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * A code signifying the currency used for tax amounts in the CreditNote.
     */
    private CurrencyCodeRepresentation codeTypeTaxCurrencyCode;
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
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
    private List<CreditNoteLineRepresentation> creditNoteLines = new ArrayList<>();
    private CustomerPartyRepresentation accountingCustomerParty;
    private CustomerPartyRepresentation buyerCustomerParty;
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceRepresentation statementDocumentReference;
    private DocumentReferenceRepresentation originatorDocumentReference;
    private DocumentReferenceRepresentation contractDocumentReference;
    private DocumentReferenceRepresentation receiptDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private DocumentReferenceRepresentation despatchDocumentReference;
    private ExchangeRateRepresentation paymentAlternativeExchangeRate;
    private ExchangeRateRepresentation paymentExchangeRate;
    private ExchangeRateRepresentation taxExchangeRate;
    private ExchangeRateRepresentation pricingExchangeRate;
    private MonetaryTotalRepresentation legalMonetaryTotal;
    private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>();
    private PartyRepresentation taxRepresentativeParty;
    private PartyRepresentation payeeParty;
    private List<PaymentMeansRepresentation> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>();
    private PeriodRepresentation invoicePeriod;
    private ResponseRepresentation discrepancyResponse;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private SupplierPartyRepresentation sellerSupplierParty;
    private SupplierPartyRepresentation accountingSupplierParty;
    private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();

}
