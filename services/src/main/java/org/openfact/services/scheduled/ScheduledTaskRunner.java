
package org.openfact.services.scheduled;

import org.jboss.logging.Logger;
import org.openfact.models.RepeidSession;
import org.openfact.models.RepeidSessionFactory;
import org.openfact.timer.ScheduledTask;

public class ScheduledTaskRunner implements Runnable {

	private static final Logger logger = Logger.getLogger(ScheduledTaskRunner.class);

    protected final RepeidSessionFactory sessionFactory;
    protected final ScheduledTask task;

    public ScheduledTaskRunner(RepeidSessionFactory sessionFactory, ScheduledTask task) {
        this.sessionFactory = sessionFactory;
        this.task = task;
    }

    @Override
    public void run() {
    	RepeidSession session = sessionFactory.create();
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

    protected void runTask(RepeidSession session) {
        session.getTransaction().begin();
        task.run(session);
        session.getTransaction().commit();

        logger.debug("Executed scheduled task " + task.getClass().getSimpleName());
    }

}
