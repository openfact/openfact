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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperPrint;
import org.openfact.common.util.ObjectUtil;
import org.openfact.models.DocumentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.report.*;
import org.openfact.ubl.jasper.BasicJRDataSource;
import org.openfact.ubl.jasper.JasperReportTemplateProvider;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        public static String getTemplate(ReportTheme.Type type, DocumentModel document) {
            StringBuilder sb = new StringBuilder();
            for (String s : document.getDocumentType().toString().toLowerCase().split("_")) {
                sb.append(s);
            }
            return sb.append(".jrxml").toString();
        }
    }

    @Override
    public void close() {
    }

    @Override
    public ReportTemplateProvider<DocumentModel> document() {
        return new JasperReportTemplateProvider<DocumentModel>() {

            @Override
            public byte[] getReport(DocumentModel document, ExportFormat exportFormat) throws ReportException {
                ReportThemeProvider themeProvider = session.getProvider(ReportThemeProvider.class, "extending");
                try {
                    String templateName = Templates.getTemplate(ReportTheme.Type.ADMIN, document);
                    BasicJRDataSource dataSource = new BasicJRDataSource<DocumentModel>(document) {
                        @Override
                        public Object getFieldValue(JRField jrField) throws JRException {
                            DocumentModel row = super.dataSource.get(super.current.get() - 1);

                            Object fieldValue = null;
                            for (UBLReportDataProvider provider : dataProviders) {
                                fieldValue = provider.document().getFieldValue(row, jrField.getName());
                                if (fieldValue != null) break;
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
