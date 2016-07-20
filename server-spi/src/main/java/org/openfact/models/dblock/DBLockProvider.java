package org.openfact.models.dblock;

import org.openfact.provider.Provider;

/**
 * Global database lock to ensure that some actions in DB can be done just be one cluster node at a time.
 *
 *
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
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
     * Check if I have lock
     *
     * @return
     */
    boolean hasLock();


    /**
     * @return true if provider supports forced unlock at startup
     */
    boolean supportsForcedUnlock();


    /**
     * Will destroy whole state of DB lock (drop table/collection to track locking).
     * */
    void destroyLockInfo();
}
