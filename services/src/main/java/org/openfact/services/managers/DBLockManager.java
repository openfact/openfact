package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.OrganizationProviderFactory;
import org.openfact.models.RepeidSession;
import org.openfact.models.dblock.DBLockProvider;
import org.openfact.models.dblock.DBLockProviderFactory;

public class DBLockManager {

	private static final Logger logger = Logger.getLogger(DBLockManager.class);

	private final RepeidSession session;

	public DBLockManager(RepeidSession session) {
		this.session = session;
	}

	public void checkForcedUnlock() {
		if (Boolean.getBoolean("repeid.dblock.forceUnlock")) {
			DBLockProvider lock = getDBLock();
			if (lock.supportsForcedUnlock()) {
				logger.info("Force to release DB LOCK");				
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
		return (DBLockProviderFactory) session.getRepeidSessionFactory().getProviderFactory(DBLockProvider.class, organizationProviderId);
	}

	private String getOrganizationProviderId() {
		OrganizationProviderFactory organizationProviderFactory = (OrganizationProviderFactory) session.getRepeidSessionFactory().getProviderFactory(OrganizationProvider.class);
		return organizationProviderFactory.getId();
	}

}
