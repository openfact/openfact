package org.openfact.models.ubl.common;

import java.util.List;

public interface LineItemType {

    IDType getID();

    void setID(IDType value);

    SalesOrderIDType getSalesOrderID();

    void setSalesOrderID(SalesOrderIDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    NoteType getNote();

    void setNote(NoteType value);

    LineStatusCodeTypeCommBas getLineStatusCode();

    void setLineStatusCode(LineStatusCodeTypeCommBas value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    LineExtensionAmountType getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountType value);

    TotalTaxAmountType getTotalTaxAmount();

    void setTotalTaxAmount(TotalTaxAmountType value);

    MinimumQuantityType getMinimumQuantity();

    void setMinimumQuantity(MinimumQuantityType value);

    MaximumQuantityType getMaximumQuantity();

    void setMaximumQuantity(MaximumQuantityType value);

    MinimumBackorderQuantityType getMinimumBackorderQuantity();

    void setMinimumBackorderQuantity(MinimumBackorderQuantityType value);

    MaximumBackorderQuantityType getMaximumBackorderQuantity();

    void setMaximumBackorderQuantity(MaximumBackorderQuantityType value);

    InspectionMethodCodeType getInspectionMethodCode();

    void setInspectionMethodCode(InspectionMethodCodeType value);

    PartialDeliveryIndicatorType getPartialDeliveryIndicator();

    void setPartialDeliveryIndicator(PartialDeliveryIndicatorType value);

    BackOrderAllowedIndicatorType getBackOrderAllowedIndicator();

    void setBackOrderAllowedIndicator(BackOrderAllowedIndicatorType value);

    AccountingCostCodeType getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeType value);

    AccountingCostType getAccountingCost();

    void setAccountingCost(AccountingCostType value);

    List<DeliveryType> getDelivery();

    void setDelivery(List<DeliveryType> delivery);

    DeliveryTermsType getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsType value);

    PartyType getOriginatorParty();

    void setOriginatorParty(PartyType value);

    List<OrderedShipmentType> getOrderedShipment();

    void setOrderedShipment(List<OrderedShipmentType> orderedShipment);

    PricingReferenceType getPricingReference();

    void setPricingReference(PricingReferenceType value);

    List<AllowanceChargeType> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeType> allowanceCharge);

    PriceType getPrice();

    void setPrice(PriceType value);

    ItemType getItem();

    void setItem(ItemType value);

    String getId();

    void setId(String value);

}
