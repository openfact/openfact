package org.openfact.ubl;

import org.openfact.email.EmailException;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface UblTemplateProvider extends Provider {

    public UblTemplateProvider setOrganization(OrganizationModel organization);

    public UblTemplateProvider setInvoice(InvoiceModel invoice);

    public void sendUbl() throws EmailException;

}