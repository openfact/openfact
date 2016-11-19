package org.openfact.report;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.OpenfactSession;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.utils.ModelToReport;
import org.openfact.report.theme.JasperReportUtil;
import org.openfact.representations.idm.report.CreditNoteReport;

public class DefaultCreditNoteReportProvider implements ReportProvider {

	protected OpenfactSession session;

	public DefaultCreditNoteReportProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {

	}

	@Override
	public byte[] processReport(Object model, ReportTheme theme) throws Exception {
		CreditNoteModel creditNote = (CreditNoteModel) model;
		List<CreditNoteReport> data = new ArrayList<>();
		CreditNoteReport to = ModelToReport.toReport(creditNote);
		data.add(to);
		JasperReportUtil reportUtil = new JasperReportUtil();
		String path = theme.getTemplate(theme.getName()).getPath();
		byte[] report = reportUtil.processReportTheme(null, path, theme, data);
		return report;
	}
}
