/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.models.utils;

import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.Provider;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.provider.ProviderFactory;
import org.openfact.representations.idm.ComponentRepresentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class ComponentUtil {

    public static Map<String, ProviderConfigProperty> getComponentConfigProperties(OpenfactSession session, ComponentRepresentation component) {
        return getComponentConfigProperties(session, component.getProviderType(), component.getProviderId());
    }

    public static Map<String, ProviderConfigProperty> getComponentConfigProperties(OpenfactSession session, ComponentModel component) {
        return getComponentConfigProperties(session, component.getProviderType(), component.getProviderId());
    }

    public static ComponentFactory getComponentFactory(OpenfactSession session, ComponentRepresentation component) {
        return getComponentFactory(session, component.getProviderType(), component.getProviderId());
    }

    public static ComponentFactory getComponentFactory(OpenfactSession session, ComponentModel component) {
        return getComponentFactory(session, component.getProviderType(), component.getProviderId());
    }

    private static Map<String, ProviderConfigProperty> getComponentConfigProperties(OpenfactSession session, String providerType, String providerId) {
        try {
            ComponentFactory componentFactory = getComponentFactory(session, providerType, providerId);
            List<ProviderConfigProperty> l = componentFactory.getConfigProperties();
            Map<String, ProviderConfigProperty> properties = new HashMap<>();
            for (ProviderConfigProperty p : l) {
                properties.put(p.getName(), p);
            }
            List<ProviderConfigProperty> common = componentFactory.getCommonProviderConfigProperties();
            for (ProviderConfigProperty p : common) {
                properties.put(p.getName(), p);
            }

            return properties;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static ComponentFactory getComponentFactory(OpenfactSession session, String providerType, String providerId) {
        Class<? extends Provider> provider = session.getProviderClass(providerType);
        if (provider == null) {
            throw new IllegalArgumentException("Invalid provider type '" + providerType + "'");
        }

        ProviderFactory<? extends Provider> f = session.getOpenfactSessionFactory().getProviderFactory(provider, providerId);
        if (f == null) {
            throw new IllegalArgumentException("No such provider '" + providerId + "'");
        }

        ComponentFactory cf = (ComponentFactory) f;
        return cf;
    }

    public static void notifyCreated(OpenfactSession session, OrganizationModel organization, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(session, model);
        factory.onCreate(session, organization, model);
//        if (factory instanceof UserStorageProviderFactory) {
//            ((OnCreateComponent) session.userStorageManager()).onCreate(session, organization, model);
//        }
    }

    public static void notifyUpdated(OpenfactSession session, OrganizationModel organization, ComponentModel model) {
        ComponentFactory factory = getComponentFactory(session, model);
        factory.onUpdate(session, organization, model);
    }

}
