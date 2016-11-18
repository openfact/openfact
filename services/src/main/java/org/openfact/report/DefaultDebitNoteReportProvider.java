package org.openfact.report;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.OpenfactSession;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.utils.ModelToReport;
import org.openfact.report.theme.JasperReportUtil;
import org.openfact.representations.idm.report.DebitNoteReport;

public class DefaultDebitNoteReportProvider implements ReportProvider {

	protected OpenfactSession session;

	public DefaultDebitNoteReportProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {

	}

	@Override
	public byte[] processReport(Object model, ReportTheme theme) throws Exception {
		DebitNoteModel debitNote = (DebitNoteModel) model;
		List<DebitNoteReport> data = new ArrayList<>();
		DebitNoteReport to = ModelToReport.toReport(debitNote);
		data.add(to);
		JasperReportUtil reportUtil = new JasperReportUtil();
		String path = theme.getTemplate(theme.getName()).getPath();
		byte[] report = reportUtil.processReportTheme(null, path, theme, data);
		return report;

	}

}
