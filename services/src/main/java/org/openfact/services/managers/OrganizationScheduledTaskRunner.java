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
import org.openfact.services.resources.OpenfactApplication;
import org.openfact.timer.ScheduledTask;

import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrganizationScheduledTaskRunner implements ScheduledTask {

    protected static final Logger logger = Logger.getLogger(OrganizationScheduledTaskRunner.class);

    protected OrganizationModel organization;
    protected String providerId;

    public OrganizationScheduledTaskRunner(OrganizationModel organization, String providerId) {
        this.organization = organization;
        this.providerId = providerId;
    }

    @Override
    public void run(OpenfactSession session) {
        OrganizationScheduleTaskProvider provider = session.getProvider(OrganizationScheduleTaskProvider.class, providerId);
        provider.run(organization);
    }

}
