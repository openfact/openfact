package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in an Invoice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:37 a. m.
 */
public class InvoiceLineEntity {

    /**
     * The buyer's accounting cost centre for this invoice line, expressed as
     * text.
     */
    private TextType accountingCost;
    /**
     * The buyer's accounting cost centre for this invoice line, expressed as a
     * code.
     */
    private CodeType accountingCostCode;
    /**
     * An indicator that this invoice line is free of charge (true) or not
     * (false). The default is false.
     */
    private IndicatorType freeOfChargeIndicator;
    /**
     * An identifier for this invoice line.
     */
    private IdentifierType ID;
    /**
     * The quantity (of items) on this invoice line.
     */
    private QuantityType invoicedQuantity;
    /**
     * The total amount for this invoice line, including allowance charges but
     * net of taxes.
     */
    private AmountType lineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private CodeType paymentPurposeCode;
    /**
     * The date of this invoice line, used to indicate the point at which tax
     * becomes applicable.
     */
    private DateType taxPointDate;
    /**
     * A universally unique identifier for this invoice line.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
    private List<DeliveryEntity> deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private List<ItemEntity> items = new ArrayList<>();
    private LineReferenceEntity despatchLineReference;
    private LineReferenceEntity receiptLineReference;
    private List<OrderLineReferenceEntity> orderLineReferences = new ArrayList<>();
    private PartyEntity originatorParty;
    private List<PaymentTermsEntity> paymentTermses = new ArrayList<>();
    private PeriodEntity invoicePeriod;
    private InvoiceLineEntity subInvoiceLine;
    private List<PriceEntity> prices = new ArrayList<>();
    private PriceExtensionEntity itemPriceExtension;
    private List<PricingReferenceEntity> pricingReferences = new ArrayList<>();
    private List<TaxTotalEntity> withholdingTaxTotal = new ArrayList<>();
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
