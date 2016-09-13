package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a CreditNoteModel or SelfBilledCreditNote.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLineModel {

    /**
     * The buyer's accounting cost centre for this credit note line, expressed
     * as text.
     */
    private TextModel accountingCost;
    /**
     * The buyer's accounting cost centre for this credit note line, expressed
     * as a code.
     */
    private CodeModel accountingCostCode;
    /**
     * The quantity of items credited in this credit note line.
     */
    private QuantityModel creditedQuantity;
    /**
     * An indicator that this credit note line is free of charge (true) or not
     * (false). The default is false.
     */
    private boolean freeOfChargeIndicator;
    /**
     * An identifier for this credit note line.
     */
    private IdentifierModel ID;
    /**
     * The total amount for this credit note line, including allowance charges
     * but exclusive of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private CodeModel paymentPurposeCode;
    /**
     * The date of this credit note line, used to indicate the point at which
     * tax becomes applicable.
     */
    private LocalDate taxPointDate;
    /**
     * A universally unique identifier for this credit note line.
     */
    private IdentifierModel UUID;
    private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceModel> billingReferences = new ArrayList<>();
    private CreditNoteLineModel subCreditNoteLine;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>();
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<ItemModel> items = new ArrayList<>();
    private LineReferenceModel receiptLineReference;
    private LineReferenceModel despatchLineReference;
    private List<OrderLineReferenceModel> orderLineReferences = new ArrayList<>();
    private PartyModel originatorParty;
    private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
    private PeriodModel invoicePeriod;
    private List<PriceModel> prices = new ArrayList<>();
    private PriceExtensionModel itemPriceExtension;
    private List<PricingReferenceModel> pricingReferences = new ArrayList<>();
    private ResponseModel discrepancyResponse;
    private List<TaxTotalModel> taxTotals = new ArrayList<>();

}
