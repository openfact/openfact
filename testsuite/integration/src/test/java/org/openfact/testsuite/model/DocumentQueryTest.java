package org.openfact.testsuite.model;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openfact.models.*;
import org.openfact.models.DocumentModel.DocumentType;
import org.openfact.models.DocumentModel.RequiredAction;
import org.openfact.models.search.PagingModel;
import org.openfact.models.search.SearchResultsModel;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Arquillian.class)
@UsingDataSet("empty.xml")
public class DocumentQueryTest {

    public static final String ORGANIZATION_NAME1 = "SISTCOOP S.A.C.";
    public static final String ORGANIZATION_NAME2 = "SOFTGREEN S.A.C.";

    private OrganizationModel ORGANIZATION1;
    private OrganizationModel ORGANIZATION2;

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
                .addClasses(TestUtil.getDocumentClasses())
                .addClasses(TestUtil.getDocumentQueryClasses());
        return archive.addAsLibraries(libs);
    }

    @Before
    public void before() {
        ORGANIZATION1 = organizationProvider.createOrganization(ORGANIZATION_NAME1);
        ORGANIZATION2 = organizationProvider.createOrganization(ORGANIZATION_NAME2);

        // documents for organization1
        documentProvider.addDocument(ORGANIZATION1, DocumentType.INVOICE, "F001-0001").setCurrencyCode("USD");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.INVOICE, "F001-0002").setCurrencyCode("USD");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.INVOICE, "F001-0003").setCurrencyCode("PEN");

        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0001").addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0002").addRequiredAction(RequiredAction.SEND_TO_CUSTOMER);
        documentProvider.addDocument(ORGANIZATION1, DocumentType.CREDIT_NOTE, "C001-0003").addRequiredAction(RequiredAction.SEND_TO_THIRD_PARTY);

        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "C001-0003");

        DocumentModel document1 = documentProvider.addDocument(ORGANIZATION1, DocumentType.DEBIT_NOTE, "X001-0001");
        document1.disable();

        // documents for organization2
        documentProvider.addDocument(ORGANIZATION2, DocumentType.INVOICE, "F001-0001");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.INVOICE, "F001-0002");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.INVOICE, "F001-0003");

        documentProvider.addDocument(ORGANIZATION2, DocumentType.CREDIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.CREDIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.CREDIT_NOTE, "C001-0003");

        documentProvider.addDocument(ORGANIZATION2, DocumentType.DEBIT_NOTE, "C001-0001");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.DEBIT_NOTE, "C001-0002");
        documentProvider.addDocument(ORGANIZATION2, DocumentType.DEBIT_NOTE, "C001-0003");
    }

    @Test
    public void test_count_success() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // All
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        Integer result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(10));

        // Filter text
        query = DocumentQueryModel.builder().filterText("F001").build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(3));

        // Currency code
        query = DocumentQueryModel.builder().currencyCode("USD").build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(2));

        query = DocumentQueryModel.builder().currencyCode("USD", "PEN").build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(3));

        // enabled
        query = DocumentQueryModel.builder().enabled(true).build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(9));

        query = DocumentQueryModel.builder().enabled(false).build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(1));

        // Required actions
        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_CUSTOMER).build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(2));

        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_THIRD_PARTY).build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(1));

        // Type
        query = DocumentQueryModel.builder().type(DocumentType.INVOICE).build();
        result = queryProvider.countQuery(query).getResult();
        assertThat("Incorrect result", result, equalTo(3));
    }

    @Ignore
    @Test
    public void test_from_to_date_success() {

    }

    @Test
    public void test_list_success() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // All
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        List<DocumentModel> documents = queryProvider.listQuery(query).getResult();

        assertThat("Result should never been null", documents, is(notNullValue()));
        assertThat("Incorrect result", documents.size(), equalTo(10));

        // First and Max Results
        query = DocumentQueryModel.builder().build();
        ListQueryParamsModel params = ListQueryParamsModel.builder().firstResult(2).maxResults(5).build();
        documents = queryProvider.listQuery(query, params).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(5));

        // Order by Asc
        query = DocumentQueryModel.builder().build();
        params = ListQueryParamsModel.builder().orderByAsc(DocumentModel.DOCUMENT_ID).build();
        documents = queryProvider.listQuery(query, params).getResult();

        DocumentModel first = documents.get(0);
        DocumentModel last = documents.get(documents.size() - 1);
        assertThat("Incorrect result", first.getID(), equalTo("C001-0001"));
        assertThat("Incorrect result", last.getID(), equalTo("X001-0001"));

        // Order by Desc
        query = DocumentQueryModel.builder().build();
        params = ListQueryParamsModel.builder().orderByDesc(DocumentModel.DOCUMENT_ID).build();
        documents = queryProvider.listQuery(query, params).getResult();

        first = documents.get(0);
        last = documents.get(documents.size() - 1);
        assertThat("Incorrect result", first.getID(), equalTo("X001-0001"));
        assertThat("Incorrect result", last.getID(), equalTo("C001-0001"));

        // Filter text
        query = DocumentQueryModel.builder().filterText("F001").build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(3));

        // Currency code
        query = DocumentQueryModel.builder().currencyCode("USD").build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(2));

        query = DocumentQueryModel.builder().currencyCode("USD", "PEN").build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(3));

        // enabled
        query = DocumentQueryModel.builder().enabled(true).build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(9));

        query = DocumentQueryModel.builder().enabled(false).build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(1));

        // Required actions
        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_CUSTOMER).build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(2));

        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_THIRD_PARTY).build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(1));

        // Type
        query = DocumentQueryModel.builder().type(DocumentType.INVOICE).build();
        documents = queryProvider.listQuery(query).getResult();
        assertThat("Incorrect result", documents.size(), equalTo(3));
    }

    @Test
    public void test_search_success() {
        // Provider
        DocumentQueryProvider queryProvider = documentProvider.queryProvider(ORGANIZATION1);

        // All
        DocumentQueryModel query = DocumentQueryModel.builder().build();
        SearchResultsModel<DocumentModel> result = queryProvider.searchQuery(query).getResult();

        assertThat("Result should never been null", result, is(notNullValue()));
        assertThat("Incorrect result", result.getTotalSize(), equalTo(10));
        assertThat("Incorrect result", result.getModels().size(), equalTo(10));

        // Paging
        query = DocumentQueryModel.builder().build();
        SearchQueryParamsModel params = SearchQueryParamsModel.builder().paging(new PagingModel(1, 5)).build();
        result = queryProvider.searchQuery(query, params).getResult();
        assertThat("Incorrect result", result.getModels().size(), equalTo(5));
        assertThat("Incorrect result", result.getTotalSize(), equalTo(10));

        // Order by Asc
        query = DocumentQueryModel.builder().build();
        params = SearchQueryParamsModel.builder().orderByAsc(DocumentModel.DOCUMENT_ID).build();
        result = queryProvider.searchQuery(query, params).getResult();

        DocumentModel first = result.getModels().get(0);
        DocumentModel last = result.getModels().get(result.getModels().size() - 1);
        assertThat("Incorrect result", first.getID(), equalTo("C001-0001"));
        assertThat("Incorrect result", last.getID(), equalTo("X001-0001"));

        // Order by Desc
        query = DocumentQueryModel.builder().build();
        params = SearchQueryParamsModel.builder().orderByDesc(DocumentModel.DOCUMENT_ID).build();
        result = queryProvider.searchQuery(query, params).getResult();

        first = result.getModels().get(0);
        last = result.getModels().get(result.getModels().size() - 1);
        assertThat("Incorrect result", first.getID(), equalTo("X001-0001"));
        assertThat("Incorrect result", last.getID(), equalTo("C001-0001"));

        // Filter text
        query = DocumentQueryModel.builder().filterText("F001").build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(3));
        assertThat("Incorrect result", result.getModels().size(), equalTo(3));

        // Currency code
        query = DocumentQueryModel.builder().currencyCode("USD").build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(2));
        assertThat("Incorrect result", result.getModels().size(), equalTo(2));

        query = DocumentQueryModel.builder().currencyCode("USD", "PEN").build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(3));
        assertThat("Incorrect result", result.getModels().size(), equalTo(3));

        // enabled
        query = DocumentQueryModel.builder().enabled(true).build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(9));
        assertThat("Incorrect result", result.getModels().size(), equalTo(9));

        query = DocumentQueryModel.builder().enabled(false).build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(1));
        assertThat("Incorrect result", result.getModels().size(), equalTo(1));

        // Required actions
        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_CUSTOMER).build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(2));
        assertThat("Incorrect result", result.getModels().size(), equalTo(2));

        query = DocumentQueryModel.builder().requiredAction(RequiredAction.SEND_TO_THIRD_PARTY).build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(1));
        assertThat("Incorrect result", result.getModels().size(), equalTo(1));

        // Type
        query = DocumentQueryModel.builder().type(DocumentType.INVOICE).build();
        result = queryProvider.searchQuery(query).getResult();
        assertThat("Incorrect result", result.getTotalSize(), equalTo(3));
        assertThat("Incorrect result", result.getModels().size(), equalTo(3));
    }

}
