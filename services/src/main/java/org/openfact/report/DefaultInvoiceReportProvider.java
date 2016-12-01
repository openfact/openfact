/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
