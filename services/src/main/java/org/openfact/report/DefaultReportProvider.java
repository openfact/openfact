package org.openfact.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.openfact.models.OpenfactSession;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToReport;
import org.openfact.representations.idm.report.CreditNoteReport;
import org.openfact.representations.idm.report.DebitNoteReport;
import org.openfact.representations.idm.report.InvoiceReport;

public class DefaultReportProvider implements ReportProvider {

	protected OpenfactSession session;

	public DefaultReportProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}

	@Override
	public byte[] processReport(InvoiceModel invoice) throws Exception {
		List<InvoiceReport> data = new ArrayList<>();
		ReportTheme theme = null;
		InvoiceReport to = ModelToReport.toReport(invoice);
		data.add(to);
		JasperReportUtil reportUtil = new JasperReportUtil();
		byte[] report = reportUtil.processReportTheme(null, "invoice/invoice.jasper", theme, data);
		return report;
	}

	@Override
	public byte[] processReport(CreditNoteModel creditNote) throws Exception {
		List<CreditNoteReport> data = new ArrayList<>();
		ReportTheme theme = null;
		CreditNoteReport to = ModelToReport.toReport(creditNote);
		data.add(to);
		JasperReportUtil reportUtil = new JasperReportUtil();
		byte[] report = reportUtil.processReportTheme(null, "creditnote/creditnote.jasper", theme, data);
		return report;
	}

	@Override
	public byte[] processReport(DebitNoteModel debitNote) throws Exception {
		List<DebitNoteReport> data = new ArrayList<>();
		ReportTheme theme = null;
		DebitNoteReport to = ModelToReport.toReport(debitNote);
		data.add(to);
		JasperReportUtil reportUtil = new JasperReportUtil();
		byte[] report = reportUtil.processReportTheme(null, "debitnote/debitnote.jasper", theme, data);
		return report;
	}

	@Override
	public byte[] processReport(Map<String, Object> parameters, String templateName, ReportTheme theme,
			Collection<?> data) throws Exception {
		JasperReportUtil reportUtil = new JasperReportUtil();
		byte[] report = reportUtil.processReportTheme(parameters, templateName, theme, data);
		return report;
	}
}
