package org.openfact.models;

import java.math.BigDecimal;

public interface InvoiceLineModel {

    String getId();

    BigDecimal getQuantity();

    void setQuantity(BigDecimal ammount);

    BigDecimal getAmmount();

    void setAmmount(BigDecimal ammount);

    String getDescription();

    void setDescription(String description);

    InvoiceModel getInvoice();

}
