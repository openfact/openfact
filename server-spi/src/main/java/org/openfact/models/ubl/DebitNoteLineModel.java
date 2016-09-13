package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a DebitNote.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLineModel {

    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * text.
     */
    private TextModel accountingCost;
    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * a code.
     */
    private CodeModel accountingCostCode;
    /**
     * The quantity of items debited in this debit note line.
     */
    private QuantityModel debitedQuantity;
    /**
     * An identifier for this debit note line.
     */
    private IdentifierModel ID;
    /**
     * The total amount for this debit note line, including allowance charges
     * but net of taxes.
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
     * The date of this debit note line, used to indicate the point at which tax
     * becomes applicable.
     */
    private LocalDate taxPointDate;
    /**
     * A universally unique identifier for this debit note line.
     */
    private IdentifierModel UUID;
    private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceModel> billingReferences = new ArrayList<>();
    private DebitNoteModel lineSubDebitNoteLine;
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<ItemModel> items = new ArrayList<>();
    private LineReferenceModel despatchLineReference;
    private LineReferenceModel receiptLineReference;
    private List<PriceModel> prices = new ArrayList<>();
    private List<PricingReferenceModel> pricingReferences = new ArrayList<>();
    private ResponseModel discrepancyResponse;
    private List<TaxTotalModel> taxTotals = new ArrayList<>();

}
