package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class ItemLocationQuantityModel {
    protected MeasureModel LeadTimeMeasure;
    protected QuantityModel MinimumQuantity;
    protected QuantityModel MaximumQuantity;
    protected boolean HazardousRiskIndicator;
    protected List<String> TradingRestrictions;
    protected List<AddressModel> ApplicableTerritoryAddress;
    protected PriceModel Price;
    protected List<DeliveryUnitModel> DeliveryUnit;
    protected List<TaxCategoryModel> ApplicableTaxCategory;
    protected String Id;
}