package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to specify changes to an existing Order.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:57 a. m.
 */
public class OrderChangeModel {

    /**
     * The buyer's accounting code, applied to the OrderChangeModel as a whole,
     * expressed as text.
     */
    private TextModel accountingCost;
    /**
     * The buyer's accounting code, applied to the OrderChangeModel as a whole.
     */
    private CodeModel accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A supplementary reference for the transaction (e.g., CRI when using
     * purchasing card).
     */
    private TextModel customerReference;
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
     * The number of OrderChangeModel lines in the document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * A code signifying the currency that is used for all prices in the
     * OrderChange.
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
     * A code signifying he currency requested for amount totals in Invoices
     * related to this OrderChange.
     */
    private CurrencyCodeModel codeTypeRequestedInvoiceCurrencyCode;
    /**
     * An identifier for the OrderChange, assigned by the seller.
     */
    private IdentifierModel salesOrderID;
    /**
     * The OrderChangeModel Sequence Number assigned by the Buyer to ensure the
     * proper sequencing of changes.
     */
    private IdentifierModel sequenceNumberID;
    /**
     * A code signifying the currency requested for tax amounts in Invoices
     * related to this OrderChange.
     */
    private CurrencyCodeModel codeTypeTaxCurrencyCode;
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
    private List<ContractModel> contracts = new ArrayList<>();
    private CountryModel destinationCountry;
    private CustomerPartyModel accountingCustomerParty;
    private CustomerPartyModel originatorCustomerParty;
    private CustomerPartyModel buyerCustomerParty;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceModel additionalDocumentReference;
    private DocumentReferenceModel originatorDocumentReference;
    private DocumentReferenceModel quotationDocumentReference;
    private ExchangeRateModel pricingExchangeRate;
    private ExchangeRateModel paymentExchangeRate;
    private ExchangeRateModel taxExchangeRate;
    private MonetaryTotalModel anticipatedMonetaryTotal;
    private List<OrderLineModel> orderLines = new ArrayList<>();
    private List<OrderReferenceModel> orderReferences = new ArrayList<>();
    private PartyModel freightForwarderParty;
    private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
    private PeriodModel validityPeriod;
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;
    private SupplierPartyModel accountingSupplierParty;
    private List<TaxTotalModel> taxTotals = new ArrayList<>();
    private List<TransactionConditionsModel> transactionConditionses = new ArrayList<>();

}
