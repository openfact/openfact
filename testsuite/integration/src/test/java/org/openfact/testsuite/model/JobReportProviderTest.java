package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.JobReportModel;
import org.openfact.models.JobReportProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

import javax.inject.Inject;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

public class JobReportProviderTest extends AbstractModelTest {

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public JobReportProvider jobReportProvider;

    public OrganizationModel ORGANIZATION;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive()
                .addClasses(TestUtil.getOrganizationClasses())
                .addClasses(TestUtil.getJobReportClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization("SISTCOOP S.A.C.");
    }

    @Test
    public void addJobReport() {
        final String JOB_REPORT_NAME = "MY_JOB_REPORT_NAME";

        // Create report
        JobReportModel jobReport = jobReportProvider.addJobReport(ORGANIZATION, JOB_REPORT_NAME);

        // Check
        assertThat(jobReport, is(notNullValue()));
        assertThat(jobReport.getId(), is(notNullValue()));
        assertThat(jobReport.getJobName(), equalTo(JOB_REPORT_NAME));
    }

    @Test
    public void getJobReport() {
        JobReportModel jobReport1 = jobReportProvider.addJobReport(ORGANIZATION, "MY_JOB_REPORT_NAME");
        JobReportModel jobReport2 = jobReportProvider.getJobReport(ORGANIZATION, jobReport1.getId());

        assertThat(jobReport1, equalTo(jobReport2));
    }

    @Test
    public void getUnknownJobReport() {
        JobReportModel jobReport = jobReportProvider.getJobReport(ORGANIZATION, UUID.randomUUID().toString());

        assertThat(jobReport, is(nullValue()));
    }

    @Test
    public void removeJobReport() {
        JobReportModel jobReport = jobReportProvider.addJobReport(ORGANIZATION, "MY_JOB_REPORT_NAME");
        boolean result = jobReportProvider.removeJobReport(ORGANIZATION, jobReport);

        jobReport = jobReportProvider.getJobReport(ORGANIZATION, jobReport.getId());

        assertThat(result, equalTo(true));
        assertThat(jobReport, is(nullValue()));
    }

    @Test
    public void removeOrganization() {
        JobReportModel jobReport1 = jobReportProvider.addJobReport(ORGANIZATION, "MY_JOB_REPORT_NAME_1");
        JobReportModel jobReport2 = jobReportProvider.addJobReport(ORGANIZATION, "MY_JOB_REPORT_NAME_2");

        // Remove organization
        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat(result, equalTo(true));

        // Check jobReports no longer exists
        jobReport1 = jobReportProvider.getJobReport(ORGANIZATION, jobReport1.getId());
        jobReport2 = jobReportProvider.getJobReport(ORGANIZATION, jobReport2.getId());

        assertThat(jobReport1, is(nullValue()));
        assertThat(jobReport2, is(nullValue()));
    }

}