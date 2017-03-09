package org.openfact.report;

import org.openfact.theme.Theme;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ExtendingTheme implements ReportTheme{

    private List<ReportTheme> themes;

    private Properties properties;

    private ConcurrentHashMap<String, ConcurrentHashMap<Locale, Properties>> messages = new ConcurrentHashMap<>();

    public ExtendingTheme(List<ReportTheme> themes) {
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
        for (ReportTheme t : themes) {
            URL template = t.getTemplate(name);
            if (template != null) {
                return template;
            }
        }
        return null;
    }

    @Override
    public InputStream getTemplateAsStream(String name) throws IOException {
        for (ReportTheme t : themes) {
            InputStream template = t.getTemplateAsStream(name);
            if (template != null) {
                return template;
            }
        }
        return null;
    }


    @Override
    public URL getResource(String path) throws IOException {
        for (ReportTheme t : themes) {
            URL resource = t.getResource(path);
            if (resource != null) {
                return resource;
            }
        }
        return null;
    }

    @Override
    public InputStream getResourceAsStream(String path) throws IOException {
        for (ReportTheme t : themes) {
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

            ListIterator<ReportTheme> itr = themes.listIterator(themes.size());
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
            ListIterator<ReportTheme> itr = themes.listIterator(themes.size());
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
