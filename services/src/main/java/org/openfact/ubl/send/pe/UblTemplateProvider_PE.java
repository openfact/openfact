package org.openfact.ubl.send.pe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.xml.security.utils.XMLUtils;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.ubl.UblProvider;
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
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLUtils.outputDOM(document, baos, true);
        sendZip(name, baos.toByteArray());
    }

    private void sendZip(String fileName, byte[] bytes) throws UblSenderException {
        try {
            byte[] zip = ZipBuilder.createZipInMemory().add(bytes).save().addFolder("dummy").toBytes();
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

    private String generateXmlFileName(InvoiceModel invoice) {
        return invoice.getID();
    }

    private String generateXmlFileName(CreditNoteModel creditNote) {
        return creditNote.getID();
    }

    private String generateXmlFileName(DebitNoteModel debitNote) {
        return debitNote.getID();
    }

}
