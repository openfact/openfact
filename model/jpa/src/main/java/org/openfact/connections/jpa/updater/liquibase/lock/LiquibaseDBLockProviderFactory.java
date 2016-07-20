package org.openfact.connections.jpa.updater.liquibase.lock;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.common.util.Time;
import org.openfact.models.RepeidSession;
import org.openfact.models.RepeidSessionFactory;
import org.openfact.models.dblock.DBLockProviderFactory;

public class LiquibaseDBLockProviderFactory implements DBLockProviderFactory {

    private static final Logger logger = Logger.getLogger(LiquibaseDBLockProviderFactory.class);

    private long lockWaitTimeoutMillis;

    protected long getLockWaitTimeoutMillis() {
        return lockWaitTimeoutMillis;
    }

    @Override
    public void init(Config.Scope config) {
        int lockWaitTimeout = config.getInt("lockWaitTimeout", 900);
        this.lockWaitTimeoutMillis = Time.toMillis(lockWaitTimeout);
        logger.debugf("Liquibase lock provider configured with lockWaitTime: %d seconds", lockWaitTimeout);
    }

    @Override
    public void postInit(RepeidSessionFactory factory) {

    }

    @Override
    public LiquibaseDBLockProvider create(RepeidSession session) {
        return new LiquibaseDBLockProvider(this, session);
    }

    @Override
    public void setTimeouts(long lockRecheckTimeMillis, long lockWaitTimeoutMillis) {
        this.lockWaitTimeoutMillis = lockWaitTimeoutMillis;
    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "jpa";
    }
}
