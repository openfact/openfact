package org.openfact.services.resources.admin;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Context;

import org.openfact.models.OpenfactSession;
import org.openfact.provider.ProviderFactory;
import org.openfact.provider.ServerInfoAwareProviderFactory;
import org.openfact.provider.Spi;
import org.openfact.representations.info.MemoryInfoRepresentation;
import org.openfact.representations.info.ProviderRepresentation;
import org.openfact.representations.info.ServerInfoRepresentation;
import org.openfact.representations.info.SpiInfoRepresentation;
import org.openfact.representations.info.SystemInfoRepresentation;
import org.openfact.services.resources.admin.info.ServerInfoAdminResource;

public class ServerInfoAdminResourceImpl implements ServerInfoAdminResource {

    @Context
    private OpenfactSession session;

    @Override
    public ServerInfoRepresentation getInfo() {
        ServerInfoRepresentation info = new ServerInfoRepresentation();
        info.setSystemInfo(SystemInfoRepresentation.create(session.getOpenfactSessionFactory().getServerStartupTimestamp()));
        info.setMemoryInfo(MemoryInfoRepresentation.create());

        setProviders(info);
        return info;
    }

    private void setProviders(ServerInfoRepresentation info) {
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
                    ProviderFactory<?> pi = session.getOpenfactSessionFactory().getProviderFactory(spi.getProviderClass(), name);
                    if (ServerInfoAwareProviderFactory.class.isAssignableFrom(pi.getClass())) {
                        provider.setOperationalInfo(((ServerInfoAwareProviderFactory) pi).getOperationalInfo());
                    }
                    providers.put(name, provider);
                }
            }
            spiRep.setProviders(providers);

            spiReps.put(spi.getName(), spiRep);
        }
        info.setProviders(spiReps);
    }

}
