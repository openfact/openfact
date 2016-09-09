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
    private TextType accountingCost;
    /**
     * The buyer's accounting code, applied to the OrderEntity as a whole.
     */
    private CodeType accountingCostCode;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private IndicatorType copyIndicator;
    /**
     * A supplementary reference for the Order.
     */
    private TextType customerReference;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeType codeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private DateType issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private TimeType issueTime;
    /**
     * The number of orderLines in the document.
     */
    private NumericType lineCountNumeric;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType note;
    /**
     * A code signifying the type of Order.
     */
    private CodeType orderTypeCode;
    /**
     * A code signifying the currency used for all prices in the Order.
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
     * A code signifying the currency requested for amount totals in Invoices
     * related to this Order.
     */
    private CurrencyCodeType codeTypeRequestedInvoiceCurrencyCode;
    /**
     * An identifier for the Order, assigned by the seller.
     */
    private IdentifierType salesOrderID;
    /**
     * A code signifying the currency requested for tax amounts in Invoices
     * related to this Order.
     */
    private CurrencyCodeType codeTypeTaxCurrencyCode;
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
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<CatalogueReferenceEntity> catalogueReferences = new ArrayList<>();
    private List<ContractEntity> contracts = new ArrayList<>();
    private CountryEntity destinationCountry;
    private CustomerPartyEntity originatorCustomerParty;
    private CustomerPartyEntity accountingCustomerParty;
    private CustomerPartyEntity buyerCustomerParty;
    private List<DeliveryEntity> deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
    private DocumentReferenceEntity orderDocumentReference;
    private DocumentReferenceEntity additionalDocumentReference;
    private DocumentReferenceEntity originatorDocumentReference;
    private DocumentReferenceEntity quotationDocumentReference;
    private ExchangeRateEntity paymentExchangeRate;
    private ExchangeRateEntity pricingExchangeRate;
    private ExchangeRateEntity taxExchangeRate;
    private MonetaryTotalEntity anticipatedMonetaryTotal;
    private List<OrderLineEntity> orderLines = new ArrayList<>();
    private PartyEntity freightForwarderParty;
    private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();
    private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
    private PeriodEntity validityPeriod;
    private List<ProjectReferenceEntity> projectReferences = new ArrayList<>();
    private List<SignatureEntity> signatures = new ArrayList<>();
    private SupplierPartyEntity sellerSupplierParty;
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();
    private List<TransactionConditionsEntity> transactionConditionses = new ArrayList<>();

}
