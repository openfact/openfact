package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A document used to order goods and services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:53 a. m.
 */
public class OrderModel {

    /**
     * The buyer's accounting cost centre, applied to the OrderModel as a whole,
     * expressed as text.
     */
    private TextModel accountingCost;
    /**
     * The buyer's accounting code, applied to the OrderModel as a whole.
     */
    private CodeModel accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A supplementary reference for the Order.
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
     * The number of orderLines in the document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextModel note;
    /**
     * A code signifying the type of Order.
     */
    private CodeModel orderTypeCode;
    /**
     * A code signifying the currency used for all prices in the Order.
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
     * A code signifying the currency requested for amount totals in Invoices
     * related to this Order.
     */
    private CurrencyCodeModel codeTypeRequestedInvoiceCurrencyCode;
    /**
     * An identifier for the Order, assigned by the seller.
     */
    private IdentifierModel salesOrderID;
    /**
     * A code signifying the currency requested for tax amounts in Invoices
     * related to this Order.
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
    private List<CatalogueReferenceModel> catalogueReferences = new ArrayList<>();
    private List<ContractModel> contracts = new ArrayList<>();
    private CountryModel destinationCountry;
    private CustomerPartyModel originatorCustomerParty;
    private CustomerPartyModel accountingCustomerParty;
    private CustomerPartyModel buyerCustomerParty;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceModel orderDocumentReference;
    private DocumentReferenceModel additionalDocumentReference;
    private DocumentReferenceModel originatorDocumentReference;
    private DocumentReferenceModel quotationDocumentReference;
    private ExchangeRateModel paymentExchangeRate;
    private ExchangeRateModel pricingExchangeRate;
    private ExchangeRateModel taxExchangeRate;
    private MonetaryTotalModel anticipatedMonetaryTotal;
    private List<OrderLineModel> orderLines = new ArrayList<>();
    private PartyModel freightForwarderParty;
    private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
    private PeriodModel validityPeriod;
    private List<ProjectReferenceModel> projectReferences = new ArrayList<>();
    private List<SignatureModel> signatures = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;
    private List<TaxTotalModel> taxTotals = new ArrayList<>();
    private List<TransactionConditionsModel> transactionConditionses = new ArrayList<>();

}
