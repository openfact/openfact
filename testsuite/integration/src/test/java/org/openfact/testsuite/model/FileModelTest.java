package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.*;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FileModelTest extends AbstractModelTest {

    public static final String FILE_NAME = "fileName.xml";

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public FileProvider fileProvider;

    public OrganizationModel ORGANIZATION;
    public FileModel FILE;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive()
                .addClasses(TestUtil.getOrganizationClasses())
                .addClasses(TestUtil.getFileClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization("SISTCOOP S.A.C.");
        FILE = fileProvider.addFile(ORGANIZATION, FILE_NAME, new byte[]{0, 1, 2, 3, 5});
    }

    @Test
    public void test_update_success() {
        assertThat(FILE.getFileName(), equalTo(FILE_NAME));

        final String newFileName = "newFileName";
        FILE.setFileName(newFileName);

        assertThat("Incorrect filename", FILE.getFileName(), equalTo(newFileName));
    }

    @Test
    public void test_extension_success() {
        assertThat("Incorrect extension", FILE.getExtension(), equalTo(".xml"));

        final String newFileName = "newFileName";
        FILE.setFileName(newFileName);

        assertThat("Incorrect extension", FILE.getExtension(), equalTo(""));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_update_duplicate_filename_fail() {
        FileModel file = fileProvider.addFile(ORGANIZATION, "fileName1.xml", new byte[]{0, 1, 2, 3, 4, 5});
        file.setFileName(FILE.getFileName());
    }

}