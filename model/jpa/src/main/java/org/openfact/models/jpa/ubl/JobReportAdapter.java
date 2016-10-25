package org.openfact.models.jpa.ubl;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.OrganizationAdapter;
import org.openfact.models.jpa.entities.ubl.JobReportEntity;
import org.openfact.models.jpa.ubl.common.UBLExtensionsAdapter;
import org.openfact.models.ubl.JobReportModel;

public class JobReportAdapter implements JobReportModel, JpaModel<JobReportEntity> {

	protected static final Logger logger = Logger.getLogger(JobReportAdapter.class);

	protected OrganizationModel organization;
	protected JobReportEntity jobReport;
	protected EntityManager em;
	protected OpenfactSession session;

	public JobReportAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
			JobReportEntity jobReport) {
		this.organization = organization;
		this.session = session;
		this.em = em;
		this.jobReport = jobReport;
	}

	@Override
	public JobReportEntity getEntity() {
		return jobReport;
	}

	@Override
	public String getId() {
		return jobReport.getId();
	}

	@Override
	public String getJobName() {
		return jobReport.getJobName();
	}

	@Override
	public void setJobName(String jobName) {
		jobReport.setJobName(jobName);
	}

	@Override
	public String getStatus() {
		return jobReport.getStatus();
	}

	@Override
	public void setStatus(String status) {
		jobReport.setStatus(status);
	}

	@Override
	public int getBatchSize() {
		return jobReport.getBatchSize();
	}

	@Override
	public void setBatchSize(int batchSize) {
		jobReport.setBatchSize(batchSize);
	}

	@Override
	public long getErrorThreshold() {
		return jobReport.getErrorThreshold();
	}

	@Override
	public void setErrorThreshold(long errorThreshold) {
		jobReport.setErrorThreshold(errorThreshold);
	}

	@Override
	public boolean isJmxMonitoring() {
		return jobReport.isJmxMonitoring();
	}

	@Override
	public void setJmxMonitoring(boolean jmxMonitoring) {
		jobReport.setJmxMonitoring(jmxMonitoring);
	}

	@Override
	public LocalDateTime getStartTime() {
		return jobReport.getStartTime();
	}

	@Override
	public void setStartTime(LocalDateTime startTime) {
		jobReport.setStartTime(startTime);
	}

	@Override
	public LocalDateTime getEndTime() {
		return jobReport.getEndTime();
	}

	@Override
	public void setEndTime(LocalDateTime endTime) {
		jobReport.setEndTime(endTime);
	}

	@Override
	public LocalDateTime getDuration() {
		return jobReport.getDuration();
	}

	@Override
	public void setDuration(LocalDateTime duration) {
		jobReport.setDuration(duration);
	}

	@Override
	public long getReadCount() {
		return jobReport.getReadCount();
	}

	@Override
	public void setReadCount(long readCount) {
		jobReport.setReadCount(readCount);
	}

	@Override
	public long getWriteCount() {
		return jobReport.getWriteCount();
	}

	@Override
	public void setWriteCount(long writeCount) {
		jobReport.setWriteCount(writeCount);
	}

	@Override
	public long getFilteredCount() {
		return jobReport.getFilteredCount();
	}

	@Override
	public void setFilteredCount(long filteredCount) {
		jobReport.setFilteredCount(filteredCount);
	}

	@Override
	public long getErrorCount() {
		return jobReport.getErrorCount();
	}

	@Override
	public void setErrorCount(long errorCount) {
		jobReport.setErrorCount(errorCount);
	}

	@Override
	public OrganizationModel getOrganization() {
		return new OrganizationAdapter(session, em, jobReport.getOrganization());
	}

	@Override
	public void setOrganization(OrganizationModel organization) {
		jobReport.setOrganization(OrganizationAdapter.toEntity(organization, em));
	}

	@Override
	public String getDocumentType() {
		return jobReport.getDocumentType();
	}

	@Override
	public void setDocumentType(String documentType) {
		jobReport.setDocumentType(documentType);
	}

}
