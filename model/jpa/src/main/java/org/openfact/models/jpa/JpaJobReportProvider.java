package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.*;
import org.openfact.models.jpa.entities.JobReportEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class JpaJobReportProvider implements JobReportProvider {

    protected static final Logger logger = Logger.getLogger(JpaJobReportProvider.class);

    @PersistenceContext
    protected EntityManager em;

    static AdminJobReport convertAdminJobReport(JobReportEntity jobReportEntity) {
        AdminJobReport adminJobReport = new AdminJobReport();

        adminJobReport.setId(jobReportEntity.getId());
        adminJobReport.setJobName(jobReportEntity.getJobName());
        adminJobReport.setDuration(jobReportEntity.getDuration());
        adminJobReport.setStartTime(jobReportEntity.getStartTime());
        adminJobReport.setEndTime(jobReportEntity.getEndTime());
        adminJobReport.setErrorCount(jobReportEntity.getErrorCount());
        adminJobReport.setReadCount(jobReportEntity.getReadCount());
        adminJobReport.setWriteCount(jobReportEntity.getWriteCount());

        return adminJobReport;
    }

    @Override
    public JobReportQuery createQuery(OrganizationModel organization) {
        return new JpaJobReportQuery(em, organization);
    }

    @Override
    public JobReportModel createJobReport(OrganizationModel organization, String jobReportName) throws ModelException {
        JobReportEntity entity = new JobReportEntity();
        entity.setJobName(jobReportName);
        entity.setOrganizationId(organization.getId());
        em.persist(entity);
        em.flush();
        return new JobReportAdapter(organization, em, entity);
    }

    @Override
    public JobReportModel getJobReportById(OrganizationModel organization, String id) {
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
    public boolean removeJobReport(OrganizationModel organization, String id) {
        JobReportEntity entity = em.find(JobReportEntity.class, id);
        if (entity != null) {
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
    public void preRemove(OrganizationModel organization) {
        em.createNamedQuery("deleteJobReportsByOrganization").setParameter("organizationId", organization.getId()).executeUpdate();
    }

}
