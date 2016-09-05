package org.openfact.ubl;

import org.openfact.models.InvoiceModel;
import org.openfact.provider.Provider;
import org.w3c.dom.Document;

public interface UblProvider extends Provider {

    public Document getDocument(String ublRepresentation);

    public Document getDocument(InvoiceModel invoice);

}