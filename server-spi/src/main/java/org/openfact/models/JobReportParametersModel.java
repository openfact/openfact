package org.openfact.models;

public interface JobReportParametersModel {

    String getId();

    long getErrorThreshold();

    void setErrorThreshold(long errorThreshold);

    boolean isJmxMonitoring();

    void setJmxMonitoring(boolean jmxMonitoring);

    int getBatchSize();

    void setBatchSize(int batchSize);

}
