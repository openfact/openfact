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
 * A class to define a line in a CreditNoteEntity or SelfBilledCreditNote.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLineEntity {

    /**
     * The buyer's accounting cost centre for this credit note line, expressed
     * as text.
     */
    private TextType AccountingCost;
    /**
     * The buyer's accounting cost centre for this credit note line, expressed
     * as a code.
     */
    private CodeType AccountingCostCode;
    /**
     * The quantity of items credited in this credit note line.
     */
    private QuantityType CreditedQuantity;
    /**
     * An indicator that this credit note line is free of charge (true) or not
     * (false). The default is false.
     */
    private IndicatorType FreeOfChargeIndicator;
    /**
     * An identifier for this credit note line.
     */
    private IdentifierType ID;
    /**
     * The total amount for this credit note line, including allowance charges
     * but exclusive of taxes.
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
     * The date of this credit note line, used to indicate the point at which
     * tax becomes applicable.
     */
    private DateType TaxPointDate;
    /**
     * A universally unique identifier for this credit note line.
     */
    private IdentifierType UUID;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<BillingReferenceEntity> BillingReferences = new ArrayList<>();
    private CreditNoteLineEntity SubCreditNoteLine;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> DeliveriesTerms = new ArrayList<>();
    private List<DocumentReferenceEntity> DocumentReferences = new ArrayList<>();
    private List<ItemEntity> Items = new ArrayList<>();
    private LineReferenceEntity ReceiptLineReference;
    private LineReferenceEntity DespatchLineReference;
    private List<OrderLineReferenceEntity> OrderLineReferences = new ArrayList<>();
    private PartyEntity OriginatorParty;
    private List<PaymentTermsEntity> PaymentTermses = new ArrayList<>();
    private PeriodEntity InvoicePeriod;
    private List<PriceEntity> Prices = new ArrayList<>();
    private PriceExtensionEntity ItemPriceExtension;
    private List<PricingReferenceEntity> PricingReferences = new ArrayList<>();
    private ResponseEntity DiscrepancyResponse;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();

}
