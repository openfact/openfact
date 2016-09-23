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

import java.util.Map.Entry;
import java.util.function.Predicate;

import org.infinispan.Cache;
import org.infinispan.notifications.Listener;
import org.jboss.logging.Logger;
import org.openfact.models.cache.infinispan.CacheManager;
import org.openfact.models.cache.infinispan.entities.Revisioned;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
@Listener
public class DebitNoteCacheManager extends CacheManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteCacheManager.class);

    protected volatile boolean enabled = true;

    public DebitNoteCacheManager(Cache<String, Revisioned> cache, Cache<String, Long> revisions) {
        super(cache, revisions);
    }

    @Override
    protected Predicate<Entry<String, Revisioned>> getInvalidationPredicate(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

}
