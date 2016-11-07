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

package org.openfact.report;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class ExtendingReportManagerFactory implements ReportThemeProviderFactory {

    private ConcurrentHashMap<TemplateKey, ReportTheme> reportCache;

    @Override
    public ReportThemeProvider create(OpenfactSession session) {
        return new ExtendingReportManager(session, reportCache);
    }

    @Override
    public void init(Config.Scope config) {
        if (Config.scope("template").getBoolean("cacheReports", true)) {
            reportCache = new ConcurrentHashMap<>();
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
        return "extending";
    }

    public static class TemplateKey {

        private String name;
        private ReportTheme.Type type;

        private TemplateKey(String name, ReportTheme.Type type) {
            this.name = name;
            this.type = type;
        }

        public static TemplateKey get(String name, ReportTheme.Type type) {
            return new TemplateKey(name, type);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ReportTheme.Type getType() {
            return type;
        }

        public void setType(ReportTheme.Type type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TemplateKey templateKey = (TemplateKey) o;

            if (name != null ? !name.equals(templateKey.name) : templateKey.name != null) return false;
            if (type != templateKey.type) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }

    }

}
