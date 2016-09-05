package org.openfact.ubl;

import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
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
    public Document getDocument(String ublRepresentation) {
        InvoiceType invoiceType = UBL21Reader.invoice().read(ublRepresentation);
        return UBL21Writer.invoice().getAsDocument(invoiceType);
    }

    @Override
    public Document getDocument(InvoiceModel invoice) {
        InvoiceType invoiceType = ModelToUbl.getInvoiceType(invoice.getOrganization(), invoice);
        return UBL21Writer.invoice().getAsDocument(invoiceType);
    }

}
