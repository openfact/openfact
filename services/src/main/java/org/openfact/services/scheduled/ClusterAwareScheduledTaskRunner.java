package org.openfact.services.scheduled;

import java.util.concurrent.Callable;

import org.jboss.logging.Logger;
import org.openfact.cluster.ClusterProvider;
import org.openfact.cluster.ExecutionResult;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.timer.ScheduledTask;

/**
 * Ensures that there are not concurrent executions of same task (either on this host or any other cluster host)
 */
public class ClusterAwareScheduledTaskRunner extends ScheduledTaskRunner {

	private static final Logger logger = Logger.getLogger(ClusterAwareScheduledTaskRunner.class);

	
    private final int intervalSecs;

    public ClusterAwareScheduledTaskRunner(OpenfactSessionFactory sessionFactory, ScheduledTask task, long intervalMillis) {
        super(sessionFactory, task);
        this.intervalSecs = (int) (intervalMillis / 1000);
    }

    @Override
    protected void runTask(final OpenfactSession session) {
        session.getTransactionManager().begin();

        ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
        String taskKey = task.getClass().getSimpleName();

        ExecutionResult<Void> result = clusterProvider.executeIfNotExecuted(taskKey, intervalSecs, new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                task.run(session);
                return null;
            }

        });

        session.getTransactionManager().commit();

        if (result.isExecuted()) {
            logger.debugf("Executed scheduled task %s", taskKey);
        } else {
            logger.debugf("Skipped execution of task %s as other cluster node is executing it", taskKey);
        }
    }


}
