package org.openfact.auth;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.OrganizationProviderFactory;

public class SecurityContextManager {

    protected static final Logger logger = Logger.getLogger(SecurityContextManager.class);

    protected OpenfactSession session;
    protected SecurityContextProvider model;
    private final HttpHeaders headers;
    private final HttpServletRequest request;

    public SecurityContextManager(OpenfactSession session, HttpHeaders headers, HttpServletRequest request) {
        this.session = session;
        this.model = session.get
        this.headers = headers;
        this.request = request;
    }

    public void checkForcedUnlock() {
        if (Boolean.getBoolean("openfact.dblock.forceUnlock")) {
            DBLockProvider lock = getDBLock();
            if (lock.supportsForcedUnlock()) {
                logger.warn(
                        "Forced release of DB lock at startup requested by System property. Make sure to not use this in production environment! And especially when more cluster nodes are started concurrently.");
                lock.releaseLock();
            } else {
                throw new IllegalStateException(
                        "Forced unlock requested, but provider " + lock + " doesn't support it");
            }
        }
    }

    // Try to detect ID from realmProvider
    public DBLockProvider getDBLock() {
        String realmProviderId = getOrganizationProviderId();
        return session.getProvider(DBLockProvider.class, realmProviderId);
    }

    public AuthProviderFactory getAuthProviderFactory() {
        String realmProviderId = getOrganizationProviderId();
        return (DBLockProviderFactory) session.getOpenfactSessionFactory()
                .getProviderFactory(DBLockProvider.class, realmProviderId);
    }

    private String getOrganizationProviderId() {
        OrganizationProviderFactory organizationProviderFactory = (OrganizationProviderFactory) session
                .getOpenfactSessionFactory().getProviderFactory(OrganizationProvider.class);
        return organizationProviderFactory.getId();
    }

}
