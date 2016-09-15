package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface TaxCategoryModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    BigDecimal getPercent();

    void setPercent(BigDecimal value);

    BaseUnitMeasureModel getBaseUnitMeasure();

    void setBaseUnitMeasure(BaseUnitMeasureModel value);

    PerUnitAmountModel getPerUnitAmount();

    void setPerUnitAmount(PerUnitAmountModel value);

    String getTaxExemptionReasonCode();

    void setTaxExemptionReasonCode(String value);

    TaxExemptionReasonModel getTaxExemptionReason();

    void setTaxExemptionReason(TaxExemptionReasonModel value);

    TierRangeModel getTierRange();

    void setTierRange(TierRangeModel value);

    TierRatePercentModel getTierRatePercent();

    void setTierRatePercent(TierRatePercentModel value);

    TaxSchemeModel getTaxScheme();

    void setTaxScheme(TaxSchemeModel value);

    String getId();

    void setId(String value);

}
