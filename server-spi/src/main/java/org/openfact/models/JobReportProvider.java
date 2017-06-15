package org.openfact.models;

import java.util.List;

public interface JobReportProvider {

    JobReportModel addJobReport(OrganizationModel organization, String name) throws ModelException;

    JobReportModel getJobReport(OrganizationModel organization, String id);

    List<JobReportModel> getJobReports(OrganizationModel organization);

    List<JobReportModel> getJobReports(OrganizationModel organization, Integer firstResult, Integer maxResults);

    boolean removeJobReport(OrganizationModel organization, JobReportModel jobReport);

}
