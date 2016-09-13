package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.CurrencyCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private TextRepresentation accountingCost;
    /**
     * An accounting cost code applied to the order as a whole.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * A supplementary reference assigned by the buyer, e.g., the CRI in a
     * purchasing card transaction.
     */
    private TextRepresentation customerReference;
    /**
     * Identifies a user-defined customization of UBL.
     */
    private IdentifierRepresentation customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeRepresentation codeTypeDocumentCurrencyCode;
    /**
     * The total volume of the goods in the OrderResponseRepresentation
     * including packaging.
     */
    private MeasureRepresentation grossVolumeMeasure;
    /**
     * The total gross weight for the OrderResponseRepresentation (goods +
     * packaging + transport equipment).
     */
    private MeasureRepresentation grossWeightMeasure;
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
     * The number of orderLines in this document.
     */
    private BigDecimal lineCountNumeric;
    /**
     * The total net weight of the goods in the OrderResponseRepresentation
     * excluding packaging.
     */
    private MeasureRepresentation netNetWeightMeasure;
    /**
     * The total volume of the goods in the OrderResponseRepresentation
     * excluding packaging.
     */
    private MeasureRepresentation netVolumeMeasure;
    /**
     * The total net weight for the OrderResponseRepresentation (goods +
     * packaging).
     */
    private MeasureRepresentation netWeightMeasure;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextRepresentation note;
    /**
     * A code signifying the type of response for this Order.
     */
    private CodeRepresentation orderResponseCode;
    /**
     * A code signifying the currency that is used for all prices in the Order
     * Response.
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
     * An identifier for the Order, issued by the Seller.
     */
    private IdentifierRepresentation salesOrderID;
    /**
     * A code signifying the currency that is used for all tax amounts in the
     * Order Response.
     */
    private CurrencyCodeRepresentation codeTypeTaxCurrencyCode;
    /**
     * The total number of packages contained in the OrderResponse.
     */
    private QuantityRepresentation totalPackagesQuantity;
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
