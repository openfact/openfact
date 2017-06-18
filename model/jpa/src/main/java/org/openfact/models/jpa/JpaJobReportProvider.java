package org.openfact.models.jpa;

import org.openfact.models.JobReportModel;
import org.openfact.models.JobReportProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.JobReportEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class JpaJobReportProvider implements JobReportProvider {

    @Inject
    protected EntityManager em;

    @Override
    public JobReportModel addJobReport(OrganizationModel organization, String name) throws ModelException {
        JobReportEntity entity = new JobReportEntity();
        entity.setJobName(name);
        entity.setOrganization(OrganizationAdapter.toEntity(organization, em));
        em.persist(entity);
        em.flush();
        return new JobReportAdapter(organization, em, entity);
    }

    @Override
    public JobReportModel getJobReport(OrganizationModel organization, String id) {
        JobReportEntity entity = em.find(JobReportEntity.class, id);
        if (entity != null) {
            return new JobReportAdapter(organization, em, entity);
        }
        return null;
    }

    @Override
    public List<JobReportModel> getJobReports(OrganizationModel organization) {
        return getJobReports(organization, -1, -1);
    }

    @Override
    public List<JobReportModel> getJobReports(OrganizationModel organization, Integer firstResult, Integer maxResults) {
        TypedQuery<JobReportEntity> query = em.createNamedQuery("getAllJobReportsByOrganization", JobReportEntity.class);
        query.setParameter("organizationId", organization.getId());
        if (firstResult != -1) {
            query.setFirstResult(firstResult);
        }
        if (maxResults != -1) {
            query.setMaxResults(maxResults);
        }
        List<JobReportEntity> results = query.getResultList();
        return results.stream().map(f -> new JobReportAdapter(organization, em, f)).collect(Collectors.toList());
    }

    @Override
    public boolean removeJobReport(OrganizationModel organization, JobReportModel jobReport) {
        if (!organization.equals(jobReport.getOrganization())) {
            return false;
        }
        JobReportEntity entity = JobReportAdapter.toEntity(jobReport, em);
        em.remove(entity);
        em.flush();
        return true;
    }

}