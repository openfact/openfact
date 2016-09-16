package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PriceRepresentation {
    private BigDecimal PriceAmount;
    private QuantityRepresentation BaseQuantity;
    private List<String> PriceChangeReason;
    private String PriceRepresentationCode;
    private String PriceRepresentation;
    private BigDecimal OrderableUnitFactorRate;
    private List<PeriodRepresentation> ValidityPeriod;
    private PriceListRepresentation PriceList;
    private List<AllowanceChargeRepresentation> AllowanceCharge;
    private String Id;
}