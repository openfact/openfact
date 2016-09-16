package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public class TaxCategoryRepresentation {
    private String ID;
    private String name;
    private BigDecimal percent;
    private MeasureRepresentation baseUnitMeasure;
    private BigDecimal perUnitAmount;
    private String taxExemptionReasonCode;
    private String taxExemptionReason;
    private String tierRange;
    private BigDecimal tierRatePercent;
    private TaxSchemeRepresentation taxScheme;
    private String id;
}
