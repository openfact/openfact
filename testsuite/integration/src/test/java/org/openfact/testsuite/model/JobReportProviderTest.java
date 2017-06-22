package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.JobReportModel;
import org.openfact.models.JobReportProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

import javax.inject.Inject;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class JobReportProviderTest {

    public static final String ORGANIZATION_NAME = "openfact";
    private OrganizationModel ORGANIZATION;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private JobReportProvider jobReportProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage())
                .addClasses(TestUtil.getJobReportClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void test_create_success() {
        final String jobReportName = "MyJobreport";

        JobReportModel jobReport = jobReportProvider.addJobReport(ORGANIZATION, jobReportName);

        assertThat("JobReport has not been created", jobReport, is(notNullValue()));
        assertThat("Primary key has not been assigned", jobReport.getId(), is(notNullValue()));
        assertThat("JobReport name has changed", jobReport.getJobName(), equalTo(jobReportName));
    }

    @Test
    public void test_get_by_id_success() {
        JobReportModel jobReport1 = jobReportProvider.addJobReport(ORGANIZATION, "myJobReport.xml");
        JobReportModel jobReport2 = jobReportProvider.getJobReport(ORGANIZATION, jobReport1.getId());

        assertThat("Both jobReports have to be the same", jobReport1, equalTo(jobReport2));
    }

    @Test
    public void test_get_by_id_not_found_success() {
        JobReportModel jobReport = jobReportProvider.getJobReport(ORGANIZATION, UUID.randomUUID().toString());

        assertThat("JobReport should not exists", jobReport, is(nullValue()));
    }

    @Test
    public void test_remove_success() {
        JobReportModel jobReport = jobReportProvider.addJobReport(ORGANIZATION, "MyJobReport");
        boolean result = jobReportProvider.removeJobReport(ORGANIZATION, jobReport);

        jobReport = jobReportProvider.getJobReport(ORGANIZATION, jobReport.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("jobReport was not removed", jobReport, is(nullValue()));
    }

    @Test
    public void test_remove_organization_cascade_success() {
        JobReportModel jobReport1 = jobReportProvider.addJobReport(ORGANIZATION, "myJobReport1");
        JobReportModel jobReport2 = jobReportProvider.addJobReport(ORGANIZATION, "myJobReport2");

        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));

        // Check jobReports no longer exists
        jobReport1 = jobReportProvider.getJobReport(ORGANIZATION, jobReport1.getId());
        jobReport2 = jobReportProvider.getJobReport(ORGANIZATION, jobReport2.getId());

        assertThat("jobReport1 was not removed", jobReport1, is(nullValue()));
        assertThat("jobReport2 was not removed", jobReport2, is(nullValue()));
    }

}