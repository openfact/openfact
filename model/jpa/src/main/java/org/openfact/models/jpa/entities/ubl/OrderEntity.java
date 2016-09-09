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
 * A document used to order goods and services.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:53 a. m.
 */
public class OrderEntity {

    /**
     * The buyer's accounting cost centre, applied to the OrderEntity as a
     * whole, expressed as text.
     */
    private TextType AccountingCost;
    /**
     * The buyer's accounting code, applied to the OrderEntity as a whole.
     */
    private CodeType AccountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * A supplementary reference for the Order.
     */
    private TextType CustomerReference;
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
     * The number of OrderLines in the document.
     */
    private NumericType LineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * A code signifying the type of Order.
     */
    private CodeType OrderTypeCode;
    /**
     * A code signifying the currency used for all prices in the Order.
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
     * A code signifying the currency requested for amount totals in Invoices
     * related to this Order.
     */
    private CurrencyCodeType CodeTypeRequestedInvoiceCurrencyCode;
    /**
     * An identifier for the Order, assigned by the seller.
     */
    private IdentifierType SalesOrderID;
    /**
     * A code signifying the currency requested for tax amounts in Invoices
     * related to this Order.
     */
    private CurrencyCodeType CodeTypeTaxCurrencyCode;
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
    private List<CatalogueReferenceEntity> CatalogueReferences = new ArrayList<>();
    private List<ContractEntity> Contracts = new ArrayList<>();
    private CountryEntity DestinationCountry;
    private CustomerPartyEntity OriginatorCustomerParty;
    private CustomerPartyEntity AccountingCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> DeliveriesTerms = new ArrayList<>();
    private DocumentReferenceEntity OrderDocumentReference;
    private DocumentReferenceEntity AdditionalDocumentReference;
    private DocumentReferenceEntity OriginatorDocumentReference;
    private DocumentReferenceEntity QuotationDocumentReference;
    private ExchangeRateEntity PaymentExchangeRate;
    private ExchangeRateEntity PricingExchangeRate;
    private ExchangeRateEntity TaxExchangeRate;
    private MonetaryTotalEntity AnticipatedMonetaryTotal;
    private List<OrderLineEntity> OrderLines = new ArrayList<>();
    private PartyEntity FreightForwarderParty;
    private List<PaymentMeansEntity> PaymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity ValidityPeriod;
    private List<ProjectReferenceEntity> ProjectReferences = new ArrayList<>();
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();
    private List<TransactionConditionsEntity> TransactionConditionses = new ArrayList<>();

}
