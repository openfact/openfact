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

package org.openfact.models.ubl.cache.infinispan;

import org.infinispan.Cache;
import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.connections.infinispan.InfinispanConnectionProvider;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.cache.infinispan.entities.Revisioned;
import org.openfact.models.ubl.cache.DebitNoteCache;
import org.openfact.models.ubl.cache.DebitNoteCacheProviderFactory;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class InfinispanDebitNoteCacheProviderFactory implements DebitNoteCacheProviderFactory {

    private static final Logger log = Logger.getLogger(InfinispanDebitNoteCacheProviderFactory.class);

    protected volatile DebitNoteCacheManager userCache;

    @Override
    public DebitNoteCache create(OpenfactSession session) {
        lazyInit(session);
        return new DebitNoteCacheSession(userCache, session);
    }

    private void lazyInit(OpenfactSession session) {
        if (userCache == null) {
            synchronized (this) {
                if (userCache == null) {
                    Cache<String, Revisioned> cache = session.getProvider(InfinispanConnectionProvider.class)
                            .getCache(InfinispanConnectionProvider.USER_CACHE_NAME);
                    Cache<String, Long> revisions = session.getProvider(InfinispanConnectionProvider.class)
                            .getCache(InfinispanConnectionProvider.USER_REVISIONS_CACHE_NAME);
                    userCache = new DebitNoteCacheManager(cache, revisions);
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
