package org.openfact.services.managers;

import org.jboss.logging.Logger;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;
import org.openfact.models.OrganizationScheduledTask;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@Stateless
public class ScheduleOrganizations {

    protected static final Logger logger = Logger.getLogger(ScheduleOrganizations.class);

    @Resource
    private TimerService timerService;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    @Any
    private Instance<OrganizationScheduledTask> tasks;

    public void scheduleTask(OrganizationModel organization) {
        cancelTask(organization);

        TimerConfig config = new TimerConfig(new OrganizationTimer(organization.getId()), true);
        timerService.createIntervalTimer(organization.getTaskFirstTime(), organization.getTaskDelay(), config);

        logger.info("Timer organization[" + organization.getId() + "] was scheduled");
    }

    public void cancelTask(OrganizationModel organization) {
        for (Timer timer : timerService.getAllTimers()) {
            if (timer.getInfo() instanceof OrganizationTimer) {
                OrganizationTimer organizationTimer = (OrganizationTimer) timer.getInfo();
                if (organizationTimer.getOrganizationId().equals(organization.getId())) {
                    timer.cancel();
                    logger.info("Timer organization[" + organizationTimer.getOrganizationId() + "] was canceled");
                }
            }
        }
    }

    public long remainingTime(OrganizationModel organization) {
        for (Timer timer : timerService.getAllTimers()) {
            if (timer.getInfo() instanceof OrganizationTimer) {
                OrganizationTimer organizationTimer = (OrganizationTimer) timer.getInfo();
                if (organizationTimer.getOrganizationId().equals(organization.getId())) {
                    return timer.getTimeRemaining();
                }
            }
        }
        return -1;
    }

    @Timeout
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    private void execute(Timer timer) {
        if (timer.getInfo() instanceof OrganizationTimer) {
            OrganizationTimer organizationTimer = (OrganizationTimer) timer.getInfo();
            OrganizationModel organization = organizationProvider.getOrganization(organizationTimer.getOrganizationId());
            if (organization.isTasksEnabled()) {
                for (OrganizationScheduledTask task : tasks) {
                    executeSingleTask(task, organization);
                }
            } else {
                logger.warn("Canceling organization[" + timer + "] timer");
                timer.cancel();
            }
        }
    }

    private void executeSingleTask(OrganizationScheduledTask task, OrganizationModel organization) {
        logger.info("Executing organization[" + organization.getId() + "] timer");
        task.executeTask(organization);
        logger.info("Closing Timer organization[" + organization.getId() + "] timer");
    }

}
