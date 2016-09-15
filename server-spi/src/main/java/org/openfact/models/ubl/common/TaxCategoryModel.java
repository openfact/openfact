package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface TaxCategoryModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    BaseUnitMeasureModel getBaseUnitMeasure();

    void setBaseUnitMeasure(BaseUnitMeasureModel value);

    PerUnitAmountModel getPerUnitAmount();

    void setPerUnitAmount(PerUnitAmountModel value);

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
