package org.openfact.report;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.report.theme.JasperReportUtil;
import org.openfact.representations.idm.report.InvoiceReport;

public class DefaultInvoiceReportProvider implements ReportProvider {

	protected OpenfactSession session;

	public DefaultInvoiceReportProvider(OpenfactSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}

	@Override
	public byte[] processReport(Object model, ReportTheme theme) throws Exception {
		/*InvoiceModel invoice = (InvoiceModel) model;
		List<InvoiceReport> data = new ArrayList<>();
		InvoiceReport to = ModelToReport.toReport(invoice);
		data.add(to);
		JasperReportUtil reportUtil = new JasperReportUtil();
		String path = theme.getTemplate(theme.getName()).getPath();
		byte[] report = reportUtil.processReportTheme(null, path, theme, data);
		return report;*/
	    return null;
	}

}
