package org.openfact.models;

import java.math.BigDecimal;
import java.util.Set;

public interface InvoiceLineModel {

    String getId();

    int getOrderNumber();

    void setOrderNumber(int orderNumber);

    BigDecimal getQuantity();

    void setQuantity(BigDecimal quantity);

    String getUnitCode();

    void setUnitCode(String uniCode);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    BigDecimal getExtensionAmmount();

    BigDecimal getAmmount();

    void setAmmount(BigDecimal ammount);

    BigDecimal getAllowanceCharge();

    void setAllowanceCharge(BigDecimal allowanceCharge);

    String getItemDescription();

    void setItemDescription(String itemDescription);

    String getItemIdentification();

    void setItemIdentification(String itemIdentification);

    Set<InvoiceLineTaxTotalModel> getTotalTaxs();

    InvoiceLineTaxTotalModel addTotalTax(String documentName, String documentId, String reasonName, String reasonId, BigDecimal ammount);

    InvoiceModel getInvoice();
}
