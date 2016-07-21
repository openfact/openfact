package org.openfact.cluster;

/**
 * Task to be executed on all cluster nodes once it's notified.
 */
public interface ClusterListener {

    /**
     * Registered task to be executed on all cluster nodes once it's notified from cache.
     *
     * @param event value of notification (Object added into the cache)
     */
    void run(ClusterEvent event);

}
