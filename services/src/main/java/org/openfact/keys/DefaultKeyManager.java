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

package org.openfact.keys;

import org.jboss.logging.Logger;
import org.openfact.component.ComponentModel;
import org.openfact.models.KeyManager;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.ProviderFactory;

import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.*;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class DefaultKeyManager implements KeyManager {

    private static final Logger logger = Logger.getLogger(DefaultKeyManager.class);

    private final OpenfactSession session;
    private final Map<String, List<KeyProvider>> providersMap = new HashMap<>();

    public DefaultKeyManager(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public ActiveKey getActiveKey(OrganizationModel organization) {
        for (KeyProvider p : getProviders(organization)) {
            if (p.getKid() != null && p.getPrivateKey() != null) {
                if (logger.isTraceEnabled()) {
                    logger.tracev("Active key organization={0} kid={1}", organization.getName(), p.getKid());
                }
                String kid = p.getKid();
                return new ActiveKey(kid, p.getPrivateKey(), p.getPublicKey(kid), p.getCertificate(kid));
            }
        }
        throw new RuntimeException("Failed to get keys");
    }

    @Override
    public PublicKey getPublicKey(OrganizationModel organization, String kid) {
        if (kid == null) {
            logger.warnv("KID is null, can't find public key", organization.getName(), kid);
            return null;
        }

        for (KeyProvider p : getProviders(organization)) {
            PublicKey publicKey = p.getPublicKey(kid);
            if (publicKey != null) {
                if (logger.isTraceEnabled()) {
                    logger.tracev("Found public key organization={0} kid={1}", organization.getName(), kid);
                }
                return publicKey;
            }
        }
        if (logger.isTraceEnabled()) {
            logger.tracev("Failed to find public key organization={0} kid={1}", organization.getName(), kid);
        }
        return null;
    }

    @Override
    public Certificate getCertificate(OrganizationModel organization, String kid) {
        if (kid == null) {
            logger.warnv("KID is null, can't find public key", organization.getName(), kid);
            return null;
        }

        for (KeyProvider p : getProviders(organization)) {
            Certificate certificate = p.getCertificate(kid);
            if (certificate != null) {
                if (logger.isTraceEnabled()) {
                    logger.tracev("Found certificate organization={0} kid={1}", organization.getName(), kid);
                }
                return certificate;
            }
        }
        if (logger.isTraceEnabled()) {
            logger.tracev("Failed to find certificate organization={0} kid={1}", organization.getName(), kid);
        }
        return null;
    }

    @Override
    public List<KeyMetadata> getKeys(OrganizationModel organization, boolean includeDisabled) {
        List<KeyMetadata> keys = new LinkedList<>();
        for (KeyProvider p : getProviders(organization)) {
            if (includeDisabled) {
                keys.addAll(p.getKeyMetadata());
            } else {
                p.getKeyMetadata().stream().filter(k -> k.getStatus() != KeyMetadata.Status.DISABLED).forEach(k -> keys.add(k));
            }
        }
        return keys;
    }

    private List<KeyProvider> getProviders(OrganizationModel organization) {
        boolean active = false;
        List<KeyProvider> providers = providersMap.get(organization.getId());
        if (providers == null) {
            providers = new LinkedList<>();

            List<ComponentModel> components = new LinkedList<>(organization.getComponents(organization.getId(), KeyProvider.class.getName()));
            components.sort(new ProviderComparator());

            for (ComponentModel c : components) {
                try {
                    ProviderFactory<KeyProvider> f = session.getOpenfactSessionFactory().getProviderFactory(KeyProvider.class, c.getProviderId());
                    KeyProviderFactory factory = (KeyProviderFactory) f;
                    KeyProvider provider = factory.create(session, c);
                    session.enlistForClose(provider);
                    providers.add(provider);
                    if (!active && provider.getKid() != null && provider.getPrivateKey() != null) {
                        active = true;
                    }
                } catch (Throwable t) {
                    logger.errorv(t, "Failed to load provider {0}", c.getId());
                }
            }

            if (!active) {
                providers.add(new FailsafeRsaKeyProvider());
            }

            providersMap.put(organization.getId(), providers);
        }
        return providers;
    }

    private class ProviderComparator implements Comparator<ComponentModel> {

        @Override
        public int compare(ComponentModel o1, ComponentModel o2) {
            int i = Long.compare(o2.get("priority", 0l), o1.get("priority", 0l));
            return i != 0 ? i : o1.getId().compareTo(o2.getId());
        }

    }
}
