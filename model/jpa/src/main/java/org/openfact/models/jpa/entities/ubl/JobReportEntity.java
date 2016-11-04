/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDateTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.jpa.entities.OrganizationEntity;

@Entity
@Table(name = "JOB_REPORT")
public class JobReportEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
		
	/*
	 * Job name and status
	 */
	@Column(name = "JOB_NAME")
	private String jobName;

	@Column(name = "STATUS")
	private String status;
	/*
	 * Job by Organization
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
	private OrganizationEntity organization;
	/*
	 * Job by Document Name
	 */
	@Column(name = "DOCUMENT_TYPE")
	private String documentType;
	/*
	 * Job parameters
	 */
	@Column(name = "BATCH_SIZE")
	private int batchSize;

	@Column(name = "ERROR_THRESHOLD")
	private long errorThreshold;

	@Column(name = "JMX_MONITORING")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean jmxMonitoring;
	/*
	 * Job metrics
	 */
	@Column(name = "START_TIME")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	private LocalDateTime startTime;

	@Column(name = "END_TIME")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	private LocalDateTime endTime;

	@Column(name = "DURATION")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	private LocalDateTime duration;

	@Column(name = "READ_COUNT")
	private long readCount;

	@Column(name = "WRITE_COUNT")
	private long writeCount;

	@Column(name = "FILTERED_COUNT")
	private long filteredCount;

	@Column(name = "ERROR_COUNT")
	private long errorCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public long getErrorThreshold() {
		return errorThreshold;
	}

	public void setErrorThreshold(long errorThreshold) {
		this.errorThreshold = errorThreshold;
	}

	public boolean isJmxMonitoring() {
		return jmxMonitoring;
	}

	public void setJmxMonitoring(boolean jmxMonitoring) {
		this.jmxMonitoring = jmxMonitoring;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public LocalDateTime getDuration() {
		return duration;
	}

	public void setDuration(LocalDateTime duration) {
		this.duration = duration;
	}

	public long getReadCount() {
		return readCount;
	}

	public void setReadCount(long readCount) {
		this.readCount = readCount;
	}

	public long getWriteCount() {
		return writeCount;
	}

	public void setWriteCount(long writeCount) {
		this.writeCount = writeCount;
	}

	public long getFilteredCount() {
		return filteredCount;
	}

	public void setFilteredCount(long filteredCount) {
		this.filteredCount = filteredCount;
	}

	public long getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(long errorCount) {
		this.errorCount = errorCount;
	}	
}
