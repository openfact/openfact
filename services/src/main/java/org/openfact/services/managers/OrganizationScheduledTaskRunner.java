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
package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.cluster.ClusterProvider;
import org.openfact.cluster.ExecutionResult;
import org.openfact.models.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.services.ServicesLogger;
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.services.scheduled.ScheduledTaskRunner;
import org.openfact.timer.ScheduledTask;

import javax.xml.registry.infomodel.Organization;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class OrganizationScheduledTaskRunner implements Runnable {

    private static final Logger logger = Logger.getLogger(OrganizationScheduledTaskRunner.class);

    protected final OpenfactSessionFactory sessionFactory;
    protected final OrganizationModel organization;

    public OrganizationScheduledTaskRunner(OpenfactSessionFactory sessionFactory, OrganizationModel organization) {
        this.sessionFactory = sessionFactory;
        this.organization = organization;
    }

    @Override
    public void run() {
        OpenfactSession session = sessionFactory.create();

        Set<OrganizationScheduleTaskProvider> provider = session.getAllProviders(OrganizationScheduleTaskProvider.class);
        Set<OrganizationScheduleTaskProvider> activeProviders = provider.stream().filter(p -> p.isActive()).collect(Collectors.toSet());

        try {
            for (OrganizationScheduleTaskProvider task: activeProviders) {
                session.getTransactionManager().begin();
                task.run(session, organization);
                session.getTransactionManager().commit();

                logger.debug("Executed scheduled task " + task.getClass().getSimpleName());
            }
        } catch (Throwable t) {
            ServicesLogger.LOGGER.failedToRunScheduledTask(t, this.getClass().getSimpleName());
            session.getTransactionManager().rollback();
        } finally {
            try {
                session.close();
            } catch (Throwable t) {
                ServicesLogger.LOGGER.failedToCloseProviderSession(t);
            }
        }
    }
}
