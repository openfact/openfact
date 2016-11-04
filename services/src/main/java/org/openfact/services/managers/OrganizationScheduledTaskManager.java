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

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.timer.TimerProvider;

public class OrganizationScheduledTaskManager {

    public static final String PREFIX = "ORG_";

    protected OpenfactSession session;

    public OrganizationScheduledTaskManager(OpenfactSession session) {
        this.session = session;
    }

    public void schedulePeriodicTask(OrganizationModel organization) {

    }

    public void reschedulePeriodicTask(OrganizationModel organization) {

    }

    public void cancelPeriodicTask(OrganizationModel organization) {
        TimerProvider timer = session.getProvider(TimerProvider.class);
        timer.cancelTask(getTaskName(organization));
    }

    protected String getTaskName(OrganizationModel organization) {
        return PREFIX + organization.getId();
    }

}
