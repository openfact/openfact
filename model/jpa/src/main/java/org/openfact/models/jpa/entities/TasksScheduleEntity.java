package org.openfact.models.jpa.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "TASKS_SCHEDULE")
public class TasksScheduleEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "ORGANIZATION_ID", length = 36)
    private String id;

    @Column(name = "ATTEMP_NUMBER")
    private int attempNumber;

    @Column(name = "LAPSE_TIME")
    private long lapseTime;

    @Column(name = "ON_ERROR_ATTEMP_NUMBER")
    private int onErrorAttempNumber;

    @Column(name = "ON_ERROR_LAPSE_TIME")
    private long onErrorLapseTime;

    @Column(name = "DELAY_TIME")
    private long delayTime;

    @Column(name = "SUBMIT_TIME")
    private LocalTime submitTime;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "SUBMIT_DAY", joinColumns = { @JoinColumn(name = "SUBMIT_DAY_ID") })
    private Set<DayOfWeek> submitDays = new HashSet<DayOfWeek>();

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAttempNumber() {
        return attempNumber;
    }

    public void setAttempNumber(int attempNumber) {
        this.attempNumber = attempNumber;
    }

    public long getLapseTime() {
        return lapseTime;
    }

    public void setLapseTime(long lapseTime) {
        this.lapseTime = lapseTime;
    }

    public int getOnErrorAttempNumber() {
        return onErrorAttempNumber;
    }

    public void setOnErrorAttempNumber(int onErrorAttempNumber) {
        this.onErrorAttempNumber = onErrorAttempNumber;
    }

    public long getOnErrorLapseTime() {
        return onErrorLapseTime;
    }

    public void setOnErrorLapseTime(long onErrorLapseTime) {
        this.onErrorLapseTime = onErrorLapseTime;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    public LocalTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalTime submitTime) {
        this.submitTime = submitTime;
    }

    public Set<DayOfWeek> getSubmitDays() {
        return submitDays;
    }

    public void setSubmitDays(Set<DayOfWeek> submitDays) {
        this.submitDays = submitDays;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        TasksScheduleEntity other = (TasksScheduleEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
