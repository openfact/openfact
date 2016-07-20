
package org.openfact.services.scheduled;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.timer.ScheduledTask;

public class ScheduledTaskRunner implements Runnable {

	private static final Logger logger = Logger.getLogger(ScheduledTaskRunner.class);

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
        	logger.info("Failed to run Shedule Task " + task.getClass().getSimpleName());

            session.getTransaction().rollback();
        } finally {
            try {
                session.close();
            } catch (Throwable t) {
            	logger.info("Failed to close Provider Session " + t);
            }
        }
    }

    protected void runTask(OpenfactSession session) {
        session.getTransaction().begin();
        task.run(session);
        session.getTransaction().commit();

        logger.debug("Executed scheduled task " + task.getClass().getSimpleName());
    }

}
