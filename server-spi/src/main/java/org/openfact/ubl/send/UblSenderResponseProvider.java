package org.openfact.ubl.send;

import java.util.List;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface UblSenderResponseProvider extends Provider {

	public UblSenderResponseProvider setOrganization(OrganizationModel organization);

	public void senderDocumentResponse(byte[] xmlDocument, byte[] eventDocument, String typeDocument, String... fault)
			throws UblSenderException;

	public void senderInvoiceResponse(List<InvoiceModel> invoices, byte[] xmlDocument, byte[] eventDocument,
			String... fault) throws UblSenderException;

	public void senderCreditNoteResponse(CreditNoteModel creditNote, byte[] eventDocument, String... fault)
			throws UblSenderException;

	public void senderDebitNoteResponse(DebitNoteModel debitNote, byte[] eventDocument, String... fault)
			throws UblSenderException;
}
