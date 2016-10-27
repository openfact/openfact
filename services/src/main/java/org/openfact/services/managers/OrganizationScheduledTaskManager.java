package org.openfact.services.managers;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.services.scheduled.OrganizationScheduledTaskRunner;
import org.openfact.timer.TimerProvider;

public class OrganizationScheduledTaskManager {

    public static final String PREFIX = "ORG_";

    protected OpenfactSession session;

    public OrganizationScheduledTaskManager(OpenfactSession session) {
        this.session = session;
    }

    public void schedulePeriodicTask(OrganizationModel organization) {
        OpenfactSessionFactory sessionFactory = session.getOpenfactSessionFactory();
        if (organization.isTasksEnabled()) {
            TimerProvider timer = session.getProvider(TimerProvider.class);
            timer.schedule(new OrganizationScheduledTaskRunner(sessionFactory, organization), organization.getTaskFirstTime(), organization.getTaskDelay(), getTaskName(organization));
        }
    }

    public void reschedulePeriodicTask(OrganizationModel organization) {
        OpenfactSessionFactory sessionFactory = session.getOpenfactSessionFactory();

        TimerProvider timer = session.getProvider(TimerProvider.class);
        timer.cancelTask(getTaskName(organization));

        if (organization.isTasksEnabled()) {
            timer.schedule(new OrganizationScheduledTaskRunner(sessionFactory, organization), organization.getTaskFirstTime(), organization.getTaskDelay(), getTaskName(organization));
        }

    }

    public void cancelPeriodicTask(OrganizationModel organization) {
        TimerProvider timer = session.getProvider(TimerProvider.class);
        timer.cancelTask(getTaskName(organization));
    }

    protected String getTaskName(OrganizationModel organization) {
        return PREFIX + organization.getId();
    }

}
