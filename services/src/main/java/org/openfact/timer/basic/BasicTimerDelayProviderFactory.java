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

package org.openfact.timer.basic;

import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.timer.TimerDelayProvider;
import org.openfact.timer.TimerDelayProviderFactory;
import org.openfact.timer.TimerProvider;
import org.openfact.timer.TimerProviderFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class BasicTimerDelayProviderFactory implements TimerDelayProviderFactory {

    private Timer timer;

    private ConcurrentMap<String, TimerTask> scheduledTasks = new ConcurrentHashMap<String, TimerTask>();

    @Override
    public TimerDelayProvider create(OpenfactSession session) {
        return new BasicTimerDelayProvider(session, timer, this);
    }

    @Override
    public void init(Config.Scope config) {
        timer = new Timer();
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {

    }

    @Override
    public void close() {
        timer.cancel();
        timer = null;
    }

    @Override
    public String getId() {
        return "basic";
    }

    protected TimerTask putTask(String taskName, TimerTask task) {
        return scheduledTasks.put(taskName, task);
    }

    protected TimerTask removeTask(String taskName) {
        return scheduledTasks.remove(taskName);
    }

}
