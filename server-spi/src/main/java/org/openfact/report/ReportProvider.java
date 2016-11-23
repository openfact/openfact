package org.openfact.report;

import java.util.Collection;
import java.util.Map;

import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.provider.Provider;

public interface ReportProvider extends Provider {
	byte[] processReport(Object model,  ReportTheme theme) throws Exception;
}
