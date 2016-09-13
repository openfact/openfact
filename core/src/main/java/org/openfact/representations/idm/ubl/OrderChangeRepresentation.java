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
 * A document used to specify changes to an existing Order.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:57 a. m.
 */
public class OrderChangeRepresentation {

    /**
     * The buyer's accounting code, applied to the OrderChangeRepresentation as
     * a whole, expressed as text.
     */
    private TextRepresentation accountingCost;
    /**
     * The buyer's accounting code, applied to the OrderChangeRepresentation as
     * a whole.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A supplementary reference for the transaction (e.g., CRI when using
     * purchasing card).
     */
    private TextRepresentation customerReference;
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
     * The number of OrderChangeRepresentation lines in the document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextRepresentation note;
    /**
     * A code signifying the currency that is used for all prices in the
     * OrderChange.
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
     * A code signifying he currency requested for amount totals in Invoices
     * related to this OrderChange.
     */
    private CurrencyCodeRepresentation codeTypeRequestedInvoiceCurrencyCode;
    /**
     * An identifier for the OrderChange, assigned by the seller.
     */
    private IdentifierRepresentation salesOrderID;
    /**
     * The OrderChangeRepresentation Sequence Number assigned by the Buyer to
     * ensure the proper sequencing of changes.
     */
    private IdentifierRepresentation sequenceNumberID;
    /**
     * A code signifying the currency requested for tax amounts in Invoices
     * related to this OrderChange.
     */
    private CurrencyCodeRepresentation codeTypeTaxCurrencyCode;
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
    private List<ContractRepresentation> contracts = new ArrayList<>();
    private CountryRepresentation destinationCountry;
    private CustomerPartyRepresentation accountingCustomerParty;
    private CustomerPartyRepresentation originatorCustomerParty;
    private CustomerPartyRepresentation buyerCustomerParty;
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceRepresentation additionalDocumentReference;
    private DocumentReferenceRepresentation originatorDocumentReference;
    private DocumentReferenceRepresentation quotationDocumentReference;
    private ExchangeRateRepresentation pricingExchangeRate;
    private ExchangeRateRepresentation paymentExchangeRate;
    private ExchangeRateRepresentation taxExchangeRate;
    private MonetaryTotalRepresentation anticipatedMonetaryTotal;
    private List<OrderLineRepresentation> orderLines = new ArrayList<>();
    private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>();
    private PartyRepresentation freightForwarderParty;
    private List<PaymentMeansRepresentation> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>();
    private PeriodRepresentation validityPeriod;
    private List<SignatureRepresentation> signatures = new ArrayList<>();
    private SupplierPartyRepresentation sellerSupplierParty;
    private SupplierPartyRepresentation accountingSupplierParty;
    private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();
    private List<TransactionConditionsRepresentation> transactionConditionses = new ArrayList<>();

}
