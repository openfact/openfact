package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InvoiceLineRepresentation {
    private String ID;
    private String UUID;
    private String note;
    private QuantityRepresentation invoicedQuantity;
    private BigDecimal lineExtensionAmount;
    private LocalDate taxPointDate;
    private String accountingCostCode;
    private String accountingCost;
    private boolean freeOfChargeIndicator;
    private List<OrderLineReferenceRepresentation> orderLineReference;
    private List<LineReferenceRepresentation> despatchLineReference;
    private List<LineReferenceRepresentation> receiptLineReference;
    private List<BillingReferenceRepresentation> billingReference;
    private List<DocumentReferenceRepresentation> documentReference;
    private PricingReferenceRepresentation pricingReference;
    private PartyRepresentation originatorParty;
    private List<DeliveryRepresentation> delivery;
    private List<PaymentTermsRepresentation> paymentTerms;
    private List<AllowanceChargeRepresentation> allowanceCharge;
    private List<TaxTotalRepresentation> taxTotal;
    private ItemRepresentation item;
    private PriceRepresentation price;
    private DeliveryTermsRepresentation deliveryTerms;
    private String id;
}
