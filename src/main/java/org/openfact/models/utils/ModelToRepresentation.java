package org.openfact.models.utils;

import org.keycloak.common.util.MultivaluedHashMap;
import org.openfact.keys.component.ComponentModel;
import org.openfact.keys.component.utils.ComponentUtil;
import org.openfact.keys.provider.ProviderConfigProperty;
import org.openfact.models.CompanyModel;
import org.openfact.models.UserModel;
import org.openfact.representations.idm.CompanyRepresentation;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.representations.idm.ConfigPropertyRepresentation;
import org.openfact.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ModelToRepresentation {

    private ModelToRepresentation() {
        // Util Class
    }

    public static CompanyRepresentation toRepresentation(CompanyModel model, boolean fullInfo) {
        CompanyRepresentation rep = new CompanyRepresentation();
        rep.setId(model.getId());
        rep.setName(model.getName());

        CompanyRepresentation.CompanyOwnerRepresentation ownerRepresentation = new CompanyRepresentation.CompanyOwnerRepresentation();
        rep.setOwner(ownerRepresentation);
        ownerRepresentation.setId(model.getOwner().getId());
        ownerRepresentation.setIdentityId(model.getOwner().getIdentityId());

        if (fullInfo) {
            rep.setDescription(model.getDescription());
            rep.setUseCustomSmtpConfig(model.getUseCustomSmtpConfig());
            rep.setSmtpServer(new HashMap<>(model.getSmtpConfig()));
        }

        return rep;
    }

    public static UserRepresentation toRepresentation(UserModel model, boolean fullInfo) {
        UserRepresentation rep = new UserRepresentation();

        rep.setId(model.getId());
        rep.setUsername(model.getUsername());
        rep.setEmail(model.getEmail());

        if (fullInfo) {

        }

        return rep;
    }

    public static ComponentRepresentation toRepresentation(ComponentModel component, boolean internal, ComponentUtil componentUtil) {
        ComponentRepresentation rep = new ComponentRepresentation();
        rep.setId(component.getId());
        rep.setName(component.getName());
        rep.setProviderId(component.getProviderId());
        rep.setProviderType(component.getProviderType());
        rep.setSubType(component.getSubType());
        rep.setParentId(component.getParentId());
        if (internal) {
            rep.setConfig(component.getConfig());
        } else {
            Map<String, ProviderConfigProperty> configProperties = componentUtil.getComponentConfigProperties(component);
            MultivaluedHashMap<String, String> config = new MultivaluedHashMap<>();

            for (Map.Entry<String, List<String>> e : component.getConfig().entrySet()) {
                ProviderConfigProperty configProperty = configProperties.get(e.getKey());
                if (configProperty != null) {
                    if (configProperty.isSecret()) {
                        config.putSingle(e.getKey(), ComponentRepresentation.SECRET_VALUE);
                    } else {
                        config.put(e.getKey(), e.getValue());
                    }
                }
            }

            rep.setConfig(config);
        }
        return rep;
    }

    public static List<ConfigPropertyRepresentation> toRepresentation(List<ProviderConfigProperty> configProperties) {
        List<ConfigPropertyRepresentation> propertiesRep = new LinkedList<>();
        for (ProviderConfigProperty prop : configProperties) {
            ConfigPropertyRepresentation propRep = toRepresentation(prop);
            propertiesRep.add(propRep);
        }
        return propertiesRep;
    }

    public static ConfigPropertyRepresentation toRepresentation(ProviderConfigProperty prop) {
        ConfigPropertyRepresentation propRep = new ConfigPropertyRepresentation();
        propRep.setName(prop.getName());
        propRep.setLabel(prop.getLabel());
        propRep.setType(prop.getType());
        propRep.setDefaultValue(prop.getDefaultValue());
        propRep.setOptions(prop.getOptions());
        propRep.setHelpText(prop.getHelpText());
        propRep.setSecret(prop.isSecret());
        return propRep;
    }

}
