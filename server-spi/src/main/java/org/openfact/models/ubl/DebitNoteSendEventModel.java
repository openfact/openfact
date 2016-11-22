package org.openfact.models.ubl;

import java.util.List;

public interface DebitNoteSendEventModel extends SendEventModel {
	List<DebitNoteModel> getDebitNotes();

	void setInvoices(List<DebitNoteModel> debitNotes);
}
