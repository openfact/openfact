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
package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.JobReportModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.JobReportEntity;

public class JobReportAdapter implements JobReportModel, JpaModel<JobReportEntity> {

    protected static final Logger logger = Logger.getLogger(JobReportAdapter.class);

    protected OrganizationModel organization;
    protected JobReportEntity jobReport;
    protected EntityManager em;

    public JobReportAdapter(OrganizationModel organization, EntityManager em, JobReportEntity jobReport) {
        this.organization = organization;
        this.em = em;
        this.jobReport = jobReport;
    }

    public static JobReportEntity toEntity(JobReportModel model, EntityManager em) {
        if (model instanceof JobReportAdapter) {
            return ((JobReportAdapter) model).getEntity();
        }
        return em.getReference(JobReportEntity.class, model.getId());
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
    public long getStartTime() {
        return jobReport.getStartTime();
    }

    @Override
    public void setStartTime(long startTime) {
        jobReport.setStartTime(startTime);
    }

    @Override
    public long getEndTime() {
        return jobReport.getEndTime();
    }

    @Override
    public void setEndTime(long endTime) {
        jobReport.setEndTime(endTime);
    }

    @Override
    public long getDuration() {
        return jobReport.getDuration();
    }

    @Override
    public void setDuration(long value) {
        jobReport.setDuration(value);
    }

    @Override
    public long getErrorCount() {
        return jobReport.getErrorCount();
    }

    @Override
    public void setErrorCount(long value) {
        jobReport.setErrorCount(value);
    }

    @Override
    public long getReadCount() {
        return jobReport.getReadCount();
    }

    @Override
    public void setReadCount(long value) {
        jobReport.setReadCount(value);
    }

    @Override
    public long getWriteCount() {
        return jobReport.getWriteCount();
    }

    @Override
    public void setWriteCount(long value) {
        jobReport.setWriteCount(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof JobReportModel)) return false;

        JobReportModel that = (JobReportModel) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
