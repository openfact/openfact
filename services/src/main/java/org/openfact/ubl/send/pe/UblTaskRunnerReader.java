package org.openfact.ubl.send.pe;

import java.util.ArrayList;
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
		List<RequeridActionDocument> requeridAction = new ArrayList<>();
		requeridAction.add(RequeridActionDocument.RESPONSE_SENDED_DOCUMENT_OK);
		List<InvoiceModel> invoices = session.invoices().getInvoices(organization, requeridAction, intoRequeridAction);
		return invoices;
	}

	public List<CreditNoteModel> getCreditNoteReader(boolean intoRequeridAction) {
		List<RequeridActionDocument> requeridAction = new ArrayList<>();
		requeridAction.add(RequeridActionDocument.RESPONSE_SENDED_DOCUMENT_OK);
		List<CreditNoteModel> creditNotes = session.creditNotes().getCreditNotes(organization, requeridAction,
				intoRequeridAction);
		return creditNotes;
	}

	public List<DebitNoteModel> getDebitNoteReader(boolean intoRequeridAction) {
		List<RequeridActionDocument> requeridAction = new ArrayList<>();
		requeridAction.add(RequeridActionDocument.RESPONSE_SENDED_DOCUMENT_OK);
		List<DebitNoteModel> debitNotes = session.debitNotes().getDebitNotes(organization, requeridAction,
				intoRequeridAction);
		return debitNotes;
	}

}
