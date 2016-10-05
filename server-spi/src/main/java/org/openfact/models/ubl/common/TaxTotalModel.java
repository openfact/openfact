package org.openfact.models.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public interface TaxTotalModel {

    BigDecimal getTaxAmount();

    void setTaxAmount(BigDecimal value);

    BigDecimal getRoundingAmount();

    void setRoundingAmount(BigDecimal value);

    boolean getTaxEvidenceIndicator();

    void setTaxEvidenceIndicator(boolean value);

    List<TaxSubtotalModel> getTaxSubtotal();

    void setTaxSubtotal(List<TaxSubtotalModel> taxSubtotal);

    String getId();

    

    /**
     * */
    TaxSubtotalModel addTaxSubtotal();

}
