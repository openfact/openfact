package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DebitNoteLineRepresentation {
    private String ID;
    private String UUID;
    private String note;
    private QuantityRepresentation debitedQuantity;
    private BigDecimal lineExtensionAmount;
    private LocalDate taxPointDate;
    private String accountingCostCode;
    private String accountingCost;
    private List<ResponseRepresentation> discrepancyResponse;
    private List<LineReferenceRepresentation> despatchLineReference;
    private List<LineReferenceRepresentation> receiptLineReference;
    private List<BillingReferenceRepresentation> billingReference;
    private List<DocumentReferenceRepresentation> documentReference;
    private PricingReferenceRepresentation pricingReference;
    private List<DeliveryRepresentation> delivery;
    private List<TaxTotalRepresentation> taxTotal;
    private ItemRepresentation item;
    private PriceRepresentation price;
    private String id;
}
