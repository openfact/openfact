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

package org.openfact.report.theme;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.ReportThemeProviderFactory;
import org.openfact.report.ReportTheme.Type;
import org.openfact.util.JsonSerialization;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class JarReportProviderFactory implements ReportThemeProviderFactory {

    protected static final String OPENFACT_TEMPLATES_JSON = "META-INF/openfact-reports.json";
    protected static Map<ReportTheme.Type, Map<String, ClassLoaderReport>> reports = new HashMap<>();

    @Override
    public ReportThemeProvider create(OpenfactSession session) {
        return new JarReportProvider(reports);
    }

    @Override
    public void init(Config.Scope config) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Enumeration<URL> resources = classLoader.getResources(OPENFACT_TEMPLATES_JSON);
            while (resources.hasMoreElements()) {
                loadReports(classLoader, resources.nextElement().openStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load reports", e);
        }
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "jar";
    }

    protected void loadReports(ClassLoader classLoader, InputStream reportsInputStream) {
        try {
            ReportsRepresentation reportsRep = JsonSerialization.readValue(reportsInputStream, ReportsRepresentation.class);

            for (ReportRepresentation reportRep : reportsRep.getReports()) {
                for (String t : reportRep.getTypes()) {
                    ReportTheme.Type type = ReportTheme.Type.valueOf(t.toUpperCase());
                    if (!reports.containsKey(type)) {
                        reports.put(type, new HashMap<String, ClassLoaderReport>());
                    }
                    reports.get(type).put(reportRep.getName(), new ClassLoaderReport(reportRep.getName(), type, classLoader));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load reports", e);
        }
    }

    public static class ReportRepresentation {
        private String name;
        private String[] types;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String[] getTypes() {
            return types;
        }

        public void setTypes(String[] types) {
            this.types = types;
        }
    }

    public static class ReportsRepresentation {
        private ReportRepresentation[] reports;

        public ReportRepresentation[] getReports() {
            return reports;
        }

        public void setReports(ReportRepresentation[] reports) {
            this.reports = reports;
        }
    }

}
