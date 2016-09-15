package org.openfact.models.ubl.common;

import java.util.List;

public interface TaxTotalType {

    TaxAmountType getTaxAmount();

    void setTaxAmount(TaxAmountType value);

    RoundingAmountType getRoundingAmount();

    void setRoundingAmount(RoundingAmountType value);

    TaxEvidenceIndicatorType getTaxEvidenceIndicator();

    void setTaxEvidenceIndicator(TaxEvidenceIndicatorType value);

    List<TaxSubtotalType> getTaxSubtotal();

    void setTaxSubtotal(List<TaxSubtotalType> taxSubtotal);

    String getId();

    void setId(String value);

}
