package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemLocationQuantityType {

    LeadTimeMeasureType getLeadTimeMeasure();

    void setLeadTimeMeasure(LeadTimeMeasureType value);

    MinimumQuantityType getMinimumQuantity();

    void setMinimumQuantity(MinimumQuantityType value);

    MaximumQuantityType getMaximumQuantity();

    void setMaximumQuantity(MaximumQuantityType value);

    HazardousRiskIndicatorType getHazardousRiskIndicator();

    void setHazardousRiskIndicator(HazardousRiskIndicatorType value);

    List<TradingRestrictionsType> getTradingRestrictions();

    void setTradingRestrictions(List<TradingRestrictionsType> tradingRestrictions);

    List<AddressType> getApplicableTerritoryAddress();

    void setApplicableTerritoryAddress(List<AddressType> applicableTerritoryAddress);

    PriceType getPrice();

    void setPrice(PriceType value);

    List<DeliveryUnitType> getDeliveryUnit();

    void setDeliveryUnit(List<DeliveryUnitType> deliveryUnit);

    List<TaxCategoryType> getApplicableTaxCategory();

    void setApplicableTaxCategory(List<TaxCategoryType> applicableTaxCategory);

    String getId();

    void setId(String value);

}
