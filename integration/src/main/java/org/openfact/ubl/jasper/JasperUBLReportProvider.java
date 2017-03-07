package org.openfact.ubl.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperPrint;
import org.openfact.models.DocumentModel;
import org.openfact.report.*;
import org.openfact.report.ReportProviderType.ProviderType;
import org.openfact.ubl.UBLReportDataProvider;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class JasperUBLReportProvider extends JasperReportTemplateProvider implements ReportTemplateProvider {

    private JasperReportUtil jasperReport;
    private List<UBLReportDataProvider> dataProviders;

    @Inject
    @Any
    private Instance<UBLReportDataProvider> providers;

    @Inject
    @ReportProviderType(type = ProviderType.EXTENDING)
    private ReportThemeProvider themeProvider;

    @PostConstruct
    private void init() {
        jasperReport = new JasperReportUtil();

        this.dataProviders = new LinkedList<>();

        Iterator<UBLReportDataProvider> it = dataProviders.iterator();
        while (it.hasNext()) {
            UBLReportDataProvider ublReportDataProvider = (UBLReportDataProvider) it.next();
            dataProviders.add(ublReportDataProvider);

        }
        Collections.sort(dataProviders, (o1, o2) -> o2.getProviderPriority() - o1.getProviderPriority());
    }

    static class Templates {
        public static String getTemplate(ReportTheme.Type type, DocumentModel document) {
            StringBuilder sb = new StringBuilder();
            for (String s : document.getDocumentType().toString().toLowerCase().split("_")) {
                sb.append(s);
            }
            return sb.append(".jrxml").toString();
        }
    }

    @Override
    public byte[] getReport(DocumentModel document, ExportFormat exportFormat) throws ReportException {
        try {
            String templateName = Templates.getTemplate(ReportTheme.Type.ADMIN, document);
            BasicJRDataSource dataSource = new BasicJRDataSource<DocumentModel>(document) {
                @Override
                public Object getFieldValue(JRField jrField) throws JRException {
                    DocumentModel row = super.dataSource.get(super.current.get() - 1);

                    Object fieldValue = null;
                    for (UBLReportDataProvider provider : dataProviders) {
                        fieldValue = provider.document().getFieldValue(row, jrField.getName());
                        if (fieldValue != null)
                            break;
                    }
                    return fieldValue;
                }
            };

            ReportTheme theme = null;
            if (themeName == null && organization.getReportTheme() != null) {
                theme = themeProvider.getTheme(organization.getReportTheme(), ReportTheme.Type.ADMIN);
                URL url = theme.getTemplate(templateName);
                if (url == null) {
                    theme = null;
                }
            }

            if (theme == null) {
                theme = themeProvider.getTheme(themeName, ReportTheme.Type.ADMIN);
                URL url = theme.getTemplate(templateName);
                if (url == null) {
                    theme = null;
                }
            }

            if (theme == null) {
                theme = themeProvider.getTheme(null, ReportTheme.Type.ADMIN);
            }

            JasperPrint jasperPrint = jasperReport.processReport(theme, templateName, parameters,
                    dataSource);
            return export(jasperPrint, exportFormat);
        } catch (Exception e) {
            throw new ReportException("Failed to template report", e);
        }
    }

}
