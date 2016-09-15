package org.openfact.models.ubl.common;

import java.util.List;

public interface LineItemModel {

    String getID();

    void setID(String value);

    String getSalesOrderID();

    void setSalesOrderID(String value);

    String getUUID();

    void setUUID(String value);

    String getNote();

    void setNote(String value);

    String getLineStatusCode();

    void setLineStatusCode(String value);

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

    String getInspectionMethodCode();

    void setInspectionMethodCode(String value);

    boolean getPartialDeliveryIndicator();

    void setPartialDeliveryIndicator(boolean value);

    boolean getBackOrderAllowedIndicator();

    void setBackOrderAllowedIndicator(boolean value);

    String getAccountingCostCode();

    void setAccountingCostCode(String value);

    String getAccountingCost();

    void setAccountingCost(String value);

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
