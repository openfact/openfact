package org.openfact.theme;

import org.openfact.util.JsonSerialization;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

@Startup
@Singleton(name = "JarThemeProvider")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
@ThemeManagerSelector
@ThemeProviderType(type = ThemeProviderType.ProviderType.JAR)
public class JarThemeProvider implements ThemeProvider {

    protected static final String OPENFACT_THEMES_JSON = "META-INF/openfact-themes.json";
    protected static Map<Theme.Type, Map<String, ClassLoaderTheme>> themes = new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Enumeration<URL> resources = classLoader.getResources(OPENFACT_THEMES_JSON);
            while (resources.hasMoreElements()) {
                loadThemes(classLoader, resources.nextElement().openStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load themes", e);
        }
    }

    @Override
    public int getProviderPriority() {
        return 0;
    }

    @Override
    public Theme getTheme(String name, Theme.Type type) throws IOException {
        return hasTheme(name, type) ? themes.get(type).get(name) : null;
    }

    @Override
    public Set<String> nameSet(Theme.Type type) {
        if (themes.containsKey(type)) {
            return themes.get(type).keySet();
        } else {
            return Collections.emptySet();
        }
    }

    @Override
    public boolean hasTheme(String name, Theme.Type type) {
        return themes.containsKey(type) && themes.get(type).containsKey(name);
    }

    protected void loadThemes(ClassLoader classLoader, InputStream themesInputStream) {
        try {
            ThemesRepresentation themesRep = JsonSerialization.readValue(themesInputStream, ThemesRepresentation.class);

            for (ThemeRepresentation themeRep : themesRep.getThemes()) {
                for (String t : themeRep.getTypes()) {
                    Theme.Type type = Theme.Type.valueOf(t.toUpperCase());
                    if (!themes.containsKey(type)) {
                        themes.put(type, new HashMap<>());
                    }
                    themes.get(type).put(themeRep.getName(), new ClassLoaderTheme(themeRep.getName(), type, classLoader));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load themes", e);
        }
    }

}
