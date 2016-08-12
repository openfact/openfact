package org.openfact.representations.idm;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class TasksScheduleRepresentation {

    private String id;
    private Integer attempNumber;
    private Long lapseTime;
    private Integer onErrorAttempNumber;
    private Long onErrorLapseTime;
    private Long delayTime;
    private LocalTime submitTime;
    private Set<DayOfWeek> submitDays = new HashSet<DayOfWeek>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAttempNumber() {
        return attempNumber;
    }

    public void setAttempNumber(Integer attempNumber) {
        this.attempNumber = attempNumber;
    }

    public Long getLapseTime() {
        return lapseTime;
    }

    public void setLapseTime(Long lapseTime) {
        this.lapseTime = lapseTime;
    }

    public Integer getOnErrorAttempNumber() {
        return onErrorAttempNumber;
    }

    public void setOnErrorAttempNumber(Integer onErrorAttempNumber) {
        this.onErrorAttempNumber = onErrorAttempNumber;
    }

    public Long getOnErrorLapseTime() {
        return onErrorLapseTime;
    }

    public void setOnErrorLapseTime(Long onErrorLapseTime) {
        this.onErrorLapseTime = onErrorLapseTime;
    }

    public Long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Long delayTime) {
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

}
