package org.openfact.models;

import java.math.BigDecimal;

public interface DocumentValuableModel extends DocumentComponentModel {

    BigDecimal getValue();

    void setValue(BigDecimal value);

}
