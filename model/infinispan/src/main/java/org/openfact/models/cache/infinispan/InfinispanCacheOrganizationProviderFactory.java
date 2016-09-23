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

package org.openfact.models.cache.infinispan;

import org.infinispan.Cache;
import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.connections.infinispan.InfinispanConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.cache.CacheOrganizationProvider;
import org.openfact.models.cache.CacheOrganizationProviderFactory;
import org.openfact.models.cache.infinispan.entities.Revisioned;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class InfinispanCacheOrganizationProviderFactory implements CacheOrganizationProviderFactory {

    private static final Logger log = Logger.getLogger(InfinispanCacheOrganizationProviderFactory.class);

    protected volatile OrganizationCacheManager organizationCache;

    @Override
    public CacheOrganizationProvider create(OpenfactSession session) {
        lazyInit(session);
        return new OrganizationCacheSession(organizationCache, session);
    }

    private void lazyInit(OpenfactSession session) {
        if (organizationCache == null) {
            synchronized (this) {
                if (organizationCache == null) {
                    Cache<String, Revisioned> cache = session.getProvider(InfinispanConnectionProvider.class)
                            .getCache(InfinispanConnectionProvider.ORGANIZATION_CACHE_NAME);
                    Cache<String, Long> revisions = session.getProvider(InfinispanConnectionProvider.class)
                            .getCache(InfinispanConnectionProvider.ORGANIZATION_REVISIONS_CACHE_NAME);
                    organizationCache = new OrganizationCacheManager(cache, revisions);
                }
            }
        }
    }

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "default";
    }

}
