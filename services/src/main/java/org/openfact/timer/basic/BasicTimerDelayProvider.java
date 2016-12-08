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

package org.openfact.timer.basic;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.services.scheduled.ScheduledTaskRunner;
import org.openfact.timer.ScheduledTask;
import org.openfact.timer.TimerDelayProvider;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class BasicTimerDelayProvider implements TimerDelayProvider {

    private static final Logger logger = Logger.getLogger(BasicTimerDelayProvider.class);

    private final OpenfactSession session;
    private final Timer timer;
    private final BasicTimerDelayProviderFactory factory;

    public BasicTimerDelayProvider(OpenfactSession session, Timer timer, BasicTimerDelayProviderFactory factory) {
        this.session = session;
        this.timer = timer;
        this.factory = factory;
    }

    @Override
    public void schedule(Runnable runnable, Date firstTime, long intervalMillis, String taskName) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runnable.run();
            }
        };

        TimerTask existingTask = factory.putTask(taskName, task);
        if (existingTask != null) {
            logger.debugf("Existing timer task '%s' found. Cancelling it", taskName);
            existingTask.cancel();
        }

        logger.debugf("Starting task '%s' with interval '%d'", taskName, intervalMillis);
        timer.schedule(task, firstTime, intervalMillis);
    }

    @Override
    public void scheduleTask(ScheduledTask scheduledTask, Date firstTime, long intervalMillis, String taskName) {
        ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner(session.getOpenfactSessionFactory(), scheduledTask);
        this.schedule(scheduledTaskRunner, firstTime, intervalMillis, taskName);
    }
    
    @Override
    public void cancelTask(String taskName) {
        TimerTask existingTask = factory.removeTask(taskName);
        if (existingTask != null) {
            logger.debugf("Cancelling task '%s'", taskName);
            existingTask.cancel();
        }
    }

    @Override
    public void close() {
    }

}
