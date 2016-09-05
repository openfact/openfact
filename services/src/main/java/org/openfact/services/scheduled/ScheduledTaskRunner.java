
package org.openfact.services.scheduled;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.services.ServicesLogger;
import org.openfact.timer.ScheduledTask;

public class ScheduledTaskRunner implements Runnable {

    protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    protected final OpenfactSessionFactory sessionFactory;
    protected final ScheduledTask task;

    public ScheduledTaskRunner(OpenfactSessionFactory sessionFactory, ScheduledTask task) {
        this.sessionFactory = sessionFactory;
        this.task = task;
    }

    @Override
    public void run() {
        OpenfactSession session = sessionFactory.create();
        try {
            runTask(session);
        } catch (Throwable t) {
            logger.failedToRunScheduledTask(t, task.getClass().getSimpleName());

            session.getTransactionManager().rollback();
        } finally {
            try {
                session.close();
            } catch (Throwable t) {
                logger.failedToCloseProviderSession(t);
            }
        }
    }

    protected void runTask(OpenfactSession session) {
        session.getTransactionManager().begin();
        task.run(session);
        session.getTransactionManager().commit();

        logger.debug("Executed scheduled task " + task.getClass().getSimpleName());
    }

}
