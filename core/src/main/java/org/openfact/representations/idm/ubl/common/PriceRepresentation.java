package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class PriceRepresentation {
    private BigDecimal priceAmount;
    private QuantityRepresentation baseQuantity;
    private List<String> priceChangeReason;
    private String priceRepresentationCode;
    private String priceRepresentation;
    private BigDecimal orderableUnitFactorRate;
    private List<PeriodRepresentation> validityPeriod;
    private PriceListRepresentation priceList;
    private List<AllowanceChargeRepresentation> allowanceCharge;
    private String id;
}
