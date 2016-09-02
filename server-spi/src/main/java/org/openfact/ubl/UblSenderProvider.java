package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.models.InvoiceModel;
import org.openfact.provider.Provider;
import org.w3c.dom.Document;

public interface UblSenderProvider extends Provider {

    void send(OrganizationModel organization, InvoiceModel invoice, Document document) throws UblException;

}
