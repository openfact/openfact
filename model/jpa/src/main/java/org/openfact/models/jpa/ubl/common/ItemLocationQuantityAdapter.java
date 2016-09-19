package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class ItemLocationQuantityAdapter
        implements ItemLocationQuantityModel, JpaModel<ItemLocationQuantityEntity> {

    protected static final Logger logger = Logger.getLogger(ItemLocationQuantityAdapter.class);
    protected ItemLocationQuantityEntity itemLocationQuantity;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemLocationQuantityAdapter(OpenfactSession session, EntityManager em,
            ItemLocationQuantityEntity itemLocationQuantity) {
        this.session = session;
        this.em = em;
        this.itemLocationQuantity = itemLocationQuantity;
    }

    MeasureAdapter getLeadTimeMeasure() {
        return this.itemLocationQuantity.getLeadTimeMeasure();
    }

    void setLeadTimeMeasure(MeasureAdapter value) {
        this.itemLocationQuantity.setLeadTimeMeasure(value);
    }

    QuantityAdapter getMinimumQuantity() {
        return this.itemLocationQuantity.getMinimumQuantity();
    }

    void setMinimumQuantity(QuantityAdapter value) {
        this.itemLocationQuantity.setMinimumQuantity(value);
    }

    QuantityAdapter getMaximumQuantity() {
        return this.itemLocationQuantity.getMaximumQuantity();
    }

    void setMaximumQuantity(QuantityAdapter value) {
        this.itemLocationQuantity.setMaximumQuantity(value);
    }

    boolean getHazardousRiskIndicator() {
        return this.itemLocationQuantity.getHazardousRiskIndicator();
    }

    void setHazardousRiskIndicator(boolean value) {
        this.itemLocationQuantity.setHazardousRiskIndicator(value);
    }

    List<String> getTradingRestrictions() {
        return this.itemLocationQuantity.getTradingRestrictions();
    }

    void setTradingRestrictions(List<String> tradingRestrictions) {
        this.itemLocationQuantity.setTradingRestrictions(tradingRestrictions);
    }

    List<AddressAdapter> getApplicableTerritoryAddress() {
        return this.itemLocationQuantity.getApplicableTerritoryAddress();
    }

    void setApplicableTerritoryAddress(List<AddressAdapter> applicableTerritoryAddress) {
        this.itemLocationQuantity.setApplicableTerritoryAddress(applicableTerritoryAddress);
    }

    PriceAdapter getPrice() {
        return this.itemLocationQuantity.getPrice();
    }

    void setPrice(PriceAdapter value) {
        this.itemLocationQuantity.setPrice(value);
    }

    List<DeliveryUnitAdapter> getDeliveryUnit() {
        return this.itemLocationQuantity.getDeliveryUnit();
    }

    void setDeliveryUnit(List<DeliveryUnitAdapter> deliveryUnit) {
        this.itemLocationQuantity.setDeliveryUnit(deliveryUnit);
    }

    List<TaxCategoryAdapter> getApplicableTaxCategory() {
        return this.itemLocationQuantity.getApplicableTaxCategory();
    }

    void setApplicableTaxCategory(List<TaxCategoryAdapter> applicableTaxCategory) {
        this.itemLocationQuantity.setApplicableTaxCategory(applicableTaxCategory);
    }

    String getId() {
        return this.itemLocationQuantity.getId();
    }

    void setId(String value) {
        this.itemLocationQuantity.setId(value);
    }

}
