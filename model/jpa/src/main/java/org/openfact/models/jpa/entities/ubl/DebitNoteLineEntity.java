package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

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
    private TextType AccountingCost;
    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * a code.
     */
    private CodeType AccountingCostCode;
    /**
     * The quantity of Items debited in this debit note line.
     */
    private QuantityType DebitedQuantity;
    /**
     * An identifier for this debit note line.
     */
    private IdentifierType ID;
    /**
     * The total amount for this debit note line, including allowance charges
     * but net of taxes.
     */
    private AmountType LineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType Note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private CodeType PaymentPurposeCode;
    /**
     * The date of this debit note line, used to indicate the point at which tax
     * becomes applicable.
     */
    private DateType TaxPointDate;
    /**
     * A universally unique identifier for this debit note line.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<BillingReferenceEntity> BillingReferences = new ArrayList<>();
    private DebitNoteEntity LineSubDebitNoteLine;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private List<ItemEntity> Items = new ArrayList<>();
    private LineReferenceEntity DespatchLineReference;
    private LineReferenceEntity ReceiptLineReference;
    private List<PriceEntity> Prices = new ArrayList<>();
    private List<PricingReferenceEntity> PricingReferences = new ArrayList<>();
    private ResponseEntity DiscrepancyResponse;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();

}
