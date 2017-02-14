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

public class JobReporModelTest extends AbstractModelTest {

    @Test
    public void persistJobFile() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();
        JobReportModel report1 = session.jobReports().createJobReport(organization, "JobTaskReport");
        String report1Id = report1.getId();

        Assert.assertNotNull(report1);
        Assert.assertEquals(1, session.jobReports().getJobReports(organization).size());
        commit();


        session = organizationManager.getSession();
        JobReportModel report2 = session.jobReports().createJobReport(organization, "JobTaskReport");
        String report2Id = report2.getId();

        Assert.assertNotNull(report2);
        Assert.assertEquals(2, session.jobReports().getJobReports(organization).size());

        report1 = session.jobReports().getJobReportById(organization, report1Id);

        Assert.assertEquals(report1.getJobName(), "JobTaskReport");
        Assert.assertEquals(report2.getJobName(), "JobTaskReport");
        Assert.assertNotEquals(report1, report2);

        commit();

        session = organizationManager.getSession();
        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        report1 = session.jobReports().getJobReportById(searchOrganization, report1Id);
        report2 = session.jobReports().getJobReportById(searchOrganization, report2Id);

        Assert.assertTrue(session.jobReports().removeJobReport(organization, report1));
        Assert.assertEquals(1, session.jobReports().getJobReports(organization).size());
    }

    public static void assertEquals(JobReportModel expected, JobReportModel actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getJobName(), actual.getJobName());
    }

}
