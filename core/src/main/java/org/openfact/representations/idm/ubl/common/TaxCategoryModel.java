package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class TaxCategoryModel {
    protected String ID;
    protected String Name;
    protected BigDecimal Percent;
    protected MeasureModel BaseUnitMeasure;
    protected BigDecimal PerUnitAmount;
    protected String TaxExemptionReasonCode;
    protected String TaxExemptionReason;
    protected String TierRange;
    protected BigDecimal TierRatePercent;
    protected TaxSchemeModel TaxScheme;
    protected String Id;
}