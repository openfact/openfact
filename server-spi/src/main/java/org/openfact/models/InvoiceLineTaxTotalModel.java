package org.openfact.models;

import java.math.BigDecimal;

/**
 * @author carlosthe19916@sistcoop.com
 */

public interface InvoiceLineTaxTotalModel {

    String getId();

    BigDecimal getAmmount();

    void setAmmount(BigDecimal ammount);

    DocumentSavedModel getDocument();

    void setDocument(String documentName, String documentId);

    DocumentSavedModel getReason();

    void setReason(String documentName, String documentId);

    InvoiceLineModel getInvoiceLine();

}
