package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PriceRepresentation {
    private BigDecimal priceAmount;
    private QuantityRepresentation baseQuantity;
    private List<String> priceChangeReason;
    private String priceTypeCode;
    private String priceRepresentation;
    private BigDecimal orderableUnitFactorRate;
    private List<PeriodRepresentation> validityPeriod;
    private PriceListRepresentation priceList;
    private List<AllowanceChargeRepresentation> allowanceCharge;
    private String id;

    public List<PeriodRepresentation> getValidityPeriod() {
        return this.validityPeriod;
    }

    public void setValidityPeriod(List<PeriodRepresentation> validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getOrderableUnitFactorRate() {
        return this.orderableUnitFactorRate;
    }

    public void setOrderableUnitFactorRate(BigDecimal orderableUnitFactorRate) {
        this.orderableUnitFactorRate = orderableUnitFactorRate;
    }

    public String getPriceTypeCode() {
        return this.priceTypeCode;
    }

    public void setPriceTypeCode(String priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }

    public String getPriceRepresentation() {
        return this.priceRepresentation;
    }

    public void setPriceRepresentation(String priceRepresentation) {
        this.priceRepresentation = priceRepresentation;
    }

    public List<String> getPriceChangeReason() {
        return this.priceChangeReason;
    }

    public void setPriceChangeReason(List<String> priceChangeReason) {
        this.priceChangeReason = priceChangeReason;
    }

    public QuantityRepresentation getBaseQuantity() {
        return this.baseQuantity;
    }

    public void setBaseQuantity(QuantityRepresentation baseQuantity) {
        this.baseQuantity = baseQuantity;
    }

    public List<AllowanceChargeRepresentation> getAllowanceCharge() {
        return this.allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeRepresentation> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    public PriceListRepresentation getPriceList() {
        return this.priceList;
    }

    public void setPriceList(PriceListRepresentation priceList) {
        this.priceList = priceList;
    }

    public BigDecimal getPriceAmount() {
        return this.priceAmount;
    }

    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }
}