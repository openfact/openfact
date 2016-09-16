package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PriceModel {
    protected BigDecimal PriceAmount;
    protected QuantityModel BaseQuantity;
    protected List<String> PriceChangeReason;
    protected String PriceModelCode;
    protected String PriceModel;
    protected BigDecimal OrderableUnitFactorRate;
    protected List<PeriodModel> ValidityPeriod;
    protected PriceListModel PriceList;
    protected List<AllowanceChargeModel> AllowanceCharge;
    protected String Id;
}