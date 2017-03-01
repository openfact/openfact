package org.openfact.services.resources.admin.info;

import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.provider.*;
import org.openfact.report.ReportTheme;
import org.openfact.report.ReportThemeProvider;
import org.openfact.report.ReportThemeProviderType;
import org.openfact.representations.idm.ComponentTypeRepresentation;
import org.openfact.representations.info.*;
import org.openfact.services.resources.OpenfactSession;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;
import org.openfact.theme.ThemeProviderType;
import org.openfact.theme.ThemeProviderType.ProviderType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;

@Stateless
public class ServerInfoAdminResource {

    //private static final Map<String, List<String>> ENUMS = createEnumsMap(EventType.class, OperationType.class, ResourceType.class);

    @Inject
    private OpenfactSession session;

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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServerInfoRepresentation getInfo() {
        ServerInfoRepresentation info = new ServerInfoRepresentation();
        info.setSystemInfo(SystemInfoRepresentation.create(session.getServerStartupTimestamp()));
        info.setMemoryInfo(MemoryInfoRepresentation.create());
        info.setProfileInfo(ProfileInfoRepresentation.create());

        setThemes(info);
        setReports(info);
        setProviders(info);
        //info.setEnums(ENUMS);
        return info;
    }

    private void setProviders(ServerInfoRepresentation info) {
        /*info.setComponentTypes(new HashMap<>());
        LinkedHashMap<String, SpiInfoRepresentation> spiReps = new LinkedHashMap<>();

        List<Spi> spis = new LinkedList<>(session.getOpenfactSessionFactory().getSpis());
        Collections.sort(spis, new Comparator<Spi>() {
            @Override
            public int compare(Spi s1, Spi s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        for (Spi spi : spis) {
            SpiInfoRepresentation spiRep = new SpiInfoRepresentation();
            spiRep.setInternal(spi.isInternal());

            List<String> providerIds = new LinkedList<>(session.listProviderIds(spi.getProviderClass()));
            Collections.sort(providerIds);

            Map<String, ProviderRepresentation> providers = new HashMap<>();

            if (providerIds != null) {
                for (String name : providerIds) {
                    ProviderRepresentation provider = new ProviderRepresentation();
                    ProviderFactory<?> pi = session.getOpenfactSessionFactory()
                            .getProviderFactory(spi.getProviderClass(), name);
                    if (ServerInfoAwareProviderFactory.class.isAssignableFrom(pi.getClass())) {
                        provider.setOperationalInfo(
                                ((ServerInfoAwareProviderFactory) pi).getOperationalInfo());
                    }
                    if (pi instanceof ConfiguredProvider) {
                        ComponentTypeRepresentation rep = new ComponentTypeRepresentation();
                        rep.setId(pi.getId());
                        ConfiguredProvider configured = (ConfiguredProvider) pi;
                        rep.setHelpText(configured.getHelpText());
                        List<ProviderConfigProperty> configProperties = configured.getConfigProperties();
                        if (configProperties == null)
                            configProperties = Collections.EMPTY_LIST;
                        rep.setProperties(ModelToRepresentation.toRepresentation(configProperties));
                        List<ComponentTypeRepresentation> reps = info.getComponentTypes()
                                .get(spi.getProviderClass().getName());
                        if (reps == null) {
                            reps = new LinkedList<>();
                            info.getComponentTypes().put(spi.getProviderClass().getName(), reps);
                        }
                        reps.add(rep);
                    }
                    providers.put(name, provider);
                }
            }
            spiRep.setProviders(providers);

            spiReps.put(spi.getName(), spiRep);
        }
        info.setProviders(spiReps);*/
    }

    private void setThemes(ServerInfoRepresentation info) {
        info.setThemes(new HashMap<String, List<ThemeInfoRepresentation>>());

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
        info.setReports(new HashMap<String, List<ReportInfoRepresentation>>());

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
