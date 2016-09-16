package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;

public interface TaxCategoryModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    MeasureModel getBaseUnitMeasure();

    void setBaseUnitMeasure(MeasureModel value);

    BigDecimal getPerUnitAmount();

    void setPerUnitAmount(BigDecimal value);

    String getTaxExemptionReasonCode();

    void setTaxExemptionReasonCode(String value);

    String getTaxExemptionReason();

    void setTaxExemptionReason(String value);

    String getTierRange();

    void setTierRange(String value);

    BigDecimal getTierRatePercent();

    void setTierRatePercent(BigDecimal value);

    TaxSchemeModel getTaxScheme();

    void setTaxScheme(TaxSchemeModel value);

    String getId();

    void setId(String value);

}
