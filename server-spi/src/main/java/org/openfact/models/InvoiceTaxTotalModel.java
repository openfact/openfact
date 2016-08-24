package org.openfact.models;

import java.math.BigDecimal;

/**
 * @author carlosthe19916@sistcoop.com
 */

public interface InvoiceTaxTotalModel {

    String getId();

    DocumentSnapshotModel getDocument();

    BigDecimal getAmount();

    void setAmount(BigDecimal ammount);

    BigDecimal getValue();

    void setValue(BigDecimal value);

}
