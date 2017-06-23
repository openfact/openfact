package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.*;

import javax.inject.Inject;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

public class FileProviderTest extends AbstractModelTest {

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public FileProvider fileProvider;

    public OrganizationModel ORGANIZATION;

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
    }

    @Test
    public void addFile() {
        final String FILE_NAME = "myFile.xml";
        FileModel file = fileProvider.addFile(ORGANIZATION, FILE_NAME, new byte[]{0, 1, 2});

        assertThat(file, is(notNullValue()));
        assertThat(file.getId(), is(notNullValue()));
        assertThat(file.getFileName(), equalTo(FILE_NAME));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_duplicate_fail() {
        final String FILE_NAME = "myFile.xml";

        FileModel file1 = fileProvider.addFile(ORGANIZATION, FILE_NAME, new byte[]{0, 1});
        FileModel file2 = fileProvider.addFile(ORGANIZATION, FILE_NAME, new byte[]{0, 1, 2});
    }

    @Test
    public void addFileDuplicate() {
        final String FILE_NAME = "myFile.xml";
        final byte[] FILE = {0, 1, 2};

        // Create organization
        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Create files
        FileModel file1 = fileProvider.addFile(ORGANIZATION, FILE_NAME, FILE);
        FileModel file2 = fileProvider.addFile(ORGANIZATION_AUX, FILE_NAME, FILE);

        assertThat(file1, is(notNullValue()));
        assertThat(file2, is(notNullValue()));
        assertThat(file1, not(equalTo(file2)));
    }

    @Test
    public void getFile() {
        FileModel file1 = fileProvider.addFile(ORGANIZATION, "myFile.xml", new byte[]{0, 1, 2});
        FileModel file2 = fileProvider.getFile(ORGANIZATION, file1.getId());

        assertThat(file1, equalTo(file2));
    }

    @Test
    public void getUnknownFile() {
        FileModel file = fileProvider.getFile(ORGANIZATION, UUID.randomUUID().toString());

        assertThat(file, is(nullValue()));
    }

    @Test
    public void removeFile() {
        FileModel file = fileProvider.addFile(ORGANIZATION, "myFile.xml", new byte[]{0, 1, 2});
        boolean result = fileProvider.removeFile(ORGANIZATION, file);

        file = fileProvider.getFile(ORGANIZATION, file.getId());

        assertThat(result, equalTo(true));
        assertThat(file, is(nullValue()));
    }

    @Test
    public void removeOrganization() {
        FileModel file1 = fileProvider.addFile(ORGANIZATION, "myFile1.xml", new byte[]{0, 1});
        FileModel file2 = fileProvider.addFile(ORGANIZATION, "myFile2.xml", new byte[]{0, 1, 2});

        // Remove organization
        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat(result, equalTo(true));

        // Check files no longer exists
        file1 = fileProvider.getFile(ORGANIZATION, file1.getId());
        file2 = fileProvider.getFile(ORGANIZATION, file2.getId());

        assertThat(file1, is(nullValue()));
        assertThat(file2, is(nullValue()));
    }

}