package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class TaxCategoryRepresentation {
    private String ID;
    private String Name;
    private BigDecimal Percent;
    private MeasureRepresentation BaseUnitMeasure;
    private BigDecimal PerUnitAmount;
    private String TaxExemptionReasonCode;
    private String TaxExemptionReason;
    private String TierRange;
    private BigDecimal TierRatePercent;
    private TaxSchemeRepresentation TaxScheme;
    private String Id;
}