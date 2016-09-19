package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PriceAdapter implements PriceModel, JpaModel<PriceEntity> {

    protected static final Logger logger = Logger.getLogger(PriceAdapter.class);
    protected PriceEntity price;
    protected EntityManager em;
    protected OpenfactSession session;

    public PriceAdapter(OpenfactSession session, EntityManager em, PriceEntity price) {
        this.session = session;
        this.em = em;
        this.price = price;
    }

    BigDecimal getPriceAmount() {
        return this.price.getPriceAmount();
    }

    void setPriceAmount(BigDecimal value) {
        this.price.setPriceAmount(value);
    }

    QuantityAdapter getBaseQuantity() {
        return this.price.getBaseQuantity();
    }

    void setBaseQuantity(QuantityAdapter value) {
        this.price.setBaseQuantity(value);
    }

    List<String> getPriceChangeReason() {
        return this.price.getPriceChangeReason();
    }

    void setPriceChangeReason(List<String> priceChangeReason) {
        this.price.setPriceChangeReason(priceChangeReason);
    }

    String getPriceAdapterCode() {
        return this.price.getPriceAdapterCode();
    }

    void setPriceAdapterCode(String value) {
        this.price.setPriceAdapterCode(value);
    }

    String getPriceAdapter() {
        return this.price.getPriceAdapter();
    }

    void setPriceAdapter(String value) {
        this.price.setPriceAdapter(value);
    }

    BigDecimal getOrderableUnitFactorRate() {
        return this.price.getOrderableUnitFactorRate();
    }

    void setOrderableUnitFactorRate(BigDecimal value) {
        this.price.setOrderableUnitFactorRate(value);
    }

    List<PeriodAdapter> getValidityPeriod() {
        return this.price.getValidityPeriod();
    }

    void setValidityPeriod(List<PeriodAdapter> validityPeriod) {
        this.price.setValidityPeriod(validityPeriod);
    }

    PriceListAdapter getPriceList() {
        return this.price.getPriceList();
    }

    void setPriceList(PriceListAdapter value) {
        this.price.setPriceList(value);
    }

    List<AllowanceChargeAdapter> getAllowanceCharge() {
        return this.price.getAllowanceCharge();
    }

    void setAllowanceCharge(List<AllowanceChargeAdapter> allowanceCharge) {
        this.price.setAllowanceCharge(allowanceCharge);
    }

    String getId() {
        return this.price.getId();
    }

    void setId(String value) {
        this.price.setId(value);
    }

}
