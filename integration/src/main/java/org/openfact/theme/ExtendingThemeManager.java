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

package org.openfact.theme;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.Version;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ExtendingThemeManager implements ThemeProvider {

    private static final Logger log = Logger.getLogger(ExtendingThemeManager.class);

    private ConcurrentHashMap<ThemeKey, Theme> themeCache;
        
    private List<ThemeProvider> providers;
    private String defaultTheme;
    
    @Inject
    @Any
    private Instance<ThemeProvider> themeProviders;

    @PostConstruct
    public void init(Config.Scope config) {
        this.defaultTheme = Config.scope("theme").get("default", Version.NAME.toLowerCase());
        
        if(Config.scope("theme").getBoolean("cacheThemes", true)) {
            themeCache = new ConcurrentHashMap<>();
        }
    }
    
    @PreDestroy    
    public void close() {
        providers = null;
    }
    
    private List<ThemeProvider> getProviders() {
        if (providers == null) {
            providers = new LinkedList<>();

            Iterator<ThemeProvider> it = themeProviders.iterator();
            while (it.hasNext()) {
                ThemeProvider themeProvider = (ThemeProvider) it.next();
                if (!(themeProvider instanceof ExtendingThemeManager)) {
                    if (!themeProvider.getClass().equals(ExtendingThemeManager.class)) {
                        providers.add(themeProvider);
                    }
                }
            }
            
            Collections.sort(providers, new Comparator<ThemeProvider>() {
                @Override
                public int compare(ThemeProvider o1, ThemeProvider o2) {
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
    public Theme getTheme(String name, Theme.Type type) throws IOException {
        if (name == null) {
            name = defaultTheme;
        }

        if (themeCache != null) {
            ThemeKey key = ThemeKey.get(name, type);
            Theme theme = themeCache.get(key);
            if (theme == null) {
                theme = loadTheme(name, type);
                if (theme == null) {
                    theme = loadTheme("openfact", type);
                    if (theme == null) {
                        theme = loadTheme("base", type);
                    }
                    log.errorv("Failed to find {0} theme {1}, using built-in themes", type, name);
                } else if (themeCache.putIfAbsent(key, theme) != null) {
                    theme = themeCache.get(key);
                }
            }
            return theme;
        } else {
            return loadTheme(name, type);
        }
    }

    private Theme loadTheme(String name, Theme.Type type) throws IOException {
        Theme theme = findTheme(name, type);
        if (theme != null && (theme.getParentName() != null || theme.getImportName() != null)) {
            List<Theme> themes = new LinkedList<>();
            themes.add(theme);

            if (theme.getImportName() != null) {
                String[] s = theme.getImportName().split("/");
                themes.add(findTheme(s[1], Theme.Type.valueOf(s[0].toUpperCase())));
            }

            if (theme.getParentName() != null) {
                for (String parentName = theme.getParentName(); parentName != null; parentName = theme.getParentName()) {
                    theme = findTheme(parentName, type);
                    themes.add(theme);

                    if (theme.getImportName() != null) {
                        String[] s = theme.getImportName().split("/");
                        themes.add(findTheme(s[1], Theme.Type.valueOf(s[0].toUpperCase())));
                    }
                }
            }

            return new ExtendingTheme(themes);
        } else {
            return theme;
        }
    }

    @Override
    public Set<String> nameSet(Theme.Type type) {
        Set<String> themes = new HashSet<String>();
        for (ThemeProvider p : getProviders()) {
            themes.addAll(p.nameSet(type));
        }
        return themes;
    }

    @Override
    public boolean hasTheme(String name, Theme.Type type) {
        for (ThemeProvider p : getProviders()) {
            if (p.hasTheme(name, type)) {
                return true;
            }
        }
        return false;
    }

    private Theme findTheme(String name, Theme.Type type) {
        for (ThemeProvider p : getProviders()) {
            if (p.hasTheme(name, type)) {
                try {
                    return p.getTheme(name, type);
                } catch (IOException e) {
                    log.errorv(e, p.getClass() + " failed to load theme, type={0}, name={1}", type, name);
                }
            }
        }
        return null;
    }

    public static class ExtendingTheme implements Theme {

        private List<Theme> themes;

        private Properties properties;

        private ConcurrentHashMap<String, ConcurrentHashMap<Locale, Properties>> messages = new ConcurrentHashMap<>();

        public ExtendingTheme(List<Theme> themes) {
            this.themes = themes;
        }

        @Override
        public String getName() {
            return themes.get(0).getName();
        }

        @Override
        public String getParentName() {
            return themes.get(0).getParentName();
        }

        @Override
        public String getImportName() {
            return themes.get(0).getImportName();
        }

        @Override
        public Type getType() {
            return themes.get(0).getType();
        }

        @Override
        public URL getTemplate(String name) throws IOException {
            for (Theme t : themes) {
                URL template = t.getTemplate(name);
                if (template != null) {
                    return template;
                }
            }
            return null;
        }

        @Override
        public InputStream getTemplateAsStream(String name) throws IOException {
            for (Theme t : themes) {
                InputStream template = t.getTemplateAsStream(name);
                if (template != null) {
                    return template;
                }
            }
            return null;
        }


        @Override
        public URL getResource(String path) throws IOException {
            for (Theme t : themes) {
                URL resource = t.getResource(path);
                if (resource != null) {
                    return resource;
                }
            }
            return null;
        }

        @Override
        public InputStream getResourceAsStream(String path) throws IOException {
            for (Theme t : themes) {
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

                ListIterator<Theme> itr = themes.listIterator(themes.size());
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
                ListIterator<Theme> itr = themes.listIterator(themes.size());
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
    
    public static class ThemeKey {

        private String name;
        private Theme.Type type;

        public static ThemeKey get(String name, Theme.Type type) {
            return new ThemeKey(name, type);
        }

        private ThemeKey(String name, Theme.Type type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Theme.Type getType() {
            return type;
        }

        public void setType(Theme.Type type) {
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
