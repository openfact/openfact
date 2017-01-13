/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.ubl;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.openfact.models.*;
import org.openfact.models.enums.DocumentType;
import org.openfact.report.*;

import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class JasperUBLReportProvider implements UBLReportProvider {

    private final Map<String, Object> attributes = new HashMap<>();
    private OpenfactSession session;
    private JasperReportUtil jasperReport;
    private OrganizationModel organization;
    private String themeName;

    public JasperUBLReportProvider(OpenfactSession session, JasperReportUtil jasperReport) {
        this.session = session;
        this.jasperReport = jasperReport;
    }

    private List<UBLReportDataProvider> getDataProviders() {
        List<UBLReportDataProvider> providers = new LinkedList<>();

        for (UBLReportDataProvider p : session.getAllProviders(UBLReportDataProvider.class)) {
            providers.add(p);
        }

        Collections.sort(providers, new Comparator<UBLReportDataProvider>() {
            @Override
            public int compare(UBLReportDataProvider o1, UBLReportDataProvider o2) {
                return o2.getProviderPriority() - o1.getProviderPriority();
            }
        });

        return providers;
    }

    public byte[] export(final JasperPrint print, ExportFormat format) throws JRException {
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

    @Override
    public void close() {
    }

    @Override
    public ReportTemplateProvider<InvoiceModel> invoice() {
        return new JasperReportTemplateProvider<InvoiceModel>() {
            @Override
            public byte[] getReportAsPdf(InvoiceModel invoice) throws ReportException {
                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.ADMIN);
                    Locale locale = organization.getDefaultLocale() != null ? new Locale(organization.getDefaultLocale()) : Locale.ENGLISH;
                    attributes.put(JRParameter.REPORT_LOCALE, locale);

                    // Data providers
                    List<UBLReportDataProvider> dataProviders = getDataProviders();

                    // Put parameters
                    for (UBLReportDataProvider provider : dataProviders) {
                        attributes.putAll(provider.invoice().getParameters(organization, invoice));
                    }

                    // Put datasource
                    JasperPrint jp = jasperReport.processReport(theme, Templates.getTemplate(ReportTheme.Type.ADMIN, DocumentType.INVOICE), attributes, new BasicJRDataSource<InvoiceModel>(Arrays.asList(invoice)) {
                        @Override
                        public Object getFieldValue(JRField jrField) throws JRException {
                            InvoiceModel current = super.dataSource.get(super.current.get() - 1);

                            Object fieldValue = null;
                            for (UBLReportDataProvider provider : dataProviders) {
                                fieldValue = provider.invoice().getFieldValue(invoice, jrField.getName());
                                if(fieldValue != null) break;
                            }
                            return fieldValue;
                        }
                    });

                    return export(jp, ExportFormat.PDF);
                } catch (Exception e) {
                    throw new ReportException("Failed to template report", e);
                }
            }

            @Override
            public byte[] getReportAsPdf(List<InvoiceModel> t) throws ReportException {
                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.ADMIN);
                    attributes.put(JRParameter.REPORT_LOCALE, new Locale(organization.getDefaultLocale()));

                    JasperPrint jp = jasperReport.processReport(theme, Templates.getTemplate(ReportTheme.Type.ADMIN, DocumentType.INVOICE), attributes, new JREmptyDataSource());
                    return JasperExportManager.exportReportToPdf(jp);
                } catch (Exception e) {
                    throw new ReportException("Failed to template report", e);
                }
            }

            @Override
            public byte[] getReport(InvoiceModel invoice, ExportFormat exportFormat) throws ReportException {
                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.ADMIN);
                    Locale locale = organization.getDefaultLocale() != null ? new Locale(organization.getDefaultLocale()) : Locale.ENGLISH;
                    attributes.put(JRParameter.REPORT_LOCALE, locale);

                    // Data providers
                    List<UBLReportDataProvider> dataProviders = getDataProviders();

                    // Put parameters
                    for (UBLReportDataProvider provider : dataProviders) {
                        attributes.putAll(provider.invoice().getParameters(organization, invoice));
                    }

                    // Put datasource
                    JasperPrint jp = jasperReport.processReport(theme, Templates.getTemplate(ReportTheme.Type.ADMIN, DocumentType.INVOICE), attributes, new BasicJRDataSource<InvoiceModel>(Arrays.asList(invoice)) {
                        @Override
                        public Object getFieldValue(JRField jrField) throws JRException {
                            InvoiceModel current = super.dataSource.get(super.current.get() - 1);

                            Object fieldValue = null;
                            for (UBLReportDataProvider provider : dataProviders) {
                                fieldValue = provider.invoice().getFieldValue(invoice, jrField.getName());
                                if(fieldValue != null) break;
                            }
                            return fieldValue;
                        }
                    });

                    return export(jp, exportFormat);
                } catch (Exception e) {
                    throw new ReportException("Failed to template report", e);
                }
            }

            @Override
            public byte[] getReport(List<InvoiceModel> t, ExportFormat exportFormat) throws ReportException {
                return new byte[0];
            }
        };
    }

    @Override
    public ReportTemplateProvider<CreditNoteModel> creditNote() {
        return new JasperReportTemplateProvider<CreditNoteModel>() {
            @Override
            public byte[] getReportAsPdf(CreditNoteModel creditNoteModel) throws ReportException {
                return new byte[0];
            }

            @Override
            public byte[] getReportAsPdf(List<CreditNoteModel> t) throws ReportException {
                return new byte[0];
            }

            @Override
            public byte[] getReport(CreditNoteModel creditNoteModel, ExportFormat exportFormat) throws ReportException {
                return new byte[0];
            }

            @Override
            public byte[] getReport(List<CreditNoteModel> t, ExportFormat exportFormat) throws ReportException {
                return new byte[0];
            }
        };
    }

    @Override
    public ReportTemplateProvider<DebitNoteModel> debitNote() {
        return new JasperReportTemplateProvider<DebitNoteModel>() {
            @Override
            public byte[] getReportAsPdf(DebitNoteModel debitNoteModel) throws ReportException {
                return new byte[0];
            }

            @Override
            public byte[] getReportAsPdf(List<DebitNoteModel> t) throws ReportException {
                return new byte[0];
            }

            @Override
            public byte[] getReport(DebitNoteModel debitNoteModel, ExportFormat exportFormat) throws ReportException {
                return new byte[0];
            }

            @Override
            public byte[] getReport(List<DebitNoteModel> t, ExportFormat exportFormat) throws ReportException {
                return new byte[0];
            }
        };
    }

    static abstract class BasicJRDataSource<T> implements JRDataSource {
        protected CopyOnWriteArrayList<T> dataSource = new CopyOnWriteArrayList<T>();
        protected AtomicInteger current = new AtomicInteger();

        public BasicJRDataSource(List<T> data) {
            this.current.set(0);
            this.dataSource.addAll(data);
        }

        @Override
        public boolean next() throws JRException {
            return current.getAndIncrement() < this.dataSource.size();
        }
    }

    abstract class JasperReportTemplateProvider<T> implements ReportTemplateProvider<T> {

        @Override
        public ReportTemplateProvider setOrganization(OrganizationModel org) {
            organization = org;
            return this;
        }

        @Override
        public ReportTemplateProvider setAttribute(String name, Object value) {
            attributes.put(name, value);
            return this;
        }

        @Override
        public ReportTemplateProvider setThemeName(String theme) {
            themeName = theme;
            return this;
        }

        @Override
        public void close() {
        }
    }

    static class Templates {
        public static String getTemplate(ReportTheme.Type type, DocumentType documentType) {
            switch (documentType) {
                case INVOICE:
                    return "invoice.jrxml";
                case CREDIT_NOTE:
                    return "credit_note.jrxml";
                case DEBIT_NOTE:
                    return "debit_note.jrxml";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

}
