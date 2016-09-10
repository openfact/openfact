package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a line in a DebitNote.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLineEntity {

    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * text.
     */
    private TextType accountingCost;
    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * a code.
     */
    private CodeType accountingCostCode;
    /**
     * The quantity of items debited in this debit note line.
     */
    private QuantityType debitedQuantity;
    /**
     * An identifier for this debit note line.
     */
    private IdentifierType ID;
    /**
     * The total amount for this debit note line, including allowance charges
     * but net of taxes.
     */
    private BigDecimal lineExtensionAmount;
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
     * The date of this debit note line, used to indicate the point at which tax
     * becomes applicable.
     */
    private LocalDate taxPointDate;
    /**
     * A universally unique identifier for this debit note line.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceEntity> billingReferences = new ArrayList<>();
    private DebitNoteEntity lineSubDebitNoteLine;
    private List<DeliveryEntity> deliveries = new ArrayList<>();
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private List<ItemEntity> items = new ArrayList<>();
    private LineReferenceEntity despatchLineReference;
    private LineReferenceEntity receiptLineReference;
    private List<PriceEntity> prices = new ArrayList<>();
    private List<PricingReferenceEntity> pricingReferences = new ArrayList<>();
    private ResponseEntity discrepancyResponse;
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
