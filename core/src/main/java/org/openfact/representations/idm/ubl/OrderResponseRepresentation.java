package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.CurrencyCodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.MeasureType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A document used to indicate detailed acceptance or rejection of an
 * OrderRepresentation or to make a counter-offer.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:59 a. m.
 */
public class OrderResponseRepresentation {

    /**
     * An accounting cost code applied to the order as a whole, expressed as
     * text.
     */
    private TextType accountingCost;
    /**
     * An accounting cost code applied to the order as a whole.
     */
    private CodeType accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A supplementary reference assigned by the buyer, e.g., the CRI in a
     * purchasing card transaction.
     */
    private TextType customerReference;
    /**
     * Identifies a user-defined customization of UBL.
     */
    private IdentifierType customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeType codeTypeDocumentCurrencyCode;
    /**
     * The total volume of the goods in the OrderResponseRepresentation
     * including packaging.
     */
    private MeasureType grossVolumeMeasure;
    /**
     * The total gross weight for the OrderResponseRepresentation (goods +
     * packaging + transport equipment).
     */
    private MeasureType grossWeightMeasure;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * The number of orderLines in this document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * The total net weight of the goods in the OrderResponseRepresentation
     * excluding packaging.
     */
    private MeasureType netNetWeightMeasure;
    /**
     * The total volume of the goods in the OrderResponseRepresentation
     * excluding packaging.
     */
    private MeasureType netVolumeMeasure;
    /**
     * The total net weight for the OrderResponseRepresentation (goods +
     * packaging).
     */
    private MeasureType netWeightMeasure;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType note;
    /**
     * A code signifying the type of response for this Order.
     */
    private CodeType orderResponseCode;
    /**
     * A code signifying the currency that is used for all prices in the Order
     * Response.
     */
    private CurrencyCodeType codeTypePricingCurrencyCode;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType profileID;
    /**
     * An identifier for the Order, issued by the Seller.
     */
    private IdentifierType salesOrderID;
    /**
     * A code signifying the currency that is used for all tax amounts in the
     * Order Response.
     */
    private CurrencyCodeType codeTypeTaxCurrencyCode;
    /**
     * The total number of packages contained in the OrderResponse.
     */
    private QuantityType totalPackagesQuantity;
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
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private List<ContractRepresentation> contracts = new ArrayList<>();
    private CountryRepresentation destinationCountry;
    private CustomerPartyRepresentation originatorCustomerParty;
    private CustomerPartyRepresentation accountingCustomerParty;
    private CustomerPartyRepresentation buyerCustomerParty;
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<DeliveryTermsRepresentation> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceRepresentation additionalDocumentReference;
    private DocumentReferenceRepresentation originatorDocumentReference;
    private DocumentReferenceRepresentation orderDocumentReference;
    private ExchangeRateRepresentation taxExchangeRate;
    private ExchangeRateRepresentation pricingExchangeRate;
    private ExchangeRateRepresentation paymentExchangeRate;
    private MonetaryTotalRepresentation legalMonetaryTotal;
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
