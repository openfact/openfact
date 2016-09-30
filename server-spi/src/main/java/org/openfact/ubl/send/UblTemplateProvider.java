package org.openfact.ubl.send;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface UblTemplateProvider extends Provider {

    public UblTemplateProvider setOrganization(OrganizationModel organization);

    /**
     * send document
     * 
     */

    public void send(String type) throws UblSenderException;

    public void sendInvoice(InvoiceModel invoice) throws UblSenderException;

    public void sendCreditNote(CreditNoteModel creditNote) throws UblSenderException;

    public void sendDebitNote(DebitNoteModel debitNote) throws UblSenderException;

}
