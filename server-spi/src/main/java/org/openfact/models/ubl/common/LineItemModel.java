package org.openfact.models.ubl.common;

import java.util.List;

public interface LineItemModel {

    IDModel getID();

    void setID(IDModel value);

    SalesOrderIDModel getSalesOrderID();

    void setSalesOrderID(SalesOrderIDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    LineStatusCodeModelCommBas getLineStatusCode();

    void setLineStatusCode(LineStatusCodeModelCommBas value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    LineExtensionAmountModel getLineExtensionAmount();

    void setLineExtensionAmount(LineExtensionAmountModel value);

    TotalTaxAmountModel getTotalTaxAmount();

    void setTotalTaxAmount(TotalTaxAmountModel value);

    MinimumQuantityModel getMinimumQuantity();

    void setMinimumQuantity(MinimumQuantityModel value);

    MaximumQuantityModel getMaximumQuantity();

    void setMaximumQuantity(MaximumQuantityModel value);

    MinimumBackorderQuantityModel getMinimumBackorderQuantity();

    void setMinimumBackorderQuantity(MinimumBackorderQuantityModel value);

    MaximumBackorderQuantityModel getMaximumBackorderQuantity();

    void setMaximumBackorderQuantity(MaximumBackorderQuantityModel value);

    InspectionMethodCodeModel getInspectionMethodCode();

    void setInspectionMethodCode(InspectionMethodCodeModel value);

    PartialDeliveryIndicatorModel getPartialDeliveryIndicator();

    void setPartialDeliveryIndicator(PartialDeliveryIndicatorModel value);

    BackOrderAllowedIndicatorModel getBackOrderAllowedIndicator();

    void setBackOrderAllowedIndicator(BackOrderAllowedIndicatorModel value);

    AccountingCostCodeModel getAccountingCostCode();

    void setAccountingCostCode(AccountingCostCodeModel value);

    AccountingCostModel getAccountingCost();

    void setAccountingCost(AccountingCostModel value);

    List<DeliveryModel> getDelivery();

    void setDelivery(List<DeliveryModel> delivery);

    DeliveryTermsModel getDeliveryTerms();

    void setDeliveryTerms(DeliveryTermsModel value);

    PartyModel getOriginatorParty();

    void setOriginatorParty(PartyModel value);

    List<OrderedShipmentModel> getOrderedShipment();

    void setOrderedShipment(List<OrderedShipmentModel> orderedShipment);

    PricingReferenceModel getPricingReference();

    void setPricingReference(PricingReferenceModel value);

    List<AllowanceChargeModel> getAllowanceCharge();

    void setAllowanceCharge(List<AllowanceChargeModel> allowanceCharge);

    PriceModel getPrice();

    void setPrice(PriceModel value);

    ItemModel getItem();

    void setItem(ItemModel value);

    String getId();

    void setId(String value);

}
