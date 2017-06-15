package org.sistcoop.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.connections.jpa.PersistenceEntityProducer;
import org.openfact.connections.jpa.PersistenceExceptionConverter;
import org.openfact.models.*;
import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.jpa.*;
import org.openfact.models.jpa.entities.OrganizationEntity;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class DocumentProviderTest {

    public static final String ORGANIZATION_NAME = "sistcoop";
    private OrganizationModel ORGANIZATION;

    @Inject
    private OrganizationProvider organizationProvider;

    @Inject
    private DocumentProvider documentProvider;

    @Deployment
    public static Archive deploy() {
        Archive[] libs = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .resolve("org.mockito:mockito-core")
                .withTransitivity()
                .as(JavaArchive.class);

        WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsResource("persistence.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("datasource.xml")

                .addClass(PersistenceEntityProducer.class)
                .addClass(PersistenceExceptionConverter.class)
                .addClass(ModelException.class)
                .addClass(ModelDuplicateException.class)

                .addClass(JpaModel.class)
                .addPackage(OrganizationEntity.class.getPackage())

                // Organization
                .addClass(OrganizationModel.class)
                .addClass(OrganizationAdapter.class)
                .addClass(OrganizationProvider.class)
                .addClass(JpaOrganizationProvider.class)

                // Document
                .addClass(DocumentModel.class)
                .addClass(DocumentAdapter.class)
                .addClass(DocumentProvider.class)
                .addClass(JpaDocumentProvider.class);

        archive.addAsLibraries(libs);
        return archive;
    }

    @Before
    public void before() {
        ORGANIZATION = organizationProvider.createOrganization(ORGANIZATION_NAME);
    }

    @Test
    public void test_create_success() {
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");

        assertThat("Document has not been created", document, is(notNullValue()));
        assertThat("Primary key has not been assigned", document.getId(), is(notNullValue()));
        assertThat("Document ID has changed", document.getID(), equalTo("F1"));
        assertThat("Document should have active state", document.isEnabled(), equalTo(true));
    }

    @Test
    public void test_createWithCustomDocumentType_success() {
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, "MyCustomDocumentType", "F1");

        assertThat("Document has not been created", document, is(notNullValue()));
        assertThat("Primary key has not been assigned", document.getId(), is(notNullValue()));
        assertThat("Document ID has changed", document.getID(), equalTo("F1"));
        assertThat("Document should have active state", document.isEnabled(), equalTo(true));
    }

    @Test(expected = ModelDuplicateException.class)
    public void test_duplicate() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
    }

    @Test
    public void test_allowDuplicateOfDifferentTypes() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, "F1");

        assertThat("Document1 should have been created", document1, is(notNullValue()));
        assertThat("Document2 should have been created", document2, is(notNullValue()));
        assertThat("Both documents have to be different", document1, not(equalTo(document2)));
    }

    @Test
    public void test_allowDuplicateOnDifferentOrganizations() {
        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, "F1");

        assertThat("Document1 should have been created", document1, is(notNullValue()));
        assertThat("Document2 should have been created", document2, is(notNullValue()));
        assertThat("Both documents have to be different", document1, not(equalTo(document2)));
    }

    @Test
    public void test_getById() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.getDocument(ORGANIZATION, document1.getId());

        assertThat("Both documents have to be the same", document1, equalTo(document2));
    }

    @Test
    public void test_getById_notFound() {
        DocumentModel document = documentProvider.getDocument(ORGANIZATION, UUID.randomUUID().toString());

        assertThat("Document should not exists", document, is(nullValue()));
    }

    @Test
    public void test_getByTypeAndID() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.getDocumentByTypeAndID(ORGANIZATION, DocumentType.INVOICE, document1.getID());

        assertThat("Both organizations have to be the same", document1, equalTo(document2));
    }

    @Test
    public void test_count() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, "F1");
        DocumentModel document3 = documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, "F1");

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");
        DocumentModel document22 = documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, "F1");

        int organizationsCount = documentProvider.getDocumentsCount(ORGANIZATION);

        assertThat("Size is not corresponding to the number of documents", organizationsCount, equalTo(3));
    }

    @Test
    public void test_listOrganizations() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, "F1");
        DocumentModel document3 = documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, "F1");

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("AUX_ORGANIZATION");
        DocumentModel document22 = documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, "F1");

        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION);

        assertThat("Result should never be null", documents, is(notNullValue()));
        assertThat("Size is not corresponding to the number of documents", documents.size(), equalTo(3));
    }

    @Test
    public void test_listOrganizationsWithLimit() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, "F1");
        DocumentModel document3 = documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, "F1");
        DocumentModel document4 = documentProvider.addDocument(ORGANIZATION, DocumentType.DEBIT_NOTE, "F2");

        OrganizationModel ORGANIZATION_AUX = organizationProvider.createOrganization("ORGANIZATION_AUX");
        DocumentModel document22 = documentProvider.addDocument(ORGANIZATION_AUX, DocumentType.INVOICE, "F1");

        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION, 1, 2);

        assertThat("Result should never be null", documents, is(notNullValue()));
        assertThat("Size is not corresponding to the number of selected documents", documents.size(), equalTo(2));
    }

    @Test
    public void test_remove() {
        DocumentModel document = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        boolean result = documentProvider.removeDocument(ORGANIZATION, document);

        document = documentProvider.getDocument(ORGANIZATION, document.getId());

        assertThat("Result should be true", result, equalTo(true));
        assertThat("Document was not removed", document, is(nullValue()));
    }

    @Test
    public void test_removeAllDocumentsOnOrganizationRemove() {
        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION, DocumentType.INVOICE, "F1");
        DocumentModel document2 = documentProvider.addDocument(ORGANIZATION, DocumentType.CREDIT_NOTE, "F1");

        boolean result = organizationProvider.removeOrganization(ORGANIZATION);
        assertThat("Result should be true", result, equalTo(true));

        // Check documents no longer exists
        List<DocumentModel> documents = documentProvider.getDocuments(ORGANIZATION);

        assertThat("Documents was not removed", documents.size(), is(0));
    }

}