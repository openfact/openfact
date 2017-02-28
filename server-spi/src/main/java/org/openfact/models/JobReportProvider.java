package org.openfact.models;

import java.util.List;

public interface JobReportProvider {

    JobReportModel createJobReport(OrganizationModel organization, String jobReportName);

    JobReportModel getJobReportById(OrganizationModel organization, String id);

    List<JobReportModel> getJobReports(OrganizationModel organization);

    List<JobReportModel> getJobReports(OrganizationModel organization, Integer firstResult, Integer maxResults);

    void preRemove(OrganizationModel organization);

    boolean removeJobReport(OrganizationModel organization, String id);

    boolean removeJobReport(OrganizationModel organization, JobReportModel jobReport);

}
