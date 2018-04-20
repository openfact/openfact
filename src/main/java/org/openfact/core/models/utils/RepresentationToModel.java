package org.openfact.core.models.utils;

import org.keycloak.common.util.MultivaluedHashMap;
import org.openfact.core.representations.idm.ComponentRepresentation;
import org.openfact.core.representations.idm.OrganizationRepresentation;
import org.openfact.core.keys.component.ComponentModel;
import org.openfact.core.keys.component.utils.ComponentUtil;
import org.openfact.core.keys.provider.ProviderConfigProperty;
import org.openfact.core.models.OrganizationModel;

import java.util.*;

public class RepresentationToModel {

    private RepresentationToModel() {
        // Just a util class
    }

    public static void updateOrganization(OrganizationRepresentation rep, OrganizationModel model) {
        if (rep.getName() != null) {
            model.setName(rep.getName());
        }

        if (rep.getDescription() != null) {
            model.setDescription(rep.getDescription());
        }

        if (rep.getUseCustomSmtpConfig() != null) {
            model.setUseCustomSmtpConfig(rep.getUseCustomSmtpConfig());
        }

        if (rep.getUseCustomCertificates() != null) {
            model.setUseCustomCertificates(rep.getUseCustomCertificates());
        }

        if (rep.getSmtpServer() != null) {
            model.setSmtpConfig(new HashMap<>(rep.getSmtpServer()));
        }
    }

    public static ComponentModel toModel(ComponentRepresentation rep) {
        ComponentModel model = new ComponentModel();
        model.setParentId(rep.getParentId());
        model.setProviderType(rep.getProviderType());
        model.setProviderId(rep.getProviderId());
        model.setConfig(new MultivaluedHashMap<>());
        model.setName(rep.getName());
        model.setSubType(rep.getSubType());

        if (rep.getConfig() != null) {
            Set<String> keys = new HashSet<>(rep.getConfig().keySet());
            for (String k : keys) {
                List<String> values = rep.getConfig().get(k);
                if (values != null) {
                    ListIterator<String> itr = values.listIterator();
                    while (itr.hasNext()) {
                        String v = itr.next();
                        if (v == null || v.trim().isEmpty()) {
                            itr.remove();
                        }
                    }

                    if (!values.isEmpty()) {
                        model.getConfig().put(k, values);
                    }
                }
            }
        }

        return model;
    }

    public static void updateComponent(ComponentRepresentation rep, ComponentModel component, boolean internal, ComponentUtil componentUtil) {
        if (rep.getName() != null) {
            component.setName(rep.getName());
        }

        if (rep.getParentId() != null) {
            component.setParentId(rep.getParentId());
        }

        if (rep.getProviderType() != null) {
            component.setProviderType(rep.getProviderType());
        }

        if (rep.getProviderId() != null) {
            component.setProviderId(rep.getProviderId());
        }

        if (rep.getSubType() != null) {
            component.setSubType(rep.getSubType());
        }

        Map<String, ProviderConfigProperty> providerConfiguration = null;
        if (!internal) {
            providerConfiguration = componentUtil.getComponentConfigProperties(component);
        }

        if (rep.getConfig() != null) {
            Set<String> keys = new HashSet<>(rep.getConfig().keySet());
            for (String k : keys) {
                if (!internal && !providerConfiguration.containsKey(k)) {
                    break;
                }

                List<String> values = rep.getConfig().get(k);
                if (values == null || values.isEmpty() || values.get(0) == null
                        || values.get(0).trim().isEmpty()) {
                    component.getConfig().remove(k);
                } else {
                    ListIterator<String> itr = values.listIterator();
                    while (itr.hasNext()) {
                        String v = itr.next();
                        if (v == null || v.trim().isEmpty() || v.equals(ComponentRepresentation.SECRET_VALUE)) {
                            itr.remove();
                        }
                    }

                    if (!values.isEmpty()) {
                        component.getConfig().put(k, values);
                    }
                }
            }
        }
    }

}
