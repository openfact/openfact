package org.openfact.models;

public interface JobReportModel {

    String getId();

    String getJobName();

    void setJobName(String jobName);

    long getStartTime();

    void setStartTime(long startTime);

    long getEndTime();

    void setEndTime(long endTime);

    long getDuration();

    void setDuration(long value);

    long getErrorCount();

    void setErrorCount(long value);

    long getReadCount();

    void setReadCount(long value);

    long getWriteCount();

    void setWriteCount(long value);

}
