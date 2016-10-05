package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemLocationQuantityModel {

    MeasureModel getLeadTimeMeasure();

    void setLeadTimeMeasure(MeasureModel value);

    QuantityModel getMinimumQuantity();

    void setMinimumQuantity(QuantityModel value);

    QuantityModel getMaximumQuantity();

    void setMaximumQuantity(QuantityModel value);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

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

    

}
