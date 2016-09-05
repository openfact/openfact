package org.openfact.email;

import org.openfact.events.Event;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;

public interface EmailTemplateProvider extends Provider {

    public EmailTemplateProvider setOrganization(OrganizationModel organization);

    public EmailTemplateProvider setInvoice(InvoiceModel invoice);

    public EmailTemplateProvider setAttribute(String name, Object value);

    public void sendEvent(Event event) throws EmailException;

    public void sendReceip() throws EmailException;

}
