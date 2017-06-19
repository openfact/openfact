package org.openfact.model;

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
import org.openfact.models.*;

import javax.inject.Inject;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class FileProviderTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";
    public static final String DOCUMENT_ID = "F001-0001";

    private OrganizationModel ORGANIZATION;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private FileProvider fileProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage())
                .addClasses(TestUtil.getFileClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void test_create_success() {
        final String fileName = "myFile.xml";
        final byte[] fileValue = {0, 1, 2};

        FileModel file = fileProvider.addFile(ORGANIZATION, fileName, fileValue);

        assertThat("File has not been created", file, is(notNullValue()));
        assertThat("Primary key has not been assigned", file.getId(), is(notNullValue()));
        assertThat("Filename has changed", file.getFileName(), equalTo(fileName));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_duplicate_fail() {
        final String fileName = "myFile.xml";

        FileModel file1 = fileProvider.addFile(ORGANIZATION, fileName, new byte[]{0, 1});
        FileModel file2 = fileProvider.addFile(ORGANIZATION, fileName, new byte[]{0, 1, 2});
    }

    @Test
    public void test_duplicate_different_organization_success() {
        final String fileName = "myFile.xml";
        byte[] fileValue = {0, 1, 2};

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");

        FileModel file1 = fileProvider.addFile(ORGANIZATION, fileName, fileValue);
        FileModel file2 = fileProvider.addFile(ORGANIZATION_AUX, fileName, fileValue);

        assertThat("File1 should have been created", file1, is(notNullValue()));
        assertThat("File2 should have been created", file2, is(notNullValue()));
        assertThat("Both files have to be different", file1, not(equalTo(file2)));
    }

    @Test
    public void test_get_by_id_success() {
        FileModel file1 = fileProvider.addFile(ORGANIZATION, "myFile.xml", new byte[]{0, 1, 2});
        FileModel file2 = fileProvider.getFile(ORGANIZATION, file1.getId());

        assertThat("Both files have to be the same", file1, equalTo(file2));
    }

    @Test
    public void test_get_by_id_not_found_success() {
        FileModel file = fileProvider.getFile(ORGANIZATION, UUID.randomUUID().toString());

        assertThat("File should not exists", file, is(nullValue()));
    }

    @Test
    public void test_remove_success() {
        FileModel file = fileProvider.addFile(ORGANIZATION, "myFile.xml", new byte[]{0, 1, 2});
        boolean result = fileProvider.removeFile(ORGANIZATION, file);

        file = fileProvider.getFile(ORGANIZATION, file.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("file was not removed", file, is(nullValue()));
    }

    @Test
    public void test_remove_organization_cascade_success() {
        FileModel file1 = fileProvider.addFile(ORGANIZATION, "myFile1.xml", new byte[]{0, 1});
        FileModel file2 = fileProvider.addFile(ORGANIZATION, "myFile2.xml", new byte[]{0, 1, 2});

        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));

        // Check files no longer exists
        file1 = fileProvider.getFile(ORGANIZATION, file1.getId());
        file2 = fileProvider.getFile(ORGANIZATION, file2.getId());

        assertThat("file1 was not removed", file1, is(nullValue()));
        assertThat("file2 was not removed", file2, is(nullValue()));
    }

}