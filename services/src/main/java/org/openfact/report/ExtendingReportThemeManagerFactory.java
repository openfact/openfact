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

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.ThemeProviderFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class ExtendingReportThemeManagerFactory implements ReportThemeProviderFactory {

    private ConcurrentHashMap<ThemeKey, ReportTheme> themeCache;

    @Override
    public ReportThemeProvider create(OpenfactSession session) {
        return new ExtendingReportThemeManager(session, themeCache);
    }

    @Override
    public void init(Config.Scope config) {
        if(Config.scope("theme").getBoolean("cacheThemes", true)) {
            themeCache = new ConcurrentHashMap<>();
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

    public static class ThemeKey {

        private String name;
        private ReportTheme.Type type;

        public static ThemeKey get(String name, ReportTheme.Type type) {
            return new ThemeKey(name, type);
        }

        private ThemeKey(String name, ReportTheme.Type type) {
            this.name = name;
            this.type = type;
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

            ThemeKey themeKey = (ThemeKey) o;

            if (name != null ? !name.equals(themeKey.name) : themeKey.name != null) return false;
            if (type != themeKey.type) return false;

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
