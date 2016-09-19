package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.PeriodModel;
import org.openfact.models.ubl.common.PriceListModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.QuantityModel;

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

    @Override
    public BigDecimal getPriceAmount() {
        return this.price.getPriceAmount();
    }

    @Override
    public void setPriceAmount(BigDecimal value) {
        this.price.setPriceAmount(value);
    }

    @Override
    public QuantityModel getBaseQuantity() {
        return this.price.getBaseQuantity();
    }

    @Override
    public void setBaseQuantity(QuantityAdapter value) {
        this.price.setBaseQuantity(value);
    }

    @Override
    public List<String> getPriceChangeReason() {
        return this.price.getPriceChangeReason();
    }

    @Override
    public void setPriceChangeReason(List<String> priceChangeReason) {
        this.price.setPriceChangeReason(priceChangeReason);
    }

    @Override
    public String getPriceModelCode() {
        return this.price.getPriceModelCode();
    }

    @Override
    public void setPriceAdapterCode(String value) {
        this.price.setPriceAdapterCode(value);
    }

    @Override
    public String getPriceModel() {
        return this.price.getPriceModel();
    }

    @Override
    public void setPriceAdapter(String value) {
        this.price.setPriceAdapter(value);
    }

    @Override
    public BigDecimal getOrderableUnitFactorRate() {
        return this.price.getOrderableUnitFactorRate();
    }

    @Override
    public void setOrderableUnitFactorRate(BigDecimal value) {
        this.price.setOrderableUnitFactorRate(value);
    }

    @Override
    public List<PeriodModel> getValidityPeriod() {
        return this.price.getValidityPeriod();
    }

    @Override
    public void setValidityPeriod(List<PeriodAdapter> validityPeriod) {
        this.price.setValidityPeriod(validityPeriod);
    }

    @Override
    public PriceListModel getPriceList() {
        return this.price.getPriceList();
    }

    @Override
    public void setPriceList(PriceListAdapter value) {
        this.price.setPriceList(value);
    }

    @Override
    public List<AllowanceChargeModel> getAllowanceCharge() {
        return this.price.getAllowanceCharge();
    }

    @Override
    public void setAllowanceCharge(List<AllowanceChargeAdapter> allowanceCharge) {
        this.price.setAllowanceCharge(allowanceCharge);
    }

    @Override
    public String getId() {
        return this.price.getId();
    }

    @Override
    public void setId(String value) {
        this.price.setId(value);
    }

}
