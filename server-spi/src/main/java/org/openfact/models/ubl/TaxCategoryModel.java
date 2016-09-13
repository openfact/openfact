package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface TaxCategoryModel {

    MeasureType getBaseUnitMeasure();

    void setBaseUnitMeasure(MeasureType baseUnitMeasure);

    IdentifierType getID();

    void setID(IdentifierType iD);

    NameType getName();

    void setName(NameType name);

    BigDecimal getPercent();

    void setPercent(BigDecimal percent);

    BigDecimal getPerUnitAmount();

    void setPerUnitAmount(BigDecimal perUnitAmount);

    TextType getTaxExemptionReason();

    void setTaxExemptionReason(TextType taxExemptionReason);

    CodeType getTaxExemptionReasonCode();

    void setTaxExemptionReasonCode(CodeType taxExemptionReasonCode);

    TextType getTierRange();

    void setTierRange(TextType tierRange);

    BigDecimal getTierRatePercent();

    void setTierRatePercent(BigDecimal tierRatePercent);

    TaxSchemeModel getTaxScheme();

    void setTaxScheme(TaxSchemeModel taxScheme);
}
