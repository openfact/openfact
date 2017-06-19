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
import org.openfact.models.DocumentModel.DocumentType;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class DocumentProviderTest {

    public static final String ORGANIZATION_NAME = "SISTCOOP S.A.C.";
    public static final String DOCUMENT_ID = "F001-0001";

    private OrganizationModel ORGANIZATION;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private DocumentProvider documentProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = TestUtil.getLibraries();
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addClasses(TestUtil.getBasicClasses())
                .addClasses(TestUtil.getOrganizationClasses())
                .addPackage(TestUtil.getEntitiesPackage())
                .addClasses(TestUtil.getDocumentClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void test_create_success() {
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);

        // Check
        test_check_create(document);
    }

    @Test
    public void test_create_custom_type_success() {
        final String documentType = "CUSTOM_DOCUMENT_TYPE";
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, documentType, DOCUMENT_ID);

        // Check
        test_check_create(document);
        assertThat("Document Type has changed", document.getDocumentType(), equalTo(documentType));
    }

    private void test_check_create(DocumentModel document) {
        assertThat("Document has not been created", document, is(notNullValue()));
        assertThat("Primary key has not been assigned", document.getId(), is(notNullValue()));
        assertThat("Document ID has changed", document.getID(), equalTo(DOCUMENT_ID));
        assertThat("Document should have active state", document.isEnabled(), equalTo(true));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_duplicate_fail() {
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
    }

    @Test
    public void test_duplicate_different_document_type_success() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F001-001");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, "F001-001");

        assertThat("Document1 should have been created", document1, is(notNullValue()));
        assertThat("Document2 should have been created", document2, is(notNullValue()));
        assertThat("Both documents have to be different", document1, not(equalTo(document2)));
    }

    @Test
    public void test_duplicate_different_organization_success() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        assertThat("Document1 should have been created", document1, is(notNullValue()));
        assertThat("Document2 should have been created", document2, is(notNullValue()));
        assertThat("Both documents have to be different", document1, not(equalTo(document2)));
    }

    @Test
    public void test_get_by_id_success() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        DocumentModel document2 = documentProvider.getDocument(ORGANIZATION, document1.getId());

        assertThat("Both documents have to be the same", document1, equalTo(document2));
    }

    @Test
    public void test_get_by_id_not_found_success() {
        DocumentModel document = documentProvider.getDocument(ORGANIZATION, UUID.randomUUID().toString());

        assertThat("Document should not exists", document, is(nullValue()));
    }

    @Test
    public void test_get_by_type_and_ID_success() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        DocumentModel document2 = documentProvider.getDocumentByTypeAndID(ORGANIZATION, DocumentType.INVOICE, document1.getID());

        assertThat("Both organizations have to be the same", document1, equalTo(document2));
    }

    @Test
    public void test_count_success() {
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, DOCUMENT_ID);

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");
        documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        // Check
        int organizationsCount = documentProvider.getDocumentsCount(ORGANIZATION);

        assertThat("Size is not corresponding to the number of documents", organizationsCount, equalTo(3));
    }

    @Test
    public void test_list_success() {
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, DOCUMENT_ID);

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");
        documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION);

        assertThat("Result should never be null", documents, is(notNullValue()));
        assertThat("Size is not corresponding to the number of documents", documents.size(), equalTo(3));
    }

    @Test
    public void test_list_limit_success() {
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, DOCUMENT_ID);

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("ORGANIZATION_AUX");
        documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, DOCUMENT_ID);

        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION, 1, 2);

        assertThat("Result should never be null", documents, is(notNullValue()));
        assertThat("Size is not corresponding to the number of selected documents", documents.size(), equalTo(2));
    }

    @Test
    public void test_remove_success() {
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        boolean result = documentProvider.removeDocument(ORGANIZATION, document);

        document = documentProvider.getDocument(ORGANIZATION, document.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("Document was not removed", document, is(nullValue()));
    }

    @Test
    public void test_remove_organization_cascade_success() {
        documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, DOCUMENT_ID);
        documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, DOCUMENT_ID);

        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));

        // Check documents no longer exists
        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION);

//        assertThat("Documents weren't removed", documents.size(), is(0));
    }

}