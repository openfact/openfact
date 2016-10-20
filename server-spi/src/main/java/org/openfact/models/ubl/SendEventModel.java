package org.openfact.models.ubl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface SendEventModel {
	String getId();

	List<InvoiceModel> getInvoices();

	void setInvoices(List<InvoiceModel> invoices);

	List<CreditNoteModel> getCreditNotes();

	void setCreditNotes(List<CreditNoteModel> creditNotes);

	List<DebitNoteModel> getDebitNotes();

	void setDebitNotes(List<DebitNoteModel> debitNotes);

	byte[] getXmlDoument();

	void setXmlDocument(byte[] xmlDocument);

	byte[] getEventDoument();

	void setEventDocument(byte[] eventDocument);

	Map<String, String> getSendWarning();

	void setSendWarning(Map<String, String> sendWarning);

	LocalDateTime getCreatedTimestamp();

	void setCreatedTimestamp(LocalDateTime localDateTime);

}
