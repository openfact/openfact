package org.openfact.models;

import java.util.List;

public interface JobReportProvider {

    JobReportQuery createQuery(OrganizationModel organization);

    JobReportModel createJobReport(OrganizationModel organization, String jobReportName) throws ModelException;

    JobReportModel getJobReportById(OrganizationModel organization, String id);

    List<JobReportModel> getJobReports(OrganizationModel organization);

    List<JobReportModel> getJobReports(OrganizationModel organization, Integer firstResult, Integer maxResults);

    void preRemove(OrganizationModel organization);

    boolean removeJobReport(OrganizationModel organization, String id);

    boolean removeJobReport(OrganizationModel organization, JobReportModel jobReport);

}
