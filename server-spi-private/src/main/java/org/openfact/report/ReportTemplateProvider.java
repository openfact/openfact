package org.openfact.report;

import org.openfact.models.DocumentModel;

public interface ReportTemplateProvider {

    byte[] getReport(ReportTemplateConfiguration config, DocumentModel document, ExportFormat exportFormat) throws ReportException;

}
