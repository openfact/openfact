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

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.JobReportEntity;
import org.openfact.models.jpa.entities.StorageFileEntity;

import javax.persistence.EntityManager;
import java.util.Map;

public class JobReportAdapter implements JobReportModel, JpaModel<JobReportEntity> {

    protected static final Logger logger = Logger.getLogger(JobReportAdapter.class);

    protected OrganizationModel organization;
    protected JobReportEntity jobReport;
    protected EntityManager em;
    protected OpenfactSession session;

    public JobReportAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em, JobReportEntity jobReport) {
        this.organization = organization;
        this.session = session;
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
    public long getIncrementFilteredCount() {
        return jobReport.getIncrementFilteredCount();
    }

    @Override
    public void setIncrementFilteredCount(long value) {
        jobReport.setIncrementFilteredCount(value);
    }

    @Override
    public long getIncrementErrorCount() {
        return jobReport.getIncrementErrorCount();
    }

    @Override
    public void setIncrementErrorCount(long value) {
        jobReport.setIncrementErrorCount(value);
    }

    @Override
    public long getIncrementReadCount() {
        return jobReport.getIncrementReadCount();
    }

    @Override
    public void setIncrementWriteCount(long count) {
        jobReport.setIncrementWriteCount(count);
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
    public long getFilteredCount() {
        return jobReport.getFilteredCount();
    }

    @Override
    public void setFilteredCount(long value) {
        jobReport.setFilteredCount(value);
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
    public Map<String, String> getAttributes() {
        return jobReport.getAttributes();
    }

    @Override
    public void addAttribute(String name, String value) {
        jobReport.getAttributes().put(name, value);
    }

}
