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
import org.openfact.models.*;
import org.openfact.models.enums.DocumentType;
import org.openfact.report.*;
import org.openfact.ubl.jasper.BasicJRDataSource;
import org.openfact.ubl.jasper.JasperReportTemplateProvider;

import java.util.*;

public class JasperUBLReportProvider implements UBLReportProvider {

    private OpenfactSession session;
    private JasperReportUtil jasperReport;
    private List<UBLReportDataProvider> dataProviders;

    public JasperUBLReportProvider(OpenfactSession session, JasperReportUtil jasperReport) {
        this.session = session;
        this.jasperReport = jasperReport;
        this.init();
    }

    private void init() {
        this.dataProviders = new LinkedList<>();
        this.dataProviders.addAll(session.getAllProviders(UBLReportDataProvider.class));
        Collections.sort(dataProviders, (o1, o2) -> o2.getProviderPriority() - o1.getProviderPriority());
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

    @Override
    public void close() {
    }

    @Override
    public ReportTemplateProvider<InvoiceModel> invoice() {
        return new JasperReportTemplateProvider<InvoiceModel>() {

            @Override
            public byte[] getReport(InvoiceModel invoice, ExportFormat exportFormat) throws ReportException {
                super.setOrganization(invoice.getOrganization());

                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    String templateName = Templates.getTemplate(ReportTheme.Type.ADMIN, DocumentType.INVOICE);
                    BasicJRDataSource dataSource = new BasicJRDataSource<InvoiceModel>(invoice) {
                        @Override
                        public Object getFieldValue(JRField jrField) throws JRException {
                            InvoiceModel row = super.dataSource.get(super.current.get() - 1);

                            Object fieldValue = null;
                            for (UBLReportDataProvider provider : dataProviders) {
                                fieldValue = provider.invoice().getFieldValue(row, jrField.getName());
                                if(fieldValue != null) break;
                            }
                            return fieldValue;
                        }
                    };

                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.ADMIN);
                    JasperPrint jasperPrint = jasperReport.processReport(theme, templateName, parameters, dataSource);
                    return export(jasperPrint, exportFormat);
                } catch (Exception e) {
                    throw new ReportException("Failed to template report", e);
                }
            }

        };
    }

    @Override
    public ReportTemplateProvider<CreditNoteModel> creditNote() {
        return new JasperReportTemplateProvider<CreditNoteModel>() {

            @Override
            public byte[] getReport(CreditNoteModel creditNote, ExportFormat exportFormat) throws ReportException {
                super.setOrganization(creditNote.getOrganization());

                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    String templateName = Templates.getTemplate(ReportTheme.Type.ADMIN, DocumentType.CREDIT_NOTE);
                    BasicJRDataSource dataSource = new BasicJRDataSource<CreditNoteModel>(creditNote) {
                        @Override
                        public Object getFieldValue(JRField jrField) throws JRException {
                            CreditNoteModel row = super.dataSource.get(super.current.get() - 1);

                            Object fieldValue = null;
                            for (UBLReportDataProvider provider : dataProviders) {
                                fieldValue = provider.creditNote().getFieldValue(row, jrField.getName());
                                if(fieldValue != null) break;
                            }
                            return fieldValue;
                        }
                    };

                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.ADMIN);
                    JasperPrint jasperPrint = jasperReport.processReport(theme, templateName, parameters, dataSource);
                    return export(jasperPrint, exportFormat);
                } catch (Exception e) {
                    throw new ReportException("Failed to template report", e);
                }
            }

        };
    }

    @Override
    public ReportTemplateProvider<DebitNoteModel> debitNote() {
        return new JasperReportTemplateProvider<DebitNoteModel>() {

            @Override
            public byte[] getReport(DebitNoteModel debitNote, ExportFormat exportFormat) throws ReportException {
                super.setOrganization(debitNote.getOrganization());

                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    String templateName = Templates.getTemplate(ReportTheme.Type.ADMIN, DocumentType.DEBIT_NOTE);
                    BasicJRDataSource dataSource = new BasicJRDataSource<DebitNoteModel>(debitNote) {
                        @Override
                        public Object getFieldValue(JRField jrField) throws JRException {
                            DebitNoteModel row = super.dataSource.get(super.current.get() - 1);

                            Object fieldValue = null;
                            for (UBLReportDataProvider provider : dataProviders) {
                                fieldValue = provider.debitNote().getFieldValue(row, jrField.getName());
                                if(fieldValue != null) break;
                            }
                            return fieldValue;
                        }
                    };

                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.ADMIN);
                    JasperPrint jasperPrint = jasperReport.processReport(theme, templateName, parameters, dataSource);
                    return export(jasperPrint, exportFormat);
                } catch (Exception e) {
                    throw new ReportException("Failed to template report", e);
                }
            }

        };
    }

}
