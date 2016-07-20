package org.openfact.connections.jpa.updater.liquibase.lock;

import liquibase.exception.DatabaseException;
import liquibase.exception.LockException;
import liquibase.lockservice.StandardLockService;

public class DummyLockService extends StandardLockService {

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void init() throws DatabaseException {
    }

    @Override
    public void waitForLock() throws LockException {
    }

    @Override
    public void releaseLock() throws LockException {
    }

}
