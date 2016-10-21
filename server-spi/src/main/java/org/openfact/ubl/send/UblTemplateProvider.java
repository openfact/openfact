package org.openfact.ubl.send;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.InternetMediaType;
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

	public void sendInvoice(List<InvoiceModel> invoices) throws UblSenderException;

	public void sendCreditNote(CreditNoteModel creditNote) throws UblSenderException;

	public void sendDebitNote(DebitNoteModel debitNote) throws UblSenderException;

}
