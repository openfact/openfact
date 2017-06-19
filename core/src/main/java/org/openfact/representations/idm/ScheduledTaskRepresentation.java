package org.openfact.representations.idm;

import java.util.List;

public class ScheduledTaskRepresentation {

    private long remainingTime;
    private List<OrganizationScheduledTaskRepresentation> tasks;

    public long getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public List<OrganizationScheduledTaskRepresentation> getTasks() {
        return tasks;
    }

    public void setTasks(List<OrganizationScheduledTaskRepresentation> tasks) {
        this.tasks = tasks;
    }

}
