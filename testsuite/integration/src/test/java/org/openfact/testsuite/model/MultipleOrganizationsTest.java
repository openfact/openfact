package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openfact.file.FileModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.DocumentType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleOrganizationsTest extends AbstractModelTest {

    private OrganizationModel organization1;
    private OrganizationModel organization2;

    Map<OrganizationModel, List<String>> organizationFilesIds = new HashMap<>();

    @Before
    @Override
    public void before() throws Exception {
        super.before();
        organization1 = organizationManager.createOrganization("id1", "organization1");
        organization2 = organizationManager.createOrganization("id2", "organization2");

        createObjects(organization1);
        createObjects(organization2);
    }

    @Test
    public void testDocuments() {
        DocumentModel r1invoice1 = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "F01-001", organization1);
        DocumentModel r2invoice1 = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "F01-001", organization2);
        Assert.assertEquals(r1invoice1.getDocumentId(), r2invoice1.getDocumentId());
        Assert.assertNotEquals(r1invoice1.getId(), r2invoice1.getId());

        // Test searching
        Assert.assertEquals(2, session.documents().searchForDocument("F01", organization1).size());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.documents().removeDocument(r1invoice1.getId(), organization1);
        DocumentModel invoice2 = session.documents().getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "F01-002", organization1);
        session.documents().removeDocument(invoice2.getId(), organization1);
        Assert.assertEquals(0, session.documents().searchForDocument("F01", organization1).size());
        Assert.assertEquals(2, session.documents().searchForDocument("F01", organization2).size());
    }

    @Test
    public void testFiles() {
        FileModel o1file1 = session.files().getFileById(organization1, organizationFilesIds.get(organization1).get(0));
        FileModel o2file1 = session.files().getFileById(organization2, organizationFilesIds.get(organization2).get(0));

        Assert.assertEquals(o1file1.getFileName(), o2file1.getFileName());
        Assert.assertNotEquals(o1file1.getId(), o2file1.getId());

        commit();
        organization1 = model.getOrganization("id1");
        organization2 = model.getOrganization("id2");

        session.files().removeFile(organization1, o1file1);
        Assert.assertNull(session.files().getFileById(organization1, o1file1.getId()));

        FileModel file2 = session.files().getFileById(organization1, organizationFilesIds.get(organization1).get(1));
        session.files().removeFile(organization1, file2);
        Assert.assertNull(session.files().getFileById(organization1, organizationFilesIds.get(organization1).get(1)));
        Assert.assertNotNull(session.files().getFileById(organization2, organizationFilesIds.get(organization2).get(0)));
        Assert.assertNotNull(session.files().getFileById(organization2, organizationFilesIds.get(organization2).get(1)));
    }

    private void createObjects(OrganizationModel organization) {
        organizationManager.getSession().documents().addDocument(DocumentType.INVOICE, "F01-001", organization);
        organizationManager.getSession().documents().addDocument(DocumentType.INVOICE, "F01-002", organization);

        FileModel file1 = organizationManager.getSession().files().createFile(organization, "file1", new byte[]{1, 2, 3});
        FileModel file2 = organizationManager.getSession().files().createFile(organization, "file2", new byte[]{1, 2, 3});

        organizationFilesIds.put(organization, Arrays.asList(file1.getId(), file2.getId()));
    }

}
