package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface TaxCategoryModel {

    MeasureModel getBaseUnitMeasure();

    void setBaseUnitMeasure(MeasureModel baseUnitMeasure);

    IdentifierModel getID();

    void setID(IdentifierModel iD);

    NameModel getName();

    void setName(NameModel name);

    BigDecimal getPercent();

    void setPercent(BigDecimal percent);

    BigDecimal getPerUnitAmount();

    void setPerUnitAmount(BigDecimal perUnitAmount);

    TextModel getTaxExemptionReason();

    void setTaxExemptionReason(TextModel taxExemptionReason);

    CodeModel getTaxExemptionReasonCode();

    void setTaxExemptionReasonCode(CodeModel taxExemptionReasonCode);

    TextModel getTierRange();

    void setTierRange(TextModel tierRange);

    BigDecimal getTierRatePercent();

    void setTierRatePercent(BigDecimal tierRatePercent);

    TaxSchemeModel getTaxScheme();

    void setTaxScheme(TaxSchemeModel taxScheme);
}
