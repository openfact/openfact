package org.openfact.services.scheduled;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.timer.ScheduledTask;

/**
 * Ensures that there are not concurrent executions of same task (either on this
 * host or any other cluster host)
 */
public class ClusterAwareScheduledTaskRunner extends ScheduledTaskRunner {

    private final int intervalSecs;

    public ClusterAwareScheduledTaskRunner(OpenfactSessionFactory sessionFactory, ScheduledTask task, long intervalMillis) {
        super(sessionFactory, task);
        this.intervalSecs = (int) (intervalMillis / 1000);
    }

    @Override
    protected void runTask(final OpenfactSession session) {
        session.getTransactionManager().begin();
        task.run(session);
        session.getTransactionManager().commit();

        logger.debug("Executed scheduled task " + task.getClass().getSimpleName());
    }

}
