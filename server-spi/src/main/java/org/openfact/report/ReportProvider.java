package org.openfact.report;

import java.util.Collection;
import java.util.Map;

import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface ReportProvider extends Provider {
	byte[] processReport(InvoiceModel invoice) throws Exception;

	byte[] processReport(CreditNoteModel creditNote) throws Exception;

	byte[] processReport(DebitNoteModel debitNoteModel) throws Exception;

	byte[] processReport(Map<String, Object> parameters, String templateName, ReportTheme theme, Collection<?> data)
			throws Exception;
}
