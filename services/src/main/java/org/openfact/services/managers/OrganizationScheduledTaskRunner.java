/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
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
 *******************************************************************************/
package org.openfact.services.managers;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationScheduleTaskProvider;
import org.openfact.timer.ScheduledTask;

public class OrganizationScheduledTaskRunner implements ScheduledTask {

    protected OrganizationModel organization;

    public OrganizationScheduledTaskRunner(OrganizationModel organization) {
        this.organization = organization;
    }

    @Override
    public void run(OpenfactSession session) {
        Set<OrganizationScheduleTaskProvider> tasks = session.getAllProviders(OrganizationScheduleTaskProvider.class);
        ExecutorService es = Executors.newCachedThreadPool();
        for (OrganizationScheduleTaskProvider task : tasks) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    task.run(organization);
                }
            });
        }
    }

}
