package org.openfact.core.services;

import org.openfact.core.ServerInfoResource;
import org.openfact.core.keys.KeyProvider;
import org.openfact.core.keys.component.ComponentFactory;
import org.openfact.core.keys.provider.ConfiguredProvider;
import org.openfact.core.keys.provider.ProviderConfigProperty;
import org.openfact.core.models.utils.ModelToRepresentation;
import org.openfact.core.representations.idm.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
@ApplicationScoped
public class DefaultServerInfoResource implements ServerInfoResource {

    @Inject
    @Any
    private Instance<ComponentFactory> componentFactories;

    @Override
    public ServerInfoRepresentation getInfo() {
        ServerInfoRepresentation info = new ServerInfoRepresentation();
        info.setSystemInfo(SystemInfoRepresentation.create(System.currentTimeMillis()));
        info.setMemoryInfo(MemoryInfoRepresentation.create());
        info.setProfileInfo(ProfileInfoRepresentation.create());

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
            rep.setProperties(ModelToRepresentation.toRepresentation(configProperties));

            types.add(rep);
        }

        info.getComponentTypes().put(KeyProvider.class.getName(), types);
    }

}
