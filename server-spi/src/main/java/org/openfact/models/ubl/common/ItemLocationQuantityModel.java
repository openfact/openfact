package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemLocationQuantityModel {

    LeadTimeMeasureModel getLeadTimeMeasure();

    void setLeadTimeMeasure(LeadTimeMeasureModel value);

    MinimumQuantityModel getMinimumQuantity();

    void setMinimumQuantity(MinimumQuantityModel value);

    MaximumQuantityModel getMaximumQuantity();

    void setMaximumQuantity(MaximumQuantityModel value);

    HazardousRiskIndicatorModel getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorModel value);

    List<String> getTradingRestrictions();

    void setTradingRestrictions(List<String> tradingRestrictions);

    List<AddressModel> getApplicableTerritoryAddress();

    void setApplicableTerritoryAddress(List<AddressModel> applicableTerritoryAddress);

    PriceModel getPrice();

    void setPrice(PriceModel value);

    List<DeliveryUnitModel> getDeliveryUnit();

    void setDeliveryUnit(List<DeliveryUnitModel> deliveryUnit);

    List<TaxCategoryModel> getApplicableTaxCategory();

    void setApplicableTaxCategory(List<TaxCategoryModel> applicableTaxCategory);

    String getId();

    void setId(String value);

}
