package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface AmountModel {

    BigDecimal getValue();

    void setValue(BigDecimal value);

    CurrencyCodeContentModel getCurrencyID();

    void setCurrencyID(CurrencyCodeContentModel value);

    String getId();

    void setId(String value);

}
