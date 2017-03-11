package org.openfact.services.managers;

import org.openfact.models.OrganizationModel;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Startup
@Singleton
public class ScheduleOrganizations {

    @Resource
    private TimerService timerService;

    private Map<String, Timer> organizationTimers;
    private Map<Timer, String> timerOrganizations;

    @PostConstruct
    private void init() {
        organizationTimers = new HashMap<>();
        timerOrganizations = new HashMap<>();
    }

    @PreDestroy
    private void close() {
        Collection<Timer> timers = timerService.getAllTimers();
        for (Timer t : timers) {
            t.cancel();
        }
    }

    @Lock(LockType.WRITE)
    public void scheduleTask(OrganizationModel organization) {
        if (organizationTimers.containsKey(organization.getId())) {
            Timer timer = organizationTimers.get(organization.getId());
            timer.cancel();
        }

        ScheduleExpression expression = new ScheduleExpression();
        Timer timer = timerService.createCalendarTimer(expression);

        organizationTimers.put(organization.getId(), timer);
        timerOrganizations.put(timer, organization.getId());
    }

    @Timeout
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void execute(Timer timer) {
        String organizationId = timerOrganizations.get(timer);

        System.out.println("executing task on organization id:" + organizationId);
    }
}
