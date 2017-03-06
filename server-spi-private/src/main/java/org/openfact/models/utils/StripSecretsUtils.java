package org.openfact.models.utils;

import org.openfact.models.provider.ProviderConfigProperty;
import org.openfact.representations.idm.ComponentRepresentation;
import org.openfact.representations.idm.IdentityProviderRepresentation;
import org.openfact.representations.idm.OrganizationRepresentation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StripSecretsUtils {

    public static ComponentRepresentation strip(ComponentUtil componentUtil, ComponentRepresentation rep) {
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

    public static OrganizationRepresentation strip(OrganizationRepresentation rep) {
        if (rep.getSmtpServer() != null && rep.getSmtpServer().containsKey("password")) {
            rep.getSmtpServer().put("password", ComponentRepresentation.SECRET_VALUE);
        }
        return rep;
    }

    public static IdentityProviderRepresentation strip(IdentityProviderRepresentation rep) {
        if (rep.getConfig() != null && rep.getConfig().containsKey("clientSecret")) {
            rep.getConfig().put("clientSecret", ComponentRepresentation.SECRET_VALUE);
        }
        return rep;
    }

}