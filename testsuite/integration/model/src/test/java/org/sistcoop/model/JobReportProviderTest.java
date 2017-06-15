package org.sistcoop.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.connections.jpa.PersistenceEntityProducer;
import org.openfact.connections.jpa.PersistenceExceptionConverter;
import org.openfact.models.*;
import org.openfact.models.jpa.*;
import org.openfact.models.jpa.entities.OrganizationEntity;

import javax.inject.Inject;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class JobReportProviderTest {

    public static final String ORGANIZATION_NAME = "sistcoop";
    private OrganizationModel ORGANIZATION;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private JobReportProvider jobReportProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.mockito:mockito-core")
                .withTransitivity()
                .as(JavaArchive.class);

        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("datasource.xml")

                .addClass(PersistenceEntityProducer.class)
                .addClass(PersistenceExceptionConverter.class)
                .addClass(ModelException.class)
                .addClass(ModelDuplicateException.class)

                .addClass(JpaModel.class)
                .addPackage(OrganizationEntity.class.getPackage())

                // Organization
                .addClass(OrganizationModel.class)
                .addClass(OrganizationAdapter.class)
                .addClass(OrganizationProvider.class)
                .addClass(JpaOrganizationProvider.class)

                // jobReport
                .addClass(JobReportModel.class)
                .addClass(JobReportAdapter.class)
                .addClass(JobReportProvider.class)
                .addClass(JpaJobReportProvider.class);

        archive.addAsLibraries(libs);
        return archive;
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
    public void test_getById() {
        JobReportModel jobReport1 = jobReportProvider.addJobReport(ORGANIZATION, "myJobReport.xml");
        JobReportModel jobReport2 = jobReportProvider.getJobReport(ORGANIZATION, jobReport1.getId());

        assertThat("Both jobReports have to be the same", jobReport1, equalTo(jobReport2));
    }

    @Test
    public void test_getById_notFound() {
        JobReportModel jobReport = jobReportProvider.getJobReport(ORGANIZATION, UUID.randomUUID().toString());

        assertThat("JobReport should not exists", jobReport, is(nullValue()));
    }

    @Test
    public void test_remove() {
        JobReportModel jobReport = jobReportProvider.addJobReport(ORGANIZATION, "MyJobReport");
        boolean result = jobReportProvider.removeJobReport(ORGANIZATION, jobReport);

        jobReport = jobReportProvider.getJobReport(ORGANIZATION, jobReport.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("jobReport was not removed", jobReport, is(nullValue()));
    }

    @Test
    public void test_removeAlljobReportsOnOrganizationRemove() {
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