package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.openfact.models.*;
import org.openfact.models.DocumentModel.DocumentType;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

public class DocumentProviderTest extends AbstractModelTest {

    public static final String DOCUMENT_ID = "F001-0001";

    @Inject
    public OrganizationProvider organizationProvider;

    @Inject
    public DocumentProvider documentProvider;

    public OrganizationModel ORGANIZATION;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = buildArchive()
                .addClasses(TestUtil.getOrganizationClasses())
                .addClasses(TestUtil.getDocumentClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization("SISTCOOP S.A.C.");
    }

    @Test
    public void addDocument() {
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);

        // Check
        testDocument(document);
    }

    @Test
    public void addDocumentWithCustomType() {
        final String CUSTOM_TYPE = "CUSTOM_DOCUMENT_TYPE";
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, CUSTOM_TYPE, DOCUMENT_ID);

        // Check
        testDocument(document);
        assertThat(document.getDocumentType(), equalTo(CUSTOM_TYPE));
    }

    private void testDocument(DocumentModel document) {
        assertThat(document, is(notNullValue()));
        assertThat(document.getId(), is(notNullValue()));
        assertThat(document.getID(), equalTo(DOCUMENT_ID));
        assertThat(document.isEnabled(), equalTo(true));
    }

    @Test(expected = ModelDuplicateException.class)
    public void addDocumentDuplicate() {
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
    }

    @Test
    public void addDocumentDuplicateWithDifferentType() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F001-001");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, "F001-001");

        assertThat(document1, is(notNullValue()));
        assertThat(document2, is(notNullValue()));
        assertThat(document1, not(equalTo(document2)));
    }

    @Test
    public void addDocumentDuplicateOnDifferentOrganizations() {
        final OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");

        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        assertThat(document1, is(notNullValue()));
        assertThat(document2, is(notNullValue()));
        assertThat(document1, not(equalTo(document2)));
    }

    @Test
    public void getDocument() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        DocumentModel document2 = documentProvider.getDocument(ORGANIZATION, document1.getId());

        assertThat(document1, equalTo(document2));
    }

    @Test
    public void getUnknownDocument() {
        DocumentModel document = documentProvider.getDocument(ORGANIZATION, UUID.randomUUID().toString());

        assertThat(document, is(nullValue()));
    }

    @Test
    public void getDocumentByTypeAndID() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        DocumentModel document2 = documentProvider.getDocumentByTypeAndID(ORGANIZATION, DocumentType.INVOICE, document1.getID());

        assertThat(document1, equalTo(document2));
    }

    @Test
    public void getDocumentsCount() {
        final OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Documents on organization1
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, DOCUMENT_ID);

        // Documents on organization2
        documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        // Check
        int organizationsCount = documentProvider.getDocumentsCount(ORGANIZATION);

        assertThat(organizationsCount, equalTo(3));
    }

    @Test
    public void getDocuments() {
        final OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");

        // Documents on organization1
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, DOCUMENT_ID);

        // Documents on organization2
        documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        // Check
        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION);

        assertThat(documents, is(notNullValue()));
        assertThat(documents.size(), equalTo(3));
    }

    @Test
    public void getDocumentsWithLimits() {
        final OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("ORGANIZATION_AUX");

        // Documents on organization1
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, DOCUMENT_ID);

        // Documents on organization2
        documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        // Check
        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION, 1, 2);

        assertThat(documents, is(notNullValue()));
        assertThat(documents.size(), equalTo(2));
    }

    @Test
    public void removeDocument() {
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        boolean result = documentProvider.removeDocument(ORGANIZATION, document);

        // Check remove operation
        assertThat(result, equalTo(true));

        // Getting document for verify
        document = documentProvider.getDocument(ORGANIZATION, document.getId());
        assertThat(document, is(nullValue()));
    }

    @Test
    public void removeOrganization() {
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);

        boolean result = organizationProvider.removeOrganization(ORGANIZATION);

        // Check remove operation
        assertThat(result, equalTo(true));

        // Check documents no longer exists
        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION);
        assertThat(documents.size(), is(0));
    }

}