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

package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.file.FileModel;
import org.openfact.file.FileProvider;
import org.openfact.models.JobReportModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;

import static org.junit.Assert.assertNotNull;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class JobReporModelTest extends AbstractModelTest {

    @Test
    public void persistJobFile() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();
        JobReportModel report = session.jobReports().createJobReport(organization, "report1");
        String reportId = report.getId();

        Assert.assertNotNull(report);
        commit();

        session = organizationManager.getSession();
        report = session.jobReports().getJobReportById(organization, reportId);

        Assert.assertEquals(report.getJobName(), "report1");

        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        JobReportModel persisted = session.jobReports().getJobReportById(searchOrganization, reportId);

        Assert.assertNotNull(persisted);
        assertEquals(report, persisted);
    }

    public static void assertEquals(JobReportModel expected, JobReportModel actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getJobName(), actual.getJobName());
    }

}
