package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.List;

public interface TaxTotalModel {

    BigDecimal getRoundingAmount();

    void setRoundingAmount(BigDecimal roundingAmount);

    BigDecimal getTaxAmount();

    void setTaxAmount(BigDecimal taxAmount);

    boolean isTaxEvidenceIndicator();

    void setTaxEvidenceIndicator(boolean taxEvidenceIndicator);

    boolean isTaxIncludedIndicator();

    void setTaxIncludedIndicator(boolean taxIncludedIndicator);

    List<TaxSubtotalModel> getTaxSubtotals();

    void setTaxSubtotals(List<TaxSubtotalModel> taxSubtotals);

    TaxSubtotalModel addTaxSubtotal();

}
