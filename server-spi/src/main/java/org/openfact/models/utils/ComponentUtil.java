/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates
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
 */

package org.openfact.models.utils;

import org.openfact.component.ComponentFactory;
import org.openfact.component.ComponentModel;
import org.openfact.models.OpenfactSession;
import org.openfact.provider.Provider;
import org.openfact.provider.ProviderConfigProperty;
import org.openfact.provider.ProviderFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class ComponentUtil {

    public static Map<String, ProviderConfigProperty> getComponentConfigProperties(OpenfactSession session, ComponentModel component) {
        try {
            List<ProviderConfigProperty> l = getComponentFactory(session, component).getConfigProperties();
            Map<String, ProviderConfigProperty> properties = new HashMap<>();
            for (ProviderConfigProperty p : l) {
                properties.put(p.getName(), p);
            }
            return properties;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ComponentFactory getComponentFactory(OpenfactSession session, ComponentModel component) {
        Class<? extends Provider> provider = session.getProviderClass(component.getProviderType());
        if (provider == null) {
            throw new RuntimeException("Invalid provider type '" + component.getProviderType() + "'");
        }

        ProviderFactory<? extends Provider> f = session.getOpenfactSessionFactory().getProviderFactory(provider, component.getProviderId());
        if (f == null) {
            throw new RuntimeException("No such provider '" + component.getProviderId() + "'");
        }

        ComponentFactory cf = (ComponentFactory) f;
        return cf;
    }

}
