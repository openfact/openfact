package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.CurrencyCodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.MeasureType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A document used to indicate detailed acceptance or rejection of an
 * OrderEntity or to make a counter-offer.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:59 a. m.
 */
public class OrderResponseEntity {

    /**
     * An accounting cost code applied to the order as a whole, expressed as
     * text.
     */
    private TextType AccountingCost;
    /**
     * An accounting cost code applied to the order as a whole.
     */
    private CodeType AccountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType CopyIndicator;
    /**
     * A supplementary reference assigned by the buyer, e.g., the CRI in a
     * purchasing card transaction.
     */
    private TextType CustomerReference;
    /**
     * Identifies a user-defined customization of UBL.
     */
    private IdentifierType CustomizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeType CodeTypeDocumentCurrencyCode;
    /**
     * The total volume of the goods in the OrderResponseEntity including
     * packaging.
     */
    private MeasureType GrossVolumeMeasure;
    /**
     * The total gross weight for the OrderResponseEntity (goods + packaging +
     * transport equipment).
     */
    private MeasureType GrossWeightMeasure;
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
     * The number of OrderLines in this document.
     */
    private NumericType LineCountNumeric;
    /**
     * The total net weight of the goods in the OrderResponseEntity excluding
     * packaging.
     */
    private MeasureType NetNetWeightMeasure;
    /**
     * The total volume of the goods in the OrderResponseEntity excluding
     * packaging.
     */
    private MeasureType NetVolumeMeasure;
    /**
     * The total net weight for the OrderResponseEntity (goods + packaging).
     */
    private MeasureType NetWeightMeasure;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType Note;
    /**
     * A code signifying the type of response for this Order.
     */
    private CodeType OrderResponseCode;
    /**
     * A code signifying the currency that is used for all prices in the Order
     * Response.
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
     * An identifier for the Order, issued by the Seller.
     */
    private IdentifierType SalesOrderID;
    /**
     * A code signifying the currency that is used for all tax amounts in the
     * Order Response.
     */
    private CurrencyCodeType CodeTypeTaxCurrencyCode;
    /**
     * The total number of packages contained in the OrderResponse.
     */
    private QuantityType TotalPackagesQuantity;
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
    private List<ContractEntity> Contracts = new ArrayList<>();
    private CountryEntity DestinationCountry;
    private CustomerPartyEntity OriginatorCustomerParty;
    private CustomerPartyEntity AccountingCustomerParty;
    private CustomerPartyEntity BuyerCustomerParty;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> DeliveriesTerms = new ArrayList<>();
    private DocumentReferenceEntity AdditionalDocumentReference;
    private DocumentReferenceEntity OriginatorDocumentReference;
    private DocumentReferenceEntity OrderDocumentReference;
    private ExchangeRateEntity TaxExchangeRate;
    private ExchangeRateEntity PricingExchangeRate;
    private ExchangeRateEntity PaymentExchangeRate;
    private MonetaryTotalEntity LegalMonetaryTotal;
    private List<OrderLineEntity> OrderLines = new ArrayList<>();
    private List<OrderReferenceEntity> OrderReferences = new ArrayList<>();
    private PartyEntity FreightForwarderParty;
    private List<PaymentMeansEntity> PaymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity ValidityPeriod;
    private List<SignatureEntity> Signatures = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;
    private SupplierPartyEntity AccountingSupplierParty;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();
    private List<TransactionConditionsEntity> TransactionConditionses = new ArrayList<>();

}
