package org.openfact.ubl;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class DefaultUblProvider implements UblProvider {

    protected OpenfactSession session;

    public DefaultUblProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public Document getDocument(OrganizationModel organization, InvoiceModel invoice) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Document getDocument(OrganizationModel organization, CreditNoteModel creditNote) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Document getDocument(OrganizationModel organization, DebitNoteModel debitNote) {
        // TODO Auto-generated method stub
        return null;
    }

}
