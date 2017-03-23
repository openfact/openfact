package org.openfact.models.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.openfact.models.AdminJobReport;
import org.openfact.models.JobReportQuery;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.JobReportEntity;

public class JpaJobReportQuery implements JobReportQuery {

    private EntityManager em;

    private CriteriaBuilder cb;
    private CriteriaQuery<JobReportEntity> cq;
    private Root<JobReportEntity> root;
    private ArrayList<Predicate> predicates;
    private Integer firstResult;
    private Integer maxResults;

    public JpaJobReportQuery(EntityManager em, OrganizationModel organization) {
        this.em = em;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(JobReportEntity.class);
        root = cq.from(JobReportEntity.class);
        predicates = new ArrayList<>();

        predicates.add(cb.equal(root.get("organizationId"), organization.getId()));
    }

    @Override
    public JobReportQuery jobName(String... jobName) {
        List<String> jobNamesStrings = Arrays.asList(jobName);
        predicates.add(root.get("jobName").in(jobNamesStrings));
        return this;
    }

    @Override
    public JobReportQuery fromDate(Date fromTime) {
        predicates.add(cb.greaterThanOrEqualTo(root.<Long>get("startTime"), fromTime.getTime()));
        return this;
    }

    @Override
    public JobReportQuery toDate(Date toTime) {
        predicates.add(cb.lessThanOrEqualTo(root.<Long>get("startTime"), toTime.getTime()));
        return this;
    }

    @Override
    public JobReportQuery firstResult(int firstResult) {
        this.firstResult = firstResult;
        return this;
    }

    @Override
    public JobReportQuery maxResults(int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    @Override
    public List<AdminJobReport> getResultList() {
        if (!predicates.isEmpty()) {
            cq.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        }

        cq.orderBy(cb.desc(root.get("startTime")));

        TypedQuery<JobReportEntity> query = em.createQuery(cq);

        if (firstResult != null) {
            query.setFirstResult(firstResult);
        }

        if (maxResults != null) {
            query.setMaxResults(maxResults);
        }

        List<AdminJobReport> reports = new LinkedList<>();
        for (JobReportEntity e : query.getResultList()) {
            reports.add(JpaJobReportProvider.convertAdminJobReport(e));
        }

        return reports;
    }
}
