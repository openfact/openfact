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
import org.openfact.models.*;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.services.ServicesLogger;
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.services.scheduled.ScheduledTaskRunner;
import org.openfact.timer.ScheduledTask;

import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class OrganizationScheduledTaskRunner implements ScheduledTask {

    protected static final Logger logger = Logger.getLogger(OrganizationScheduledTaskRunner.class);

    protected OrganizationModel organization;

    public OrganizationScheduledTaskRunner(OrganizationModel organization) {
        this.organization = organization;
    }

    @Override
    public void run(OpenfactSession session) {
        Set<OrganizationScheduleTaskProvider> provider = session.getAllProviders(OrganizationScheduleTaskProvider.class);
        Set<OrganizationScheduleTaskProvider> activeProviders = provider.stream().filter(p -> p.isActive()).collect(Collectors.toSet());

        ExecutorService executorService = null;
        try {
            executorService = Executors.newCachedThreadPool();

            for (OrganizationScheduleTaskProvider organizationTask: activeProviders) {
                ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner(session.getOpenfactSessionFactory(), new ScheduledTask() {
                    @Override
                    public void run(OpenfactSession session) {
                        organizationTask.run(session, organization);
                    }
                });
                executorService.execute(scheduledTaskRunner);
            }
        } finally {
            if(executorService != null) {
                executorService.shutdown();
            }
        }

    }
}
