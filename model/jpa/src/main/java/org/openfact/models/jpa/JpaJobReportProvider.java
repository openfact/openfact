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
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.jpa.entities.JobReportEntity;
import org.openfact.models.jpa.entities.StorageFileEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class JpaJobReportProvider extends AbstractHibernateStorage implements JobReportProvider {

    protected static final Logger logger = Logger.getLogger(JpaJobReportProvider.class);

    private static final String FILE_NAME = "fileName";

    private final OpenfactSession session;
    protected EntityManager em;

    public JpaJobReportProvider(OpenfactSession session, EntityManager em) {
        this.session = session;
        this.em = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }


    @Override
    public JobReportModel createJobReport(OrganizationModel organization, String jobReportName) {
        JobReportEntity entity = new JobReportEntity();
        entity.setJobName(jobReportName);
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(entity);
        em.flush();
        return new JobReportAdapter(session, organization, em, entity);
    }

    @Override
    public JobReportModel getJobReportById(OrganizationModel organization, String id) {
        JobReportEntity entity = em.find(JobReportEntity.class, id);
        if(entity != null) {
            return new JobReportAdapter(session, organization, em, entity);
        }
        return null;
    }

    @Override
    public List<JobReportModel> getJobReports(OrganizationModel organization) {
        return getJobReports(organization, -1, -1);
    }

    @Override
    public List<JobReportModel> getJobReports(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        String queryName = "getAllJobsReportByOrganization";

        TypedQuery<JobReportEntity> query = em.createNamedQuery(queryName, JobReportEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<JobReportEntity> results = query.getResultList();
        List<JobReportModel> invoices = results.stream().map(f -> new JobReportAdapter(session, organization, em, f)).collect(Collectors.toList());
        return invoices;
    }

    @Override
    public boolean removeJobReport(OrganizationModel organization, String id) {
        JobReportEntity entity = em.find(JobReportEntity.class, id);
        if(entity != null) {
            em.remove(entity);
            em.flush();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeJobReport(OrganizationModel organization, JobReportModel jobReport) {
        return removeJobReport(organization, jobReport.getId());
    }

    @Override
    public void close() {
    }
}
