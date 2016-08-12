package org.openfact.models.jpa;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.TasksScheduleModel;
import org.openfact.models.jpa.entities.TasksScheduleEntity;

public class TasksScheduleAdapter implements TasksScheduleModel, JpaModel<TasksScheduleEntity> {

    protected static final Logger logger = Logger.getLogger(TasksScheduleAdapter.class);

    protected OrganizationModel organization;
    protected TasksScheduleEntity tasksSchedule;
    protected EntityManager em;
    protected OpenfactSession session;

    public TasksScheduleAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            TasksScheduleEntity tasksSchedule) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.tasksSchedule = tasksSchedule;
    }

    @Override
    public TasksScheduleEntity getEntity() {
        return tasksSchedule;
    }

    public static TasksScheduleEntity toEntity(TasksScheduleModel model, EntityManager em) {
        if (model instanceof TasksScheduleAdapter) {
            return ((TasksScheduleAdapter) model).getEntity();
        }
        return em.getReference(TasksScheduleEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return tasksSchedule.getId();
    }

    @Override
    public int getAttempNumber() {
        return tasksSchedule.getAttempNumber();
    }

    @Override
    public void setAttempNumber(int attempNumber) {
        tasksSchedule.setAttempNumber(attempNumber);
    }

    @Override
    public long getLapseTime() {
        return tasksSchedule.getLapseTime();
    }

    @Override
    public void setLapseTime(long lapseTime) {
        tasksSchedule.setLapseTime(lapseTime);
    }

    @Override
    public int getOnErrorAttempNumber() {
        return tasksSchedule.getOnErrorAttempNumber();
    }

    @Override
    public void setOnErrorAttempNumber(int OnErrorAttempNumber) {
        tasksSchedule.setOnErrorAttempNumber(OnErrorAttempNumber);
    }

    @Override
    public long getOnErrorLapseTime() {
        return tasksSchedule.getOnErrorLapseTime();
    }

    @Override
    public void setOnErrorLapseTime(long onErrorlapseTime) {
        tasksSchedule.setOnErrorLapseTime(onErrorlapseTime);
    }

    @Override
    public long getDelayTime() {
        return tasksSchedule.getDelayTime();
    }

    @Override
    public void setDelayTime(long delayTime) {
        tasksSchedule.setDelayTime(delayTime);
    }

    @Override
    public LocalTime getSubmitTime() {
        return tasksSchedule.getSubmitTime();
    }

    @Override
    public void setSubmitTime(LocalTime submitTime) {
        tasksSchedule.setSubmitTime(submitTime);
    }

    @Override
    public Set<DayOfWeek> getSubmitDays() {
        return tasksSchedule.getSubmitDays();
    }

    @Override
    public void setSubmitDays(Set<DayOfWeek> submitDays) {
        tasksSchedule.setSubmitDays(submitDays);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tasksSchedule == null) ? 0 : tasksSchedule.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TasksScheduleAdapter other = (TasksScheduleAdapter) obj;
        if (tasksSchedule == null) {
            if (other.tasksSchedule != null)
                return false;
        } else if (!tasksSchedule.equals(other.tasksSchedule))
            return false;
        return true;
    }

}
