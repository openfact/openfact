package org.openfact.services.managers;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationScheduleTaskProvider;
import org.openfact.timer.ScheduledTask;

public class OrganizationScheduledTaskRunner implements ScheduledTask {

    protected OrganizationModel organization;

    public OrganizationScheduledTaskRunner(OrganizationModel organization) {
        this.organization = organization;
    }

    @Override
    public void run(OpenfactSession session) {
        Set<OrganizationScheduleTaskProvider> tasks = session.getAllProviders(OrganizationScheduleTaskProvider.class);
        ExecutorService es = Executors.newCachedThreadPool();
        for (OrganizationScheduleTaskProvider task : tasks) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    task.run(organization);
                }
            });
        }
    }

}
