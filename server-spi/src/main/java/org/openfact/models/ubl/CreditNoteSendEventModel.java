package org.openfact.models.ubl;

import java.util.List;

public interface CreditNoteSendEventModel extends SendEventModel {
	List<CreditNoteModel> getCreditNotes();

	void setInvoices(List<CreditNoteModel> creditNotes);
}
