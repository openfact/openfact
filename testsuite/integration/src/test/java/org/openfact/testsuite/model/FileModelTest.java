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
import org.openfact.models.*;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class FileModelTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";
    public static final String FILE_NAME = "fileName.xml";

    public OrganizationModel ORGANIZATION;
    public FileModel FILE;

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public FileProvider fileProvider;

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
        FILE = fileProvider.addFile(ORGANIZATION, FILE_NAME, new byte[]{0, 1, 2, 3, 5});
    }

    @Test
    public void test_update_success() {
        assertThat("Incorrect filename", FILE.getFileName(), equalTo(FILE_NAME));

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