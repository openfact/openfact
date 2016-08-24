package org.openfact.models;

import java.math.BigDecimal;

public interface ValuableDocumentModel extends DocumentModel {

    BigDecimal getValue();

    void setValue(BigDecimal value);

}
