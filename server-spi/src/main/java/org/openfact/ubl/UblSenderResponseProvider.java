package org.openfact.ubl;

import java.util.Map;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.provider.Provider;

public interface UblSenderResponseProvider extends Provider {

	public SendEventModel invoiceSenderResponse(OrganizationModel organization, InvoiceModel invoice, byte[] submitted, Map<String, Object> response,
			String... fault) throws UblSenderException;
	public SendEventModel creditNoteSenderResponse(OrganizationModel organization, CreditNoteModel creditNote, byte[] submitted, Map<String, Object>response,
			String... fault) throws UblSenderException;
	public SendEventModel debitNoteSenderResponse(OrganizationModel organization, DebitNoteModel debitNote, byte[] submitted, Map<String, Object> response,
			String... fault) throws UblSenderException;

}
