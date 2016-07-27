package org.openfact.services.managers;

import org.openfact.Config;
import org.openfact.models.InvoiceModel;
import org.openfact.models.InvoiceProvider;
import org.openfact.models.OpenfactSession;


/**
 * Created by Gissela-Sistemas on 26/07/2016.
 */
public class InvoiceManager {
    protected OpenfactSession session;
    protected InvoiceProvider model;
    protected String contextPath = "";

    public InvoiceManager(OpenfactSession session) {
        this.session = session;
        this.model = session.invoices();
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public OpenfactSession getSession() {
        return session;
    }

    public boolean removeInvoice(InvoiceModel invoice) {
                boolean removed=model.removeInvoice(invoice.getOrganization(), invoice);
        return removed;
    }

//
//    public InvoiceModel getOpenfactAdminstrationOrganization() {
//        return getInvoice(Config.getAdminOrganization());}
//
//    public InvoiceModel getInvoice(String id){
//        return model.getInvoice(id);
//    }


}
