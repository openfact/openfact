package org.openfact.models;

import java.math.BigDecimal;

/**
 * @author carlosthe19916@sistcoop.com
 */

public interface InvoiceTaxTotalModel {

    String getId();

    DocumentSavedModel getDocument();

    BigDecimal getAmmount();

    void setAmmount(BigDecimal ammount);

    BigDecimal getValue();

    void setValue(BigDecimal value);

}
