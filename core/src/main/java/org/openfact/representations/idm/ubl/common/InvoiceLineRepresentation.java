package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InvoiceLineRepresentation {
    private String ID;
    private String UUID;
    private String Note;
    private QuantityRepresentation InvoicedQuantity;
    private BigDecimal LineExtensionAmount;
    private LocalDate TaxPointDate;
    private String AccountingCostCode;
    private String AccountingCost;
    private boolean FreeOfChargeIndicator;
    private List<OrderLineReferenceRepresentation> OrderLineReference;
    private List<LineReferenceRepresentation> DespatchLineReference;
    private List<LineReferenceRepresentation> ReceiptLineReference;
    private List<BillingReferenceRepresentation> BillingReference;
    private List<DocumentReferenceRepresentation> DocumentReference;
    private PricingReferenceRepresentation PricingReference;
    private PartyRepresentation OriginatorParty;
    private List<DeliveryRepresentation> Delivery;
    private List<PaymentTermsRepresentation> PaymentTerms;
    private List<AllowanceChargeRepresentation> AllowanceCharge;
    private List<TaxTotalRepresentation> TaxTotal;
    private ItemRepresentation Item;
    private PriceRepresentation Price;
    private DeliveryTermsRepresentation DeliveryTerms;
    private String Id;
}