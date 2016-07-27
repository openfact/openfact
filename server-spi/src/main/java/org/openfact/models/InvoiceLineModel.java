package org.openfact.models;

import java.math.BigDecimal;
import java.util.Map;

import org.openfact.models.enums.TaxType;

public interface InvoiceLineModel {

    String getId();

    int getOrderNumber();

    double getQuantity();

    String getUnitCode();

    BigDecimal getPrice();

    BigDecimal getExtensionAmmount();

    BigDecimal getAmmount();

    void setAmmount(BigDecimal ammount);

    BigDecimal getAllowanceCharge();

    void setAllowanceCharge(BigDecimal allowanceCharge);

    String getItemDescription();

    String getItemIdentification();

    void setItemIdentification(String itemIdentification);

    Map<TaxType, BigDecimal> getTaxs();

    InvoiceModel getInvoice();

}
