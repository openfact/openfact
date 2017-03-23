package org.openfact.ubl.report.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.openfact.models.DocumentModel;
import org.openfact.report.*;
import org.openfact.report.ReportProviderType.ProviderType;
import org.openfact.ubl.data.UBLReportDataProvider;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.net.URL;

@Stateless
public class JasperUBLReportProvider implements ReportTemplateProvider {

    @Inject
    private JasperReportUtil jasperReport;

    @Inject
    @ReportProviderType(type = ProviderType.EXTENDING)
    private ReportThemeProvider themeProvider;

    @Inject
    @Any
    private Instance<UBLReportDataProvider> reportDataProviders;

    static class Templates {
        public static String getTemplate(ReportTheme.Type type, DocumentModel document) {
            StringBuilder sb = new StringBuilder();
            for (String s : document.getDocumentType().toString().toLowerCase().split("_")) {
                sb.append(s);
            }
            return sb.toString();
        }
    }

    @Override
    public byte[] getReport(ReportTemplateConfiguration config, DocumentModel document, ExportFormat exportFormat) throws ReportException {
        try {
            String templateName = Templates.getTemplate(ReportTheme.Type.ADMIN, document);
            BasicJRDataSource dataSource = new BasicJRDataSource<DocumentModel>(document) {
                @Override
                public Object getFieldValue(JRField jrField) throws JRException {
                    DocumentModel row = super.dataSource.get(super.current.get() - 1);

                    Object fieldValue = null;
                    for (UBLReportDataProvider provider : reportDataProviders) {
                        fieldValue = provider.getFieldValue(row, jrField.getName());
                        if (fieldValue != null)
                            break;
                    }
                    return fieldValue;
                }
            };

            ReportTheme theme = null;
            if (config.getThemeName() == null && config.getOrganization().getReportTheme() != null) {
                theme = themeProvider.getTheme(config.getOrganization().getReportTheme(), ReportTheme.Type.ADMIN);
                URL url = theme.getTemplate(templateName + ".jrxml");
                if (url == null) {
                    theme = null;
                }
            }

            if (theme == null) {
                theme = themeProvider.getTheme(config.getThemeName(), ReportTheme.Type.ADMIN);
                URL url = theme.getTemplate(templateName + ".jrxml");
                if (url == null) {
                    theme = null;
                }
            }

            if (theme == null) {
                theme = themeProvider.getTheme(null, ReportTheme.Type.ADMIN);
            }

            JasperPrint jasperPrint = jasperReport.processReport(theme, templateName, config.getAttributes(), dataSource);
            return export(jasperPrint, exportFormat);
        } catch (Exception e) {
            throw new ReportException("Failed to template report", e);
        }
    }

    protected byte[] export(final JasperPrint print, ExportFormat format) throws JRException {
        final Exporter exporter;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        boolean html = false;
        switch (format) {
            case HTML:
                exporter = new HtmlExporter();
                exporter.setExporterOutput(new SimpleHtmlExporterOutput(out));
                html = true;
                break;
            case PDF:
                exporter = new JRPdfExporter();
                break;
            default:
                throw new JRException("Unknown report format: " + format.toString());
        }

        if (!html) {
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
        }

        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.exportReport();

        return out.toByteArray();
    }

}
