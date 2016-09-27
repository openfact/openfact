package org.openfact.ubl.pe;

import javax.xml.datatype.DatatypeConfigurationException;

import org.jboss.logging.Logger;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToType;
import org.openfact.ubl.UblProvider;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21NamespaceContext;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class UblProvider_PE implements UblProvider {

    private static final Logger log = Logger.getLogger(UblProvider_PE.class);

    protected OpenfactSession session;

    public UblProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {

    }

    @Override
    public Document getDocument(OrganizationModel organization, InvoiceModel invoice) {
        try {
            InvoiceType invoiceType = ModelToType.toType(invoice);
            UBL21NamespaceContext namespaceContext = UBL21NamespaceContext.getInstance();
            return UBL21Writer.invoice().setNamespaceContext(namespaceContext).getAsDocument(invoiceType);
        } catch (DatatypeConfigurationException e) {
            log.error(e.getMessage());
            throw new ModelException(e.getMessage());
        }
    }

    @Override
    public Document getDocument(OrganizationModel organization, CreditNoteModel creditNote) {
        try {
            CreditNoteType creditNoteType = ModelToType.toType(creditNote);
            return UBL21Writer.creditNote().getAsDocument(creditNoteType);
        } catch (DatatypeConfigurationException e) {
            log.error(e.getMessage());
            throw new ModelException(e.getMessage());
        }
    }

    @Override
    public Document getDocument(OrganizationModel organization, DebitNoteModel debitNote) {
        try {
            DebitNoteType debitNoteType = ModelToType.toType(debitNote);
            return UBL21Writer.debitNote().getAsDocument(debitNoteType);
        } catch (DatatypeConfigurationException e) {
            log.error(e.getMessage());
            throw new ModelException(e.getMessage());
        }
    }

}
