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

public class OrganizationTaskManager {

    private static final String FEDERATION_TASK_KEY = "federation";

    protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    public OrganizationTaskManager(OpenfactSession session) {
        // TODO Auto-generated constructor stub
    }

    public void schedulePeriodicTask(OrganizationModel organization) {
        // TODO Auto-generated method stub
        
    }

    public void reschedulePeriodicTask(OrganizationModel organization) {
        // TODO Auto-generated method stub
        
    }

    

}
