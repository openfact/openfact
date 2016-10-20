package org.openfact.models.ubl.provider;

import java.util.List;
import java.util.Map;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.ubl.SendEventModel;
import org.openfact.provider.Provider;

public interface SendEventProvider extends Provider {

	SendEventModel addEvent(OrganizationModel organization, List<InvoiceModel> invoices, byte[] xmlDocument,
			byte[] eventDocument,boolean isError, Map<String, String> sendWarning);

	SendEventModel addEvent(OrganizationModel organization, DebitNoteModel debitNote, byte[] xmlDocument,
			byte[] eventDocument,boolean isError, Map<String, String> sendWarning);

	SendEventModel addEvent(OrganizationModel organization, CreditNoteModel creditNote, byte[] xmlDocument,
			byte[] eventDocument,boolean isError, Map<String, String> sendWarning);

	List<SendEventModel> getEvents(OrganizationModel organization, InvoiceModel invoice);

	List<SendEventModel> getEvents(OrganizationModel organization, DebitNoteModel debitNote);

	List<SendEventModel> getEvents(OrganizationModel organization, CreditNoteModel creditNote);
}
