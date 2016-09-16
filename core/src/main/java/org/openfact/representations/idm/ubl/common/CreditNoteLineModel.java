package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CreditNoteLineModel {
    protected String ID;
    protected String UUID;
    protected String Note;
    protected QuantityModel CreditedQuantity;
    protected BigDecimal LineExtensionAmount;
    protected LocalDate TaxPointDate;
    protected String AccountingCostCode;
    protected String AccountingCost;
    protected List<ResponseModel> DiscrepancyResponse;
    protected List<LineReferenceModel> DespatchLineReference;
    protected List<LineReferenceModel> ReceiptLineReference;
    protected List<BillingReferenceModel> BillingReference;
    protected List<DocumentReferenceModel> DocumentReference;
    protected PricingReferenceModel PricingReference;
    protected List<DeliveryModel> Delivery;
    protected List<TaxTotalModel> TaxTotal;
    protected ItemModel Item;
    protected PriceModel Price;
    protected String Id;
}