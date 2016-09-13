package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a DebitNote.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:19 a. m.
 */
public class DebitNoteLineRepresentation {

    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * text.
     */
    private TextRepresentation accountingCost;
    /**
     * The buyer's accounting cost centre for this debit note line, expressed as
     * a code.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * The quantity of items debited in this debit note line.
     */
    private QuantityRepresentation debitedQuantity;
    /**
     * An identifier for this debit note line.
     */
    private IdentifierRepresentation ID;
    /**
     * The total amount for this debit note line, including allowance charges
     * but net of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * A code signifying the business purpose for this payment.
     */
    private CodeRepresentation paymentPurposeCode;
    /**
     * The date of this debit note line, used to indicate the point at which tax
     * becomes applicable.
     */
    private LocalDate taxPointDate;
    /**
     * A universally unique identifier for this debit note line.
     */
    private IdentifierRepresentation UUID;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private List<BillingReferenceRepresentation> billingReferences = new ArrayList<>();
    private DebitNoteRepresentation lineSubDebitNoteLine;
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private LineReferenceRepresentation despatchLineReference;
    private LineReferenceRepresentation receiptLineReference;
    private List<PriceRepresentation> prices = new ArrayList<>();
    private List<PricingReferenceRepresentation> pricingReferences = new ArrayList<>();
    private ResponseRepresentation discrepancyResponse;
    private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();

}
