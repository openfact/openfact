package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InvoiceLineModel {
    protected String ID;
    protected String UUID;
    protected String Note;
    protected QuantityModel InvoicedQuantity;
    protected BigDecimal LineExtensionAmount;
    protected LocalDate TaxPointDate;
    protected String AccountingCostCode;
    protected String AccountingCost;
    protected boolean FreeOfChargeIndicator;
    protected List<OrderLineReferenceModel> OrderLineReference;
    protected List<LineReferenceModel> DespatchLineReference;
    protected List<LineReferenceModel> ReceiptLineReference;
    protected List<BillingReferenceModel> BillingReference;
    protected List<DocumentReferenceModel> DocumentReference;
    protected PricingReferenceModel PricingReference;
    protected PartyModel OriginatorParty;
    protected List<DeliveryModel> Delivery;
    protected List<PaymentTermsModel> PaymentTerms;
    protected List<AllowanceChargeModel> AllowanceCharge;
    protected List<TaxTotalModel> TaxTotal;
    protected ItemModel Item;
    protected PriceModel Price;
    protected DeliveryTermsModel DeliveryTerms;
    protected String Id;
}