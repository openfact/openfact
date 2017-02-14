package org.openfact.models;

import org.openfact.provider.Provider;

import java.util.List;

public interface JobReportProvider extends Provider {

    JobReportQuery createQuery();

    JobReportModel createJobReport(OrganizationModel organization, String jobReportName);

    JobReportModel getJobReportById(OrganizationModel organization, String id);

    List<JobReportModel> getJobReports(OrganizationModel organization);

    List<JobReportModel> getJobReports(OrganizationModel organization, Integer firstResult, Integer maxResults);

    boolean removeJobReport(OrganizationModel organization, String id);

    boolean removeJobReport(OrganizationModel organization, JobReportModel jobReport);

    void preRemove(OrganizationModel organization);
}
