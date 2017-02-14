package org.openfact.models.jpa;

import org.openfact.models.AdminJobReport;
import org.openfact.models.JobReportQuery;
import org.openfact.models.jpa.entities.JobReportEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;


public class JpaJobReportQuery implements JobReportQuery {

    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaQuery<JobReportEntity> cq;
    private final Root<JobReportEntity> root;
    private final ArrayList<Predicate> predicates;
    private Integer firstResult;
    private Integer maxResults;

    public JpaJobReportQuery(EntityManager em) {
        this.em = em;

        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(JobReportEntity.class);
        root = cq.from(JobReportEntity.class);
        predicates = new ArrayList<>();
    }


    @Override
    public JobReportQuery organization(String organizationId) {
        predicates.add(cb.equal(root.get("organizationId"), organizationId));
        return this;
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
