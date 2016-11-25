package org.openfact.ubl;

import java.util.List;
import java.util.Map;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.provider.Provider;

public interface UblSendEventProvider extends Provider {
	SendEventModel addInvoiceSendEvent(OrganizationModel organization, InvoiceModel invoice, boolean isAccepted)
			throws UblSenderException;

	SendEventModel addCreditNoteSendEvent(OrganizationModel organization, CreditNoteModel creditNote,
			boolean isAccepted) throws UblSenderException;

	SendEventModel addDebitNoteSendEvent(OrganizationModel organization, DebitNoteModel debitNote, boolean isAccepted)
			throws UblSenderException;

	List<SendEventModel> getInvoiceSendEvents(OrganizationModel organization, InvoiceModel invoice)
			throws UblSenderException;

	List<SendEventModel> getCreditNoteSendEvents(OrganizationModel organization, CreditNoteModel creditNote)
			throws UblSenderException;

	List<SendEventModel> getDebitNoteSendEvents(OrganizationModel organization, DebitNoteModel debitNote)
			throws UblSenderException;

}
