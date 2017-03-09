package org.openfact.models.utils;

import org.openfact.components.utils.ComponentUtil;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.representations.idm.IdentityProviderRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Stateless
public class StripSecretsUtils {

    @Inject
    private ComponentUtil componentUtil;

    public ComponentRepresentation strip(ComponentRepresentation rep) {
        Map<String, ProviderConfigProperty> configProperties = componentUtil.getComponentConfigProperties(rep);
        if (rep.getConfig() == null) {
            return rep;
        }

        Iterator<Map.Entry<String, List<String>>> itr = rep.getConfig().entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, List<String>> next = itr.next();
            ProviderConfigProperty configProperty = configProperties.get(next.getKey());
            if (configProperty != null) {
                if (configProperty.isSecret()) {
                    next.setValue(Collections.singletonList(ComponentRepresentation.SECRET_VALUE));
                }
            } else {
                itr.remove();
            }
        }
        return rep;
    }

    public OrganizationRepresentation strip(OrganizationRepresentation rep) {
        if (rep.getSmtpServer() != null && rep.getSmtpServer().containsKey("password")) {
            rep.getSmtpServer().put("password", ComponentRepresentation.SECRET_VALUE);
        }
        return rep;
    }

    public IdentityProviderRepresentation strip(IdentityProviderRepresentation rep) {
        if (rep.getConfig() != null && rep.getConfig().containsKey("clientSecret")) {
            rep.getConfig().put("clientSecret", ComponentRepresentation.SECRET_VALUE);
        }
        return rep;
    }

}