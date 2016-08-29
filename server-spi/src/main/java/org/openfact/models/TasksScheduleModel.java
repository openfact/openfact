package org.openfact.models;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Deprecated
public interface TasksScheduleModel {

    String getId();

    int getAttempNumber();

    void setAttempNumber(int attempNumber);

    long getLapseTime();

    void setLapseTime(long lapseTime);

    int getOnErrorAttempNumber();

    void setOnErrorAttempNumber(int OnErrorAttempNumber);

    long getOnErrorLapseTime();

    void setOnErrorLapseTime(long onErrorlapseTime);

    long getDelayTime();

    void setDelayTime(long delayTime);

    LocalTime getSubmitTime();

    void setSubmitTime(LocalTime submitTime);

    Set<DayOfWeek> getSubmitDays();

    void setSubmitDays(Set<DayOfWeek> submitDays);

    OrganizationModel getOrganization();

}
