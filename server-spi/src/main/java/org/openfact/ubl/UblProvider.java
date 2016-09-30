package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;
import org.w3c.dom.Document;

public interface UblProvider extends Provider {

    Document getDocument(OrganizationModel organization, InvoiceModel invoice);

    Document getDocument(OrganizationModel organization, CreditNoteModel creditNote);

    Document getDocument(OrganizationModel organization, DebitNoteModel debitNote);

}