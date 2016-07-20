package org.openfact.models.dblock;

import org.openfact.provider.Provider;

public interface DBLockProvider extends Provider {


    /**
     * Try to retrieve DB lock or wait if retrieve was unsuccessful. Throw exception if lock can't be retrieved within specified timeout (900 seconds by default)
     */
    void waitForLock();


    /**
     * Release previously acquired lock
     */
    void releaseLock();


    /**
     * @return true if provider supports forced unlock at startup
     */
    boolean supportsForcedUnlock();


    /**
     * Will destroy whole state of DB lock (drop table/collection to track locking).
     */
    void destroyLockInfo();
}
