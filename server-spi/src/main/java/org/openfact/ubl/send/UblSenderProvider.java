package org.openfact.ubl.send;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface UblSenderProvider extends Provider {

	void send(OrganizationModel organization, InvoiceModel invoice, byte[] document, String contentType, String name)
			throws UblSenderException;

	void send(OrganizationModel organization, DebitNoteModel debitNote, byte[] document, String contentType,
			String name) throws UblSenderException;

	void send(OrganizationModel organization, CreditNoteModel creditNote, byte[] document, String contentType,
			String name) throws UblSenderException;

	void send(OrganizationModel organization, byte[] document, String contentType, String name)
			throws UblSenderException;
}
