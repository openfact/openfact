/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.models.dblock;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.OrganizationProviderFactory;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class DBLockManager {

    protected static final Logger logger = Logger.getLogger(DBLockManager.class);

    private final OpenfactSession session;

    public DBLockManager(OpenfactSession session) {
        this.session = session;
    }


    public void checkForcedUnlock() {
        if (Boolean.getBoolean("openfact.dblock.forceUnlock")) {
            DBLockProvider lock = getDBLock();
            if (lock.supportsForcedUnlock()) {
                logger.warn("Forced release of DB lock at startup requested by System property. Make sure to not use this in production environment! And especially when more cluster nodes are started concurrently.");
                lock.releaseLock();
            } else {
                throw new IllegalStateException("Forced unlock requested, but provider " + lock + " doesn't support it");
            }
        }
    }


    // Try to detect ID from organizationProvider
    public DBLockProvider getDBLock() {
        String organizationProviderId = getOrganizationProviderId();
        return session.getProvider(DBLockProvider.class, organizationProviderId);
    }

    public DBLockProviderFactory getDBLockFactory() {
        String organizationProviderId = getOrganizationProviderId();
        return (DBLockProviderFactory) session.getOpenfactSessionFactory().getProviderFactory(DBLockProvider.class, organizationProviderId);
    }

    private String getOrganizationProviderId() {
        OrganizationProviderFactory organizationProviderFactory = (OrganizationProviderFactory) session.getOpenfactSessionFactory().getProviderFactory(OrganizationProvider.class);
        return organizationProviderFactory.getId();
    }

}
