package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface AmountType {

    BigDecimal getValue();

    void setValue(BigDecimal value);

    CurrencyCodeContentType getCurrencyID();

    void setCurrencyID(CurrencyCodeContentType value);

    String getId();

    void setId(String value);

}
