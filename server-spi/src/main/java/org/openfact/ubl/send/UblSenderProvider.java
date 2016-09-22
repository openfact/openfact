package org.openfact.ubl.send;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface UblSenderProvider extends Provider {

	void send(OrganizationModel orgamization, InvoiceModel invoice, byte[] document, String name)
			throws UblSenderException;

	void send(OrganizationModel orgamization, DebitNoteModel debitNote, byte[] document, String name)
			throws UblSenderException;

	void send(OrganizationModel orgamization, CreditNoteModel creditNote, byte[] document, String name)
			throws UblSenderException;

	void send(OrganizationModel orgamization, byte[] document, String name) throws UblSenderException;
}
