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

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.openfact.models.*;
import org.openfact.report.*;
import org.openfact.theme.FreeMarkerUtil;
import org.openfact.theme.beans.LocaleBean;

import javax.ejb.Local;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

    @Override
    public void close() {
    }

    @Override
    public ReportTemplateProvider<InvoiceModel> invoice() {
        return new JasperReportTemplateProvider<InvoiceModel>() {
            @Override
            public byte[] getReportAsPdf(InvoiceModel invoiceModel) throws ReportException {
                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.INVOICE);
                    Locale locale = organization.getDefaultLocale() != null ? new Locale(organization.getDefaultLocale()) : Locale.ENGLISH;
                    attributes.put(JRParameter.REPORT_LOCALE, locale);

                    // Put parameters
                    attributes.putIfAbsent("OF_ORGANIZATION", organization.getName());

                    JasperPrint jp = jasperReport.processReport(theme, Templates.getTemplate(ReportTheme.Type.INVOICE), attributes, new JREmptyDataSource());
                    return JasperExportManager.exportReportToPdf(jp);
                } catch (Exception e) {
                    throw new ReportException("Failed to template report", e);
                }
            }

            @Override
            public byte[] getReportAsPdf(List<InvoiceModel> t) throws ReportException {
                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    ReportTheme theme = themeProvider.getTheme(themeName, ReportTheme.Type.INVOICE);
                    attributes.put(JRParameter.REPORT_LOCALE, new Locale(organization.getDefaultLocale()));

                    JasperPrint jp = jasperReport.processReport(theme, Templates.getTemplate(ReportTheme.Type.INVOICE), attributes, new JREmptyDataSource());
                    return JasperExportManager.exportReportToPdf(jp);
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
            public byte[] getReportAsPdf(CreditNoteModel creditNoteModel) throws ReportException {
                return new byte[0];
            }

            @Override
            public byte[] getReportAsPdf(List<CreditNoteModel> t) throws ReportException {
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
        };
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
        public static String getTemplate(ReportTheme.Type type) {
            switch (type) {
                case INVOICE:
                    return "invoice.jrxml";
                case INVOICES:
                    return "invoices.jrxml";
                case CREDIT_NOTE:
                    return "credit_note.jrxml";
                case CREDIT_NOTES:
                    return "credit_notes.jrxml";
                case DEBIT_NOTE:
                    return "debit_note.jrxml";
                case DEBIT_NOTES:
                    return "debit_notes.jrxml";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

}
