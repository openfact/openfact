package org.openfact.ubl.send.pe;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.DocumentUtils;
import org.openfact.ubl.UblProvider;
import org.openfact.ubl.pe.constants.CodigoTipoDocumento;
import org.openfact.ubl.send.UblSenderException;
import org.openfact.ubl.send.UblSenderProvider;
import org.openfact.ubl.send.UblTemplateProvider;
import org.w3c.dom.Document;

import jodd.io.ZipBuilder;

public class UblTemplateProvider_PE implements UblTemplateProvider {

    private OpenfactSession session;
    private OrganizationModel organization;

    public UblTemplateProvider_PE(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public UblTemplateProvider setOrganization(OrganizationModel organization) {
        this.organization = organization;
        return this;
    }

    @Override
    public void send(String type) throws UblSenderException {
        throw new ModelException("method not implemented");
    }

    @Override
    public void sendInvoice(InvoiceModel invoice) throws UblSenderException {
        Document document = getUblProvider(organization).getDocument(organization, invoice);
        send(document, generateXmlFileName(invoice));
    }

    @Override
    public void sendCreditNote(CreditNoteModel creditNote) throws UblSenderException {
        Document document = getUblProvider(organization).getDocument(organization, creditNote);
        send(document, generateXmlFileName(creditNote));
    }

    @Override
    public void sendDebitNote(DebitNoteModel debitNote) throws UblSenderException {
        Document document = getUblProvider(organization).getDocument(organization, debitNote);
        send(document, generateXmlFileName(debitNote));
    }

    private void send(Document document, String name) throws UblSenderException {        
        try {                        
            sendZip(name, DocumentUtils.getBytesFromDocument(document));
        } catch (TransformerException e) {
            throw new UblSenderException("Invalid document", e);
        }        
    }

    private void sendZip(String fileName, byte[] bytes) throws UblSenderException {
        try {
            byte[] zip = ZipBuilder.createZipInMemory()                                    
                    .add(bytes)
                    .path(fileName)
                    .save()   

                    .addFolder("dummy")                    
                    
                    .toBytes();

            send(fileName, zip, "application/zip");
        } catch (IOException e) {
            throw new UblSenderException("Failed to template ubl", e);
        }
    }

    private UblProvider getUblProvider(OrganizationModel organization) {
        return session.getProvider(UblProvider.class, organization.getDefaultUblLocale());
    }

    private void send(String fileName, byte[] file, String contentType) throws UblSenderException {
        UblSenderProvider ublSender = session.getProvider(UblSenderProvider.class, "soap");
        ublSender.send(organization, fileName, file, contentType);
    }

    private String generateXmlFileName(InvoiceModel invoice) throws UblSenderException {
        if(organization.getAssignedIdentificationId() == null) {
            throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
        }
        
        String codido;
        if (invoice.getInvoiceTypeCode().equals(CodigoTipoDocumento.FACTURA.getCodigo())) {
            codido = CodigoTipoDocumento.FACTURA.getCodigo();
        } else if (invoice.getInvoiceTypeCode().equals(CodigoTipoDocumento.BOLETA.getCodigo())) {
            codido = CodigoTipoDocumento.BOLETA.getCodigo();
        } else {
            throw new UblSenderException("Invalid invoice code", new Throwable());
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(organization.getAssignedIdentificationId()).append("-");
        sb.append(codido).append("-");
        sb.append(invoice.getID());
        sb.append(".xml");
        return sb.toString();
    }

    private String generateXmlFileName(CreditNoteModel creditNote) throws UblSenderException {
        if(organization.getAssignedIdentificationId() == null) {
            throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
        }
        
        String codido = CodigoTipoDocumento.NOTA_CREDITO.getCodigo();
        
        StringBuilder sb = new StringBuilder();
        sb.append(organization.getAssignedIdentificationId()).append("-");
        sb.append(codido).append("-");
        sb.append(creditNote.getID());
        sb.append(".xml");
        return sb.toString();
    }

    private String generateXmlFileName(DebitNoteModel debitNote) throws UblSenderException {
        if(organization.getAssignedIdentificationId() == null) {
            throw new UblSenderException("Organization doesn't have assignedIdentificationId", new Throwable());
        }
        
        String codido = CodigoTipoDocumento.NOTA_CREDITO.getCodigo();
        
        StringBuilder sb = new StringBuilder();
        sb.append(organization.getAssignedIdentificationId()).append("-");
        sb.append(codido).append("-");
        sb.append(debitNote.getID());
        sb.append(".xml");
        return sb.toString();
    }

}
