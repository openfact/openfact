package org.openfact.services.resources.admin.info;

import org.openfact.keys.KeyProvider;
import org.openfact.component.ComponentFactory;
import org.openfact.provider.ConfiguredProvider;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.report.ReportProviderType;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.representations.idm.ComponentTypeRepresentation;
import org.openfact.representations.info.*;
import org.openfact.services.managers.ServerStartup;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.ThemeProviderType;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;

@Stateless
@Path("/admin/serverinfo")
public class ServerInfoAdminResource {

    @Inject
    private ServerStartup serverStartup;

    @Inject
    @ThemeProviderType(type = ThemeProviderType.ProviderType.EXTENDING)
    private ThemeProvider themeProvider;

    @Inject
    @ReportProviderType(type = ReportProviderType.ProviderType.EXTENDING)
    private ReportThemeProvider reportThemeProvider;

    @Inject
    @Any
    private Instance<ComponentFactory> componentFactories;

    @Inject
    private ModelToRepresentation modelToRepresentation;

    private static Map<String, List<String>> createEnumsMap(Class... enums) {
        Map<String, List<String>> m = new HashMap<>();
        for (Class e : enums) {
            String n = e.getSimpleName();
            n = Character.toLowerCase(n.charAt(0)) + n.substring(1);

            List<String> l = new LinkedList<>();
            for (Object c : e.getEnumConstants()) {
                l.add(c.toString());
            }
            Collections.sort(l);

            m.put(n, l);
        }
        return m;
    }

    /**
     * General information about the server
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServerInfoRepresentation getInfo() {
        ServerInfoRepresentation info = new ServerInfoRepresentation();
        info.setSystemInfo(SystemInfoRepresentation.create(serverStartup.getServerStartupTimestamp()));
        info.setMemoryInfo(MemoryInfoRepresentation.create());
        info.setProfileInfo(ProfileInfoRepresentation.create());

        setThemes(info);
        setReports(info);
        setProviders(info);
        return info;
    }

    private void setProviders(ServerInfoRepresentation info) {
        info.setComponentTypes(new HashMap<>());

        List<ComponentTypeRepresentation> types = new ArrayList<>();

        Iterator<ComponentFactory> iterator = componentFactories.iterator();
        while (iterator.hasNext()) {
            ComponentFactory componentFactory = iterator.next();

            ComponentTypeRepresentation rep = new ComponentTypeRepresentation();
            rep.setId(componentFactory.getId());
            ConfiguredProvider configured = componentFactory;
            rep.setHelpText(configured.getHelpText());
            List<ProviderConfigProperty> configProperties = configured.getConfigProperties();
            if (configProperties == null) {
                configProperties = Collections.EMPTY_LIST;
            }
            rep.setProperties(modelToRepresentation.toRepresentation(configProperties));

            types.add(rep);
        }

        info.getComponentTypes().put(KeyProvider.class.getName(), types);
    }

    private void setThemes(ServerInfoRepresentation info) {
        info.setThemes(new HashMap<>());

        for (Theme.Type type : Theme.Type.values()) {
            List<String> themeNames = new LinkedList<>(themeProvider.nameSet(type));
            Collections.sort(themeNames);

            List<ThemeInfoRepresentation> themes = new LinkedList<>();
            info.getThemes().put(type.toString().toLowerCase(), themes);

            for (String name : themeNames) {
                try {
                    Theme theme = themeProvider.getTheme(name, type);
                    ThemeInfoRepresentation ti = new ThemeInfoRepresentation();
                    ti.setName(name);

                    String locales = theme.getProperties().getProperty("locales");
                    if (locales != null) {
                        ti.setLocales(locales.replaceAll(" ", "").split(","));
                    }

                    themes.add(ti);
                } catch (IOException e) {
                    throw new WebApplicationException("Failed to load themes", e);
                }
            }
        }
    }

    private void setReports(ServerInfoRepresentation info) {
        info.setReports(new HashMap<>());

        for (ReportTheme.Type type : ReportTheme.Type.values()) {
            List<String> reportThemeNames = new LinkedList<>(reportThemeProvider.nameSet(type));
            Collections.sort(reportThemeNames);

            List<ReportInfoRepresentation> themes = new LinkedList<>();
            info.getReports().put(type.toString().toLowerCase(), themes);

            for (String name : reportThemeNames) {
                try {
                    ReportTheme theme = reportThemeProvider.getTheme(name, type);
                    ReportInfoRepresentation ti = new ReportInfoRepresentation();
                    ti.setName(name);

                    String locales = theme.getProperties().getProperty("locales");
                    if (locales != null) {
                        ti.setLocales(locales.replaceAll(" ", "").split(","));
                    }

                    themes.add(ti);
                } catch (IOException e) {
                    throw new WebApplicationException("Failed to load report themes", e);
                }
            }
        }
    }

}
