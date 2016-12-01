/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.report;

import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.openfact.Config;
import org.openfact.theme.FreeMarkerException;
import org.openfact.theme.Theme;

import java.io.*;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class JasperReportUtil {

    private ConcurrentHashMap<String, JasperReport> cache;

    public JasperReportUtil() {
        if (Config.scope("theme").getBoolean("cacheTemplates", true)) {
            cache = new ConcurrentHashMap<>();
        }
    }

    public JasperPrint processReport(ReportTheme theme, String templateName, Map<String, Object> parameters, JRDataSource dataSource) throws JasperReportException {
        try {
            JasperReport jr;
            if(cache != null) {
                String key = theme.getName() + "/" + templateName;
                jr = cache.get(key);
                if(jr == null) {
                    jr = getReport(templateName, theme);
                    if(cache.putIfAbsent(key, jr) != null) {
                        jr = cache.get(key);
                    }
                }
            } else {
                jr = getReport(templateName, theme);
            }

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, dataSource);
            return jp;
        } catch (Exception e) {
            throw new JasperReportException("Failed to process report template " + templateName, e);
        }
    }

    private JasperReport getReport(String templateName, ReportTheme theme) throws IOException, JRException {
        InputStream is = theme.getResourceAsStream(templateName);
        JasperReport jr = (JasperReport) JRLoader.loadObject(is);
        return jr;
    }

}
