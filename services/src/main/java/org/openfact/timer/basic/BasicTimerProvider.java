package org.openfact.timer.basic;

import java.util.Timer;
import java.util.TimerTask;

import org.jboss.logging.Logger;
import org.openfact.models.RepeidSession;
import org.openfact.services.scheduled.ScheduledTaskRunner;
import org.openfact.timer.ScheduledTask;
import org.openfact.timer.TimerProvider;

/**
 * @author <a href="mailto:sthorger@redhat.com">Stian Thorgersen</a>
 */
public class BasicTimerProvider implements TimerProvider {

    private static final Logger logger = Logger.getLogger(BasicTimerProvider.class);

    private final RepeidSession session;
    private final Timer timer;
    private final BasicTimerProviderFactory factory;

    public BasicTimerProvider(RepeidSession session, Timer timer, BasicTimerProviderFactory factory) {
        this.session = session;
        this.timer = timer;
        this.factory = factory;
    }

    @Override
    public void schedule(final Runnable runnable, final long intervalMillis, String taskName) {
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
        timer.schedule(task, intervalMillis, intervalMillis);
    }

    @Override
    public void scheduleTask(ScheduledTask scheduledTask, long intervalMillis, String taskName) {
        ScheduledTaskRunner scheduledTaskRunner = new ScheduledTaskRunner(session.getRepeidSessionFactory(), scheduledTask);
        this.schedule(scheduledTaskRunner, intervalMillis, taskName);
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
        // do nothing
    }

}
