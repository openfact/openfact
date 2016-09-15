package org.openfact.models.ubl.common;

public interface TaxCategoryType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    PercentType getPercent();

    void setPercent(PercentType value);

    BaseUnitMeasureType getBaseUnitMeasure();

    void setBaseUnitMeasure(BaseUnitMeasureType value);

    PerUnitAmountType getPerUnitAmount();

    void setPerUnitAmount(PerUnitAmountType value);

    TaxExemptionReasonCodeType getTaxExemptionReasonCode();

    void setTaxExemptionReasonCode(TaxExemptionReasonCodeType value);

    TaxExemptionReasonType getTaxExemptionReason();

    void setTaxExemptionReason(TaxExemptionReasonType value);

    TierRangeType getTierRange();

    void setTierRange(TierRangeType value);

    TierRatePercentType getTierRatePercent();

    void setTierRatePercent(TierRatePercentType value);

    TaxSchemeType getTaxScheme();

    void setTaxScheme(TaxSchemeType value);

    String getId();

    void setId(String value);

}
