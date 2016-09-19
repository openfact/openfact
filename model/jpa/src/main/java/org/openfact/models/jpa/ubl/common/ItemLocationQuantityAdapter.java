package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ItemLocationQuantityEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.DeliveryUnitModel;
import org.openfact.models.ubl.common.ItemLocationQuantityModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TaxCategoryModel;

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

    @Override
    public MeasureModel getLeadTimeMeasure() {
        return this.itemLocationQuantity.getLeadTimeMeasure();
    }

    @Override
    public void setLeadTimeMeasure(MeasureAdapter value) {
        this.itemLocationQuantity.setLeadTimeMeasure(value);
    }

    @Override
    public QuantityModel getMinimumQuantity() {
        return this.itemLocationQuantity.getMinimumQuantity();
    }

    @Override
    public void setMinimumQuantity(QuantityAdapter value) {
        this.itemLocationQuantity.setMinimumQuantity(value);
    }

    @Override
    public QuantityModel getMaximumQuantity() {
        return this.itemLocationQuantity.getMaximumQuantity();
    }

    @Override
    public void setMaximumQuantity(QuantityAdapter value) {
        this.itemLocationQuantity.setMaximumQuantity(value);
    }

    @Override
    public boolean getHazardousRiskIndicator() {
        return this.itemLocationQuantity.getHazardousRiskIndicator();
    }

    @Override
    public void setHazardousRiskIndicator(boolean value) {
        this.itemLocationQuantity.setHazardousRiskIndicator(value);
    }

    @Override
    public List<String> getTradingRestrictions() {
        return this.itemLocationQuantity.getTradingRestrictions();
    }

    @Override
    public void setTradingRestrictions(List<String> tradingRestrictions) {
        this.itemLocationQuantity.setTradingRestrictions(tradingRestrictions);
    }

    @Override
    public List<AddressModel> getApplicableTerritoryAddress() {
        return this.itemLocationQuantity.getApplicableTerritoryAddress();
    }

    @Override
    public void setApplicableTerritoryAddress(List<AddressAdapter> applicableTerritoryAddress) {
        this.itemLocationQuantity.setApplicableTerritoryAddress(applicableTerritoryAddress);
    }

    @Override
    public PriceModel getPrice() {
        return this.itemLocationQuantity.getPrice();
    }

    @Override
    public void setPrice(PriceAdapter value) {
        this.itemLocationQuantity.setPrice(value);
    }

    @Override
    public List<DeliveryUnitModel> getDeliveryUnit() {
        return this.itemLocationQuantity.getDeliveryUnit();
    }

    @Override
    public void setDeliveryUnit(List<DeliveryUnitAdapter> deliveryUnit) {
        this.itemLocationQuantity.setDeliveryUnit(deliveryUnit);
    }

    @Override
    public List<TaxCategoryModel> getApplicableTaxCategory() {
        return this.itemLocationQuantity.getApplicableTaxCategory();
    }

    @Override
    public void setApplicableTaxCategory(List<TaxCategoryAdapter> applicableTaxCategory) {
        this.itemLocationQuantity.setApplicableTaxCategory(applicableTaxCategory);
    }

    @Override
    public String getId() {
        return this.itemLocationQuantity.getId();
    }

    @Override
    public void setId(String value) {
        this.itemLocationQuantity.setId(value);
    }

}
