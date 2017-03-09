package org.openfact.theme;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.Version;
import org.openfact.theme.ThemeProviderType.ProviderType;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Startup
@DependsOn(value = {"JarThemeProvider"})
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Lock(LockType.READ)
@ThemeProviderType(type = ProviderType.EXTENDING)
public class ExtendingThemeManager implements ThemeProvider {

    private static final Logger log = Logger.getLogger(ExtendingThemeManager.class);

    private ConcurrentHashMap<ThemeKey, Theme> themeCache;

    private List<ThemeProvider> providers;
    private String defaultTheme;

    @Inject
    @Any
    @ThemeManagerSelector
    private Instance<ThemeProvider> themeProviders;

    @PostConstruct
    public void init() {
        this.defaultTheme = Config.scope("theme").get("default", Version.NAME.toLowerCase());
        loadProviders();

        if (Config.scope("theme").getBoolean("cacheThemes", true)) {
            themeCache = new ConcurrentHashMap<>();
        }
    }

    private void loadProviders() {
        providers = new LinkedList<>();

        Iterator<ThemeProvider> it = themeProviders.iterator();

        while (it.hasNext()) {
            ThemeProvider themeProvider = it.next();
            if (!(themeProvider instanceof ExtendingThemeManager)) {
                if (!themeProvider.getClass().equals(ExtendingThemeManager.class)) {
                    providers.add(themeProvider);
                }
            }
        }

        Collections.sort(providers, (o1, o2) -> o2.getProviderPriority() - o1.getProviderPriority());
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
        Set<String> themes = new HashSet<>();
        for (ThemeProvider p : providers) {
            themes.addAll(p.nameSet(type));
        }
        return themes;
    }

    @Override
    public boolean hasTheme(String name, Theme.Type type) {
        for (ThemeProvider p : providers) {
            if (p.hasTheme(name, type)) {
                return true;
            }
        }
        return false;
    }

    private Theme findTheme(String name, Theme.Type type) {
        for (ThemeProvider p : providers) {
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

}
