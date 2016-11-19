package org.openfact.report;

import java.util.Collection;
import java.util.Map;

import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.provider.Provider;

public interface ReportProvider extends Provider {
	byte[] processReport(Object model,  ReportTheme theme) throws Exception;
}
