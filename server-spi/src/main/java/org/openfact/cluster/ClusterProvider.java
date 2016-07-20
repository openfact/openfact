package org.openfact.cluster;


import java.util.concurrent.Callable;

import org.openfact.provider.Provider;

/**
 * Various utils related to clustering and concurrent tasks on cluster nodes
 */
public interface ClusterProvider extends Provider {

    /**
     * Same value for all cluster nodes. It will use startup time of this server in non-cluster environment.
     */
    int getClusterStartupTime();


    /**
     * Execute given task just if it's not already in progress (either on this or any other cluster node).
     *
     * @param taskKey
     * @param taskTimeoutInSeconds timeout for given task. If there is existing task in progress for longer time, it's considered outdated so we will start our task.
     * @param task
     * @param <T>
     * @return result with "executed" flag specifying if execution was executed or ignored.
     */
    <T> ExecutionResult<T> executeIfNotExecuted(String taskKey, int taskTimeoutInSeconds, Callable<T> task);


    /**
     * Register task (listener) under given key. When this key will be put to the cache on any cluster node, the task will be executed
     *
     * @param taskKey
     * @param task
     */
    void registerListener(String taskKey, ClusterListener task);


    /**
     * Notify registered listeners on all cluster nodes
     *
     * @param taskKey
     * @param event
     */
    void notify(String taskKey, ClusterEvent event);
}
