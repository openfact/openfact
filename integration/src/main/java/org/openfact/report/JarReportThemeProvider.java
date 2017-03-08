package org.openfact.report;

import org.openfact.util.JsonSerialization;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

@Startup
@Singleton(name = "JarReportThemeProvider")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
@ReportThemeManagerSelector
@ReportProviderType(type = ReportProviderType.ProviderType.JAR)
public class JarReportThemeProvider implements ReportThemeProvider {

    protected static final String OPENFACT_REPORT_THEMES_JSON = "META-INF/openfact-reports.json";
    private Map<ReportTheme.Type, Map<String, ClassLoaderReportTheme>> themes = new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Enumeration<URL> resources = classLoader.getResources(OPENFACT_REPORT_THEMES_JSON);
            while (resources.hasMoreElements()) {
                loadThemes(classLoader, resources.nextElement().openStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load report themes", e);
        }
    }

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public ReportTheme getTheme(String name, ReportTheme.Type type) throws IOException {
        return hasTheme(name, type) ? themes.get(type).get(name) : null;
    }

    @Override
    public Set<String> nameSet(ReportTheme.Type type) {
        if (themes.containsKey(type)) {
            return themes.get(type).keySet();
        } else {
            return Collections.emptySet();
        }
    }

    @Override
    public boolean hasTheme(String name, ReportTheme.Type type) {
        return themes.containsKey(type) && themes.get(type).containsKey(name);
    }

    protected void loadThemes(ClassLoader classLoader, InputStream themesInputStream) {
        try {
            ThemesRepresentation themesRep = JsonSerialization.readValue(themesInputStream, ThemesRepresentation.class);

            for (ThemeRepresentation themeRep : themesRep.getThemes()) {
                for (String t : themeRep.getTypes()) {
                    ReportTheme.Type type = ReportTheme.Type.valueOf(t.toUpperCase());
                    if (!themes.containsKey(type)) {
                        themes.put(type, new HashMap<>());
                    }
                    themes.get(type).put(themeRep.getName(), new ClassLoaderReportTheme(themeRep.getName(), type, classLoader));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load themes", e);
        }
    }

}
