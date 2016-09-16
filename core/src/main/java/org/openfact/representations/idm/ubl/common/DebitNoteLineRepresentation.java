package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DebitNoteLineRepresentation {
    private String ID;
    private String UUID;
    private String Note;
    private QuantityRepresentation DebitedQuantity;
    private BigDecimal LineExtensionAmount;
    private LocalDate TaxPointDate;
    private String AccountingCostCode;
    private String AccountingCost;
    private List<ResponseRepresentation> DiscrepancyResponse;
    private List<LineReferenceRepresentation> DespatchLineReference;
    private List<LineReferenceRepresentation> ReceiptLineReference;
    private List<BillingReferenceRepresentation> BillingReference;
    private List<DocumentReferenceRepresentation> DocumentReference;
    private PricingReferenceRepresentation PricingReference;
    private List<DeliveryRepresentation> Delivery;
    private List<TaxTotalRepresentation> TaxTotal;
    private ItemRepresentation Item;
    private PriceRepresentation Price;
    private String Id;
}