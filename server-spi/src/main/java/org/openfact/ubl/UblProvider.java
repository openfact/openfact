package org.openfact.ubl;

import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;
import org.w3c.dom.Document;

public interface UblProvider extends Provider {

    public Document getDocument(OrganizationModel organization, InvoiceModel invoice) throws UblException;

}