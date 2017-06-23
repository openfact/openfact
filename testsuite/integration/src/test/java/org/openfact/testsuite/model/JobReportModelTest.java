package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openfact.models.JobReportModel;
import org.openfact.models.JobReportProvider;
import org.openfact.models.OrganizationModel;
import org.openfact.models.OrganizationProvider;

import javax.inject.Inject;

public class JobReportModelTest extends AbstractModelTest {

    public OrganizationModel ORGANIZATION;
    public JobReportModel JOB_REPORT;

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public JobReportProvider jobReportProvider;

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

    @Ignore
    @Test
    public void test() {

    }

}