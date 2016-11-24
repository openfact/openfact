package org.openfact.ubl;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.provider.Provider;

public interface UblTemplateProvider extends Provider {

	public SendEventModel sendInvoice(OrganizationModel organization, InvoiceModel invoice) throws UblSenderException;

	public SendEventModel sendInvoices(OrganizationModel organization, List<InvoiceModel> invoices) throws UblSenderException;

	public SendEventModel sendCreditNote(OrganizationModel organization, CreditNoteModel creditNote) throws UblSenderException;

	public SendEventModel sendDebitNote(OrganizationModel organization, DebitNoteModel debitNote) throws UblSenderException;

}