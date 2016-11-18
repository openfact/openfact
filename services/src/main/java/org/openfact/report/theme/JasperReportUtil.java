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

package org.openfact.report.theme;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.openfact.Config;
import org.openfact.report.ReportTheme;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class JasperReportUtil {

    private ConcurrentHashMap<String, JasperReport> cache;

    public JasperReportUtil() {
        if (Config.scope("template").getBoolean("cacheReportThemes", true)) {
            cache = new ConcurrentHashMap<>();
        }
    }

    public byte[] processReportTheme(Map<String, Object> parameters, String templateName, ReportTheme theme,
                                     Collection<?> data) throws JasperReportException {
        try {
            JasperReport template;
            if (cache != null) {
                String key = theme.getName() + "/" + templateName;
                template = cache.get(key);
                if (template == null) {
                    template = getTemplate(templateName, theme);
                    if (cache.putIfAbsent(key, template) != null) {
                        template = cache.get(key);
                    }
                }
            } else {
                template = getTemplate(templateName, theme);
            }

            JasperPrint print = JasperFillManager.fillReport(template, parameters, new JRBeanCollectionDataSource(data));
            return JasperExportManager.exportReportToPdf(print);
        } catch (Exception e) {
            throw new JasperReportException("Failed to process report " + templateName, e);
        }
    }

    private JasperReport getTemplate(String reportName, ReportTheme theme) throws JRException, IOException {
        URL url = theme.getTemplate(reportName);
        return (JasperReport) JRLoader.loadObject(url);
    }

}
