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
package org.openfact.services.resources.admin.info;

import org.openfact.events.EventType;
import org.openfact.events.admin.OperationType;
import org.openfact.events.admin.ResourceType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.provider.*;
import org.openfact.representations.idm.ComponentTypeRepresentation;
import org.openfact.representations.info.*;
import org.openfact.theme.Theme;
import org.openfact.theme.ThemeProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.*;

public class ServerInfoAdminResource {

    private static final Map<String, List<String>> ENUMS = createEnumsMap(EventType.class,
            OperationType.class, ResourceType.class);

    @Context
    private OpenfactSession session;

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
        info.setSystemInfo(SystemInfoRepresentation
                .create(session.getOpenfactSessionFactory().getServerStartupTimestamp()));
        info.setMemoryInfo(MemoryInfoRepresentation.create());
        info.setProfileInfo(ProfileInfoRepresentation.create());

        setThemes(info);
        setProviders(info);
        info.setEnums(ENUMS);
        return info;
    }

    private void setProviders(ServerInfoRepresentation info) {
        info.setComponentTypes(new HashMap<>());
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
        info.setProviders(spiReps);
    }

    private void setThemes(ServerInfoRepresentation info) {
        ThemeProvider themeProvider = session.getProvider(ThemeProvider.class, "extending");
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

}
