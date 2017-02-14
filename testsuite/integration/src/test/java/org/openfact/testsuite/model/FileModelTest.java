package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.Test;
import org.openfact.file.FileModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;

import static org.junit.Assert.assertNotNull;

public class FileModelTest extends AbstractModelTest {

    @Test
    public void persistFile() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();
        FileModel file1 = session.files().createFile(organization, "file1", new byte[]{1, 2, 3});
        String file1Id = file1.getId();

        Assert.assertNotNull(file1);
        Assert.assertEquals(file1.getExtension(), "");

        file1.setFileName("file1.xml");
        commit();

        session = organizationManager.getSession();
        file1 = session.files().getFileById(organization, file1Id);

        Assert.assertEquals(file1.getFileName(), "file1.xml");
        Assert.assertEquals(file1.getExtension(), ".xml");
        assertNotNull(file1.getFile());

        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        FileModel persisted = session.files().getFileById(searchOrganization, file1Id);

        Assert.assertNotNull(persisted);
        assertEquals(file1, persisted);
    }

    @Test
    public void removeFile() {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();
        FileModel file1 = session.files().createFile(organization, "file1.xml", new byte[]{1, 2, 3});
        String file1Id = file1.getId();
        commit();

        session = organizationManager.getSession();
        file1 = session.files().getFileById(organization, file1Id);

        Assert.assertTrue(session.files().removeFile(organization, file1));

        OrganizationModel searchOrganization = organizationManager.getOrganization(organization.getId());
        FileModel persisted = session.files().getFileById(searchOrganization, file1Id);

        Assert.assertNull(persisted);
    }

    public static void assertEquals(FileModel expected, FileModel actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getFileName(), actual.getFileName());
        Assert.assertEquals(expected.getExtension(), actual.getExtension());
        Assert.assertEquals(expected.getFile(), actual.getFile());
    }

}
