package org.openfact.ubl.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.openfact.models.OrganizationModel;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportTemplateProvider;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class JasperReportTemplateProvider<T> implements ReportTemplateProvider<T> {

    public final static String OF_ORGANIZATION= "OF_ORGANIZATION";

    protected OrganizationModel organization;
    protected final Map<String, Object> parameters = new HashMap<>();
    protected String themeName;

    @Override
    public ReportTemplateProvider setOrganization(OrganizationModel organization) {
        this.organization = organization;

        this.parameters.put(OF_ORGANIZATION.toString(), organization.getName());
        if (organization.getDefaultLocale() != null) {
            parameters.put(JRParameter.REPORT_LOCALE, new Locale(organization.getDefaultLocale()));
        }

        if (organization.getReportTheme() != null) {
            this.themeName = organization.getReportTheme();
        }
        return this;
    }

    @Override
    public ReportTemplateProvider setParameter(String name, Object value) {
        this.parameters.put(name, value);
        return this;
    }

    @Override
    public ReportTemplateProvider setThemeName(String themeName) {
        this.themeName = themeName;
        return this;
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
