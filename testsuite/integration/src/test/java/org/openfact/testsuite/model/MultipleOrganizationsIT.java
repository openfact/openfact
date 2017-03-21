package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.*;
import org.openfact.models.types.DocumentType;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleOrganizationsIT extends AbstractModelTest {

    @Inject
    private DocumentProvider documentProvider;

    @Inject
    private FileProvider fileProvider;

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
        DocumentModel r1invoice1 = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "F01-001", organization1);
        DocumentModel r2invoice1 = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "F01-001", organization2);
        Assert.assertEquals(r1invoice1.getDocumentId(), r2invoice1.getDocumentId());
        Assert.assertNotEquals(r1invoice1.getId(), r2invoice1.getId());

        // Test searching
        Assert.assertEquals(2, documentProvider.searchForDocument("F01", organization1).size());

        organization1 = organizationProvider.getOrganization("id1");
        organization2 = organizationProvider.getOrganization("id2");

        documentProvider.removeDocument(r1invoice1.getId(), organization1);
        DocumentModel invoice2 = documentProvider.getDocumentByTypeAndDocumentId(DocumentType.INVOICE, "F01-002", organization1);
        documentProvider.removeDocument(invoice2.getId(), organization1);
        Assert.assertEquals(0, documentProvider.searchForDocument("F01", organization1).size());
        Assert.assertEquals(2, documentProvider.searchForDocument("F01", organization2).size());
    }

    @Test
    public void testFiles() {
        FileModel o1file1 = fileProvider.getFileById(organization1, organizationFilesIds.get(organization1).get(0));
        FileModel o2file1 = fileProvider.getFileById(organization2, organizationFilesIds.get(organization2).get(0));

        Assert.assertEquals(o1file1.getFileName(), o2file1.getFileName());
        Assert.assertNotEquals(o1file1.getId(), o2file1.getId());

        organization1 = organizationProvider.getOrganization("id1");
        organization2 = organizationProvider.getOrganization("id2");

        fileProvider.removeFile(organization1, o1file1);
        Assert.assertNull(fileProvider.getFileById(organization1, o1file1.getId()));

        FileModel file2 = fileProvider.getFileById(organization1, organizationFilesIds.get(organization1).get(1));
        fileProvider.removeFile(organization1, file2);
        Assert.assertNull(fileProvider.getFileById(organization1, organizationFilesIds.get(organization1).get(1)));
        Assert.assertNotNull(fileProvider.getFileById(organization2, organizationFilesIds.get(organization2).get(0)));
        Assert.assertNotNull(fileProvider.getFileById(organization2, organizationFilesIds.get(organization2).get(1)));
    }

    private void createObjects(OrganizationModel organization) {
        documentProvider.addDocument(DocumentType.INVOICE, "F01-001", organization);
        documentProvider.addDocument(DocumentType.INVOICE, "F01-002", organization);

        FileModel file1 = fileProvider.createFile(organization, "file1", new byte[]{1, 2, 3});
        FileModel file2 = fileProvider.createFile(organization, "file2", new byte[]{1, 2, 3});

        organizationFilesIds.put(organization, Arrays.asList(file1.getId(), file2.getId()));
    }

}
