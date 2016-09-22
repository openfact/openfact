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
package org.openfact.services.managers;

import org.openfact.cluster.ClusterEvent;
import org.openfact.cluster.ClusterListener;
import org.openfact.cluster.ClusterProvider;
import org.openfact.cluster.ExecutionResult;
import org.openfact.common.util.Time;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.OrganizationModel;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.services.ServicesLogger;
import org.openfact.timer.TimerProvider;


import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class UblSyncManager {

    private static final String FEDERATION_TASK_KEY = "federation";

    protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    /**
     * Check federationProviderModel of all organizations and possibly start periodic sync for them
     *
     * @param sessionFactory
     * @param timer
     */
    public void bootstrapPeriodic(final OpenfactSessionFactory sessionFactory, final TimerProvider timer) {
        OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                /*List<OrganizationModel> organizations = session.organizations().getOrganizations();
                for (final OrganizationModel organization : organizations) {
                    List<UserFederationProviderModel> federationProviders = organization.getUserFederationProviders();
                    for (final UserFederationProviderModel fedProvider : federationProviders) {
                        refreshPeriodicSyncForProvider(sessionFactory, timer, fedProvider, organization.getId());
                    }
                }*/

                /*ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
                clusterProvider.registerListener(FEDERATION_TASK_KEY, new UserFederationClusterListener(sessionFactory));*/
            }
        });
    }


    /*private class Holder {
        ExecutionResult<UserFederationSyncResult> result;
    }

    public UserFederationSyncResult syncAllUsers(final OpenfactSessionFactory sessionFactory, final String organizationId, final UserFederationProviderModel fedProvider) {
        final Holder holder = new Holder();

        // Ensure not executed concurrently on this or any other cluster node
        OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
                // shared key for "full" and "changed" . Improve if needed
                String taskKey = fedProvider.getId() + "::sync";

                // 30 seconds minimal timeout for now
                int timeout = Math.max(30, fedProvider.getFullSyncPeriod());
                holder.result = clusterProvider.executeIfNotExecuted(taskKey, timeout, new Callable<UserFederationSyncResult>() {

                    @Override
                    public UserFederationSyncResult call() throws Exception {
                        final UserFederationProviderFactory fedProviderFactory = (UserFederationProviderFactory) sessionFactory.getProviderFactory(UserFederationProvider.class, fedProvider.getProviderName());
                        updateLastSyncInterval(sessionFactory, fedProvider, organizationId);
                        return fedProviderFactory.syncAllUsers(sessionFactory, organizationId, fedProvider);
                    }

                });
            }

        });

        if (holder.result == null || !holder.result.isExecuted()) {
            logger.debugf("syncAllUsers for federation provider %s was ignored as it's already in progress", fedProvider.getDisplayName());
            return UserFederationSyncResult.ignored();
        } else {
            return holder.result.getResult();
        }
    }

    public UserFederationSyncResult syncChangedUsers(final OpenfactSessionFactory sessionFactory, final String organizationId, final UserFederationProviderModel fedProvider) {
        final Holder holder = new Holder();

        // Ensure not executed concurrently on this or any other cluster node
        OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
                // shared key for "full" and "changed" . Improve if needed
                String taskKey = fedProvider.getId() + "::sync";

                // 30 seconds minimal timeout for now
                int timeout = Math.max(30, fedProvider.getChangedSyncPeriod());
                holder.result = clusterProvider.executeIfNotExecuted(taskKey, timeout, new Callable<UserFederationSyncResult>() {

                    @Override
                    public UserFederationSyncResult call() throws Exception {
                        final UserFederationProviderFactory fedProviderFactory = (UserFederationProviderFactory) sessionFactory.getProviderFactory(UserFederationProvider.class, fedProvider.getProviderName());

                        // See when we did last sync.
                        int oldLastSync = fedProvider.getLastSync();
                        updateLastSyncInterval(sessionFactory, fedProvider, organizationId);
                        return fedProviderFactory.syncChangedUsers(sessionFactory, organizationId, fedProvider, Time.toDate(oldLastSync));
                    }

                });
            }

        });

        if (holder.result == null || !holder.result.isExecuted()) {
            logger.debugf("syncChangedUsers for federation provider %s was ignored as it's already in progress", fedProvider.getDisplayName());
            return UserFederationSyncResult.ignored();
        } else {
            return holder.result.getResult();
        }
    }


    // Ensure all cluster nodes are notified
    public void notifyToRefreshPeriodicSync(OpenfactSession session, OrganizationModel organization, UserFederationProviderModel federationProvider, boolean removed) {
        FederationProviderClusterEvent event = FederationProviderClusterEvent.createEvent(removed, organization.getId(), federationProvider);
        session.getProvider(ClusterProvider.class).notify(FEDERATION_TASK_KEY, event);
    }


    // Executed once it receives notification that some UserFederationProvider was created or updated
    protected void refreshPeriodicSyncForProvider(final OpenfactSessionFactory sessionFactory, TimerProvider timer, final UserFederationProviderModel fedProvider, final String organizationId) {
        logger.debugf("Going to refresh periodic sync for provider '%s' . Full sync period: %d , changed users sync period: %d",
                fedProvider.getDisplayName(), fedProvider.getFullSyncPeriod(), fedProvider.getChangedSyncPeriod());

        if (fedProvider.getFullSyncPeriod() > 0) {
            // We want periodic full sync for this provider
            timer.schedule(new Runnable() {

                @Override
                public void run() {
                    try {
                        boolean shouldPerformSync = shouldPerformNewPeriodicSync(fedProvider.getLastSync(), fedProvider.getChangedSyncPeriod());
                        if (shouldPerformSync) {
                            syncAllUsers(sessionFactory, organizationId, fedProvider);
                        } else {
                            logger.debugf("Ignored periodic full sync with federation provider %s due small time since last sync", fedProvider.getDisplayName());
                        }
                    } catch (Throwable t) {
                        logger.errorDuringFullUserSync(t);
                    }
                }

            }, fedProvider.getFullSyncPeriod() * 1000, fedProvider.getId() + "-FULL");
        } else {
            timer.cancelTask(fedProvider.getId() + "-FULL");
        }

        if (fedProvider.getChangedSyncPeriod() > 0) {
            // We want periodic sync of just changed users for this provider
            timer.schedule(new Runnable() {

                @Override
                public void run() {
                    try {
                        boolean shouldPerformSync = shouldPerformNewPeriodicSync(fedProvider.getLastSync(), fedProvider.getChangedSyncPeriod());
                        if (shouldPerformSync) {
                            syncChangedUsers(sessionFactory, organizationId, fedProvider);
                        } else {
                            logger.debugf("Ignored periodic changed-users sync with federation provider %s due small time since last sync", fedProvider.getDisplayName());
                        }
                    } catch (Throwable t) {
                        logger.errorDuringChangedUserSync(t);
                    }
                }

            }, fedProvider.getChangedSyncPeriod() * 1000, fedProvider.getId() + "-CHANGED");

        } else {
            timer.cancelTask(fedProvider.getId() + "-CHANGED");
        }
    }

    // Skip syncing if there is short time since last sync time.
    private boolean shouldPerformNewPeriodicSync(int lastSyncTime, int period) {
        if (lastSyncTime <= 0) {
            return true;
        }

        int currentTime = Time.currentTime();
        int timeSinceLastSync = currentTime - lastSyncTime;

        return (timeSinceLastSync * 2 > period);
    }

    // Executed once it receives notification that some UserFederationProvider was removed
    protected void removePeriodicSyncForProvider(TimerProvider timer, UserFederationProviderModel fedProvider) {
        logger.debugf("Removing periodic sync for provider %s", fedProvider.getDisplayName());
        timer.cancelTask(fedProvider.getId() + "-FULL");
        timer.cancelTask(fedProvider.getId() + "-CHANGED");
    }

    // Update interval of last sync for given UserFederationProviderModel. Do it in separate transaction
    private void updateLastSyncInterval(final OpenfactSessionFactory sessionFactory, final UserFederationProviderModel fedProvider, final String organizationId) {
        OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                OrganizationModel persistentOrganization = session.organizations().getOrganization(organizationId);
                List<UserFederationProviderModel> persistentFedProviders = persistentOrganization.getUserFederationProviders();
                for (UserFederationProviderModel persistentFedProvider : persistentFedProviders) {
                    if (fedProvider.getId().equals(persistentFedProvider.getId())) {
                        // Update persistent provider in DB
                        int lastSync = Time.currentTime();
                        persistentFedProvider.setLastSync(lastSync);
                        persistentOrganization.updateUserFederationProvider(persistentFedProvider);

                        // Update "cached" reference
                        fedProvider.setLastSync(lastSync);
                    }
                }
            }

        });
    }


    private class UserFederationClusterListener implements ClusterListener {

        private final OpenfactSessionFactory sessionFactory;

        public UserFederationClusterListener(OpenfactSessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

        @Override
        public void run(ClusterEvent event) {
            final FederationProviderClusterEvent fedEvent = (FederationProviderClusterEvent) event;
            OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                @Override
                public void run(OpenfactSession session) {
                    TimerProvider timer = session.getProvider(TimerProvider.class);
                    if (fedEvent.isRemoved()) {
                        removePeriodicSyncForProvider(timer, fedEvent.getFederationProvider());
                    } else {
                        refreshPeriodicSyncForProvider(sessionFactory, timer, fedEvent.getFederationProvider(), fedEvent.getOrganizationId());
                    }
                }

            });
        }
    }


    // Send to cluster during each update or remove of federationProvider, so all nodes can update sync periods
    public static class FederationProviderClusterEvent implements ClusterEvent {

        private boolean removed;
        private String organizationId;
        private UserFederationProviderModel federationProvider;

        public boolean isRemoved() {
            return removed;
        }

        public void setRemoved(boolean removed) {
            this.removed = removed;
        }

        public String getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(String organizationId) {
            this.organizationId = organizationId;
        }

        public UserFederationProviderModel getFederationProvider() {
            return federationProvider;
        }

        public void setFederationProvider(UserFederationProviderModel federationProvider) {
            this.federationProvider = federationProvider;
        }

        public static FederationProviderClusterEvent createEvent(boolean removed, String organizationId, UserFederationProviderModel fedProvider) {
            FederationProviderClusterEvent notification = new FederationProviderClusterEvent();
            notification.setRemoved(removed);
            notification.setOrganizationId(organizationId);
            notification.setFederationProvider(fedProvider);
            return notification;
        }
    }*/

}
