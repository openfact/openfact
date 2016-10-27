package org.openfact.ubl.send.pe;

import java.util.Arrays;
import java.util.List;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequeridActionDocument;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;

public class UblTaskRunnerReader {
	private OpenfactSession session;
	private OrganizationModel organization;

	public UblTaskRunnerReader(OpenfactSession session, OrganizationModel organization) {
		this.organization = organization;
		this.session = session;
	}

	public List<InvoiceModel> getInvoiceReader(boolean intoRequeridAction) {
		List<InvoiceModel> invoices = session.invoices().getInvoices(organization,
				Arrays.asList(RequeridActionDocument.SEND_SOA_XML_DOCUMENT), intoRequeridAction);
		return invoices;
	}

	public List<CreditNoteModel> getCreditNoteReader(boolean intoRequeridAction) {
		List<CreditNoteModel> creditNotes = session.creditNotes().getCreditNotes(organization,
				Arrays.asList(RequeridActionDocument.SEND_SOA_XML_DOCUMENT), intoRequeridAction);
		return creditNotes;
	}

	public List<DebitNoteModel> getDebitNoteReader(boolean intoRequeridAction) {
		List<DebitNoteModel> debitNotes = session.debitNotes().getDebitNotes(organization,
				Arrays.asList(RequeridActionDocument.SEND_SOA_XML_DOCUMENT), intoRequeridAction);
		return debitNotes;
	}

}
