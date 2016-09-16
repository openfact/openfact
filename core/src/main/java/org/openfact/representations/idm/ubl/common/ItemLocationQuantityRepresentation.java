package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class ItemLocationQuantityRepresentation {
    private MeasureRepresentation leadTimeMeasure;
    private QuantityRepresentation minimumQuantity;
    private QuantityRepresentation maximumQuantity;
    private boolean hazardousRiskIndicator;
    private List<String> tradingRestrictions;
    private List<AddressRepresentation> applicableTerritoryAddress;
    private PriceRepresentation price;
    private List<DeliveryUnitRepresentation> deliveryUnit;
    private List<TaxCategoryRepresentation> applicableTaxCategory;
    private String id;
}
