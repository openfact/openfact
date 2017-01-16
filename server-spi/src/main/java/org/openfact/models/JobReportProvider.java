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
package org.openfact.models;

import org.openfact.provider.Provider;

import java.util.List;

public interface JobReportProvider extends Provider {

    JobReportModel createJobReport(OrganizationModel organization, String jobReportName);

    JobReportModel getJobReportById(OrganizationModel organization, String id);

    List<JobReportModel> getJobReports(OrganizationModel organization);

    List<JobReportModel> getJobReports(OrganizationModel organization, Integer firstResult, Integer maxResults);

    boolean removeJobReport(OrganizationModel organization, String id);

    boolean removeJobReport(OrganizationModel organization, JobReportModel jobReport);

    void preRemove(OrganizationModel organization);
}
