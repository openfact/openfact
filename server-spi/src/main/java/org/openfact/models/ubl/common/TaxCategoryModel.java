package org.openfact.models.ubl.common;

public interface TaxCategoryModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    PercentModel getPercent();

    void setPercent(PercentModel value);

    BaseUnitMeasureModel getBaseUnitMeasure();

    void setBaseUnitMeasure(BaseUnitMeasureModel value);

    PerUnitAmountModel getPerUnitAmount();

    void setPerUnitAmount(PerUnitAmountModel value);

    TaxExemptionReasonCodeModel getTaxExemptionReasonCode();

    void setTaxExemptionReasonCode(TaxExemptionReasonCodeModel value);

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
