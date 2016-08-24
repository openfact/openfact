package org.openfact.models;

import java.math.BigDecimal;

/**
 * @author carlosthe19916@sistcoop.com
 */

public interface InvoiceAdditionalInformationModel {

    String getId();

    BigDecimal getAmmount();

    void setAmmount(BigDecimal ammount);

    DocumentSnapshotModel getDocument();

    void setDocument(String documentName, String documentId);   

    InvoiceModel getInvoice();

}
