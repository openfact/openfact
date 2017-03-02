package org.openfact.services.resources.admin.info;

import org.openfact.events.EventType;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.ReportThemeProviderType;
import org.openfact.representations.info.*;
import org.openfact.services.managers.ServerStartup;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.ThemeProviderType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;

@Path("/admin/serverinfo")
@Stateless
public class ServerInfoAdminResource {

    private static final Map<String, List<String>> ENUMS = createEnumsMap(EventType.class, OperationType.class, ResourceType.class);

    @Inject
    private ServerStartup serverStartup;

    @Inject
    @ThemeProviderType(type = ThemeProviderType.ProviderType.EXTENDING)
    private ThemeProvider themeProvider;

    @Inject
    @ReportThemeProviderType(type = ReportThemeProviderType.ProviderType.EXTENDING)
    private ReportThemeProvider reportThemeProvider;

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
        info.setEnums(ENUMS);
        return info;
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
