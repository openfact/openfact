package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class ItemLocationQuantityRepresentation {
    private MeasureRepresentation LeadTimeMeasure;
    private QuantityRepresentation MinimumQuantity;
    private QuantityRepresentation MaximumQuantity;
    private boolean HazardousRiskIndicator;
    private List<String> TradingRestrictions;
    private List<AddressRepresentation> ApplicableTerritoryAddress;
    private PriceRepresentation Price;
    private List<DeliveryUnitRepresentation> DeliveryUnit;
    private List<TaxCategoryRepresentation> ApplicableTaxCategory;
    private String Id;
}