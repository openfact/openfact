package org.openfact.models.ubl;

import java.time.LocalDateTime;

import org.openfact.models.OrganizationModel;

public interface JobReportModel {

	String getId();

	/*
	 * Job name and status
	 */
	String getJobName();

	void setJobName(String jobName);

	String getStatus();

	void setStatus(String status);

	/*
	 * Organization
	 */
	OrganizationModel getOrganization();

	void setOrganization(OrganizationModel organization);

	String getDocumentType();

	void setDocumentType(String documentType);

	/*
	 * Job parameters
	 */

	int getBatchSize();

	void setBatchSize(int batchSize);

	long getErrorThreshold();

	void setErrorThreshold(long errorThreshold);

	boolean isJmxMonitoring();

	void setJmxMonitoring(boolean jmxMonitoring);

	/*
	 * Job metrics
	 */
	LocalDateTime getStartTime();

	void setStartTime(LocalDateTime startTime);

	LocalDateTime getEndTime();

	void setEndTime(LocalDateTime endTime);

	LocalDateTime getDuration();

	void setDuration(LocalDateTime duration);

	long getReadCount();

	void setReadCount(long readCount);

	long getWriteCount();

	void setWriteCount(long writeCount);

	long getFilteredCount();

	void setFilteredCount(long filteredCount);

	long getErrorCount();

	void setErrorCount(long errorCount);

}
