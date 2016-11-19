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

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.models.OpenfactSession;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.ReportTheme.Type;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class ExtendingReportManager implements ReportThemeProvider {

    private static final Logger log = Logger.getLogger(ExtendingReportManager.class);

    private final OpenfactSession session;
    private final ConcurrentHashMap<ExtendingReportManagerFactory.TemplateKey, ReportTheme> reportCache;
    private List<ReportThemeProvider> providers;
    private String defaultTemplate;

    public ExtendingReportManager(OpenfactSession session, ConcurrentHashMap<ExtendingReportManagerFactory.TemplateKey, ReportTheme> reportCache) {
        this.session = session;
        this.reportCache = reportCache;
        this.defaultTemplate = Config.scope("report").get("default", Version.NAME.toLowerCase());
    }

    private List<ReportThemeProvider> getProviders() {
        if (providers == null) {
            providers = new LinkedList<>();

            for (ReportThemeProvider p : session.getAllProviders(ReportThemeProvider.class)) {
                if (!(p instanceof ExtendingReportManager)) {
                    if (!p.getClass().equals(ExtendingReportManager.class)) {
                        providers.add(p);
                    }
                }
            }

            Collections.sort(providers, new Comparator<ReportThemeProvider>() {
                @Override
                public int compare(ReportThemeProvider o1, ReportThemeProvider o2) {
                    return o2.getProviderPriority() - o1.getProviderPriority();
                }
            });
        }

        return providers;
    }

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public ReportTheme getReportTheme(String name, ReportTheme.Type type) throws IOException {
        if (name == null) {
            name = defaultTemplate;
        }

        if (reportCache != null) {
            ExtendingReportManagerFactory.TemplateKey key = ExtendingReportManagerFactory.TemplateKey.get(name, type);
            ReportTheme report = reportCache.get(key);
            if (report == null) {
                report = loadTemplate(name, type);
                if (report == null) {
                    report = loadTemplate("openfact", type);
                    if (report == null) {
                        report = loadTemplate("base", type);
                    }
                    log.errorv("Failed to find {0} report {1}, using built-in reports", type, name);
                } else if (reportCache.putIfAbsent(key, report) != null) {
                    report = reportCache.get(key);
                }
            }
            return report;
        } else {
            return loadTemplate(name, type);
        }
    }

    private ReportTheme loadTemplate(String name, ReportTheme.Type type) throws IOException {
        ReportTheme report = findTemplate(name, type);
        if (report != null) {
            List<ReportTheme> reports = new LinkedList<>();
            reports.add(report);

            return new ExtendingTemplate(reports);
        } else {
            return report;
        }
    }

    @Override
    public Set<String> nameSet(ReportTheme.Type type) {
        Set<String> reports = new HashSet<String>();
        for (ReportThemeProvider p : getProviders()) {
            reports.addAll(p.nameSet(type));
        }
        return reports;
    }

    @Override
    public boolean hasReportTheme(String name, ReportTheme.Type type) {
        for (ReportThemeProvider p : getProviders()) {
            if (p.hasReportTheme(name, type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void close() {
        providers = null;
    }

    private ReportTheme findTemplate(String name, ReportTheme.Type type) {
        for (ReportThemeProvider p : getProviders()) {
            if (p.hasReportTheme(name, type)) {
                try {
                    return p.getReportTheme(name, type);
                } catch (IOException e) {
                    log.errorv(e, p.getClass() + " failed to load report, type={0}, name={1}", type, name);
                }
            }
        }
        return null;
    }

    public static class ExtendingTemplate implements ReportTheme {

        private List<ReportTheme> reports;

        private Properties properties;

        private ConcurrentHashMap<String, ConcurrentHashMap<Locale, Properties>> messages = new ConcurrentHashMap<>();

        public ExtendingTemplate(List<ReportTheme> reports) {
            this.reports = reports;
        }

        @Override
        public String getName() {
            return reports.get(0).getName();
        }

        @Override
        public Type getType() {
            return reports.get(0).getType();
        }

        @Override
        public URL getTemplate(String name) throws IOException {
            for (ReportTheme t : reports) {
                URL report = t.getTemplate(name);
                if (report != null) {
                    return report;
                }
            }
            return null;
        }

        @Override
        public InputStream getTemplateAsStream(String name) throws IOException {
            for (ReportTheme t : reports) {
                InputStream report = t.getTemplateAsStream(name);
                if (report != null) {
                    return report;
                }
            }
            return null;
        }


        @Override
        public URL getResource(String path) throws IOException {
            for (ReportTheme t : reports) {
                URL resource = t.getResource(path);
                if (resource != null) {
                    return resource;
                }
            }
            return null;
        }

        @Override
        public InputStream getResourceAsStream(String path) throws IOException {
            for (ReportTheme t : reports) {
                InputStream resource = t.getResourceAsStream(path);
                if (resource != null) {
                    return resource;
                }
            }
            return null;
        }

        @Override
        public Properties getMessages(Locale locale) throws IOException {
            return getMessages("messages", locale);
        }

        @Override
        public Properties getMessages(String baseBundlename, Locale locale) throws IOException {
            if (messages.get(baseBundlename) == null || messages.get(baseBundlename).get(locale) == null) {
                Properties messages = new Properties();

                if (!Locale.ENGLISH.equals(locale)) {
                    messages.putAll(getMessages(baseBundlename, Locale.ENGLISH));
                }

                ListIterator<ReportTheme> itr = reports.listIterator(reports.size());
                while (itr.hasPrevious()) {
                    Properties m = itr.previous().getMessages(baseBundlename, locale);
                    if (m != null) {
                        messages.putAll(m);
                    }
                }

                this.messages.putIfAbsent(baseBundlename, new ConcurrentHashMap<Locale, Properties>());
                this.messages.get(baseBundlename).putIfAbsent(locale, messages);

                return messages;
            } else {
                return messages.get(baseBundlename).get(locale);
            }
        }

        @Override
        public Properties getProperties() throws IOException {
            if (properties == null) {
                Properties properties = new Properties();
                ListIterator<ReportTheme> itr = reports.listIterator(reports.size());
                while (itr.hasPrevious()) {
                    Properties p = itr.previous().getProperties();
                    if (p != null) {
                        properties.putAll(p);
                    }
                }
                this.properties = properties;
                return properties;
            } else {
                return properties;
            }
        }

    }

}
