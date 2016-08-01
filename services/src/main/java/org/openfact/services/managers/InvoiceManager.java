package org.openfact.services.managers;

import org.openfact.Config;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;

/**
 * Created by Gissela-Sistemas on 26/07/2016.
 */
public class InvoiceManager {

    protected OpenfactSession session;
    protected InvoiceProvider model;

    public InvoiceManager(OpenfactSession session) {
        this.session = session;
        this.model = session.invoices();
    }

    public OpenfactSession getSession() {
        return session;
    }

    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        boolean removed = model.removeInvoice(invoice.getOrganization(), invoice);
        return removed;
    }

}
