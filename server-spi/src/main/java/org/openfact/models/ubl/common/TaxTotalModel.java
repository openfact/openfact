package org.openfact.models.ubl.common;

import java.util.List;

public interface TaxTotalModel {

    TaxAmountModel getTaxAmount();

    void setTaxAmount(TaxAmountModel value);

    RoundingAmountModel getRoundingAmount();

    void setRoundingAmount(RoundingAmountModel value);

    boolean getTaxEvidenceIndicator();

    void setTaxEvidenceIndicator(boolean value);

    List<TaxSubtotalModel> getTaxSubtotal();

    void setTaxSubtotal(List<TaxSubtotalModel> taxSubtotal);

    String getId();

    void setId(String value);

}
