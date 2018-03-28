package org.openfact.services;

import org.openfact.ServerInfoResource;
import org.openfact.UsersResource;
import org.openfact.keys.KeyProvider;
import org.openfact.keys.component.ComponentFactory;
import org.openfact.keys.provider.ConfiguredProvider;
import org.openfact.keys.provider.ProviderConfigProperty;
import org.openfact.models.UserModel;
import org.openfact.models.UserProvider;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import java.io.IOException;
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
