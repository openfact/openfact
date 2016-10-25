package org.openfact.models.ubl.provider;

import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.JobReportModel;
import org.openfact.provider.Provider;

public interface JobReportProvider extends Provider {
	
	JobReportModel createJobReport(OrganizationModel organization, String jobName);

	JobReportModel createJobReport(OrganizationModel organization, String jobName, String documentType);
}
