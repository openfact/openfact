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

import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.openfact.models.DocumentModel;
import org.openfact.report.ExportFormat;
import org.openfact.report.JasperReportUtil;
import org.openfact.report.ReportException;
import org.openfact.report.ReportTemplateProvider;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.ReportProviderType;
import org.openfact.report.ReportProviderType.ProviderType;
import org.openfact.ubl.jasper.BasicJRDataSource;
import org.openfact.ubl.jasper.JasperReportTemplateProvider;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperPrint;

@Stateless
public class JasperUBLReportProvider implements UBLReportProvider {

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
    public ReportTemplateProvider<DocumentModel> document() {
        return new JasperReportTemplateProvider<DocumentModel>() {

            @Override
            public byte[] getReport(DocumentModel document, ExportFormat exportFormat)
                    throws ReportException {
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

        };
    }

}
