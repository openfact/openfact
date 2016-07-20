package org.openfact.timer.basic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.openfact.Config;
import org.openfact.models.RepeidSession;
import org.openfact.models.RepeidSessionFactory;
import org.openfact.timer.TimerProvider;
import org.openfact.timer.TimerProviderFactory;

public class BasicTimerProviderFactory implements TimerProviderFactory {

    private Timer timer;

    private ConcurrentMap<String, TimerTask> scheduledTasks = new ConcurrentHashMap<String, TimerTask>();

    @Override
    public TimerProvider create(RepeidSession session) {
        return new BasicTimerProvider(session, timer, this);
    }

    @Override
    public void init(Config.Scope config) {
        timer = new Timer();
    }

    @Override
    public void postInit(RepeidSessionFactory factory) {

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
